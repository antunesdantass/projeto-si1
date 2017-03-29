angular.module('adExtreme').controller('AnuncioListarController', function ($scope, $rootScope, AnuncioService, $routeParams, toastr) {

    $scope.type = AnuncioService.getFirstType();
    $scope.allTypes = AnuncioService.types;

    $scope.filter = 'data';
    $scope.date1 = new Date();
    $scope.date2 = new Date();

    function getAds() {
        AnuncioService.getAds()
            .then(function (ads) {
                $rootScope.anuncios = ads;
            })
            .catch(function (error) {
                toastr.error('Não foi possível obter anúncios', 'Erro');
                console.log(error);
            })
    }

    $scope.search = function () {
        var query = '';
        if ($scope.filter == 'tipo') {
            query = $scope.type;
        }
        AnuncioService.search($scope.filter, query)
            .then(function (ads) {
                $rootScope.anuncios = ads;
            })
            .catch(function (error) {
                toastr.error('Não foi possível obter anúncios', 'Erro');
                console.log(error);
            })
    };

    getAds();
});