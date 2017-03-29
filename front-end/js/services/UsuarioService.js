angular.module('adExtreme').service('UsuarioService', function ($resource) {
    var Usuario = $resource('http://localhost:8080/ad-extreme/usuario/:id');

    this.getUser = function (id) {
        return Usuario.get({id: id});
    }
});