var myApp = angular.module('myApp', []);

myApp.controller("myAppController", function($http, $scope, $log){
    $http.get("pokemon.json").success(function (data){
        $log.log(data)
        $scope.pokemans = data
    });
    
    $scope.pokemanRemove = function(pokeman) {
        return Math.abs(pokeman["weight"] - $scope.currentWeight) < 10;
    };
});