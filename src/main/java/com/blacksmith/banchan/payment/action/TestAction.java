package com.blacksmith.banchan.payment.action;


import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blacksmith.banchan.payment.dao.DeliveryDAO;
import com.blacksmith.banchan.payment.dao.OrderDAO;
import com.blacksmith.banchan.payment.dao.OrderDetailDAO;
import com.blacksmith.banchan.payment.dao.PaymentGatewayDAO;
import com.blacksmith.banchan.payment.dto.DeliveryVO;
import com.blacksmith.banchan.payment.dto.OrderDetailVO;
import com.blacksmith.banchan.payment.dto.OrderVO;
import com.blacksmith.banchan.payment.dto.PaymentGatewayVO;
import com.blacksmith.banchan.util.Action;
import com.blacksmith.banchan.util.DBManager;



public class TestAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String[] itemId = request.getParameterValues("id");
		String[] itemPrice = request.getParameterValues("price");
		String[] itemQuantity = request.getParameterValues("quantity");
		
		
		
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
		
		if(pVo != null) {
			Connection conn = null;
			try {
				int orderId = 0;
				int deliveryId = 0;
				
			    conn = DBManager.getConnection();
			    conn.setAutoCommit(false);
			
				String dateString = request.getParameter("currentDate");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. M. d. a h:mm:ss", Locale.KOREAN);
				LocalDateTime orderDate = LocalDateTime.parse(dateString, formatter);
	
				int totalPrice = Integer.parseInt(request.getParameter("totalPrice"));
				String paymentMethod = request.getParameter("paymentMethod");
				int memberId = Integer.parseInt(request.getParameter("memberId"));
				String recipientName = request.getParameter("recipientName");
			    String roadAddress = request.getParameter("roadAddress");
			    String jibunAddress = request.getParameter("jibunAddress");
			    String detailAddress = request.getParameter("detailAddress");
			    String zipcode = request.getParameter("zipcode");
			    String phoneNumber = request.getParameter("phoneNumber");
				
				
				OrderVO orderVo =  new OrderVO();
				OrderDAO orderDao =  OrderDAO.getInstance();
				orderVo.setMemberId(memberId);
				orderVo.setOrderDate(orderDate);
				orderVo.setTotalPrice(totalPrice);
				orderVo.setPaymentMethod(paymentMethod);
				orderId = orderDao.insertOrderInfo(orderVo, conn);
				
				
					System.out.println(orderId);
					
					DeliveryVO deliveryVo = new DeliveryVO();
					DeliveryDAO deliveryDao = DeliveryDAO.getInstance();
					
					deliveryVo.setOrderId(orderId);
					deliveryVo.setDeliveryDate(orderDate);
					deliveryVo.setRecipientName(recipientName);
					deliveryVo.setRoadAddress(roadAddress);
					deliveryVo.setJibunAddress(jibunAddress);
					deliveryVo.setDetailAddress(detailAddress);
					deliveryVo.setZipcode(zipcode);
					deliveryVo.setPhoneNumber(phoneNumber);
					
					System.out.println("성공");
					
					deliveryId = deliveryDao.insertDeliveryInfo(deliveryVo, conn);
					
					System.out.println(deliveryId);
			
					System.out.println(deliveryId);
					System.out.println(orderId);
					OrderDetailVO orderDetailVo = new OrderDetailVO(); 
					OrderDetailDAO orderDetailDao = OrderDetailDAO.getInstance();
					System.out.println(orderId + "kk");
					int result = 0;
					int length = itemId.length;
					for (int i = 0; i < length; i++) {
						orderDetailVo.setOrderId(orderId);
						orderDetailVo.setDeliveryId(deliveryId);
						orderDetailVo.setProductId(Integer.parseInt(itemId[i]));
						orderDetailVo.setQuantity(Integer.parseInt(itemQuantity[i]));
						orderDetailVo.setPrice(Integer.parseInt(itemPrice[i]));
						orderDetailDao.insertOrderDetailInfo(orderDetailVo, conn);
					}
					
					System.out.println("성공");
				
			
				conn.commit();
			} catch (SQLException e) {
			    // 롤백
			    if (conn != null) {
			        try {
			            conn.rollback();
			        } catch (SQLException rollbackException) {
			            rollbackException.printStackTrace();
			        }
			    }
			    e.printStackTrace();
			} finally {
			    // 커넥션 반환 및 자원 해제
			    if (conn != null) {
			        try {
			            conn.setAutoCommit(true);
			            conn.close();
			        } catch (SQLException closeException) {
			            closeException.printStackTrace();
			        }
			    }
			}
		}
		response.sendRedirect("banchan?command=order-complete");
	}
}
