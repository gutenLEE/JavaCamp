
public class SungjukTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sungjuk sungjuk = new Sungjuk("�й�", "�̸�");
		
		perform(sungjuk);
		sungjuk.process();
		// process�� ��� ȣ���ؾ� ����?
		
		PersonInfo personInfo = new PersonInfo("ab", "bc");
		perform(personInfo);
		
		
		
	}
	static void perform(Person obj) {
		// ���� ���ε�
		obj.input();
		obj.output();
	}
}
