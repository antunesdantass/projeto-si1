angular.module('adExtreme').controller('AnuncioListarController', function ($scope, $rootScope, AnuncioService, $routeParams, toastr) {

    $scope.type = AnuncioService.getFirstType();
    $scope.allTypes = AnuncioService.types;

    $scope.filter = 'date';

    function getAds(query) {
        AnuncioService.getAds(query)
            .then(function (ads) {
                $rootScope.anuncios = ads;
            })
            .catch(function (error) {
                toastr.error('Não foi possível obter anúncios', 'Erro');
                console.log(error);
            })
    }

    getAds({});
});