package com.blacksmith.banchan.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blacksmith.banchan.payment.dto.PaymentGatewayVO;
import com.blacksmith.banchan.util.DBManager;

public class PaymentGatewayDAO {
    
    private static PaymentGatewayDAO instance = new PaymentGatewayDAO();

    private PaymentGatewayDAO() {}

    public static PaymentGatewayDAO getInstance() {
        return instance;
    }

    public PaymentGatewayVO searchCardInfo(PaymentGatewayVO paymentGatewayVO) {
        String sql = "SELECT * FROM tbl_payment_gateway WHERE cardNumber=? AND expirationMM=? AND expirationYY=? AND cvc=? AND cardHolderName=?";
        PaymentGatewayVO pVo = null;

        try (Connection conn = DBManager.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, paymentGatewayVO.getCardNumber());
            pstmt.setInt(2, paymentGatewayVO.getExpirationMM());
            pstmt.setInt(3, paymentGatewayVO.getExpirationYY());
            pstmt.setString(4, paymentGatewayVO.getCvc());
            pstmt.setString(5, paymentGatewayVO.getCardHolderName());
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    pVo = new PaymentGatewayVO();
                    pVo.setCardNumber(rs.getString("cardNumber"));
                    pVo.setExpirationMM(rs.getInt("expirationMM"));
                    pVo.setExpirationYY(rs.getInt("expirationYY"));
                    pVo.setCvc(rs.getString("cvc"));
                    pVo.setCardHolderName(rs.getString("cardHolderName"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pVo;
    }
}
