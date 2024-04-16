<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="includes/head_set.jsp"%>
<%@include file="includes/body_init.jsp"%>
<%@include file="includes/top_banner.jsp"%>
<%@include file="includes/header.jsp"%>
<%@include file="includes/main_slide.jsp"%>
<%@include file="includes/product_list.jsp"%>
<%@include file="includes/cart.jsp"%>
<%@include file="includes/footer.jsp"%>

<script>
        /* slider */
        /* 메인 슬라이더 페이드 인 페이드 아웃 기능 
        v0.01 : 240107 setTime()메서드에 시간을 입력하며 하드 코딩함
        v0.02 : 240110 로직을 조금 만들어 함수를 활용하지만 개체수 증가시 코드도 함께 증가
        v0.03 : 240115 개체수 증가시 코드 증가 문제 해결 -> 이미지 추가 시 아이디만 배열에 추가
        v0.04 : 240119 웹페이지 포커스 대기간 쌓이는 인터벌로 인한 페이드 인, 아웃 이상 현상 개선/visiblechange이벤트 활용
        */
        
        function fadeInManager() {

            let opacityValueFadeIn = 0;
            function FadeInUnit(image) {
                this.image = image;
                this.fadeIn = function () {
                    document.getElementById(image).style.opacity = opacityValueFadeIn;
                    opacityValueFadeIn += 0.1;
                    if (opacityValueFadeIn >= 1.5) {
                        clearInterval(myFadeIn);
                        opacityValueFadeIn = 0;
                    }
                }
                let myFadeIn = setInterval(this.fadeIn, 100);
            }

            let imageIdIndexFadeIn = 0;
            function repeatFadeIn() {
                const imageId = ["mobileAward", "delivery"];
                if (imageIdIndexFadeIn == imageId.length) {
                    stopFadeInInterval();
                    return
                }
                let createFadeIn = new FadeInUnit(imageId[imageIdIndexFadeIn]);
                imageIdIndexFadeIn++;
            }

            let fadeInInterval = setInterval(repeatFadeIn, 2500);

            function stopFadeInInterval() {
                clearInterval(fadeInInterval);
            }
        }

        function fadeOutManager() {

            let opacityValueFadeOut = 1;
            function FadeOutUnit(image) {
                this.image = image;
                this.fadeOut = function () {
                    document.getElementById(image).style.opacity = opacityValueFadeOut;
                    opacityValueFadeOut -= 0.1;
                    if (opacityValueFadeOut <= -0.7) {
                        clearInterval(myFadeOut);
                        opacityValueFadeOut = 1;
                    }
                }
                let myFadeOut = setInterval(this.fadeOut, 100);
            }

            let imageIdIndexFadeOut = 1;
            function repeatFadeOut() {
                const imageId = ["mobileAward", "delivery"];
                if (imageIdIndexFadeOut < 0) {
                    stopFadeOutInterval();
                    return
                }
                let createFadeOut = new FadeOutUnit(imageId[imageIdIndexFadeOut]);
                imageIdIndexFadeOut--;
            }

            let fadeOutInterval = setInterval(repeatFadeOut, 2500);

            function stopFadeOutInterval() {
                clearInterval(fadeOutInterval);
            }
        }

        let sliderTimer;

        function repeat() {
            setTimeout(fadeOutManager, 0);
            setTimeout(fadeInManager, 6000);
        }

        function sliderStart() {
            setTimeout(repeat, 0);
            sliderTimer = setInterval(repeat, 12000);
        }

        function sliderStop() {
            clearInterval(sliderTimer);
        }

        sliderStart();
</script>