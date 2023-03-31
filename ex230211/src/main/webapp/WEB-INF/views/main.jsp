<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- swiper api -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.css"/>
<script src="https://cdn.jsdelivr.net/npm/swiper@9/swiper-bundle.min.js"></script>

<style>
	.swiper {
		width: 100%;
		height: 450px;
	}
	.swiper-scrollbar {
		background: #fefde1;
	}
	.swiper-scrollbar-drag {
		background: #4431bf;
	}
	img {
		width: 100%;
	}
</style>
<script type="text/javascript">
	window.addEventListener("load", function(){
		var swiper = new Swiper('.swiper', {
			// Optional parameters
			direction: 'horizontal',
			loop: true,
		  	// Navigation arrows
		  	navigation: {
		    	nextEl: '.swiper-button-next',
		    	prevEl: '.swiper-button-prev',
		  	},
		  	// And if we need scrollbar
		  	scrollbar: {
		    	el: '.swiper-scrollbar',
		  	},
		  	autoplay: {
		  	  	delay: 3000,
		  	 	pauseOnMouseEnter: true,
		  	 },
		});
	});
</script>
		
		<div class="container-800">
			<!-- Slider main container -->
			<div class="swiper">
				<!-- Additional required wrapper -->
			  	<div class="swiper-wrapper">
			    	<!-- Slides -->
			    	<div class="swiper-slide">
			    		<img src="/images/cat1.jpg">
			    	</div>
			    	<div class="swiper-slide">
			    		<img src="/images/cat2.jpg">
			    	</div>
			    	<div class="swiper-slide">
			    		<img src="/images/cat3.jpg">
			    	</div>
			    	<div class="swiper-slide">
			    		<img src="/images/dog1.jpg">
			    	</div>
			    	<div class="swiper-slide">
			    		<img src="/images/dog2.jpg">
			    	</div>
			    	<div class="swiper-slide">
			    		<img src="/images/dog3.jpg">
			    	</div>
			  	</div>
			 	<!-- If we need scrollbar -->
				<div class="swiper-scrollbar"></div>
			</div>
		</div>
		
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>