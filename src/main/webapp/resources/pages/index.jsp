<%--
  Created by IntelliJ IDEA.
  User: Etheros
  Date: 4/22/2018
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QuestInfo</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,600&amp;subset=latin-ext" rel="stylesheet">

    <!-- CSS -->
    <link href="assets/css/main.css" rel="stylesheet">

    <!-- JS -->
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
    <script src="assets/js/vendor/jquery-1.12.0.min.js"></script>
</head>
<body background="/Authentication/assets/css/17861.jpg">
<style>
    <%@include file="assets/css/main.css"%>
</style>
<script>
    <%@include file="assets/js/vendor/modernizr-2.8.3.min.js"%>
    <%@include file="assets/js/vendor/jquery-1.12.0.min.js"%>
</script>

<div class="site" id="page">
    <a class="skip-link sr-only" href="#main">Skip to content</a>

    <!-- Options headline effects: .rotate | .slide | .zoom | .push | .clip -->
    <section class="hero-section hero-section--image clearfix clip">
        <div class="hero-section__wrap">
            <div class="hero-section__option">
                <img src="assets/images/index.jpg" alt="Hero section image">
            </div>
            <!-- .hero-section__option -->

            <div class="container">
                <div class="row">
                    <div class="offset-lg-2 col-lg-8">
                        <div class="title-01 title-01--11 text-center">
                            <h2 class="title__heading">
                                <span>Ти</span>
                                <strong class="hero-section__words">
                                    <span class="title__effect is-visible">унікальний?</span>
                                    <span class="title__effect">креативний?</span>
                                    <span class="title__effect">вільний?</span>
                                </strong>
                            </h2>
                            <div class="title__description">Якщо це про тебе, тоді випробуй себе і спробуй пройти до кінця. В кінці тебе чекає дещо цікаве :)</div>

                            <!-- Options btn color: .btn-success | .btn-info | .btn-warning | .btn-danger | .btn-primary -->
                            <div class="title__action"><a href="/start" class="btn btn-success">Розпочнемо?</a></div>
                        </div> <!-- .title-01 -->
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<!-- JS -->
<script>
    <%@include file="assets/js/plugins/animate-headline.js"%>
</script>
<script>
    <%@include file="assets/js/main.js"%>
</script>
</body>
</html>
