<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<Section>
    <iframe width="700" height="400" src="https://www.youtube.com/embed/${v.url}" 
    title="YouTube video player" 
    frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

    <h1>Tên Video ${v.title}</h1>
    <h3>Mô tả: ${v.des}</h3>
    <h3>View: ${v.views}</h3>
    <form action="video" method="post">
        <input type="hidden" name="userId" value="<%= session.getAttribute("userId") %>">
        <input type="hidden" name="videoId" value="${v.id}">
        <input class="btn-like" type="submit" value="Chưa yêu thích">
    </form>
    <input class="btn" type="button" name="share" id="" value="Share">
</Section>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var likeButton = document.querySelector(".btn-like");
        var isLiked = false;
        likeButton.addEventListener("click", function () {
            if (isLiked) {
                likeButton.value = "Chưa yêu thích";
            } else {
                likeButton.value = "Đã yêu thích";
            }
            isLiked = !isLiked;
        });
    });
</script>
