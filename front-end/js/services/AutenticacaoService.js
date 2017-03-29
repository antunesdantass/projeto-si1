angular.module('adExtreme').service("AutenticacaoService", function($http, $localStorage, $location, toastr, $rootScope) {

    this.login = function(user) {
        var req = {url : 'http://localhost:8080/login', method : 'POST', data : user};
        $http(req)
            .then(function successCallback(response) {
                if (response.data.token) {
                    var loggedUser = {user : response.data.usuario, token : response.data.token};
                    $localStorage.currentUser = loggedUser;
                    $rootScope.currentUser = response.data.usuario;
                    $http.defaults.headers.common['x-auth-token'] = loggedUser.token;
                    $location.path("/");
                    toastr.success('Logado com sucesso.','Sucesso.');
                }
            })
            .catch(function (error) {
                console.log(error);
                toastr.error('Usuario e/ou senha incorretos.', 'Erro')
            });
    };

    this.logout = function() {
        delete $localStorage.currentUser;
        $rootScope.currentUser = {};
        $http.defaults.headers.common['x-auth-token'] = '';
    };

    this.isLogged = function() {
        return $http.defaults.headers.common['x-auth-token'] != null && $http.defaults.headers.common['x-auth-token'] !=  '';
    }
});   