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
        .otherwise({
            redirectTo: '/'
        });

    $locationProvider.hashPrefix('');
});