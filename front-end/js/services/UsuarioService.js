angular.module('adExtreme').service('UsuarioService', function ($resource, $localStorage, $http) {

    this.getUser = function (id) {
        // var token = $localStorage.currentUser ? $localStorage.currentUser.token : null;
        // var Usuario = $resource('http://localhost:8080/ad-extreme/usuario/id/:id', null, {
        //     get: {
        //         method: 'GET',
        //         headers: {
        //             'x-auth-token': token
        //         }
        //     }
        // });
        // return Usuario.get({id: id}).$promise;
        return $http.get('http://localhost:8080/ad-extreme/usuario/id/' + id);
    }
});