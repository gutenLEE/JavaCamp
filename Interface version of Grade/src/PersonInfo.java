import java.util.Scanner;

public class PersonInfo extends Person implements Personable {
	
	String addr, phoneNo, email;
	
	PersonInfo(){ }
	
	@Override
	public boolean input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("   ### �������� �Է� ###");
		
		System.out.println("hakbun =>>");
		hakbun = scan.next();
		
		// �й��� exit �ԷµǸ� input() �޼��� ����.
		if( hakbun.equals("exit") ) {
			return true;
		}
		
		System.out.println("Name =>>");
		irum = scan.next();
		
		System.out.println("Address =>>");
		addr = scan.next();
		
		System.out.println("Phone No. =>>");
		phoneNo = scan.next();
		
		System.out.println("E-mail =>>");
		email = scan.next();
		
		System.out.println();
		
		return false;
	}

	@Override
	public void output() {
		
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%5s    %4s     %3s       %3s       %3s \n", hakbun, irum, addr, phoneNo, email);
	}

}
