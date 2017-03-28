angular.module('adExtreme').controller('AnuncioController', function ($scope, $rootScope, AnuncioService) {

    $scope.adCreate = {};
    $scope.adBuy= {};

    $scope.type = AnuncioService.getFirstType();
    $scope.allTypes = AnuncioService.types;

    $scope.filter = 'date';

    $rootScope.ads = AnuncioService.getAds();

    $scope.save = function () {
        // $scope.ad["@type"] = $scope.type;
        AnuncioService.save($scope.adCreate);
    };

    $scope.buy = function () {

    }
});