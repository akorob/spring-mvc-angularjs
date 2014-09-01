'use strict';

var ResultsController = function($scope, $http) {

    $scope.fetchAllResultsList = function() {
        /*$http.get('results/allResultsList.json').success(function(resList){
            $scope.cashedResults = resList;
        });*/
    	$scope.cashedResults = lscache.get('key');
    	console.log($scope.cashedResults);

    };

  

    $scope.removeAllResults = function() {
        $scope.resetError();
        lscache.remove('key');
        $scope.fetchAllResultsList();

    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchAllResultsList();

    $scope.predicate = 'startTime';
};