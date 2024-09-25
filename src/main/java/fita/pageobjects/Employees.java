package fita.pageobjects;

public class Employees {

	private String name;
	private String id;
	private char gender;
	private int age;
	private String designation;
	
	public Employees(String name, String id, char gender, int age, String designation) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.designation=designation;
	}
	

	@Override
	public String toString() {
		return "Employees [name=" + name + ", id=" + id + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
	
}
