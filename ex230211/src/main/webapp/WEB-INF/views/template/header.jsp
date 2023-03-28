<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/css/load.css">
    <link rel="stylesheet" type="text/css" href="/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/test.css">
    <link rel="stylesheet" type="text/css" href="/css/commons.css">
    <link rel="stylesheet" type="text/css" href="/css/layout.css">
    <!-- font awsome 아이콘 -->
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
    <!-- tabler 아이콘 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@tabler/icons-webfont@latest/tabler-icons.min.css">
    <!-- jquery cdn -->
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <title>개발하는 쿼카</title>
    <style>
        .logo {
            border-radius: 100px;
            width: 70px;
            height: 70px;
            justify-content: center;
        }
        .logo-title {
            display: inline;
        }
        .logo-box {
            align-items: center;
        }
        .member-icons {
            align-items: center;
        }
        .member-icon {
            font-size: 1.5em;
            color: #4431bf;
        }
        .member-link {
            text-align: center;
        }
        .link-text {
            display: block;
            color: #4431bf;
        }
        .category-link {
            align-items: center;
        }
    </style>
    <script type="text/javascript">
        $(function() {
            
        })
    </script>
</head>
<body>
    <main>
        <header>
            <div class="container-800">
                <div class="flex">
                    <div class="w-30">
                        <a class="link flex logo-box" href="/">
                            <img class="logo me-10" src="/images/logo.jpg" alt="로고">
                            <h2 class="logo-title title">개발하는 쿼카</h2>
                        </a>
                    </div>
                    <div class="w-50 flex center">
                        <a class="link w-50 center category-link flex" href="/lectures/list">
                            <h3 class="title">강의</h3>
                        </a>
                        <a class="link w-50 center category-link flex" href="/board/list">
                            <h3 class="title">QnA 게시판</h3>
                        </a>
                        <c:if test="${sessionScope.memberLevel == 'admin'}">
							<a class="link w-50 center category-link flex" href="/admin">
								<h3 class="title">관리</h3>
							</a>
						</c:if>
                    </div>
                    <div class="w-20 flex right">
                    	<c:choose>
							<c:when test="${sessionScope.memberID == null}">
		                        <div class="flex member-icons me-20">
		                            <a class="link member-link" href="/members/join">
		                                <i class="fa-solid fa-user member-icon join"></i>
		                                <span class="link-text">회원가입</span>
		                            </a>
		                        </div>
		                        <div class="flex member-icons">
		                            <a class="link member-link" href="/members/login">
		                                <i class="fa-solid fa-lock member-icon login"></i>
		                                <span class="link-text">로그인</span>
		                            </a>
		                        </div>
                        	</c:when>
							<c:otherwise>
		                        <div class="flex member-icons me-20">
		                            <a class="link member-link" href="/members/mypage">
		                                <i class="fa-solid fa-user member-icon mypage"></i>
		                                <span class="link-text">마이페이지</span>
		                            </a>
		                        </div>
		                        <div class="flex member-icons">
		                            <a class="link member-link" href="/members/logout">
		                                <i class="fa-solid fa-lock-open member-icon logout"></i>
		                                <span class="link-text">로그아웃</span>
		                            </a>
		                        </div>
		                    </c:otherwise>
						</c:choose>
                    </div>
                </div>
            </div>
        </header>
        <section>
            <article>