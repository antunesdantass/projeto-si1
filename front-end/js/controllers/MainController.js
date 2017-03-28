angular.module('adExtreme').controller('MainControler', function ($rootScope, AutenticacaoService) {

    $rootScope.currentUser = {};

    $rootScope.anuncios = [
        {
            titulo: 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa',
            preco: 4,
            '@type': 'movel',
            dataDeCriacao: new Date()
        },
        {
            titulo: 'bbaa',
            preco: 4,
            '@type': 'servico',
            dataDeCriacao: new Date()
        }
    ];

    $rootScope.isLogged = function() {
        return AutenticacaoService.isLogged();
    };

    $rootScope.logout = function() {
        AutenticacaoService.logout();
    };

});