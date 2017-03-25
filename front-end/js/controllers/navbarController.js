angular.module('adExtreme').controller('navbarController', function($scope, AuthenticationService, $window) {
    
    $scope.isLogado = function() {
        return AuthenticationService.isLogado();
    }

    $scope.logout = function() {
        AuthenticationService.Logout();
    }
})