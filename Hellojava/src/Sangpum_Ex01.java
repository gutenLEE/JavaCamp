import java.util.Scanner;

public class Sangpum_Ex01 {

	public static void main(String[] args) {
		String code, irum, grade;
		int su, dan, price;

		Scanner scan = new Scanner(System.in);
		System.out.print("상품코드 입력 => ");
		code = scan.next();
		System.out.print("상품명 입력 => ");
		irum = scan.next();
		System.out.print("수량 입력 => ");
		su = scan.nextInt();
		System.out.print("단가 입력 => ");
		dan = scan.nextInt();
		
		price = su * dan;
		
		if (su >= 100)
			grade = "우수";
		else if (su >= 70)
			grade = "보통";
		else
			grade = "분발";
		
		System.out.println("\n             *** 판매 현황 ***");
		System.out.println("==========================================");
		System.out.println("상품코드      상품명        수량        단가          금액           평가");
		System.out.println("==========================================");
		System.out.printf("%4s  %6s     %4d  %7d %8d   %2s\n",
				code, irum, su, dan, price, grade);
		System.out.println("==========================================");
	}
}