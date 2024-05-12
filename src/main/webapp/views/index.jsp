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
    document.addEventListener("DOMContentLoaded", function() {
        let images = document.querySelectorAll('.fade-in-out-slider img');
        let index = 0;

        function fadeInOut() {
            
            images[index].classList.remove('active');

            index = (index + 1) % images.length;

            images[index].classList.add('active');
        }

        images[index].classList.add('active');

        // Set interval to call fadeInOut function every 5 seconds
        let interval = setInterval(fadeInOut, 2000);

        // Clear interval when mouse hovers over the slider
        document.querySelector('.fade-in-out-slider').addEventListener('mouseenter', function() {
            clearInterval(interval);
        });

        document.querySelector('.fade-in-out-slider').addEventListener('mouseleave', function() {
            interval = setInterval(fadeInOut, 2000);
        });
    });
</script>

</body>
</html>
