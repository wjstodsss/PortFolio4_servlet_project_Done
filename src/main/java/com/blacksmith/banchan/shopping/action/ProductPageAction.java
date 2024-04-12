package com.blacksmith.banchan.shopping.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.blacksmith.banchan.product.dao.ProductDAO;
import com.blacksmith.banchan.product.dto.ProductVO;
import com.blacksmith.banchan.util.Action;

public class ProductPageAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/views/index.jsp";
        ProductDAO pDao = ProductDAO.getInstance();
        
        int categoryCount = 8; // 카테고리 개수
        List<List<ProductVO>> allProductLists = new ArrayList<>();

        // OAuth 2.0 인증 코드 가져오기
        String code = request.getParameter("code");
       System.out.println(code);
        if (code != null && !code.isEmpty()) {
            // OAuth 2.0의 인증 코드 처리
            String clientId = "ec9c8d7b291bb7ea6d12f8945029f0cc"; // 클라이언트 ID
            String redirectUri = "http://localhost:8080/banchan?command=index"; // 등록한 리다이렉트 URI

            // OAuth 2.0 인증 코드를 사용하여 액세스 토큰 요청
            String tokenEndpoint = "https://kauth.kakao.com/oauth/token"; // 토큰 엔드포인트
            String grantType = "authorization_code";
            String accessToken = null;

            try {
                // 액세스 토큰 요청을 위한 HTTP 요청 생성
                CloseableHttpClient httpClient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(tokenEndpoint);

                // POST 요청에 필요한 파라미터 설정
                List<NameValuePair> params = new ArrayList<>();
                params.add(new BasicNameValuePair("grant_type", grantType));
                params.add(new BasicNameValuePair("code", code));
                params.add(new BasicNameValuePair("redirect_uri", redirectUri));
                params.add(new BasicNameValuePair("client_id", clientId));
                httpPost.setEntity(new UrlEncodedFormEntity(params));

                // HTTP POST 요청 실행
                HttpResponse httpResponse = httpClient.execute(httpPost);

                // HTTP 응답 처리
                HttpEntity entity = httpResponse.getEntity();
                String responseString = EntityUtils.toString(entity, "UTF-8");
                
                // JSON 형식의 응답 파싱
                JSONObject jsonResponse = new JSONObject(responseString);
               System.out.println(jsonResponse);
                // 액세스 토큰 추출
                accessToken = jsonResponse.getString("access_token");
                
                // 사용자 정보 요청
                String userInfoEndpoint = "https://kapi.kakao.com/v1/oidc/userinfo";
                HttpGet httpGet = new HttpGet(userInfoEndpoint);
                httpGet.addHeader("Authorization", "Bearer " + accessToken);

                HttpResponse userInfoResponse = httpClient.execute(httpGet);
                HttpEntity userInfoEntity = userInfoResponse.getEntity();
                String userInfoString = EntityUtils.toString(userInfoEntity, "UTF-8");

                // 사용자 정보 응답을 JSON으로 파싱
                JSONObject userInfoJson = new JSONObject(userInfoString);
                System.out.println(userInfoJson);

                // 사용자 이메일 추출
                String email = userInfoJson.getString("email");
                System.out.println("사용자 이메일: " + email);

                // 이메일 정보를 세션에 저장하거나 데이터베이스에 유지
                request.getSession().setAttribute("userEmail", email);
                HttpSession session = request.getSession();
//                String userEmail = (String) session.getAttribute("userEmail");
//                System.out.println(userEmail + "요기");
                
            } catch (IOException e) {
                e.printStackTrace();
                // 오류 처리
            }

            // 사용자 정보 요청 등 추가 작업
        }


        // 카테고리별 제품 목록 가져오기
        for (int i = 1; i <= categoryCount; i++) {
            List<ProductVO> productList = pDao.selectProductsByCategoryCountNineLess(i);
            allProductLists.add(productList);
        }
        
        // 요청에 카테고리별 제품 목록 추가하기
        for (int i = 1; i <= categoryCount; i++) {
            String attributeName = "productList" + i;
            request.setAttribute(attributeName, allProductLists.get(i - 1));
        }
        
        // 포워딩
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
