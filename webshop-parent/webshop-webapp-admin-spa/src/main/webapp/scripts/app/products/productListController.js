(function(){
	"use strict";
	
	angular.module("adminModule").controller("ProductListController", ["productResource", productListController]);
	
	function productListController(productResource) {
		var vm = this;
		
		productResource.query(function(data){
			vm.products = data;
		});
	}
	
})();