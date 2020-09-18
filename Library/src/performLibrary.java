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
			

			if(obj instanceof BookInfo[]) {
				                                            //System.out.println("���⼭ ���");
				obj[i] = new BookInfo(bookCode, title, author, company); // �� �ڵ尡 ���� 44���� �ڵ带 �����ϰ� �Ǹ� �迭�� ���ҿ��� � ��ü�� ���µ� input�� �����϶�� �ؼ� null�� ����̴�.
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
		System.out.println("   *** ��� ���� ***");
		System.out.println("����������������������������������������������");
		System.out.println("�� 1. å ���          ��");
		System.out.println("�� 2. ȸ�� ���        ��");
		System.out.println("�� 3. ����             ��");
		System.out.println("�� 4. �ݳ�             ��");
		System.out.println("�� 5. ������ ���� ��ȸ ��");
		System.out.println("�� 6. ��ü ��ȸ        ��");
		System.out.println("�� 7. ����             ��");
		System.out.println("����������������������������������������������");
		System.out.print("��ȣ ���� => ");
		int result = scan.nextInt();
		return result;
	}

}
