import java.util.Scanner;

public class performLibrary {
	
	final static int MAX = 100;
	final static int RENT_LIMIT = 5;

	static int book_cnt = 0;
	static int member_cnt = 0;
	
	public static void main(String[] args) {

		
//		BookInfo bookInfo [] = new BookInfo[MAX]; �̷��� �ϸ� ����ȯ�� �� �ȵǴ°�?
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
				default:
					break;
			}
		}
	}

	static void search(Lendable[] obj1, Lendable[] obj2) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("   *** ��ȸ ���� ***");
		System.out.println("����������������������������������������������");
		System.out.println("�� 1. ��ü ���� ��ȸ   ��");
		System.out.println("�� 2. ��ü ȸ�� ��ȸ   ��");
		System.out.println("�� 3. ������ ���� ��ȸ ��");
		System.out.println("�� 2. ������ ȸ�� ��ȸ ��");
		System.out.println("�� 3. ����             ��");
		System.out.println("����������������������������������������������");
		System.out.print("��ȣ ���� => ");
		int result = scan.nextInt();
		
		switch(result){
			case 1:
				printRegister(obj1);
				break;
			case 2:
				printRegister(obj2);
				break;
			case 3:
				printRentReturn(obj1);
				break;
			default:
				break;
		}
	}


	static void printRentReturn(Lendable[] obj1) {
		
		System.out.println("å �ڵ�         ����           ����          ���ǻ�         ������");
		System.out.println("==================================================================");
		BookInfo data [] = (BookInfo [])obj1;

		for(int i = 0; i < book_cnt; i++) {
			byte state = '1';
			if(data[i].state == 1) {
				data[i].output(state);
			}
		}// end for
	}

	static void printRegister(Lendable[] obj) {
		
		if(obj instanceof BookInfo[]) {
			System.out.println("å �ڵ�         ����           ����          ���ǻ�");
			System.out.println("===================================================");
			for(int i = 0; i < book_cnt; i++) {
				obj[i].output();
			}
		}
		else {
			System.out.println("ȸ�� �ڵ�        �̸�              ��ȭ��ȣ               �ּ�");
			System.out.println("=======================================================================");
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
					
					System.out.print("å ���ڵ� �Է� => ");
					bookCode = scan.next();
					if(bookCode.equals("exit"))
						return;
					
					System.out.print("å ���� => ");
					title = scan.next();
					
					System.out.print("���� => ");
					author = scan.next();
					
					System.out.print("���ǻ� => ");
					company = scan.next();
				                                            //System.out.println("���⼭ ���");
				obj[i] = new BookInfo(bookCode, title, author, company); // �� �ڵ尡 ���� 44���� �ڵ带 �����ϰ� �Ǹ� �迭�� ���ҿ��� � ��ü�� ���µ� input�� �����϶�� �ؼ� null�� ����̴�.
				book_cnt++;
			}
		}
		else{
			String memberCode, name, phoneNo, addr;
			
			for(int i = 0; i < MAX; i++) {
				
				System.out.printf("\n    %3d.\n", i + 1);
				
				System.out.print("ȸ�� �ڵ� �Է� => ");
				memberCode = scan.next();
				if(memberCode.equals("exit"))
					return;
				
				System.out.print("�̸� => ");
				name = scan.next();
				
				System.out.print("��ȭ��ȣ => ");
				phoneNo = scan.next();
				
				System.out.print("�ּ� => ");
				addr = scan.next();
				
				obj[i] = new MemberInfo(memberCode, name, phoneNo, addr);
				member_cnt++;
			}
		}
	}

	static int printMenu() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println();
		System.out.println("   *** ��� ���� ***");
		System.out.println("����������������������������������������������");
		System.out.println("�� 1. å ���          ��");
		System.out.println("�� 2. ȸ�� ���        ��");
		System.out.println("�� 3. ����             ��");
		System.out.println("�� 4. �ݳ�             ��");
		System.out.println("�� 5. ��ȸ             ��");
		System.out.println("�� 6. ����             ��");
		System.out.println("����������������������������������������������");
		System.out.print("��ȣ ���� => ");
		int result = scan.nextInt();
		return result;
	}
	
	static void rent(Lendable obj[]) {
		Scanner scan = new Scanner(System.in);
		
		BookInfo[] data = (BookInfo [])obj;
		
		System.out.println(" ### ���� ###");
		System.out.println("ȸ�� �ڵ� => ");
		String borrower = scan.next();
		
		System.out.println("(�ִ� 5�� ���� �����մϴ�)");
		System.out.println("===========================================");
	
		System.out.println("������ ������ �ڵ带 �Է��ϼ���");
		for(int i = 0; i < RENT_LIMIT; i++ ) {
			
			System.out.println(" => ");
			String bookCode = scan.next();
			
			if(bookCode.equals("exit")) {
				System.out.println("## ���� �Ϸ� ##");
				return;
			}
			
			for(int j = 0; j < book_cnt; j++) { // => ��ø �ݺ��� ī��Ʈ�� �� �� i�� �����ϸ� �ȵȴ�.
				
				if(data[j].bookCode.equals(bookCode)) {
					data[j].checkOut(borrower);
					break; 
				}
			}
			if(i == RENT_LIMIT -1)
				System.out.println("## ���� �Ϸ� ##");
		} // end for
	}
	
	static void turnIn(Lendable obj[]) {
		Scanner scan = new Scanner(System.in);
		
		BookInfo[] data = (BookInfo [])obj;
		
		System.out.println(" ### �ݳ� ###");
		System.out.println("ȸ�� �ڵ� => ");
		String borrower = scan.next();
		
		System.out.println("===========================================");
		System.out.println("�ݳ��� ������ �ڵ带 �Է��ϼ���");
		
		for(int i = 0; i < RENT_LIMIT; i++ ) {
			System.out.println(" => ");
			String bookCode = scan.next();
			
			if(bookCode.equals("exit")) {
				System.out.println("## �ݳ� �Ϸ� ##");
				return;
			}
			
			for(int j = 0; j < book_cnt; j++) {
				
				if(data[j].bookCode.equals(bookCode)) {
					data[j].checkIn(borrower);
					break; // break�� ���� �� �� ���ѷ����� ��������???!!! 
				}
			}
		}// end for
	}
}
