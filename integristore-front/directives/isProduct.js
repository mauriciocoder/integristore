app.directive('isProduct', function() {
  return {
    restrict: 'E',
    templateUrl: 'directives/is-product.html',
    controller: 'ProductController',
    controllerAs: 'ctrl'
  }
})
