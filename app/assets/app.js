var myApp = angular.module('myApp', []);

myApp.controller("myAppController", function($http, $scope, $log){
    $http.get("pokemon.json").success(function (data){
        $scope.pokemans = data
    });
    
    $scope.pokemanRemove = function(pokeman) {
        return Math.abs(pokeman["weight"] - $scope.currentWeight) < 5;
    };
    
    $scope.pokemanOrder = function(pokeman1){
        return Math.abs(pokeman1["weight"] - $scope.currentWeight)
        // pokeman2Delta = Math.abs(pokeman2["weight"] - $scope.currentWeight)
        // $log.log(pokeman1Delta)
    };
    
});