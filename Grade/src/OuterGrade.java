import java.util.ArrayList;
import java.util.Scanner;


public class School {
	
	static int CNT = 0;
	
	ArrayList<Student> list = new ArrayList<Student>();
	
	void addInfo() {
		
		Student obj = new Student();
		if(obj.input())
			return;
		obj.processGrade();
		list.add(obj);
	}

	void removeInfo(int index) {
		list.remove(index);
	}
	
	int getStudentNum() {
		return list.size();
	}
	
	Student getSutudentObj(int index) {
		return list.get(index);
	}
	
	double getTotalAvg() {
		double total_avg = 0.0;
		
		for(Student dat : list) {
			total_avg += dat.avg;
		}
		int CNT = list.size();
		return total_avg / CNT;
	}
	
	 
	
	class Student {
		
		String hakbun, name;
		int kor, math, eng, sum;
		double avg;
		char grade;
		
		Student(){ }
		
		boolean input() {
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Input your name => ");
			name = scan.next();
			System.out.println("Input your student code => ");
			hakbun = scan.next();
			// duplicate value check
			for(Student obj : list) {
				if(hakbun.equals(obj.hakbun)) {
					System.out.println("중복 학번 존재함");
					return true;
				}
			}
			System.out.println("Input your English score =>");
			eng = scan.nextInt();
			System.out.println("Input your Korean score =>");
			kor = scan.nextInt();
			System.out.println("Input your math score =>");
			math = scan.nextInt();
			
			System.out.println();
			return false;
		}
		
		void processGrade() {
			
			sum = getTotal();
			avg = getAvg();
			
			if(avg >= 90)
				grade = '수';
			if( avg >= 80 && avg < 90)
				grade = '우';
			if( avg >= 70 && avg < 80)
				grade = '미';
			if( avg >= 60 && avg < 70)
				grade = '양';
			if( avg < 60)
				grade = '가';
			
		}
		int getTotal() {
			return kor + math + eng;
		}
		double getAvg() {
			return sum / 3.;
		}
	
		void printOut() {
			
			System.out.printf("│%3s      %3s       %3d        %3d       %3d          %3d         %5.2f     %3s    │\n", 
					name, hakbun, eng, kor, math, sum, avg, grade);
		}
		void update() {
			Scanner scan = new Scanner(System.in);
			System.out.println("Input your English score =>");
			eng = scan.nextInt();
			System.out.println("Input your Korean score =>");
			kor = scan.nextInt();
			System.out.println("Input your math score =>");
			math = scan.nextInt();
			
			System.out.println();
		}
	} // end class_Student
}
