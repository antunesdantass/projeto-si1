angular.module('adExtreme').controller('LoginController', function ($scope, AuthenticationService) {

    $scope.user;
    $scope.password;

    $scope.login = function () {
       AuthenticationService.login($scope.user, $scope.password)
   }
   
});