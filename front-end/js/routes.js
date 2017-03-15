angular.module('adExtreme').config(function ($routeProvider, $locationProvider) {

    $routeProvider
        .when('/', {
            templateUrl: 'views/anuncio/listar_anuncios.html',
            controller: 'AnunciosController'
        })
        .when('/empresa', {
            templateUrl: 'views/empresa/home_empresa.html',
            controller: 'UsuarioController'
        })
        .when('/anuncio', {
            templateUrl: 'views/anuncio/criar_anuncio.html',
            controller: 'AnuncioController'
        })
        // .when('/lista_anuncios', {
        //     templateUrl: 'views/listar_anuncios.html',
        //     controller: 'AnunciosController'
        // })
        .when('/login', {
            templateUrl: 'views/autenticacao/login.html',
            controller: 'LoginController'
        })
        .when('/cadastro', {
            templateUrl: 'views/autenticacao/cadastro.html',
            controller: 'CadastroController'
        })
        .otherwise({
            redirectTo: '/'
        });

    $locationProvider.hashPrefix('');
});