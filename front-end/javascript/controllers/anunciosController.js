angular.module("ad-extreme").controller("anunciosController", ['$scope', '$http', function($scope, $http) {

    $scope.anuncios = [];
    var api = "localhost:8080/ad-extreme/anuncio";
    $scope.carregarAnuncios = function() {
        $http({url : api, method : 'GET'}).then(function successCallback(response) {
            console.log(response.data);
            $scope.anuncios = response.data;
        })
    };
    $scope.carregarAnuncios();

}])