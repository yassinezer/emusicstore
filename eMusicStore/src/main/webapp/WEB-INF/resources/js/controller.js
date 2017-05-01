/**
 * Created by Le on 1/11/2016.
 */


var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function ($scope, $http){

    $scope.refreshCart = function () {
        $http.get('/emusicstore/rest/cart/'+$scope.cartId).success(function (data) {
           $scope.cart=data;
        });
    };

    $scope.clearCart = function () {
        $http.delete('/emusicstore/rest/cart/'+$scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function (cartId) {
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };
    
    $scope.addToCart = function (productId) {
        $http.put('/emusicstore/rest/cart/processing/'+productId).success(function (data) {
            alert("Your Order is being proccessing Now, Please check My orders Tab for further information!")
        });
    };

    $scope.removeFromCart = function (productId) {
        $http.put('/emusicstore/rest/cart/remove/'+productId).success(function (data) {
            $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function () {
        var grandTotal=0;
        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }
        return grandTotal;
    };
});

var orderApp = angular.module ("orderApp", []);

orderApp.controller("orderCtrl", function ($scope, $http){
    
	$scope.acceptOrder = function (customerId,pOrderId, productid){
        $http.put('/emusicstore/rest/cart/add/'+customerId+'/'+pOrderId+'/'+productid).success(function () {
            alert("The Order has been accepted successfully");
            document.getElementById(pOrderId).style.display = 'none';            
        });
    };
});
