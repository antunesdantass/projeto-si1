angular.module('adExtreme').service('CadastroService', function ($resource) {

    var Register = $resource('http://localhost:8080/ad-extreme/cadastrar/usuario');

    this.save = function (user) {
        console.log(user);
        return Register.save(user).$promise;
    }
});