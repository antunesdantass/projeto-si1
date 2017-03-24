var app = angular.module( "ad-extreme", ['ngRoute']);
app.config(function($routeProvider, $locationProvider) {
       $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
});
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'views/home.html',
                controller  : 'anunciosController'
            })

            .when('/anuncio', {
                templateUrl : 'views/home.html',
                controller : 'anunciosController'
            })

            // route for the about page
            .when('/usuario', {
                templateUrl : 'views/criar.html',
                controller  : 'criarController'
            })

            // route for the contact page
            .when('/login', {
                templateUrl : 'views/sobre.html',
                controller  : 'sobreController'
            });
});