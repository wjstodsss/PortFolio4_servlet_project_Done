package com.blacksmith.banchan.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.blacksmith.banchan.payment.dto.DeliveryVO;
import com.blacksmith.banchan.util.DBManager;

public class DeliveryDAO {
	private static DeliveryDAO instance = new DeliveryDAO();

    private DeliveryDAO() {}

    public static DeliveryDAO getInstance() {
        return instance;
    }

    public String registerDeliveryInfo(DeliveryVO deliveryVO) {
        String sql = "insert into tbl_delivery(recipient_name, road_address, jibun_address, detail_address, zipcode, phone_number) values(?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, deliveryVO.getOrderId());
            pstmt.setString(3, deliveryVO.getRecipientName());
            pstmt.setString(4, deliveryVO.getRoadAddress());
            pstmt.setString(5, deliveryVO.getJibunAddress());
            pstmt.setString(6, deliveryVO.getDetailAddress());
            pstmt.setString(7, deliveryVO.getZipcode());
            pstmt.setString(8, deliveryVO.getPhoneNumber());
            
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                return "success";
            } else {
                return "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
