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

            <body ng-app="PhimNew">
                <!-- Header -->
                <header class="header p-3 mb-1 border-bottom " id="header">
                    <%@include file="layout/header.jsp" %>
                </header>

                <main ng-controller="Block_video">
                    <%@include file="layout/HomePage.jsp" %>
                </main>




                <!-- Footer -->
                <footer class="text-center text-lg-start text-white" style="background-color: #1c2331">
                    <%@include file="layout/footer.jsp" %>

                </footer>
                <!-- Footer -->


            </body>

            <script src="views/src/Js/index.js"></script>
            <script>
                var app = angular.module('PhimNew', []);



                app.controller('Block_video', function ($scope, $http) {

                    // Gọi hàm loadItems khi trang web vừa được load
                    $scope.$on('$viewContentLoaded', function () {
                        loadItems('made_for_you');
                        loadItemsTrend('nhieu_luot_xem');
                        console.log('chạy cái này');
                    });


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


            </script>

            </html>