import java.util.Scanner;

public class PersonInfo extends Person implements Personable {
	
	String addr, phoneNo, email;
	
	PersonInfo(){ }
	
	@Override // => annotation
	public boolean input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("hakbun =>>");
		hakbun = scan.next();
		
		// �й��� exit �ԷµǸ� input() ����.
		if( hakbun.toLowerCase().equals("exit") ) {
			return true;
		}
		
		// ������������ �ʵ忡�� ���� �̸��� ������ ����Ǿ� �ִٸ� this. �� ���ִ°� ����.
		System.out.println("Name =>>");
		this.irum = scan.next();
		
		System.out.println("Address =>>");
		this.addr = scan.next();
		
		System.out.println("Phone No. =>>");
		this.phoneNo = scan.next();
		
		System.out.println("E-mail =>>");
		this.email = scan.next();
		
		return false;
	}
 
	@Override
	public void output() {
		
		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%5s    %4s     %3s       %3s       %3s \n", hakbun, irum, addr, phoneNo, email);
	}

}
