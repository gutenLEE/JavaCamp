
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
		
		System.out.printf(" %s         %s          %s          %s/n", memberCode, name, phoneNo, addr);
	}
}
