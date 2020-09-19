import java.util.Scanner;

public class performLibrary {
	
	final static int MAX = 100;
	final static int RENT_LIMIT = 5;
	final static byte STATE_CheckIN = 0; // 0 : 미대출 상태.
	final static byte STATE_CheckOUT = 1;
	
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
				case 3:
					rent(obj1);
					break;
				case 4:
					turnIn(obj1);
					break;
				case 5:
					search(obj1, obj2);
				case 6:
					System.out.println("종료되었습니다.");
					return;
			}
		}
	}

	static void search(Lendable[] obj1, Lendable[] obj2) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("   *** 조회 선택 ***");
		System.out.println("┌─────────────────────┐");
		System.out.println("│ 1. 전체 도서 조회   │");
		System.out.println("│ 2. 전체 회원 조회   │");
		System.out.println("│ 3. 대출중 도서 조회 │");
		System.out.println("│ 4. 대출중 회원 조회 │");
		System.out.println("│ 5. 종료             │");
		System.out.println("└─────────────────────┘");
		System.out.print("번호 선택 => ");
		int result = scan.nextInt();
		
		switch(result){
			case 1:
				printRegister(obj1);
				break;
			case 2:
				printRegister(obj2);
				break;
			case 3:
				printCheckOutList(obj1);
				break;
			case 4:
				// 구현하기.
				break;
		}
	}


	static void printCheckOutList(Lendable[] obj1) {
		
		System.out.println("                        ### 대출 목록 ##                          ");
		System.out.println("────────────────────────────────────────────────────────────────────────────");
		System.out.println("책 코드         제목           저자            출판사                대출인");
		System.out.println("=============================================================================");
		BookInfo data [] = (BookInfo [])obj1;

		for(int i = 0; i < book_cnt; i++) {
			if(data[i].state != STATE_CheckIN) {
				data[i].output(STATE_CheckOUT);
			}
		}// end for
	}

	static void printRegister(Lendable[] obj) {
		
		if(obj instanceof BookInfo[]) {
			System.out.println("책 코드         제목           저자          출판사");
			System.out.println("===================================================");
			for(int i = 0; i < book_cnt; i++) {
				obj[i].output();
			}
		}
		else {
			System.out.println("회원 코드             이름                      전화번호                      주소");
			System.out.println("====================================================================================");
			for(int i = 0; i < member_cnt; i++) {
				obj[i].output();
			}
		}
	}

	static void register(Lendable obj []) {
		
		Scanner scan = new Scanner(System.in);
		
		if(obj instanceof BookInfo[]) {
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
				                                            //System.out.println("여기서 헤맴");
				obj[i] = new BookInfo(bookCode, title, author, company); // 이 코드가 없이 44줄의 코드를 실행하게 되면 배열의 원소에는 어떤 객체도 없는데 input을 실행하라고 해서 null이 뜬것이다.
				book_cnt++;
			}
		}
		else{
			String memberCode, name, phoneNo, addr;
			
			for(int i = 0; i < MAX; i++) {
				
				System.out.printf("\n    %3d.\n", member_cnt);
				
				System.out.print("회원 코드 입력 => ");
				memberCode = scan.next();
				if(memberCode.equals("exit"))
					return;
				
				System.out.print("이름 => ");
				name = scan.next();
				
				System.out.print("전화번호 => ");
				phoneNo = scan.next();
				
				System.out.print("주소 => ");
				addr = scan.next();
				
				obj[i] = new MemberInfo(memberCode, name, phoneNo, addr);
				member_cnt++;
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
		System.out.println("│ 5. 조회             │");
		System.out.println("│ 6. 종료             │");
		System.out.println("└─────────────────────┘");
		System.out.print("번호 선택 => ");
		int result = scan.nextInt();
		return result;
	}
	
	static void rent(Lendable obj[]) {
		Scanner scan = new Scanner(System.in);
		
		BookInfo[] data = (BookInfo [])obj;
		
		System.out.println(" ### 대출 ###");
		System.out.println("회원 코드 => ");
		String borrower = scan.next();
		
		System.out.println("(최대 5권 대출 가능합니다)");
		System.out.println("===========================================");
		System.out.println("대출할 도서의 코드를 입력하세요");
		
		for(int i = 0; i < RENT_LIMIT; i++ ) {
			
			System.out.println(" => ");
			String bookCode = scan.next();
			
			if(bookCode.equals("exit")) {
				System.out.println("## 대출 완료 ##");
				return;
			}
			
			for(int j = 0; j < book_cnt; j++) { // => 중첩 반복문 카운트롤 둘 다 i로 선언하면 안된다.
				
				if(data[j].bookCode.equals(bookCode)) {
					data[j].checkOut(borrower);
					break; 
				}
			}
			if(i == RENT_LIMIT -1)
				System.out.println("## 대출 완료 ##");
		} // end for
	}
	
	static void turnIn(Lendable obj[]) {
		Scanner scan = new Scanner(System.in);
		
		BookInfo[] data = (BookInfo [])obj;
		
		System.out.println(" ### 반납 ###");
		System.out.println("회원 코드 => ");
		String borrower = scan.next();
		
		System.out.println("===========================================");
		System.out.println("반납할 도서의 코드를 입력하세요");
		
		for(int i = 0; i < RENT_LIMIT; i++ ) {
			System.out.println(" => ");
			String bookCode = scan.next();
			
			if(bookCode.equals("exit")) {
				System.out.println("## 반납 완료 ##");
				return;
			}
			
			for(int j = 0; j < book_cnt; j++) {
				
				if(data[j].bookCode.equals(bookCode)) {
					data[j].checkIn(borrower);
					break; 
				}
			}
			if(i == RENT_LIMIT -1)
				System.out.println("## 반납 완료 ##");
		}
		// end for
		
	}
}
