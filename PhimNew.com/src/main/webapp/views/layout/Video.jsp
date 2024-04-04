<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<Section>
    <iframe width="700" height="400" src="https://www.youtube.com/embed/${v.url}" 
    title="YouTube video player" 
    frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>

    <h1>Tên Video ${v.title}</h1>
    <h3>Mô tả: ${v.des}</h3>
    <h3>View: ${v.views}</h3>
    <input class="btn" type="button" name="like" id="" value="Like">
    <input class="btn" type="button" name="like" id="" value="Share">
</Section>