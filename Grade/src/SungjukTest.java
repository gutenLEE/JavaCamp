
public class SungjukTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sungjuk sungjuk = new Sungjuk("�й�", "�̸�");
		
		perform(sungjuk);
		
	}
	static void perform(Person obj) {
		obj.input();
		obj.output();
	}
}
