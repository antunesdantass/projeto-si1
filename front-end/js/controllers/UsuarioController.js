angular.module('adExtreme').controller('UsuarioController', function ($scope, $rootScope) {
    var date = new Date();
    $rootScope.currentUser.anuncios = [
        {
            titulo: 'aa',
            preco: 4,
            '@type': 'movel',
            dataDeCriacao: date
        },
        {
            titulo: 'bbaa',
            preco: 4,
            '@type': 'servico',
            dataDeCriacao: date
        }
    ]
});