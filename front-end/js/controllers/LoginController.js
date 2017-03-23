angular.module('adExtreme').controller('LoginController', function ($scope, AuthenticationService) {

    $scope.email;
    $scope.password;

    $scope.login = function () {
        AuthenticationService.Login($scope.email, $scope.password);
   }
   
});