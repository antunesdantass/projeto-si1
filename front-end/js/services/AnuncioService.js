angular.module('adExtreme').service('AnuncioService', function ($resource, $localStorage, $rootScope) {

    var adUrl = 'http://localhost:8080/ad-extreme/anuncio/:id';
    var searchUrl = 'http://localhost:8080/ad-extreme/anuncio/pesquisa/';

    function getResource(url) {
        var token = $localStorage.currentUser ? $localStorage.currentUser.token : null;
        return $resource(url, null, {
            'update': { method: 'PUT', headers: { 'x-auth-token': token }  }
        });
    }

    var typesFisica = ['movel', 'imovel'];
    var typesJuridica = ['movel', 'imovel', 'emprego', 'servico'];
    this.types = $rootScope.currentUser['@type'] == 'Fisica' ? typesFisica : typesJuridica;

    this.getFirstType = function () {
        return this.types[0];
    };

    this.getAds = function () {
        var adResource = getResource(adUrl);
        return adResource.query().$promise;
    };

    this.getAd = function (id) {
        var adResource = getResource(adUrl);
        return adResource.get({id: id}).$promise;
    };

    this.save = function (ad) {
        var adResource = getResource(adUrl);
        return adResource.save(ad).$promise;
    };

    this.update = function (ad) {
        var adResource = getResource(adUrl);
        return adResource.update({id: ad.id}, ad).$promise;
    };

    this.removeAd = function (idAd) {
        var adResource = getResource(adUrl);
        return adResource.delete({id: idAd}).$promise;
    };

    this.search = function (filter, query) {
        var searchAux = searchUrl + filter + '/' + query;
        var searchResource = $resource(searchAux);
        return searchResource.query().$promise;
    };

    this.buy = function (idAnuncio) {
        var buyResource = getResource('http://localhost:8080/ad-extreme/anuncio/' + idAnuncio + '/comprar');
        return buyResource.update({idComprador: $rootScope.currentUser.id}).$promise;
    }
});