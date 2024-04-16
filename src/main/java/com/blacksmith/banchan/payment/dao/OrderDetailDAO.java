package com.blacksmith.banchan.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.blacksmith.banchan.payment.dto.OrderDetailVO;

public class OrderDetailDAO {
	
	private static OrderDetailDAO instance = new OrderDetailDAO();

	private OrderDetailDAO() {
	}

	public static OrderDetailDAO getInstance() {
		return instance;
	}

	public void insertOrderDetailInfo(OrderDetailVO orderDetailVo, Connection conn) throws SQLException {
		String sql = "INSERT INTO tbl_order_detail (order_id, delivery_id, product_id, quantity, price) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderDetailVo.getOrderId());
			pstmt.setInt(2, orderDetailVo.getDeliveryId());
			pstmt.setInt(3, orderDetailVo.getProductId());
			pstmt.setInt(4, orderDetailVo.getQuantity());
			pstmt.setInt(5, orderDetailVo.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace(); // 또는 로깅 프레임워크를 사용하여 로그에 기록
		    throw e; // SQLException을 그대로 던짐
		}
	}
}
