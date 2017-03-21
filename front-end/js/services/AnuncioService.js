angular.module('adExtreme').service('AnuncioService', function ($resource) {

    var Anuncio = $resource('http://localhost:8080/ad-extreme/anuncio/:id');

    this.types = ['movel', 'imovel', 'emprego']; // pegar do servidor

    this.getFirstType = function () {
        return this.types[0];
    };

    this.getAds = function () {
        return Anuncio.query();
    };

    this.save = function (ad) {
        // usar resource para dar post
        // $scope.ad.date = new Date();
        // $rootScope.anuncios.push($scope.ad);
        // $scope.ad = {};
        // $scope.ad.type = $scope.types[0];
    };
});