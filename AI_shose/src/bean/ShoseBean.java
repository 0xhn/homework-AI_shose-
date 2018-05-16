package bean;

import java.sql.Date;

public class ShoseBean {
	int id;
	String S_name,S_type,S_season,S_fabric;
	Float S_size,S_price;
	Date s_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String s_name) {
		S_name = s_name;
	}
	public String getS_type() {
		return S_type;
	}
	public void setS_type(String s_type) {
		S_type = s_type;
	}
	public String getS_season() {
		return S_season;
	}
	public void setS_season(String s_season) {
		S_season = s_season;
	}
	public String getS_fabric() {
		return S_fabric;
	}
	public void setS_fabric(String s_fabric) {
		S_fabric = s_fabric;
	}
	public Float getS_size() {
		return S_size;
	}
	public void setS_size(Float s_size) {
		S_size = s_size;
	}
	public Float getS_price() {
		return S_price;
	}
	public void setS_price(Float s_price) {
		S_price = s_price;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public ShoseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShoseBean(int id, String s_name, String s_type, String s_season, String s_fabric, Float s_size,
			Float s_price, Date s_date) {
		super();
		this.id = id;
		S_name = s_name;
		S_type = s_type;
		S_season = s_season;
		S_fabric = s_fabric;
		S_size = s_size;
		S_price = s_price;
		this.s_date = s_date;
	}
	@Override
	public String toString() {
		return "ShoseBean [id=" + id + ", S_name=" + S_name + ", S_type=" + S_type + ", S_season=" + S_season
				+ ", S_fabric=" + S_fabric + ", S_size=" + S_size + ", S_price=" + S_price + ", s_date=" + s_date + "]";
	}
	

}
