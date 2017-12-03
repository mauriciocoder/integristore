app.service('cart', function() {
  this.cart = []
  this.add = function (product) {
    this.cart.push(product)
  }
  this.remove = function (product) {
    this.cart = this.cart.filter((p) => p.id !== product.id)
  }
  this.getAll = function () {
    return this.cart
  }
  this.getItemsQty = function () {
    return this.cart.length
  }
  this.getPrice = function() {
    return this.cart.map(p => p.price).reduce(function (a, b) {
      return a + b;
    }, 0);
  }
});
