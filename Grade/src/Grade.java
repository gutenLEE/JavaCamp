import java.util.Scanner;

public class Grade {
	String name, studentCode;
	int kor, math, eng, sum;
	double avg;
	
	char grade;
	
	static int cnt = 0;
	static double total_avg = 0;
	
	Grade(){	}
	
	void createScore(){
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input your name => ");
		name = scan.next();
		System.out.println("Input your student code => ");
		studentCode = scan.next();
		System.out.println("Input your English score =>");
		eng = scan.nextInt();
		System.out.println("Input your Korean score =>");
		kor = scan.nextInt();
		System.out.println("Input your math score =>");
		math = scan.nextInt();
		
		System.out.println();
	
	}
	
	void getGrade() {
		
		sum = eng + kor + math;
		avg = (eng + kor + math) / 3.;
		
	
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
	
	static double getTotalAvg() {
		
		return total_avg / Grade.cnt;
	}
	
	void readGradeSheet() {
	
		System.out.printf("│%3s      %3s       %3d        %3d       %3d          %3d         %5.2f     %3s    │\n", 
														name, studentCode, eng, kor, math, sum, avg, grade);
		System.out.println("└───────────────────────────────────────────────────────────────────────────────────┘");
	}
	
	void updateGradeSheet() {

		Scanner scan = new Scanner(System.in);

		System.out.println("Input your English score =>");
		eng = scan.nextInt();
		System.out.println("Input your Korean score =>");
		kor = scan.nextInt();
		System.out.println("Input your math score =>");
		math = scan.nextInt();
		
		System.out.println();
	}
	
	void searchGradeSheet() {
		System.out.println("┌────────────────────────────────***  조회 결과 ***─────────────────────────────────┐");
		System.out.println("│                                                                                   │");
		System.out.println("│이름     학번       영어      국어      수학        총점         평균       등급   │");
		System.out.println("│===================================================================================│");
		System.out.printf("│%3s      %3s       %3d        %3d       %3d          %3d         %5.2f     %3s    │\n", 
				name, studentCode, eng, kor, math, sum, avg, grade);
		System.out.println("└───────────────────────────────────────────────────────────────────────────────────┘");
	}
}
			