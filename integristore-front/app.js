var app = angular.module('store', ['ngRoute'])
app.config(function($routeProvider, $locationProvider) {
  $locationProvider.hashPrefix('')
  $routeProvider
  .when('/', {
    templateUrl : "views/home.html",
    controller: 'StoreController'
  })
  .when("/checkout", {
    templateUrl : "views/checkout.html",
    controller: 'StoreController'
  })
})
