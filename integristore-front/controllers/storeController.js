// CONTROLLERS
app.controller('StoreController', function($scope, $http, cart) {
  $scope.products = []
  $http.get('http://127.0.0.1:8080/product').then(function(result) {
    $scope.products = result.data
  })
  this.getItemsQty = function() {
    return cart.getItemsQty()
  }
  this.getCartPrice = function() {
    return cart.getPrice()
  }
  this.cartContainItems = function() {
    return this.getItemsQty() > 0
  }
  this.getCartItems = function() {
    return cart.getAll()
  }
  this.getCartItemsIds = function() {
    return cart.getAll().map(item => item.id)
  }
  this.checkout = function() {
    var data = {
      creditCard: {
          name: $scope.name,
          cardNumber: $scope.cardNumber,
          expDateMonth: $scope.expDateMonth,
          expDateYear: $scope.expDateYear
      },
      products: this.getCartItemsIds().reduce((accumulator, currentValue) => {
        accumulator.push({'id': currentValue})
        return accumulator
      }, []),
      cartPrice: this.getCartPrice()
    }
    var config = {
      headers : {
        'Content-Type': 'application/json'
      }
    }
    $http.post('http://127.0.0.1:8080/checkout', data, config)
    .then(function successCallback(response) {
        alert('The payment was accepted and the order will be available to be collected at the store')
    }, function errorCallback(response) {
        alert('Error Processing Request, try again latter!')
    })
  }
})
