angular.module('adExtreme').service('AnuncioService', function ($resource, $localStorage) {

    var adResource = $resource('http://localhost:8080/ad-extreme/anuncio/:id', null, {
        'update': { method: 'PUT' }
    });

    this.types = ['movel', 'imovel', 'emprego', 'servico']; // pegar do servidor

    this.getFirstType = function () {
        return this.types[0];
    };

    this.getAds = function (query) {
        return adResource.query(query).$promise;
    };

    this.getAd = function (id) {
        return adResource.get({id: id}).$promise;
    };

    this.save = function (ad) {
        return adResource.save(ad).$promise;
        // return $http.post('http://localhost:8080/ad-extreme/anuncio', ad);
    };

    this.update = function (ad) {
        return adResource.update(ad).$promise;
        // return $http.post('http://localhost:8080/ad-extreme/anuncio', ad);
    };

    // this.refreshUserAds = function () {
    //     var search = $resource('http://localhost:8080/ad-extreme/anuncio/pesquisa/usuario/' + $rootScope.currentUser.email + '/');
    //     search.query().$promise
    //         .then(function (anuncios) {
    //             $rootScope.currentUser.anuncios = anuncios;
    //         })
    // };

    this.buy = function (idAnuncio) {
        // var buyResource = $resource('http://localhost:8080/ad-extreme/anuncio/:idAnuncio/comprar', null, {
        var buyResource = $resource('http://localhost:8080/ad-extreme/anuncio/' + idAnuncio + '/comprar', null, {
            'update': { method: 'PUT', headers: { 'x-auth-token': $localStorage.currentUser.token } }
        });
        // return buyResource.update({idAnuncio: idAnuncio}).$promise;
        return buyResource.update().$promise;
    }
});