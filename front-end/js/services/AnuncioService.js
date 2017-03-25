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
        ad['@type'] = 'movel';
       Anuncio.save(ad);
    };
});