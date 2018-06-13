package com.saven.model;

public class GapsIndex {

    private Long	minute;
    private String	flavor;
    private String	feed;
    private Long	recv;
    private Long	miss;
    private Long	fill;
    
	public Long getMinute() {
		return minute;
	}
	public void setMinute(Long minute) {
		this.minute = minute;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	public String getFeed() {
		return feed;
	}
	public void setFeed(String feed) {
		this.feed = feed;
	}
	public Long getRecv() {
		return recv;
	}
	public void setRecv(Long recv) {
		this.recv = recv;
	}
	public Long getMiss() {
		return miss;
	}
	public void setMiss(Long miss) {
		this.miss = miss;
	}
	public Long getFill() {
		return fill;
	}
	public void setFill(Long fill) {
		this.fill = fill;
	}

}
