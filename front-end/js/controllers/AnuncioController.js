angular.module('adExtreme').controller('AnuncioController', function ($scope, $rootScope, AnuncioService, $routeParams, toastr) {

    $scope.adCreate = {};

    $scope.adCreate['@type'] = AnuncioService.getFirstType();
    $scope.allTypes = AnuncioService.types;

    $scope.editing = false;

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

    if ($routeParams.idAnuncio) {
        getOneAdd($routeParams.idAnuncio);
        $scope.editing = true
    }

    $scope.save = function () {
        var promise = $scope.editing ? AnuncioService.update($scope.adCreate) : AnuncioService.save($scope.adCreate);
        // AnuncioService.save($scope.adCreate)
        promise
            .then(function (ad) {
                toastr.success('Salvo com sucesso', 'Sucesso');
            })
            .catch(function (error) {
                toastr.error('Não foi possível salvar', 'Erro');
                console.log(error);
            });
        // AnuncioService.refreshUserAds();
    };
});