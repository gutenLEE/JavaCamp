import java.util.Scanner;

public class PersonInfo extends Person {
	
	String addr;
	String phone;
	String email;
	
	PersonInfo(){
	}
	
	@Override
	void input() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�й� => ");
		hakbun = scan.next();
		System.out.println("�̸� => ");
		irum = scan.next();
		System.out.println("�ּ� => ");
		addr = scan.next();
		System.out.println("�ڵ��� ��ȣ => ");
		phone = scan.next();
		System.out.println("�̸��� �ּ� => ");
		email = scan.next();

	}

	@Override
	void output() {
		System.out.println("�й�     �̸�    �ּ�                   ��ȭ��ȣ                     �̸���");
		System.out.println("=====================================================================================");
		System.out.printf("%5s      %4s     %10s     %10s        %10s ", hakbun , irum , addr , phone , email);
		System.out.println("--------------------------------------------------------------------------------------");

	}
	

}

//, String addr, String phone, String email