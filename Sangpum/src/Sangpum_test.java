import java.util.Scanner;

public class Sangpum_test {
	
	final static int MAX = 100;
	static String ch;
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Sangpum obj [] = new Sangpum[100];
		
		while(true) {
			menu();
			ch = scan.next();
			if(ch.equals("1"))
				input_process(obj);
			if(ch.equals("2"))
				output_process(obj);
			if(ch.equals("3")) {
				System.out.println("         *** 최종***         ");
				output_process(obj);
				break;
			}
		}
	}
	
	static void input_process(Sangpum obj[]) {
		
		obj[Sangpum.cnt] = new Sangpum();
		obj[Sangpum.cnt].input_sangpum();
		obj[Sangpum.cnt].process_sangpum();
		Sangpum.cnt++;
		
//		for(int i = 0; i < MAX; i++) {
//			obj[i] = new Sangpum();
//			if(obj[i].input_sangpum())
//				break;
//			obj[i].process_sangpum();
//			Sangpum.cnt++;
//		}
	}
	
	static void output_process(Sangpum obj[]) {
		System.out.println("=========================================================");
		Sangpum.total_price = 0;
		for(int i = 0; i < Sangpum.cnt; i++) {
			obj[i].output_sangpum();
			Sangpum.total_price += obj[i].price;
		}
		
		System.out.println("=========================================================");
		System.out.printf("\t 총상품수 = %d,     총판매금액 =  %d", Sangpum.cnt, Sangpum.getTotalPrice());
		System.out.println("");
	}
	
	static void menu() {
		System.out.println("");
		System.out.println("┌───────────프로그램 안내────────────┐");
		System.out.println("│  1. 상품 정보 입력                 │");
		System.out.println("│  2. 상품 정보 출력                 │");
		System.out.println("│  3. 종료                           │");
		System.out.println("└────────────────────────────────────┘");
		System.out.println("=====> 입력 : ");
	}
}
