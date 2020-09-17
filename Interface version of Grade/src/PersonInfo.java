import java.util.Scanner;

public class PersonInfo extends Person implements Personable {
	
	String addr, phoneNo, email;
	
	PersonInfo(){ }
	
	@Override // => annotation
	public boolean input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("hakbun =>>");
		hakbun = scan.next();
		
		// 학번에 exit 입력되면 input() 종료.
		if( hakbun.toLowerCase().equals("exit") ) {
			return true;
		}
		
		// 지역변수에도 필드에도 같은 이름의 변수가 선언되어 있다면 this. 를 써주는게 좋다.
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
