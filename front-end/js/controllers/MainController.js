angular.module('adExtreme').controller('MainControler', function ($rootScope, AutenticacaoService, UsuarioService) {

    $rootScope.server = 'http://localhost:8080/';

    $rootScope.currentUser = {};

    $rootScope.anuncios = [];

    $rootScope.toUpdate = false;

    $rootScope.isLogged = function() {
        return AutenticacaoService.isLogged();
    };

    $rootScope.updateUser = function () {
        var id = $rootScope.currentUser.id;
        UsuarioService.getUser(id)
            .then(function (user) {
                $rootScope.currentUser = user;
            })
    };

    $rootScope.logout = function() {
        AutenticacaoService.logout();
    };

});