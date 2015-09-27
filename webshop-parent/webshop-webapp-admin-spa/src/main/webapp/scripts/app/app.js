(function() {
	"use strict";

	var app = angular.module("adminModule", ["common.services", "ui.router"]);

	app.config(["$stateProvider", "$urlRouterProvider", function($stateProvider, $urlRouterProvider){
		$urlRouterProvider.otherwise("/");
		
		$stateProvider
		.state("home", {
			url: "/",
			templateUrl: BASE_URL + "scripts/app/welcomeView.html"
		})
		.state("productList", {
			url: "/products", 
			templateUrl: BASE_URL + "scripts/app/products/productListView.html",
			controller: "ProductListController as vm"});
	}]);
})();