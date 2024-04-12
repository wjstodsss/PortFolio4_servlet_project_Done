package com.blacksmith.banchan.payment.dto;
import java.time.LocalDateTime;

public class DeliveryVO {
    private int deliveryId;
    private int orderId;
    private LocalDateTime deliveryDate;
    private String recipientName;
    private String roadAddress;
    private String jibunAddress;
    private String detailAddress;
    private String zipcode;
    private String phoneNumber;

    public DeliveryVO() {
    }

    public DeliveryVO(int deliveryId, int orderId, LocalDateTime deliveryDate, String recipientName, String roadAddress, String jibunAddress, String detailAddress, String zipcode, String phoneNumber) {
        this.deliveryId = deliveryId;
        this.orderId = orderId;
        this.deliveryDate = deliveryDate;
        this.recipientName = recipientName;
        this.roadAddress = roadAddress;
        this.jibunAddress = jibunAddress;
        this.detailAddress = detailAddress;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRoadAddress() {
        return roadAddress;
    }

    public void setRoadAddress(String roadAddress) {
        this.roadAddress = roadAddress;
    }

    public String getJibunAddress() {
        return jibunAddress;
    }

    public void setJibunAddress(String jibunAddress) {
        this.jibunAddress = jibunAddress;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", orderId=" + orderId +
                ", deliveryDate=" + deliveryDate +
                ", recipientName='" + recipientName + '\'' +
                ", roadAddress='" + roadAddress + '\'' +
                ", jibunAddress='" + jibunAddress + '\'' +
                ", detailAddress='" + detailAddress + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
