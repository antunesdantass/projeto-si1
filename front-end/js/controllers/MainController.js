angular.module('adExtreme').controller('MainControler', function ($rootScope, AutenticacaoService, UsuarioService) {

    $rootScope.currentUser = {};

    $rootScope.anuncios = [];

    $rootScope.isLogged = function() {
        return AutenticacaoService.isLogged();
    };

    $rootScope.updateUser = function () {
        UsuarioService.getUser($rootScope.currentUser.id)
            .then(function (user) {
                $rootScope.currentUser = user;
            })
    };

    $rootScope.logout = function() {
        AutenticacaoService.logout();
    };

});