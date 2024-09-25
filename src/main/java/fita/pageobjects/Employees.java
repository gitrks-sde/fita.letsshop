package fita.pageobjects;

public class Employees {

	private String name;
	private String id;
	private char gender;
	private int age;
	private float salary;
	private String designation;
	
	public Employees(String name, String id, char gender, int age,float salary,String designation) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.age = age;
		this.salary=salary;
		this.designation=designation;
	}
	

	@Override
	public String toString() {
		return "Employees [name=" + name + ", id=" + id + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
	
}
