package com.lzb.oa.entity;

public class HouseInfo {
	private String house_no; // ��Դ���
	private String house_type; // �������ͣ�����������
	private String house_area; // �������
	private String house_price; // ��/�ۼ۸�
	private String house_flag; // ��/�۱�ʶ��0����/1���ۣ�
	private String house_city; // �������ڳ���
	private String house_address; // ������ϸ��ַ
	private String house_green_rating; // С���̻����
	private String house_property; // С����ҵ
	private String house_owner_name; // ��������
	private String house_owner_phone_no; // ������ϵ��ʽ
	private String house_emp_no; // ����Ա����
	private String house_out_flag; // �����Ƿ���ɣ�0�����/1��δ��ɣ�
	

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getHouse_type() {
		return house_type;
	}

	public void setHouse_type(String house_type) {
		this.house_type = house_type;
	}

	public String getHouse_area() {
		return house_area;
	}

	public void setHouse_area(String house_area) {
		this.house_area = house_area;
	}

	public String getHouse_price() {
		return house_price;
	}

	public void setHouse_price(String house_price) {
		this.house_price = house_price;
	}

	public String getHouse_flag() {
		return house_flag;
	}

	public void setHouse_flag(String house_flag) {
		this.house_flag = house_flag;
	}

	public String getHouse_city() {
		return house_city;
	}

	public void setHouse_city(String house_city) {
		this.house_city = house_city;
	}

	public String getHouse_address() {
		return house_address;
	}

	public void setHouse_address(String house_address) {
		this.house_address = house_address;
	}

	public String getHouse_green_rating() {
		return house_green_rating;
	}

	public void setHouse_green_rating(String house_green_rating) {
		this.house_green_rating = house_green_rating;
	}

	public String getHouse_property() {
		return house_property;
	}

	public void setHouse_property(String house_property) {
		this.house_property = house_property;
	}

	

	public String getHouse_owner_name() {
		return house_owner_name;
	}

	public void setHouse_owner_name(String house_owner_name) {
		this.house_owner_name = house_owner_name;
	}

	public String getHouse_owner_phone_no() {
		return house_owner_phone_no;
	}

	public void setHouse_owner_phone_no(String house_owner_phone_no) {
		this.house_owner_phone_no = house_owner_phone_no;
	}

	public String getHouse_emp_no() {
		return house_emp_no;
	}

	public void setHouse_emp_no(String house_emp_no) {
		this.house_emp_no = house_emp_no;
	}

	public String getHouse_out_flag() {
		return house_out_flag;
	}

	public void setHouse_out_flag(String house_out_flag) {
		this.house_out_flag = house_out_flag;
	}

	public HouseInfo() {

	}

	public HouseInfo(String house_no, String house_type, String house_area,
			String house_price, String house_flag, String house_city,
			String house_address, String house_green_rating,
			String house_property, String house_owner_name,
			String house_owner_phone_no, String house_emp_no,
			String house_out_flag) {
		super();
		this.house_no = house_no;
		this.house_type = house_type;
		this.house_area = house_area;
		this.house_price = house_price;
		this.house_flag = house_flag;
		this.house_city = house_city;
		this.house_address = house_address;
		this.house_green_rating = house_green_rating;
		this.house_property = house_property;
		this.house_owner_name = house_owner_name;
		this.house_owner_phone_no = house_owner_phone_no;
		this.house_emp_no = house_emp_no;
		this.house_out_flag = house_out_flag;
	}

}
