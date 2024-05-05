function checkAdminTokenAndRedirect() {
    // 세션 스토리지에서 토큰을 가져옴
    var adminToken = sessionStorage.getItem("adminToken");
    
    // 토큰이 없으면 로그인 페이지로 리다이렉트
    if (!adminToken) {
        window.location.href = "banchan?command=admin_login_form";
    }
}