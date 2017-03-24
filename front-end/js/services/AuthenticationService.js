angular.module('adExtreme').service("AuthenticationService", function($http, $localStorage) {

         function Login(email, senha) {
            var requisicao = {url : 'http://localhost:8080/login', method : 'POST', data : usuario};
            $http(requisicao).then(function successCallback(data) {
                if (data.token) {
                    $localStorage.currentUser = {email : email, token : data.token};
                    $http.defaults.headers.common.Authorization = 'x-auth-token ' + response.token;
                }
            })
         }
        });   