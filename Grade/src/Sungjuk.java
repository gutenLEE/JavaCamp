import java.util.Scanner;

public class Sungjuk extends Person {
	
	int kor, eng, math, tot;
	String grade;
	double avg;
	
	Sungjuk(){
	}

	@Override
	void input() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�й� => ");
		hakbun = scan.next();
		System.out.println("�̸� => ");
		irum = scan.next();
		System.out.println("���� ���� => ");
		kor = scan.nextInt();
		System.out.println("���� ���� => ");
		eng = scan.nextInt();
		System.out.println("���� ���� => ");
		math = scan.nextInt();
	
	}

	@Override
	void output() {
		// TODO Auto-generated method stub
//		process();
		System.out.println("�й�       �̸�      ����       ����       ����       ����       ���        ���");
		System.out.println("=================================================================================");
		System.out.printf("%5s      %4s     %3d      %3d       %3d       %3d       %.2f       %7s ", hakbun, irum,  kor, eng, math, tot, avg, grade);
		System.out.println("\n-------------------------------------------------------------------------------");
	}
	
	void process() {
		this.tot = this.kor + this.eng + this.math;
		this.avg = this.tot / 3.;
		
		if( ( avg / 3) >= 90 ) {
			grade = "Exellent";
		}
		else if ( ( avg / 3) >= 80 && ( avg / 3) > 90 ) {
			grade = "Great";
		}
		else if ( ( avg / 3) >= 70 && ( avg / 3) > 80 ) {
			grade = "Good";
		}
		else if ( ( avg / 3) >= 60 && ( avg / 3) > 70 ) {
			grade = "not bad";
		}
		else {
			grade = "bad";
		}
	}
}

//String hakbun, String irum, int kor, int eng, int math, int tot, int avg, int garde