
public class MemberInfo extends Member implements Lendable {
	
	String phoneNo, addr;
	
	public MemberInfo(String memberCode, String name, String phoneNo, String addr){
		super(memberCode,name);
		this.phoneNo = phoneNo;
		this.addr = addr;
	}
	
	public void input(String borrower) {

	}

	@Override
	public void output() {
		
		System.out.printf(" %3s         %4s          %11s          %10s \n", memberCode, name, phoneNo, addr);
	}
}
