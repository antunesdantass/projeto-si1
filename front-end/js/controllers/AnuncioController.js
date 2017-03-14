angular.module('adExtreme').controller('AnuncioController', function ($scope, $rootScope) {

    $scope.ad = {};

    $scope.types = ['movel', 'imovel', 'emprego']; // pegar do servidor
    $scope.ad.type = $scope.types[0];

    $scope.save = function () {
        if (!$rootScope.anuncios) {
            $rootScope.anuncios = [];
        }
        $scope.ad.date = new Date();
        $rootScope.anuncios.push($scope.ad);
        $scope.ad = {};
        $scope.ad.type = $scope.types[0];
    };
});