import java.util.Scanner;

public class MemberInfo extends Member implements Lendable {
	
	String phoneNo, addr;
	
	@Override
	public boolean input() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("멤버쉽 코드 => ");
		memberCode = scan.next();
		if(memberCode.equals("exit"))
			return true;
		
		System.out.print("회원 이름 => ");
		name = scan.next();
		
		System.out.print("전화번호 => ");
		phoneNo = scan.next();
		
		System.out.print("주소 => ");
		addr = scan.next();
		return false;
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

	}

}
