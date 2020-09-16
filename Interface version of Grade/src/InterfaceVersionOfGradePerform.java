
public class InterfaceVersionOfGradePerform {
	
	final static int MAX = 100;
	static int cnt_obj1 = 0;
	static int cnt_obj2 = 0;

	
	public static void main(String[] args) {
		
		Personable obj1 [] = new Personable[MAX];
		Personable obj2 [] = new Personable[MAX];

		
		performInputSungjuk(obj1);
		performInputPersonInfo(obj2);
		
		System.out.println("    ### 성적표 ###");
		System.out.println("=====================================================================");
		System.out.println("학번      이름     국어      영어     수학      총점      평균       등급");
		performOutput(obj1, cnt_obj1);
		System.out.println("=====================================================================");
		System.out.println();
		
		System.out.println("    ### 개인정보 ###");
		System.out.println("=====================================================================");
		System.out.println("학번      이름     주소     전화번호       이메일");
		performOutput(obj2, cnt_obj2);
		System.out.println(" =====================================================================");
		System.out.println();

	}
	
	static void performOutput(Personable[] obj, int cnt) {

		for (int i = 0; i < cnt; i++) {
			obj[i].output();
		}
	}


	static void performInputSungjuk(Personable obj1 []) {
		
		
		for ( int i = 0; i < MAX; i++) {
			
			obj1[i] = new Sungjuk();
			Sungjuk sungjuk = (Sungjuk)obj1[i];
			
			if(obj1[i].input())
				break;
			sungjuk.process(); // 이거 때문에 performInput 메서드 하나로 만들 순 없는 것인가?
			cnt_obj1 ++;
		}
		
	}
	static void performInputPersonInfo(Personable obj []) {
		
		for ( int i = 0; i < MAX; i++) {
			
			obj[i] = new PersonInfo();
			if(obj[i].input())
				break;
			cnt_obj2 ++;
		}
	}
}
