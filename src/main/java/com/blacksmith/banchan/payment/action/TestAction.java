package com.blacksmith.banchan.payment.action;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.payment.dao.DeliveryDAO;
import com.blacksmith.banchan.payment.dao.PaymentGatewayDAO;
import com.blacksmith.banchan.payment.dto.DeliveryVO;
import com.blacksmith.banchan.payment.dto.PaymentGatewayVO;
import com.blacksmith.banchan.util.Action;



public class TestAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
		    String parameterName = parameterNames.nextElement();
		    System.out.println("Parameter - " + parameterName + ": " + request.getParameter(parameterName));
		}
		
		
		String cardNumber = request.getParameter("cardNumber");
		int expirationMM = Integer.parseInt(request.getParameter("expirationMMInput"));
		int expirationYY = Integer.parseInt(request.getParameter("expirationYYInput"));
		String cvc = request.getParameter("cvc");
		String cardHolderName = request.getParameter("cardHolderName");		
		
		PaymentGatewayVO pVo =  new PaymentGatewayVO();
		PaymentGatewayDAO pDao =  PaymentGatewayDAO.getInstance( );
		
		pVo.setCardNumber(cardNumber);
		pVo.setExpirationMM(expirationMM);
		pVo.setExpirationYY(expirationYY);
		pVo.setCvc(cvc);
		pVo.setCardHolderName(cardHolderName);
		
		pVo = pDao.searchCardInfo(pVo);
		
//		if(pVo != null) {
//			
//			int expirationYY = Integer.parseInt(request.getParameter("expirationYYInput"));
//			int expirationMM = Integer.parseInt(request.getParameter("expirationMMInput"));
//			String cardNumber = request.getParameter("cardNumber");
//			int expirationYY = Integer.parseInt(request.getParameter("expirationYYInput"));
//			String cvc = request.getParameter("cvc");
//			
//			
//			PaymentGatewayVO pVo =  new PaymentGatewayVO();
//			PaymentGatewayDAO pDao =  PaymentGatewayDAO.getInstance( );
//			
//			pVo.setCardNumber(cardNumber);
//			pVo.setExpirationMM(expirationMM);
//			pVo.setExpirationYY(expirationYY);
//			pVo.setCvc(cvc);
//			pVo.setCardHolderName(cardHolderName);
//			
//			pVo = pDao.searchCardInfo(pVo);
//			
//		}
//			String recipientName = request.getParameter("recipientName");
//			String zipcode = request.getParameter("zipcode");
//			String roadAddress = request.getParameter("roadAddress");
//			String jibunAddress = request.getParameter("jibunAddress");
//			String detailAddress = request.getParameter("detailAddress");
//			String phoneNumber = request.getParameter("phoneNumber");
//			
//			DeliveryVO deliveryVo =  new DeliveryVO();
//			DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
//			
//			deliveryVo.setRecipientName(recipientName);
//			deliveryVo.setZipcode(zipcode);
//			deliveryVo.setRoadAddress(roadAddress);
//			deliveryVo.setJibunAddress(jibunAddress);
//			deliveryVo.setDetailAddress(detailAddress);
//			deliveryVo.setPhoneNumber(phoneNumber);
//			
//			deliveryDAO.registerDeliveryInfo(deliveryVo);
//			
//			
//			
//			
//			
//			
//			
//			String recipientName = request.getParameter("recipientName");
//			String zipcode = request.getParameter("zipcode");
//			String roadAddress = request.getParameter("roadAddress");
//			String jibunAddress = request.getParameter("jibunAddress");
//			String detailAddress = request.getParameter("detailAddress");
//			String phoneNumber = request.getParameter("phoneNumber");
//			
//			DeliveryVO deliveryVo =  new DeliveryVO();
//			DeliveryDAO deliveryDAO = DeliveryDAO.getInstance();
//			
//			deliveryVo.setRecipientName(recipientName);
//			deliveryVo.setZipcode(zipcode);
//			deliveryVo.setRoadAddress(roadAddress);
//			deliveryVo.setJibunAddress(jibunAddress);
//			deliveryVo.setDetailAddress(detailAddress);
//			deliveryVo.setPhoneNumber(phoneNumber);
//			
//			deliveryDAO.registerDeliveryInfo(deliveryVo);
//			
//			
			
			// 아마 배송정보도 저장해야하고
			// 아마 구매정보도 저장해야하는데
			// 누군지 모르겠음 ㅠㅠ
			
			
			
			
			
			
			
			
			
//			
//			
//		} else {
//			System.out.println("fail");
//		}
//	    
//	    
	    
	    
//	    // 클라이언트로 응답 전송
//	    response.setContentType("text/plain");
//	    response.setCharacterEncoding("UTF-8");
//	    response.getWriter().write("Cart items received successfully");
	}



}
