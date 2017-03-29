angular.module('adExtreme').service('CadastroService', function ($resource, $rootScope) {

    var Register = $resource($rootScope.server + 'ad-extreme/cadastrar/usuario');

    this.save = function (user) {
        console.log(user);
        return Register.save(user).$promise;
    }
});