angular.module('adExtreme').controller('AnuncioController', function ($scope, $rootScope, AnuncioService, $routeParams, toastr) {

    $scope.adCreate = {};
    $scope.adBuy= {};

    $scope.type = $scope.adCreate['@type'] = AnuncioService.getFirstType();
    $scope.allTypes = AnuncioService.types;

    $scope.filter = 'date';
    $scope.editing = false;

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

    function getOneAdd(id) {
        AnuncioService.getAd(id)
            .then(function (ad) {
                $scope.adCreate = ad;
            })
            .catch(function (error) {
                toastr.error('Não foi possível obter anuncio.', 'Erro.');
                console.log(error);
            });
    }

    if ($routeParams.id) {
        getOneAdd($routeParams.id);
        $scope.editing = true
    }

    $scope.save = function () {
        // $scope.ad["@type"] = $scope.type;
        AnuncioService.save($scope.adCreate)
            .then(function (ad) {
                toastr.success('Salvo com sucesso', 'Sucesso');
            })
            .catch(function (error) {
                toastr.error('Não foi possível salvar', 'Erro');
                console.log(error);
            });
    };

    $scope.buy = function () {

    }
});