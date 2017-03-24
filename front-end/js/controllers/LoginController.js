angular.module('adExtreme').controller('LoginController', function ($scope, $http, $localStorage) {

    $scope.email;
    $scope.password;

    $scope.login = function () {
        usuario = {email : $scope.email, password : $scope.password};
       var requisicao = {url : 'http://localhost:8080/login', method : 'POST', data : usuario};
            $http(requisicao).then(function successCallback(data) {
                if (data) {
                    console.log(data);
                    //$localStorage.currentUser = {email : $scope.email, token : data.token};
                    //$http.defaults.headers.common.Authorization = 'x-auth-token ' + response.token;
                }
            })
   }
   
});