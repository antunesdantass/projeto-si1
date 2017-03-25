angular.module('adExtreme').controller('LoginController', function ($scope, $http, $localStorage, AuthenticationService) {

    $scope.email;
    $scope.password;

    $scope.login = function () {
       AuthenticationService.Login($scope.email, $scope.password);
       delete $scope.email, $scope.password;
   }
   
});