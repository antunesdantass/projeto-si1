angular.module('adExtreme').controller('CadastroController', function ($scope, CadastroService) {
    $scope.user = {};
    $scope.type;

    $scope.save = function () {
        CadastroService.save($scope.user, $scope.type);
    }
});