import java.util.Scanner;

public class PersonInfo extends Person {
	
	String addr;
	String phone;
	String email;
	
	PersonInfo(String hakbun, String irum){
		super(hakbun, irum);
	}
	
	@Override
	void input() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("학번 => ");
		hakbun = scan.next();
		System.out.println("이름 => ");
		irum = scan.next();
		System.out.println("주소 => ");
		addr = scan.next();
		System.out.println("핸드폰 번호 => ");
		phone = scan.next();
		System.out.println("이메일 주소 => ");
		email = scan.next();

	}

	@Override
	void output() {
		System.out.println("학번     이름    주소                   전화번호                     이메일");
		System.out.println("=====================================================================================");
		System.out.printf("%5s      %4s     %10s     %10s        %10s "+ hakbun + irum + addr + phone + email);
		System.out.println("--------------------------------------------------------------------------------------");

	}
	

}

//, String addr, String phone, String email