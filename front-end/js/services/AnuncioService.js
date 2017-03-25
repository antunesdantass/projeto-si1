angular.module('adExtreme').service('AnuncioService', function ($resource) {

    var adResource = $resource('http://localhost:8080/ad-extreme/anuncio/:id');

    this.types = ['movel', 'imovel', 'emprego', 'serviço']; // pegar do servidor

    this.getFirstType = function () {
        return this.types[0];
    };

    this.getAds = function () {
        return adResource.query();
    };

    this.save = function (ad) {
        adResource.save(ad);
    };
});