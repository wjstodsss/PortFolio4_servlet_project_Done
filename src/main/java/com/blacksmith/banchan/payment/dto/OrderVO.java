package com.blacksmith.banchan.payment.dto;


import java.time.LocalDateTime;

public class OrderVO {
    private Integer orderId;
    private Integer memberId;
    private LocalDateTime orderDate;
    private Integer totalPrice;
    private String paymentMethod;

    public OrderVO() {
        // 기본 생성자
    }


    // Getter 및 Setter 메서드
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "orderId=" + orderId +
                ", memberId=" + memberId +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
