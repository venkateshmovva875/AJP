package model;

public class StudentModel {
	private int id;
	private String name;
	private String phone;

	
	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentModel(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
}
