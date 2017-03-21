angular.module('adExtreme').controller('LoginController', function ($scope, LoginService) {
    $scope.user;
    $scope.password;

    $scope.login = function () {
       LoginService.login($scope.user, $scope.password)
   }
});