
public class SungjukTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sungjuk sungjuk = new Sungjuk("학번", "이름");
		
		perform(sungjuk);
		
	}
	static void perform(Person obj) {
		obj.input();
		obj.output();
	}
}
