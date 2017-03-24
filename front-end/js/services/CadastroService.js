angular.module('adExtreme').service('CadastroService', function ($http, $resource) {

    var apiAdress = "http://localhost:8080/ad-extreme/usuario"

    var Register = $resource();

    this.save = function (user, type) {
        //user.obj['@type'] = type;
        $http.post(apiAdress, user).then();
    }
});