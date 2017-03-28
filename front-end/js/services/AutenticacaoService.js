angular.module('adExtreme').service("AutenticacaoService", function($http, $localStorage, $location, toastr, $rootScope) {

    function setRootUser(userEmail) {
        var url = 'http://localhost:8080/ad-extreme/usuario/email/' + userEmail + '/';
        $http.get(url)
            .then(function (res) {
                $rootScope.currentUser = res.data;
            }).catch(function (error) {
                console.log(error);
            });
    }

    this.login = function(user) {
        var req = {url : 'http://localhost:8080/login', method : 'POST', data : user};
        $http(req)
            .then(function successCallback(response) {
                if (response.data.token) {
                    var loggedUser = {email : response.data.email, token : response.data.token};
                    $localStorage.currentUser = loggedUser;
                    $http.defaults.headers.common.Authorization = 'x-auth-token ' + loggedUser.token;
                    $location.path("/");
                    setRootUser(loggedUser.email);
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
        $http.defaults.headers.common.Authorization = '';
    };

    this.isLogged = function() {
        return $http.defaults.headers.common.Authorization != null && $http.defaults.headers.common.Authorization !=  '';
    }
});   