package com.akorobtc.angualrspringapp.beans;

public class SiteImageInfo {
	
    private String url;
    private int quantity;
    private int totalSize;
    private long startTime;
    private int processingTime;
	
	public SiteImageInfo(String url, int quantity,
			int totalSize, long startTime, int processingTime) {
		this.url = url;
		this.quantity = quantity;
		this.totalSize = totalSize;
		this.startTime = startTime;
		this.processingTime = processingTime;
	}
	public SiteImageInfo() {
	}
    
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public Integer getProcessingTime() {
		return processingTime;
	}
	public void setProcessingTime(Integer processingTime) {
		this.processingTime = processingTime;
	}


}
