
public class SungjukTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sungjuk sungjuk = new Sungjuk("�й�", "�̸�");
		
		perform(sungjuk);
		sungjuk.process();
		
		
		
	}
	static void perform(Person obj) {
		obj.input();
		obj.output();
	}
}
