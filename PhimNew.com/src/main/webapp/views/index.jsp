<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fm" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">

                <title>PhimNew.com</title>

                <link rel="icon" type="image/x-icon" href="views/src/img/logo12.png">
                <!-- Bootstrap -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
                <link rel="stylesheet"
                    href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <!-- Font Awesome -->
                <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
                <!-- Google Fonts Roboto -->
                <link rel="stylesheet"
                    href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
                <!-- CSS -->
                <link rel="stylesheet" href="views/src/css/home-page.css">

                <!-- Angular JS-->
                <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
                <!-- AngularJS Route -->
                <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.min.js"></script>


            </head>

            <body ng-app="PhimNew" ng-controller="mainCtrl">
                <!-- Header -->
                <header class="header p-3 mb-1 border-bottom " id="header">
                    <%@include file="layout/header.jsp" %>
                </header>

                <main>
                    <ng-view></ng-view>
                </main>




                <!-- Footer -->
                <footer class="text-center text-lg-start text-white" style="background-color: #1c2331">
                    <%@include file="layout/footer.jsp" %>

                </footer>

                <!-- Footer -->


            </body>

            <script>
                var app = angular.module('PhimNew', ["ngRoute"]);
                app.config(function ($routeProvider) {
                    $routeProvider
                        .when("/home", {
                            templateUrl: "views/layout/HomePage.jsp",
                            controller: "homeCtrl"
                        })
                        .when("/timkiem", {
                            templateUrl: "views/layout/Trangtimkiem.jsp",
                            controller: "findCtrl"
                        })
                        .when("/watch", {
                            templateUrl: "views/watch.jsp",
                            controller: "watchCtrl"
                        })
                        .otherwise({
                            redirectTo: '/home',
                            controller: "homeCtrl"
                        });
                });
                app.controller('mainCtrl', function ($scope, $location, $http, $routeParams, $rootScope) {
                    console.log('loading');
                    // Định nghĩa hoặc truyền biến key tại đây
                    $scope.timkiem = function () {
                        $rootScope.nd = $scope.nd;
                        $location.path('/timkiem').search({ key: $scope.nd });
                    };
                });


                app.controller('findCtrl', function ($scope, $http, $routeParams, $rootScope) {
                    var key = $routeParams.key;
                    $scope.search = function () {
                        $rootScope.nd = key;
                        $http.get('/PhimNew/home/timkiem', { params: { key: key } })
                            .then(function (response) {
                                $scope.videos = response.data;
                                console.log('tìm: ' + key);
                            })
                            .catch(function (error) {
                                console.error('Error loading items:', error);
                            });
                    };
                    $scope.search();
                });


                app.controller('homeCtrl', function ($scope, $http) {

                    $scope.loadItems = function (tab) {
                        $scope.selectedTab = tab;
                        console.log(tab);
                        $http.get('/PhimNew/VideoLoad', { params: { tab: tab } })
                            .then(function (response) {
                                // Lấy dữ liệu trả về và gán cho biến $scope.videos để hiển thị trên trang
                                $scope.videos = response.data;
                            })
                            .catch(function (error) {
                                $scope.videos = null;
                                console.error('Error loading items:', error);
                            });
                    };

                    $scope.loadItems("made_for_you");

                    $scope.loadItemsTrend = function (tab) {
                        $scope.selectedTabTrend = tab;

                        console.log(tab);
                        $http.get('/PhimNew/VideoLoad', { params: { tab: tab } })
                            .then(function (response) {
                                // Lấy dữ liệu trả về và gán cho biến $scope.videos để hiển thị trên trang
                                $scope.videos2 = response.data;
                            })
                            .catch(function (error) {
                                $scope.videos2 = null;
                                console.error('Error loading items:', error);
                            });
                    };


                });


                app.controller('watchCtrl', function ($scope, $http, $routeParams, $sce) {
                    var id = $routeParams.id;
                    $scope.likeNum = 0;

                    $scope.loadVideo = function () {

                        // Kiểm tra trạng thái like của video
                        $http.get('/PhimNew/home/watch/CheckLike', { params: { id: id } })
                            .then(function (response) {
                                $scope.isLiked = response.data.isLiked;
                                $scope.likeNum = response.data.likeNum;
                            })
                            .catch(function (error) {
                                console.error('Error checking like status:', error);
                            });

                        $http.get('/PhimNew/home/video', { params: { id: id } })
                            .then(function (response) {
                                $scope.video = response.data;
                                console.log('load: ' + $scope.video.title);
                                $scope.url = 'https://www.youtube.com/embed/' + $scope.video.url;
                                $scope.url = $sce.trustAsResourceUrl($scope.url);
                            })
                            .catch(function (error) {
                                console.error('Error loading items:', error);
                            });
                    };


                    $scope.loadVideo();

                    $scope.toggleLike = function(){
                        $http.post('/PhimNew/home/video?id=' + id)
                        .then(function (response) {
                            $scope.isLiked = !$scope.isLiked;
                            $scope.likeNum = response.data;
                            console.log($scope.isLiked);
                        })
                        .catch(function (error) {
                            console.error('Error toggling like:', error);
                        });
                    }

                    
                });
            </script>

            </html>