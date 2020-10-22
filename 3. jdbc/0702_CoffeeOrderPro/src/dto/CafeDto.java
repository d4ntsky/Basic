package dto;

import java.io.Serializable;

public class CafeDto implements Serializable {

	private String id;
	private String coffee;
	private String cupsize;
	private String addsyrp;
	private String addshot;
	private String addwhip;
	private int cups;
	private int price;

	public CafeDto() {

	}

	public CafeDto(String id, String coffee, String cupsize, String addsyrp, String addshot, String addwhip, int cups,
			int price) {
		super();
		this.id = id;
		this.coffee = coffee;
		this.cupsize = cupsize;
		this.addsyrp = addsyrp;
		this.addshot = addshot;
		this.addwhip = addwhip;
		this.cups = cups;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoffee() {
		return coffee;
	}

	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}

	public String getCupsize() {
		return cupsize;
	}

	public void setCupsize(String cupsize) {
		this.cupsize = cupsize;
	}

	public String getAddsyrp() {
		return addsyrp;
	}

	public void setAddsyrp(String addsyrp) {
		this.addsyrp = addsyrp;
	}

	public String getAddshot() {
		return addshot;
	}

	public void setAddshot(String addshot) {
		this.addshot = addshot;
	}

	public String getAddwhip() {
		return addwhip;
	}

	public void setAddwhip(String addwhip) {
		this.addwhip = addwhip;
	}

	public int getCups() {
		return cups;
	}

	public void setCups(int cups) {
		this.cups = cups;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CafeDto [id=" + id + ", coffee=" + coffee + ", cupsize=" + cupsize + ", addsyrp=" + addsyrp
				+ ", addshot=" + addshot + ", addwhip=" + addwhip + ", cups=" + cups + ", price=" + price + "]";
	}

}
