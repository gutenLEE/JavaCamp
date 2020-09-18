import java.util.Scanner;

public class performLibrary {
	
	final static int MAX = 100;
	final static int RENT_LIMIT = 5;

	static int book_cnt = 0;
	static int member_cnt = 0;
	
	public static void main(String[] args) {

		
//		BookInfo bookInfo [] = new BookInfo[MAX]; 이렇게 하면 형변환이 왜 안되는것?
//		MemberInfo memberInfo [] = new MemberInfo[MAX];
		
		Lendable obj1 [] = new BookInfo[MAX];
		Lendable obj2 [] = new MemberInfo[MAX];
		
		
		int choice = 0;
		while(true) {
			choice = printMenu();
			switch(choice){
				case 1:
					register(obj1);
					break;
				case 2:
					register(obj2);
					break;
				default:
					break;
			}
		}
		
	}
	 

	static void register(Lendable obj []) {

		Scanner scan = new Scanner(System.in); 
		
		String bookCode, title, author, company;
		
		for(int i = 0; i < MAX; i++) {
			
			System.out.printf("\n    %3d.\n", i + 1);
			
			System.out.print("책 바코드 입력 => ");
			bookCode = scan.next();
			if(bookCode.equals("exit"))
				return;
			
			System.out.print("책 제목 => ");
			title = scan.next();
			
			System.out.print("저자 => ");
			author = scan.next();
			
			System.out.print("출판사 => ");
			company = scan.next();
			

			if(obj instanceof BookInfo[]) {
				                                            //System.out.println("여기서 헤맴");
				obj[i] = new BookInfo(bookCode, title, author, company); // 이 코드가 없이 44줄의 코드를 실행하게 되면 배열의 원소에는 어떤 객체도 없는데 input을 실행하라고 해서 null이 뜬것이다.
				if(obj[i].input()) {
					break;
				}
				book_cnt++;
			}
			else{
				
				obj[i] = new MemberInfo();
				if(obj[i].input())
					member_cnt++;
					break;
			}
		}
		
	}


	static int printMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("   *** 모드 선택 ***");
		System.out.println("┌─────────────────────┐");
		System.out.println("│ 1. 책 등록          │");
		System.out.println("│ 2. 회원 등록        │");
		System.out.println("│ 3. 대출             │");
		System.out.println("│ 4. 반납             │");
		System.out.println("│ 5. 대출중 도서 조회 │");
		System.out.println("│ 6. 연체 조회        │");
		System.out.println("│ 7. 종료             │");
		System.out.println("└─────────────────────┘");
		System.out.print("번호 선택 => ");
		int result = scan.nextInt();
		return result;
	}

}
