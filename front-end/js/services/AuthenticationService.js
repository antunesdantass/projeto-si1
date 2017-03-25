angular.module('adExtreme').service("AuthenticationService", function($http, $localStorage, $window) {

         this.Login = function(email, senha) {
             usuario = {email : email, password : senha};
             var requisicao = {url : 'http://localhost:8080/login', method : 'POST', data : usuario};
             $http(requisicao).then(function successCallback(response) {
                 if (response.data.token) {
                    var loggedUser = {email : response.data.email, token : response.data.token};
                    $localStorage.currentUser = loggedUser;
                    $http.defaults.headers.common.Authorization = 'x-auth-token ' + loggedUser.token;
                    $window.location = "/";
                 }
             })
         };

         this.Logout = function() {
             delete $localStorage.currentUser;
             $http.defaults.headers.common.Authorization = '';
         };

         this.isLogado = function() {
             return $http.defaults.headers.common.Authorization !=  '';
         }
});   