angular.module('adExtreme').controller('LoginController', function ($scope, $http, $localStorage, AutenticacaoService) {

    $scope.user = {
        email: '',
        password: ''
    };

    $scope.login = function () {
        AutenticacaoService.login($scope.user);
        delete $scope.user;
    }
   
});