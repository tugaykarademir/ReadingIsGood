package com.getir.ReadingIsGood.dto;

public class StatisticsResponseDto {
 private String month;
 private Integer totalOrderCount;
 private Integer totalBookCount;
 private Long totalPurchasedAmount;
 
public StatisticsResponseDto() {
	super();
}
public StatisticsResponseDto(String month, Integer totalOrderCount, Integer totalBookCount, Long totalPurchasedAmount) {
	super();
	this.month = month;
	this.totalOrderCount = totalOrderCount;
	this.totalBookCount = totalBookCount;
	this.totalPurchasedAmount = totalPurchasedAmount;
}
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public Integer getTotalOrderCount() {
	return totalOrderCount;
}
public void setTotalOrderCount(Integer totalOrderCount) {
	this.totalOrderCount = totalOrderCount;
}
public Integer getTotalBookCount() {
	return totalBookCount;
}
public void setTotalBookCount(Integer totalBookCount) {
	this.totalBookCount = totalBookCount;
}
public Long getTotalPurchasedAmount() {
	return totalPurchasedAmount;
}
public void setTotalPurchasedAmount(Long totalPurchasedAmount) {
	this.totalPurchasedAmount = totalPurchasedAmount;
}
@Override
public String toString() {
	return "StatisticsResponseDto [month=" + month + ", totalOrderCount=" + totalOrderCount + ", totalBookCount="
			+ totalBookCount + ", totalPurchasedAmount=" + totalPurchasedAmount + "]";
}
 
 
}
