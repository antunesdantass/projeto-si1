angular.module('adExtreme').service('CadastroService', function ($http) {

    var apiAdress = "localhost:8080/ad-extreme/usuario"

    var Register = $resource();

    this.save = function (user, type) {
        user.obj['@type'] = type;
        $http.post(apiAdress, user).then();
    }
});