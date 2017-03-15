angular.module('adExtreme').factory('UsuarioService', function ($resource) {
    return $resource('http://localhost:8080/ad-extreme/usuario/{id}', {type: '@type'});
});