angular.module('adExtreme').controller('CadastroController', function ($scope, CadastroService, $location, toastr) {
    $scope.user;
    $scope.type;
    $scope.pass1;
    $scope.pass2;

    function validatePass(pass1, pass2) {
        return pass1 == pass2;
    }

    $scope.save = function () {
        if (validatePass($scope.pass1, $scope.pass2)) {
            $scope.user.senha = $scope.pass1;
            $scope.user['@type'] = $scope.type;
            CadastroService.save($scope.user)
                .then(function () {
                    toastr.success('Sucesso.', 'Usuario cadastrado com sucesso');
                    $location.path('/');
                }).catch(function (error) {
                    toastr.error('Error', 'Nao foi possível cadastrar');
                    console.log(error);
                });
            delete $scope.user, $scope.type, $scope.pass1, $scope.pass2;
        } else {
            toastr.error('As senhas não correspondem', 'Erro!');
        }
    }
});