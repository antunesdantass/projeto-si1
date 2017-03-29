angular.module('adExtreme').controller('AnuncioComprarController', function ($scope, $rootScope, AnuncioService, $routeParams, toastr) {
    $scope.adBuy = {};

    function getAd(id) {
        AnuncioService.getAd(id)
            .then(function (ad) {
                $scope.adBuy = ad;
            })
            .catch(function (error) {
                toastr.error('Não foi possível obter anuncio.', 'Erro.');
                console.log(error);
            });
    }

    getAd($routeParams.idAnuncio);

    $scope.buy = function () {
        AnuncioService.buy($scope.adBuy.id)
            .then(function (ad) {
                toastr.success('Comprado com sucesso', 'Sucesso');
            })
            .catch(function (error) {
                toastr.error('Não foi possível comprar', 'Erro');
                console.log(error);
            });
    }
});