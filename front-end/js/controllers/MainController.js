angular.module('adExtreme').controller('MainControler', function ($rootScope, AutenticacaoService) {

    $rootScope.currentUser = {};

    $rootScope.ads = [];

    $rootScope.isLogged = function() {
        return AutenticacaoService.isLogged();
    };

    $rootScope.logout = function() {
        AutenticacaoService.logout();
    };

});