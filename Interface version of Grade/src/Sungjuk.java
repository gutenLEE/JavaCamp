import java.util.Scanner;

public class Sungjuk extends Person implements Personable {
	
	int kor, eng, math, tot;
	double avg;
	String grade;
	
	Sungjuk(){ }
	
	@Override
	public boolean input() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("   ### ���� �Է� ###");
		
		System.out.println("hakbun =>>");
		hakbun = scan.next();
		
		// �й��� exit �ԷµǸ� input() �޼��� ����.
		if( hakbun.equals("exit") ) {
			return true;
		}
		
		System.out.println("Name =>>");
		irum = scan.next();
		
		System.out.println("Korean Score =>>");
		kor = scan.nextInt();
		
		System.out.println("English Score =>>");
		eng = scan.nextInt();
		
		System.out.println("Math Score =>>");
		math = scan.nextInt();
		System.out.println();
		
		return false;
	}

	@Override
	public void output() {
		
		System.out.println("==============================================");
		System.out.printf("%5s    %4s     %3d       %3d       %3d      %3d      %.2f      %6s", hakbun, irum, kor, eng, math, tot, avg, grade);
	}
	
	void process() {
		// this �� ����� �ϴ°ž�
		this.tot = this.math + this.kor + this.eng;
		this.avg = tot / 3.;
	
		switch( (int)(avg / 10)) {
			case 9: 
				grade = "Exellent";
				break;
			case 8:
				grade = "Great";
				break;
			case 7:
				grade = "Good";
				break;
			case 6:
				grade = "Not bad";
				break;
			case 5:
				grade = "Bad";
				break;
			default:
				grade = "Worst";
		}
	}
}
