angular.module('adExtreme').controller('AnunciosController', function ($scope, $rootScope) {
    $scope.ads = $rootScope.anuncios;

    $scope.formatPrice = function (price) {
        var value = '' + price;
        value = value.split('.');

        var intValue = value[0];
        var decValue = value[1];

        if (decValue) {
            // decValue =
        }
    }
});