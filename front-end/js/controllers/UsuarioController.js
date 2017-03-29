angular.module('adExtreme').controller('UsuarioController', function ($scope, AnuncioService, UsuarioService) {
    $scope.removeAd = function (idAd) {
        AnuncioService.removeAd(idAd)
            .then(function () {
                toastr.success('Removido com sucesso', 'Sucesso')
            })
    }
});