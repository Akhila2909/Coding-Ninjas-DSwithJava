package classes_and_objects;

import java.util.Scanner;
 
public class StudentUse {

		public static void main(String[] args) {

//			Student s1 = new Student();
//			s1.name = "Ankush";
//			s1.rollNumber = 123;
//			
//			Student s2 = new Student();
//			s2.name = "Manisha";
//			s2.rollNumber = 121;
//			
//			System.out.println(s1.name);
//			System.out.println(s2.name);
		
			
//				Scanner s = new Scanner(System.in);
//				
//				Student s1 = new Student();
//				s1.name = "Ankush";
//				s1.setRollnumber(-123);
//				
//				Student s2 = new Student();
//				s2.name = "Manisha";
//				s2.setRollnumber(121);
//				
//				System.out.println(s1.name);
//				System.out.println(s2.name);
//				System.out.println(s1.getRollNumber());

				
//				Student s1 = new Student("Ankush", 123);
//				s1.print();
//				Student s2 = new Student("Manisha", 121);
//				s2.print();				
				
				
				
				Student s1 = new Student("Ankush", 123);
				s1.print();	
				Student s2 = new Student("Manisha", 121);
				s2.print();
				System.out.println(Student.getNumStudents());				
				System.out.println(s1.name);
				
		}
}
