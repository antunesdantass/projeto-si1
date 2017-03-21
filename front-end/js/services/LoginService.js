angular.module('adExtreme').service('LoginService', function ($resource) {
    var Login = $resource();

    this.login = function (user, password) {
        // usar resource para dar post
    }
});