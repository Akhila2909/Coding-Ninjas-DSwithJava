package classes_and_objects;

public class Student {
//	String name;
//	int rollNumber;
	
	
	
//	public String name;
//	private int rollNumber;
//	
//	public void setRollnumber(int rn) {
//		if (rn <= 0) {
//			return;
//		}
//		rollNumber = rn;
//	}
//	
//	public int getRollNumber() {
//		return rollNumber;
//	}
//	

	
	
	
	
//	public String name;
//	private int rollNumber;
//	
//	public Student() {
//		rollNumber = 100;
//	}
//	
//	public Student(String n) {
//		name  = n;
//		rollNumber = 100;
//	}
//	
//	public Student(String n, int rn) {
//		name = n;
//		rollNumber = rn;
//	}
//	
//	public void setRollnumber(int rn) {
//		if (rn <= 0) {
//			return;
//		}
//		rollNumber = rn;
//	}
//	
//	public int getRollNumber() {
//		return rollNumber;
//	}
//	
//	public void print() {
//		System.out.println(name + " : " + rollNumber);
//	}
	

	
	
	public String name;
	private final int rollNumber;
	private static int numStudents;
	
	public Student(String name, int rollNumber) {
		this.name = name;
		this.rollNumber = rollNumber;
		numStudents++;
	}
	
	public static int getNumStudents() {
		return numStudents;
	}
	
	
	public void print() {
       System.out.println(name + " : " + rollNumber);
	}
	
	
}
