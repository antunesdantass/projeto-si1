angular.module('adExtreme').config(function ($routeProvider, $locationProvider, $httpProvider) {

    // $locationProvider.html5Mode({
    //     enabled: true,
    //     requireBase: false
    // });

    $httpProvider.interceptors.push('httpErrorResponseInterceptor');
    $locationProvider.html5Mode(true);
    // $locationProvider.hashPrefix('');

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
        .when('/404', {
            templateUrl: 'views/error/404.html'
        })
        .when('/401', {
            templateUrl: 'views/error/401.html'
        })
        .when('/500', {
            templateUrl: 'views/error/500.html'
        })
        .otherwise({
            redirectTo: '/'
        });

    // $locationProvider.hashPrefix('');
});