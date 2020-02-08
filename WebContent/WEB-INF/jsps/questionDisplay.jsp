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
            <p>
               <u>
            <h1 class="display-4" style="margin-bottom:60px">${article.title }</h1></u>
            <c:forEach var="section" items="${article.sections}">
               <h3 class="text-left">${section.title}</h3>
               <hr />
               <class="text-left">${section.content}</p>
               <p></p>
            </c:forEach>
         </div>
      </section>
      <div class="container text-center">
         <p>
            <c:url value="/createNewArticle" var="createNewArticleUrl"/>
            <c:url value="/articles/${article.title }/edit" var="editArticleUrl"/>
            <a style="color: white;" onclick="window.location.href = '${editArticleUrl}';" class="btn btn-primary my-2">Edit</a>
            <a style="color: white;" onclick="window.location.href = '${rootUrl}';" class="btn btn-secondary my-2">Back</a>
            <!-- <a href="#" class="btn btn-secondary my-2">Secondary action</a> -->
         </p>
      </div>
      <footer class="text-muted">
         <div class="container">
            <p>&copy; <a href="https://getbootstrap.com/">Bootstrap</a></p>
         </div>
      </footer>
   </body>
</html>