package com.blacksmith.banchan.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.blacksmith.banchan.payment.dto.DeliveryVO;
import com.blacksmith.banchan.payment.dto.OrderVO;
import com.blacksmith.banchan.util.DBManager;

public class DeliveryDAO {
	private static DeliveryDAO instance = new DeliveryDAO();

	private DeliveryDAO() {
	}

	public static DeliveryDAO getInstance() {
		return instance;
	}

	public int insertDeliveryInfo(DeliveryVO deliveryVo, Connection conn) throws SQLException {
		String sql = "INSERT INTO tbl_delivery (order_id, delivery_date, recipient_name, road_address, jibun_address, detail_address, zipcode, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pstmt.setInt(1, deliveryVo.getOrderId());
			pstmt.setObject(2, java.sql.Timestamp.valueOf(deliveryVo.getDeliveryDate()));
			pstmt.setString(3, deliveryVo.getRecipientName());
			pstmt.setString(4, deliveryVo.getRoadAddress());
			pstmt.setString(5, deliveryVo.getJibunAddress());
			pstmt.setString(6, deliveryVo.getDetailAddress());
			pstmt.setString(7, deliveryVo.getZipcode());
			pstmt.setString(8, deliveryVo.getPhoneNumber());

			int affectedRows = pstmt.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("배송 정보 추가 실패: No rows affected.");
			}


			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					return generatedKeys.getInt(1);
				} else {
					throw new SQLException("배송 정보 추가 실패: No ID obtained.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 또는 로깅 프레임워크를 사용하여 로그에 기록
			throw e;
		}
	}

}
