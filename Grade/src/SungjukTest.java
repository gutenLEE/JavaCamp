
public class SungjukTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sungjuk sungjuk = new Sungjuk("학번", "이름");
		
		perform(sungjuk);
		sungjuk.process();
		// process를 어떻게 호출해야 하지?
		
		PersonInfo personInfo = new PersonInfo("ab", "bc");
		perform(personInfo);
		
		
		
	}
	static void perform(Person obj) {
		// 동적 바인딩
		obj.input();
		obj.output();
	}
}
