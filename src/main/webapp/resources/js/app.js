'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/search', {
        templateUrl: 'search/layout',
        controller: SearchController,
        
    });
    
    $routeProvider.when('/results', {
        templateUrl: 'results/layout',
        controller: ResultsController
    });

    $routeProvider.otherwise({redirectTo: '/search'});
    
    
}]);


	 
