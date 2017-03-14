angular.module('adExtreme').config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            // templateUrl: '', // colocar a view dos anuncios
            template: 'home'
        })
        .when('/company', {
            templateUrl: 'views/company/company_home.html',
            controller: 'CompanyController'
        })
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