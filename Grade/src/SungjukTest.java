
public class SungjukTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sungjuk sungjuk = new Sungjuk();
		PersonInfo personInfo = new PersonInfo();
		
		performInput(sungjuk);
		sungjuk.process();
		// process를 어떻게 호출해야 하지?
		
		System.out.println();
		performOutput(sungjuk);
		System.out.println("--------------------------------------------------------------");
		performOutput(personInfo);
		
		
		
	}
	
	// input, output 클래스를 분리하면 되었구나....
	static void performInput(Person obj) {
		// 동적 바인딩
		obj.input();
	}
	static void performOutput(Person obj) {
		obj.output();
	}
}
