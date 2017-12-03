app.controller('ProductController', function($scope, $http, cart) {
  $scope.insideCart = false
  this.addToCart = function(product) {
    cart.add(product)
    $scope.insideCart = true
  }
  this.removeFromCart = function(product) {
    cart.remove(product)
    $scope.insideCart = false
  }
})
