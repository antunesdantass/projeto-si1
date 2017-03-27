angular.module('adExtreme').service("AutenticacaoService", function($http, $localStorage, $location, toastr) {

         this.login = function(user) {
             var req = {url : 'http://localhost:8080/login', method : 'POST', data : user};
             $http(req)
                 .then(function successCallback(response) {
                     if (response.data.token) {
                        var loggedUser = {email : response.data.email, token : response.data.token};
                        $localStorage.currentUser = loggedUser;
                        $http.defaults.headers.common.Authorization = 'x-auth-token ' + loggedUser.token;
                        $location.path("#/");
                        toastr.success('Sucesso.', 'Logado com sucesso.');
                     }
                 })
                 .catch(function (error) {
                     console.log(error);
                     toastr.error('Erro', 'Não foi possível logar.')
                 });
         };

         this.logout = function() {
             delete $localStorage.currentUser;
             $http.defaults.headers.common.Authorization = '';
         };

         this.isLogged = function() {
             return $http.defaults.headers.common.Authorization != null && $http.defaults.headers.common.Authorization !=  '';
         }
});   