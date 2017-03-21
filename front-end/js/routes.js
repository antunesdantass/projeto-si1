angular.module('adExtreme').config(function ($routeProvider, $locationProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'views/anuncio/listar_anuncios.html',
            controller: 'AnuncioController',
            authorize : false
        })
        .when('/empresa', {
            templateUrl: 'views/empresa/home_empresa.html',
            controller: 'UsuarioController',
            authorize : true
        })
        .when('/anuncio', {
            templateUrl: 'views/anuncio/criar_anuncio.html',
            controller: 'AnuncioController',
            authorize : false
        })
        .when('/login', {
            templateUrl: 'views/autenticacao/login.html',
            controller: 'LoginController',
            authorize : false
        })
        .when('/cadastro', {
            templateUrl: 'views/autenticacao/cadastro.html',
            controller: 'CadastroController',
            authorize : false
        })
        .when('/usuario', {
            templateUrl: 'views/usuario.html',
            controller: 'UsuarioController',
            authorize : true
        })
        .when('/anuncio/comprar', {
            templateUrl: 'view de comprar',
            controller: 'ComprarController',
            authorize : true
        })
        .otherwise({
            redirectTo: '/'
        });

    $locationProvider.hashPrefix('');
});