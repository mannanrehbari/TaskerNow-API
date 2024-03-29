package com.backend.rest.entity;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.backend.rest.converters.PaymentMethodJpaConverter;
import com.backend.rest.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="paymentinformation")
public class PaymentInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long taskerId;
	
	//optional
	private Long seekerId;
	
	private String reqTrackingId;
	
	private String paymentConfirmationNo;
	private Long serviceCharges;
	private Long otherCharges;
	private Long totalCharges;
	
	@Convert(converter = PaymentMethodJpaConverter.class)
	private PaymentMethod paymentMethod;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime paymentReportDate;
	
	// image properties
	private String name;
	private String type;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] imageByte;
	
	public PaymentInformation() {
	}
	
	public PaymentInformation(Long taskerId, String reqTrackingId, 
			String paymentConfirmationNo, Long serviceCharges,
			Long otherCharges, Long totalCharges,
			PaymentMethod paymentMethod) {
		this.taskerId = taskerId;
		this.reqTrackingId = reqTrackingId;
		this.paymentConfirmationNo = paymentConfirmationNo;
		this.serviceCharges = serviceCharges;
		this.otherCharges = otherCharges;
		this.totalCharges = totalCharges;
		this.paymentMethod = paymentMethod;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskerId() {
		return taskerId;
	}

	public void setTaskerId(Long taskerId) {
		this.taskerId = taskerId;
	}

	public Long getSeekerId() {
		return seekerId;
	}

	public void setSeekerId(Long seekerId) {
		this.seekerId = seekerId;
	}

	public String getReqTrackingId() {
		return reqTrackingId;
	}

	public void setReqTrackingId(String reqTrackingId) {
		this.reqTrackingId = reqTrackingId;
	}

	public String getPaymentConfirmationNo() {
		return paymentConfirmationNo;
	}

	public void setPaymentConfirmationNo(String paymentConfirmationNo) {
		this.paymentConfirmationNo = paymentConfirmationNo;
	}

	public Long getServiceCharges() {
		return serviceCharges;
	}

	public void setServiceCharges(Long serviceCharges) {
		this.serviceCharges = serviceCharges;
	}

	public Long getOtherCharges() {
		return otherCharges;
	}

	public void setOtherCharges(Long otherCharges) {
		this.otherCharges = otherCharges;
	}

	public Long getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(Long totalCharges) {
		this.totalCharges = totalCharges;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public LocalDateTime getPaymentReportDate() {
		return paymentReportDate;
	}

	public void setPaymentReportDate(LocalDateTime paymentReportDate) {
		this.paymentReportDate = paymentReportDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImageByte() {
		return imageByte;
	}

	public void setImageByte(byte[] imageByte) {
		this.imageByte = imageByte;
	}

	@Override
	public String toString() {
		return "PaymentInformation [id=" + id + ", taskerId=" + taskerId + ", seekerId=" + seekerId + ", reqTrackingId="
				+ reqTrackingId + ", paymentConfirmationNo=" + paymentConfirmationNo + ", serviceCharges="
				+ serviceCharges + ", otherCharges=" + otherCharges + ", totalCharges=" + totalCharges
				+ ", paymentMethod=" + paymentMethod + ", paymentReportDate=" + paymentReportDate + ", name=" + name
				+ ", type=" + type + ", imageByte=" + Arrays.toString(imageByte) + "]";
	}

}
