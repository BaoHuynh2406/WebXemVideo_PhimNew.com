<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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



	<div class="container d-flex flex-column align-items-center" style="margin-top: 100px;">

		<div class="card my-3 col-10 videoitem" ng-repeat="v in videos">
			<a href="/PhimNew/home/video?id={{v.Id}}"
				style="border-radius: 20px; box-shadow: 0 0 15px rgba(10, 10, 10, 0.3);">
				<div class="row g-0">
					<div class="col-md-4">
						<img src="views/src/img/{{v.poster}}" class="img-fluid rounded-start" alt="...">
					</div>
					<div class="col-md-8">
						<div class="card-body">
							<h5 class="card-title">{{v.title}}</h5>
							<p style="max-height: 100px; overflow-y: auto;" class="card-text">{{v.des}}</p>
							<span  class=" fs-7">{{v.views | number}}<i class="far fa-eye ms-1 me-3"></i>{{100 |
								number}}<i style="color: red;" class="ms-1 bi bi-heart-fill"></i>
							</span>
						</div>
					</div>
				</div>
			</a>
		</div>




	</div>