import java.util.Scanner;

public class MemberInfo extends Member implements Lendable {
	
	String phoneNo, addr;
	
	@Override
	public boolean input() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("����� �ڵ� => ");
		memberCode = scan.next();
		if(memberCode.equals("exit"))
			return true;
		
		System.out.print("ȸ�� �̸� => ");
		name = scan.next();
		
		System.out.print("��ȭ��ȣ => ");
		phoneNo = scan.next();
		
		System.out.print("�ּ� => ");
		addr = scan.next();
		return false;
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub

	}

}
