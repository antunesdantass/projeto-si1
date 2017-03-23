(function () {
    'use strict';

    angular
        .module('adExtreme')
        .factory('AuthenticationService', Service);

    function Service($resource, $localStorage, $http) {
        var service = {};

        service.Login = Login;
        service.Logout = Logout;

        return service;

        function Login(email, password, callback) {
            var usuario = {email : email, password : password};
            console.log(usuario);
            // $http.post('localhost:8080/login', usuario)
            //     .then(function (response) {
            //         // login successful if there's a token in the response
            //         if (response.token) {
            //             // store username and token in local storage to keep user logged in between page refreshes
            //             $localStorage.currentUser = { username: username, token: response.token };

            //             // add jwt token to auth header for all requests made by the $http service
            //             $http.defaults.headers.common.Authorization = 'x-auth-token ' + response.token;

            //             // execute callback with true to indicate successful login
            //             callback(true);
            //         } else {
            //             // execute callback with false to indicate failed login
            //             callback(false);
            //         }
            //     });

            var requisicao = {url : 'localhost:8080/login', method : 'POST', data : usuario};
            $http(requisicao).then(function successCallback(data) {
                if (data.token) {
                    $localStorage.currentUser = {email : email, token : data.token};
                    $http.defaults.headers.common.Authorization = 'x-auth-token ' + response.token;
                }
            })
        }

        function Logout() {
            // remove user from local storage and clear http auth header
            delete $localStorage.currentUser;
            $http.defaults.headers.common.Authorization = '';
        }
    }
})();