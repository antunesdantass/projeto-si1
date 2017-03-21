angular.module('adExtreme').controller('AnuncioController', function ($scope, $rootScope, AnuncioService) {

    $scope.ad = {};
    $scope.ad.type = AnuncioService.getFirstType();

    $rootScope.ads = AnuncioService.getAds();

    $scope.save = function () {
        AnuncioService.save($scope.ad);
    };
});