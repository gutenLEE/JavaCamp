import java.util.Scanner;

public class Sangpum {
	String code, irum, grade;
	int su, dan, price;
	
	static int cnt = 0; // 상품수 카운트
	static int total_price = 0; // 금액누계
	
	Sangpum(){
		
	}
	
	void input_sangpum() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("상품코드 입력 => ");
		code = scan.next();
		System.out.print("상품명 입력 => ");
		irum = scan.next();
		System.out.print("수량 입력 => ");
		su = scan.nextInt();
		System.out.print("단가 입력 => ");
		dan = scan.nextInt();
		
		System.out.println();

	}
	
	void process_sangpum() {
		
		price = su * dan;
		
		if (su >= 100)
			grade = "우수";
		else if (su >= 70)
			grade = "보통";
		else
			grade = "분발";
	}
	
	void output_sangpum() {
		System.out.printf("%7s  %7s     %8d  %8d %8d   %2s\n",
				code, irum, su, dan, price, grade);
	}
	
	static int getTotalPrice() {
		return total_price; // static 필드만 사용 가능.
	}
}
