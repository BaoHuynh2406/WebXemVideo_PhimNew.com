var app = angular.module('indexPage', ["ngRoute"]);

app.config(function ($routeProvider) {
    $routeProvider
        .when("/login", { templateUrl: "./login.html", controller: "myCtrl" })
        .when("/siginUp", { templateUrl: "./SignUp.html", controller: "myCtrl" })
        .when("/doipass", {templateUrl: "./doipass.html", controller: "myCtrl"})
        .when("/MonHoc/:idMH", { templateUrl: "./lessson.html", controller: "monHocCtrl" })
        .when("/Quiz/:idMH/:idQ", { templateUrl: "./quiz.html", controller: "monHocCtrl" })
        .otherwise({ templateUrl: "./includes/home.html", controller: "myCtrl" });
});

app.controller('myCtrl', function ($scope, $rootScope, $http, $location) {
   
   
});

app.controller('monHocCtrl', function ($scope, $http, $routeParams, $interval) {
   
});
