package com.lzb.oa.entity;

public class CustomerInfo {
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
	private String house_out_flag; // �����Ƿ���ɣ�0�����/1��δ��ɣ�
	
	private String roomer_no;       //�ͻ����
	private String roomer_name;     //�ͻ�����
	private String roomer_sex;      //�ͻ��Ա�
	private String roomer_phone_no; //�ͻ��ֻ�����
	private String roomer_email;    //�ͻ���������
	private String roomer_date;       //��������
	private String roomer_period;   //����ʱ���
	private String roomer_rent;     //�ͻ�����
	private String roomer_complete;  //������ɱ�ʾ
	private String roomer_emp_no;   //����Ա��
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
	public String getHouse_out_flag() {
		return house_out_flag;
	}
	public void setHouse_out_flag(String house_out_flag) {
		this.house_out_flag = house_out_flag;
	}
	public String getRoomer_no() {
		return roomer_no;
	}
	public void setRoomer_no(String roomer_no) {
		this.roomer_no = roomer_no;
	}
	public String getRoomer_name() {
		return roomer_name;
	}
	public void setRoomer_name(String roomer_name) {
		this.roomer_name = roomer_name;
	}
	public String getRoomer_sex() {
		return roomer_sex;
	}
	public void setRoomer_sex(String roomer_sex) {
		this.roomer_sex = roomer_sex;
	}
	public String getRoomer_phone_no() {
		return roomer_phone_no;
	}
	public void setRoomer_phone_no(String roomer_phone_no) {
		this.roomer_phone_no = roomer_phone_no;
	}
	public String getRoomer_email() {
		return roomer_email;
	}
	public void setRoomer_email(String roomer_email) {
		this.roomer_email = roomer_email;
	}
	
	public String getRoomer_date() {
		return roomer_date;
	}
	public void setRoomer_date(String roomer_date) {
		this.roomer_date = roomer_date;
	}
	public String getRoomer_period() {
		return roomer_period;
	}
	public void setRoomer_period(String roomer_period) {
		this.roomer_period = roomer_period;
	}
	public String getRoomer_rent() {
		return roomer_rent;
	}
	public void setRoomer_rent(String roomer_rent) {
		this.roomer_rent = roomer_rent;
	}
	public String getRoomer_complete() {
		return roomer_complete;
	}
	public void setRoomer_complete(String roomer_complete) {
		this.roomer_complete = roomer_complete;
	}
	public String getRoomer_emp_no() {
		return roomer_emp_no;
	}
	public void setRoomer_emp_no(String roomer_emp_no) {
		this.roomer_emp_no = roomer_emp_no;
	}
	public CustomerInfo() {
		
	}
	public CustomerInfo(String house_no, String house_type, String house_area,
			String house_price, String house_flag, String house_city,
			String house_address, String house_green_rating,
			String house_property, String house_owner_name,
			String house_owner_phone_no, String house_out_flag,
			String roomer_no, String roomer_name, String roomer_sex,
			String roomer_phone_no, String roomer_email, String roomer_date,
			String roomer_period, String roomer_rent, String roomer_complete,
			String roomer_emp_no) {
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
		this.house_out_flag = house_out_flag;
		this.roomer_no = roomer_no;
		this.roomer_name = roomer_name;
		this.roomer_sex = roomer_sex;
		this.roomer_phone_no = roomer_phone_no;
		this.roomer_email = roomer_email;
		this.roomer_date = roomer_date;
		this.roomer_period = roomer_period;
		this.roomer_rent = roomer_rent;
		this.roomer_complete = roomer_complete;
		this.roomer_emp_no = roomer_emp_no;
	}
	
	
	

}
