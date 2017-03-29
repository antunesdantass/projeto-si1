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
            controller: 'AnuncioListarController'
        })
        .when('/anuncio/:idAnuncio?', {
            templateUrl: 'views/anuncio/criar_anuncio.html',
            controller: 'AnuncioController',
            requiredAuth: true
        })
        .when('/login', {
            templateUrl: 'views/autenticacao/login.html',
            controller: 'LoginController'
        })
        .when('/cadastro', {
            templateUrl: 'views/autenticacao/cadastro.html',
            controller: 'CadastroController'
        })
        .when('/conta', {
            templateUrl: 'views/usuario/conta.html',
            controller: 'UsuarioController',
            requiredAuth: true
        })
        .when('/extrato', {
            templateUrl: 'views/usuario/extrato.html',
            controller: 'UsuarioController',
            requiredAuth: true
        })
        .when('/comprar_anuncio/:idAnuncio', {
            templateUrl: 'views/anuncio/comprar_anuncio.html',
            controller: 'AnuncioComprarController',
            requiredAuth: true
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
            redirectTo: '/404'
        });

})
.run(function ($rootScope, $location) {
    $rootScope.$on('$routeChangeStart', function (angularEvent, newUrl) {
        if (newUrl.requiredAuth && !$rootScope.isLogged()) {
            $location.path('/login');
        }
    })
});