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
                    setRootUser(loggedUser.email);
                    $localStorage.currentUser = loggedUser;
                    $http.defaults.headers.common.Authorization = 'x-auth-token ' + loggedUser.token;
                    $location.path("/");
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
        $rootScope.currentUser = {};
        $http.defaults.headers.common.Authorization = '';
    };

    this.isLogged = function() {
        return $http.defaults.headers.common.Authorization != null && $http.defaults.headers.common.Authorization !=  '';
    }
});   