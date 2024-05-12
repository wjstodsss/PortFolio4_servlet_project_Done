package com.blacksmith.banchan.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.blacksmith.banchan.payment.dto.OrderVO;

public class OrderDAO {
	
	private OrderDAO() {
	}

	private static OrderDAO instance = new OrderDAO();

	public static OrderDAO getInstance() {
		return instance;
	}
	
	public int insertOrderInfo(OrderVO orderVo, Connection conn) throws SQLException  {
	    String sql = "INSERT INTO tbl_order (member_id, order_date, total_price) VALUES (?, ?, ?)";
	    try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        
	        pstmt.setInt(1, orderVo.getMemberId());
	        pstmt.setObject(2, java.sql.Timestamp.valueOf(orderVo.getOrderDate()));
	        pstmt.setInt(3, orderVo.getTotalPrice());
	        
	        int affectedRows = pstmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("주문 추가 실패: No rows affected.");
	        }
	        
	        // 생성된 주문 ID 가져오기
	        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("주문 추가 실패: No ID obtained.");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // 또는 로깅 프레임워크를 사용하여 로그에 기록
	        throw e;
	    }
	}


}
