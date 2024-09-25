package fita.pageobjects;

public class Employees {

	private String name;
	private String id;
	private char gender;
	private int age;
	
	public Employees(String name, String id, char gender, int age) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.age = age;
	}
	

	@Override
	public String toString() {
		return "Employees [name=" + name + ", id=" + id + ", gender=" + gender + ", age=" + age + "]";
	}
	
	
	
	
	
}
