angular.module('adExtreme').factory('httpErrorResponseInterceptor', function ($q, $location) {
    var interceptor = {
        response: function (responseData) {
            return responseData;
        },
        responseError: function (response) {
            switch (response.status) {
                case 401:
                    $location.path('/login');
                    break;
                case 404:
                    $location.path('/404');
                    break;
                case 500:
                    $location.path('/500');
                    break;
            }
            return $q.reject(response);
        }
    };

    return interceptor;
});