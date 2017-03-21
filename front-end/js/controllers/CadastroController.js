angular.module('adExtreme').controller('CadastroController', function ($scope, CadastroService, toastr) {
    $scope.user = {};
    $scope.type;
    $scope.pass1;
    $scope.pass2;

    function validatePass(pass1, pass2) {
        return pass1 == pass2;
    }

    $scope.save = function () {
        if (validatePass($scope.pass1, $scope.pass2)) {
            $scope.user.senha = $scope.pass1;
            CadastroService.save($scope.user, $scope.type);
        } else {
            toastr.error('As senhas não correspondem', 'Erro!');
        }
    }
});