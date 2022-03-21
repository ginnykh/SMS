package org.khj.domain;

public class smsStoreDTO {

	private int ino;
	private int sno;
	private String s_name;
	private String shipping_fee;
	private String price;
	
	public int getino() {
		return ino;
	}
	public void setino(int ino) {
		this.ino = ino;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getShipping_fee() {
		return shipping_fee;
	}
	public void setShipping_fee(String shipping_fee) {
		this.shipping_fee = shipping_fee;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "smsStoreDTO [ino=" + ino + ", sno=" + sno + ", s_name=" + s_name + ", shipping_fee=" + shipping_fee
				+ ", price=" + price + "]";
	}
	
}
