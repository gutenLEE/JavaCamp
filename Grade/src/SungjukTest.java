
public class SungjukTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sungjuk sungjuk = new Sungjuk();
		PersonInfo personInfo = new PersonInfo();
		
		performInput(sungjuk);
		sungjuk.process();
		// process�� ��� ȣ���ؾ� ����?
		
		System.out.println();
		performOutput(sungjuk);
		System.out.println("--------------------------------------------------------------");
		performOutput(personInfo);
		
		
		
	}
	
	// input, output Ŭ������ �и��ϸ� �Ǿ�����....
	static void performInput(Person obj) {
		// ���� ���ε�
		obj.input();
	}
	static void performOutput(Person obj) {
		obj.output();
	}
}
