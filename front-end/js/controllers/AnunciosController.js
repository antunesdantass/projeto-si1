angular.module('adExtreme').controller('AnunciosController', function ($scope, $rootScope) {
    $scope.ads = $rootScope.anuncios;
});