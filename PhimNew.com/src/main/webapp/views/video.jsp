<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
    content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<title>Video management</title>
    <style type="text/css">
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;900&display=swap');

*, body {
    font-family: 'Poppins', sans-serif;
    font-weight: 300;
    -webkit-font-smoothing: antialiased;
    text-rendering: optimizeLegibility;
    -moz-osx-font-smoothing: grayscale;
}

html, body {
    height: 100%;
    background-color: #152733;
}

.form-holder {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
}

.form-holder .form-content {
    position: relative;
    text-align: center;
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-align-items: center;
    align-items: center;
    padding-top: 15px;
}

.form-content .form-items {
    border: 3px solid #fff;
    padding: 40px;
    display: inline-block;
    width: 100%;
    min-width: 540px;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
    text-align: left;
    -webkit-transition: all 0.4s ease;
    transition: all 0.4s ease;
}

.form-content h3 {
    color: #fff;
    text-align: left;
    font-size: 28px;
    font-weight: 600;
    margin-bottom: 5px;
}

.form-content h3.form-title {
    margin-bottom: 30px;
}

.form-content p {
    color: #fff;
    text-align: left;
    font-size: 17px;
    font-weight: 300;
    line-height: 20px;
    margin-bottom: 30px;
}


.form-content label, .was-validated .form-check-input:invalid~.form-check-label, .was-validated .form-check-input:valid~.form-check-label{
    color: #fff;
}

.form-content input[type=text], .form-content input[type=password], .form-content input[type=email], .form-content select {
    width: 100%;
    padding: 9px 20px;
    text-align: left;
    border: 0;
    outline: 0;
    border-radius: 6px;
    background-color: #fff;
    font-size: 15px;
    font-weight: 300;
    color: #8D8D8D;
    -webkit-transition: all 0.3s ease;
    transition: all 0.3s ease;
    margin-top: 16px;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active{
    background-color: #495056;
    outline: none !important;
    border: none !important;
     box-shadow: none;
}
.btn-warning:hover, .btn-warning:focus, .btn-warning:active{
    background-color: #495056;
    outline: none !important;
    border: none !important;
     box-shadow: none;
}
.btn-danger:hover, .btn-danger:focus, .btn-danger:active{
    background-color: #495056;
    outline: none !important;
    border: none !important;
     box-shadow: none;
}
.btn-success:hover, .btn-success:focus, .btn-success:active{
    background-color: #495056;
    outline: none !important;
    border: none !important;
     box-shadow: none;
}
.btn-success,.btn-danger,.btn-warning,.btn-primary{width:86px}
.form-content textarea {
    position: static !important;
    width: 100%;
    padding: 8px 20px;
    border-radius: 6px;
    text-align: left;
    background-color: #fff;
    border: 0;
    font-size: 15px;
    font-weight: 300;
    color: #8D8D8D;
    outline: none;
    resize: none;
    height: 120px;
    -webkit-transition: none;
    transition: none;
    margin-bottom: 14px;
}

.form-content textarea:hover, .form-content textarea:focus {
    border: 0;
    background-color: #ebeff8;
    color: #8D8D8D;
}

.mv-up{
    margin-top: -9px !important;
    margin-bottom: 8px !important;
}

.invalid-feedback{
    color: #ff606e;
}

.valid-feedback{
   color: #2acc80;
}
    </style>
    
</head>
<body>
    <div class="form-body">
        <div class="row">
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Video Management</h3>
                        <p>Fill in the data below.</p>
                        <form class="requires-validation" novalidate method="POST" action="Controller_Video" enctype="multipart/form-data">

                            <div class="row">
                                <div class="col">
                                <div class="col-md-12">
                                <input class="form-control" type="number" name="videoID" placeholder="VideoID" required value="${video.id}" readonly style="background-color: gray; color:white">
                               <div class="valid-feedback">VideoID field is valid!</div>
                               <div class="invalid-feedback">VideoID field cannot be blank!</div>
                            </div>

                            <div class="col-md-12">
                                <input class="form-control" type="text" name="title" placeholder="Title" required value="${video.title}">
                                 <div class="valid-feedback">Title field is valid!</div>
                                 <div class="invalid-feedback">Title field cannot be blank!</div>
                            </div>

                           <div class="col-md-12">
                                <input class="form-control" type="text" name="description" placeholder="Description" required value="${video.description}">
                                <div class="valid-feedback">Description is entered!</div>
                                <div class="invalid-feedback">Please enter description!</div>
                           </div>
                            
                        
                           <div class="col-md-12" style="margin-top: 20px">
                                <label style="color: black;" class="form-check-label text-white">Choose Poster</label>
                               <div class="form-control d-inline" >
                                <input type="file" class="custom-file-input" id="inputGroupFile04"  name="poster">
                                </div>
                           </div> 
                           <div class="col-md-12">
                           
						    <input class="form-control" type="text" name="url" placeholder="URL" required value="${video.url}">
						    <div class="valid-feedback">URL field is valid!</div>
						    <div class="invalid-feedback">URL field cannot be blank!</div>
						</div>
                           
                            </div>
                           <div class="col" style="width: 0px">
                            <c:if test="${not empty video.poster}">
                                <div class="col-md-12" style="margin-top: 14px">
                                    <div class="row align-items-center" >
                                        <img src="/Lab6_NguyenThaiBinh_PS14048/Posters/${video.poster}" class="myImage" style="height: 232.5px ;width: 200px;"/>
                                        <c:set var="myImage" value ="${video.poster}" scope="session"/>
                                    </div>
                                </div>
                            </c:if>      
                           </div>
                            </div>                        

                           <div class="row">
                            <div class="col-md-12 mt-3">
                            <label class="mb-3 mr-1" for="gender">Active: </label>

                            <input type="radio" class="btn-check" name="active" id="male" autocomplete="off" required value="true" ${video.active?'checked':''}>
                            <label class="btn btn-sm btn-outline-secondary" for="male">Yes</label>

                            <input type="radio" class="btn-check" name="active" id="female" autocomplete="off" required value="false" ${!video.active?'checked':''}>
                            <label class="btn btn-sm btn-outline-secondary" for="female">No</label>

                               <div class="valid-feedback mv-up">You selected an active status!</div>
                                <div class="invalid-feedback mv-up">Please select an active status!</div>
                            </div>
                  
                            
                            <div class="form-button mt-3">
                                <c:choose>
                                <c:when test="${disabled == 'disabled'}"><button id="submit" type="submit" class="btn btn-primary" formaction="Controller/VideoCreate" disabled>Create</button></c:when>
                                <c:otherwise><button id="submit" type="submit" class="btn btn-primary" formaction="Controller/VideoCreate">Create</button></c:otherwise>
                                </c:choose>                     
                                <button id="submit" type="submit" class="btn btn-warning" formaction="Controller/VideoUpdate">Update</button>
                                <button id="submit" type="submit" class="btn btn-danger" formaction="Controller/VideoDelete">Delete</button>
                                <button id="submit" type="submit" class="btn btn-success" formaction="Controller/VideoReset">Reset</button>
                            </div>
                            <div class="col-md-12">
                                <c:if test="${not empty message}">
                                    <div class="alert alert-success">${message}</div>
                                </c:if>
                                <c:if test="${not empty error}">
                                    <div class="alert alert-danger">${error}</div>
                                </c:if>
                            </div>                   
                           </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <br />
        <div class="container">    
        <table class="table table-bordered table-hover mt-2 table-light">
          <thead class="table-primary">
            <tr>
              <th scope="col">No</th>
              <th scope="col">Video ID</th>
              <th scope="col">Title</th>
              <th scope="col">Poster</th>
              <th scope="col">Description</th>
              <th scope="col">Active</th>
              <th scope="col">Views</th>
              <th scope="col">Edit/Remove</th>
            </tr>
          </thead>
          <tbody>
            <c:set var="count" value="${0}" scope="request"/>
            <c:forEach var="item" items="${videos}">
            <c:set var="count" value="${count+1}" scope="request"/>
            <tr>
              <th scope="row"><c:out value="${requestScope.count}"/></th>
              <td>${item.id}</td>
              <td>${item.title}</td>
              <td>${item.poster}</td>
              <td>${item.des}</td>
              <td>${item.active?'Yes':'No'}</td>
              <td>${item.views}</td>
              <td>
                <a href="Controller/VideoEdit?videoID=${item.id}">Edit</a>
                <a href="Controller/VideoDelete?videoID=${item.id}">Remove</a>
              </td>
            </tr>
            </c:forEach>

          </tbody>
    </table>
        
        
        </div>
    </div>
    <script type="text/javascript">
    (function () {
        'use strict'
        const forms = document.querySelectorAll('.requires-validation')
        Array.from(forms)
          .forEach(function (form) {
            form.addEventListener('submit', function (event) {
              if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
              }

              form.classList.add('was-validated')
            }, false)
          })
        })()
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>
