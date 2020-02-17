<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<!doctype html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel="icon" href="../../../../favicon.ico">
      <title>RileyWiki - ${article.title }</title>
      <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/album/">
      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
      <!-- JS Libraries -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
      <style>
         .sectionDiv{
         padding-left: 0px;
         border:3px solid #686868;
         padding-left: 0px;
         padding-right: 0px;
         padding-top: 15px;
         padding-bottom: 15px;
         margin: 10px;
         background-color: white;
         border-radius: 7px;
         overflow: auto;
         }
         .deleteButton{
         margin-bottom: 8px;
         border:1px solid black;
         width: 20px;
         height: 20px;
         padding: 3px 0 0 5px;
         font-weight: bold;
         background-color: #D5D5D5;
         }
         .handle{
         position:absolute;
         top: 10px;
         border: 1px solid black;
         margin-left: 20px;
         margin-right: 0px;
         height: 50px;
         width: 50px;
         background-color: #D5D5D5; 
         }
         .sectionDiv_col{
         display:inline-block;
         }
         textarea{
         margin: 0px;
         width: 95%;
         height: 160px;
         }
         .sectionTitleInput{
         margin-bottom: 10px;
         font-size:27px;
         text-align:center;
         width:85%
         }
         .sectionDiv_col{
         border: 2px solid green;
         }
         #sectionDiv_col_1{
         width: 80%;
         margin: 0px;
         padding: 0px;
         border: 2px solid red;
         }
      </style>
      <style>
         :root {
         --jumbotron-padding-y: 3rem;
         }
         .jumbotron {
         padding-top: var(--jumbotron-padding-y);
         padding-bottom: var(--jumbotron-padding-y);
         margin-bottom: 0;
         background-color: #fff;
         }
         @media (min-width: 768px) {
         .jumbotron {
         padding-top: calc(var(--jumbotron-padding-y) * 2);
         padding-bottom: calc(var(--jumbotron-padding-y) * 2);
         }
         }
         .jumbotron p:last-child {
         margin-bottom: 0;
         }
         .jumbotron-heading {
         font-weight: 300;
         }
         .jumbotron .container {
         max-width: 40rem;
         }
         footer {
         padding-top: 3rem;
         padding-bottom: 3rem;
         }
         footer p {
         margin-bottom: .25rem;
         }
         .box-shadow { box-shadow: 0 .25rem .75rem rgba(0, 0, 0, .05); }
      </style>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
      <script>
         var currentSectionCount = ${article.sections.size()};
         var sortableArr;
         
         function deleteSection(index) {
         	$("#sectionDiv_" + index).remove();
         }
         
         $( function() {
         	$( "#sectionSpan" ).sortable();
         });
         
         function createNewSection() {
         	newSectionHtml = 
         		'<div id="sectionDiv_' + currentSectionCount + '" class="sectionDiv">'
         				+ '<input class="sectionTitleInput" id="sections' + currentSectionCount  + '.title" name="sections[' + currentSectionCount  + '].title" style="font-size:23px;" type="text"value="Section Title"/><br/>'
         				+ '<textarea id="sections' + currentSectionCount  + '.content" name="sections[' + currentSectionCount  + '].content" rows="5" cols="30"></textarea><br/>'
         				+ '<input name="sectionNum" type="hidden" value="' + currentSectionCount  + '"/>'
         			+ '<div class="container text-center" style="width:30%">'
         				+ '<c:url value="/createNewArticle" var="createNewArticleUrl"/>'
         				+ '<a style="color:white;font-size:20px" onclick="deleteSection(' + currentSectionCount + ')" class="btn btn-danger my-2">Delete</a>'
         			+ '</div>'
         	   + '</div>'
         	
         	//Sets the new divs ID based on how many items are in the array. If I allow deleting, this could cause problems
         	$("#sectionSpan").append(newSectionHtml);
         	currentSectionCount++;
         }
         
         function changeMode() {
         	var data = { test: "test" };
         	$.ajax({
         		  type: 'POST',
         		  url: 'http://localhost:8080/spring/changeMode',
         		  dataType: "html",
         		  success: function(e){
         			  window.location.reload(true); 
         		  },
         		  error: function(xhr, status, error){
         			  //alert(alert(xhr.responseText));
         		  }
         		});
         }
      </script>
   </head>
   <body>
      <header>
         <div class="collapse bg-dark" id="navbarHeader">
            <div class="container">
               <div class="row">
                  <div class="col-sm-8 col-md-7 py-4">
                     <h4 class="text-white">About RileyWiki</h4>
                     <p class="text-muted">...</p>
                  </div>
                  <div class="col-sm-4 offset-md-1 py-4">
                     <h4 class="text-white">Contact</h4>
                     <ul class="list-unstyled">
                        <li><a href="#" class="text-white">Follow on Twitter</a></li>
                        <li><a href="#" class="text-white">Like on Facebook</a></li>
                        <li><a href="#" class="text-white">Email me</a></li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
         <div class="navbar navbar-dark bg-dark box-shadow">
            <div class="container d-flex justify-content-between">
               <c:url value="/" var="rootUrl"/>
               <a href="${rootUrl }" class="navbar-brand d-flex align-items-center">
                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mr-2">
                     <path d="M23 19a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h4l2-3h6l2 3h4a2 2 0 0 1 2 2z"></path>
                     <circle cx="12" cy="13" r="4"></circle>
                  </svg>
                  <strong>RileyWiki</strong>
               </a>
               <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
               <span class="navbar-toggler-iconXXX"></span>
               </button>
            </div>
         </div>
      </header>
      <section class="jumbotron text-center">
         <div class="container">
            <p class="lead text-muted" style="font-size:27px;margin-bottom:35px;">Click and drag to reorder sections!</p>
            <c:url var="url" value="/saveArticle" />
            <form:form modelAttribute="article" method="post" action="${url }">
               <form:input path="title" style="font-size:40px; margin-bottom: 10px; text-align:center; width:95%"/>
               <br/>
               <div id="sectionDiv_0" class="sectionDiv" style="border:5px solid black;">
                  <h3 style="margin: 0;">Summary</h3>
                  <form:hidden path="sections[0].title" />
                  <br/>
                  <form:textarea path="sections[0].content" rows="5" cols="30"/>
                  <br/>
                  <input name="sectionNum" type="hidden" value="0"/>
               </div>
               <span id="sectionSpan">
                  <c:forEach var="i" begin="1" end="${article.sections.size() - 1}">
                     <div id="sectionDiv_${i }" class="sectionDiv">
                        <form:input class="sectionTitleInput" path="sections[${i}].title"/>
                        <br/>
                        <form:textarea path="sections[${i}].content" rows="5" cols="30"/>
                        <br/>
                        <input name="sectionNum" type="hidden" value="${i }"/>
                        <div class="container text-center" style="width:30%">
                           <c:url value="/createNewArticle" var="createNewArticleUrl"/>
                           <a style="color:white;font-size:20px" onclick="deleteSection(${i})" class="btn btn-danger my-2">Delete</a>
                        </div>
                     </div>
                  </c:forEach>
               </span>
               <form:hidden path="id" />
               <div class="container text-center">
                  <p>
                     <a style="color: white;" onclick="createNewSection()" class="btn btn-info my-2">Add Section</a>
                  </p>
               </div>
               <p></p>
               <div class="container text-center">
                  <p>
                     <c:url value="/createNewArticle" var="createNewArticleUrl"/>
                     <input type="submit" value="Save Changes" class="btn btn-primary my-2"/>
                     <c:if test="${not empty article.id}">
                        <c:url value="/deleteArticle/${article.id }" var="deleteArticleUrl"/>
                        <a style="color: white;" onclick="window.location.href = '${deleteArticleUrl}';" class="btn btn-danger my-2">Delete Article</a>
                        <c:url value="/articles/${article.id }/view" var="viewArticleUrl"/>
                        <a style="color: white;" onclick="window.location.href = '${viewArticleUrl}';" class="btn btn-secondary my-2">Cancel</a>
                     </c:if>
                     <c:if test="${empty article.id}">
                        <c:url value="/" var="rootUrl"/>
                        <a style="color: white;" onclick="window.location.href = '${rootUrl}';" class="btn btn-secondary my-2">Cancel</a>
                     </c:if>
                     <!-- <a href="#" class="btn btn-secondary my-2">Secondary action</a> -->
                  </p>
               </div>
            </form:form>
         </div>
      </section>
       <footer class="text-muted">
         <div class="container">
            <p>&copy; <a href="https://getbootstrap.com/">Bootstrap</a></p>
         </div>
      </footer>
   </body>
</html>