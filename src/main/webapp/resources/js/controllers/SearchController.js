'use strict';

var SearchController = function($scope, $http) {
	$scope.searchUrls='http://www.gismeteo.ru'+'\n'+'http://www.yandex.ru/'+'\n'+'http://www.rambler.ru/';
	$scope.results = [];

	$scope.NewSearch = function(searchString) {
		$scope.resetError();
		var urls = searchString.split('\n');
		var newUrls = [];
		for (var j = 0; j < urls.length; j++){
			var contains = false;
			for (var i = 0; i < $scope.results.length; i++){
				if (urls[j] === $scope.results[i].url){
					contains = true;
				}
			}
			if (!contains){
				newUrls[newUrls.length] = urls[j];
			}
		}
		$scope.searchUrls='';
		$http.post('search/getSitesInfo', newUrls).success(function(resultList) {
			console.log("search/getSitesInfo-success");
			

			var cachedList = lscache.get('key');
			if (!cachedList){
				cachedList = [];
			}
			for (var j = 0; j < resultList.length; j++){
				var contains = false;
				for (var i = 0; i < cachedList.length; i++){
					if (cachedList[i].url === resultList[j].url){
						contains = true;
					}
				}
				if (!contains){
					cachedList[cachedList.length] = resultList[j];
				}
			}
			lscache.set('key', cachedList, 10);
			for (var i = 0; i < resultList.length; i++){
				$scope.results[$scope.results.length] = resultList[i];
			}
		}).error(function() {
			console.log("search/getSitesInfo-error");
			$scope.setError('Could not perform search');
		});


	};



	$scope.resetError = function() {
		$scope.error = false;
		$scope.errorMessage = '';
	};

	$scope.setError = function(message) {
		$scope.error = true;
		$scope.errorMessage = message;
	};

	$scope.predicate = 'startTime';



};