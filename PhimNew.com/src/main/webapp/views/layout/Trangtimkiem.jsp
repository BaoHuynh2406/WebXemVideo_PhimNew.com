<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html lang="en">

	<head>
		<title>Trang tìm kiếm</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
		<!-- Angular JS-->
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
		<!-- Font Awesome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
		<style>
			.videoitem:hover {
				scale: 1.02;
				background-color: rgba(213, 229, 255, 0.271);
				color: #333;
			}

			.videoitem {
				transition: all ease 0.1s;
			}

			a {
				text-decoration: none;
				color: #333;
			}
		</style>
	</head>

	<body ng-app="MyApp" ng-controller="controller">



		<div clasns="container d-flex flex-column align-items-center">

			<!-- SEARCH -->
			<form class="d-flex align-items-center justify-content-center mt-5">
				<div class="input-group">
					<input type="text" ng-model="nd" name="NDtimkiem" class="form-control" placeholder="Tìm kiếm...">
					<div class="input-group-append">
						<button ng-click="timkiem()" class="btn btn-primary">
							<i class="bi bi-search"></i>
						</button>
					</div>
				</div>
			</form>

			<div class="card my-3 col-10 videoitem" ng-repeat="v in videos">
				<a  href="/PhimNew/home/video?id={{v.Id}}"
				style="border-radius: 20px; box-shadow: 0 0 15px rgba(10, 10, 10, 0.3);">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="../src/img/{{v.poster}}" class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">{{v.title}}</h5>
							<p class="card-text">{{v.des}}</p>
							<span class=" fs-7">{{v.views | number}}<i class="far fa-eye ms-1 me-3"></i>{{100 |
								number}}<i style="color: red;" class="ms-1 bi bi-heart-fill"></i>
							</span>
						</div>
					</div>
				</div>
			</a>
			</div>
			



		</div>

	</body>
	<script>
		var app = angular.module('MyApp', []);


		app.controller('controller', function ($scope, $http) {

			$scope.timkiem = function () {
				$http.get('/PhimNew/timkiem', { params: { nd: $scope.nd } })
					.then(function (response) {
						$scope.videos = response.data;
					})
					.catch(function (error) {

						console.error('Error loading items:', error);
					});
			};
		});


	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

	</html>