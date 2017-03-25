angular.module('adExtreme').controller('LoginController', function ($scope, $http, $localStorage, AutenticacaoService) {

    $scope.email;
    $scope.password;

    $scope.login = function () {
       AutenticacaoService.login($scope.email, $scope.password);
       delete $scope.email, $scope.password;
   }
   
});