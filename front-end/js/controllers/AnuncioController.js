angular.module('adExtreme').controller('AnuncioController', function ($scope, $rootScope, AnuncioService) {

    $scope.ad = {};
    $scope.type = AnuncioService.getFirstType();
    $scope.allTypes = AnuncioService.types;

    $rootScope.ads = AnuncioService.getAds();

    $scope.save = function () {
        $scope.ad["@type"] = $scope.type;
        AnuncioService.save($scope.ad);
    };
});