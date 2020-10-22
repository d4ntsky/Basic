package dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {

	private String id;
	private String pwd;
	private String name;
	private String cuge;

	public CustomerDto(String id, String pwd, String name, String cuge) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.cuge = cuge;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuge() {
		return cuge;
	}

	public void setCuge(String cuge) {
		this.cuge = cuge;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", cuge=" + cuge + "]";
	}

}