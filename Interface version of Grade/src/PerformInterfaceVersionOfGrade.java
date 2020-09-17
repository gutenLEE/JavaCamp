
public class PerformInterfaceVersionOfGrade {
	
	final static int MAX = 100;
	
	public static void main(String[] args) {
		
		Sungjuk obj1[] = new Sungjuk[MAX];
		PersonInfo obj2[] = new PersonInfo[MAX];
		int i, cnt_obj1 = 0, cnt_obj2 = 0;
		
		// input
		System.out.println("              ### 성적 입력 ###");
		for(i = 0; i < MAX; i++) {
			
			obj1[i] = new Sungjuk();
			
			if(obj1[i].input())
				break;
			obj1[i].process();
			
			cnt_obj1++;
			System.out.println();
		}
		
		System.out.println("             ### 개인정보 입력 ###");
		for(i = 0; i < MAX; i++) {
			
			obj2[i] = new PersonInfo();
			
			if(obj2[i].input())
				break;
			
			cnt_obj2++;
			System.out.println();
		}
		
		// output
		System.out.println("                          ### 성적표 ###                             ");
		System.out.println("=====================================================================");
		System.out.println("학번      이름     국어      영어     수학      총점      평균       등급");
		performOutput(obj1, cnt_obj1);
		System.out.println("=====================================================================");
		System.out.println();
		
		System.out.println("                         ### 개인정보 ###                            ");
		System.out.println("=====================================================================");
		System.out.println("학번      이름     주소     전화번호       이메일");
		performOutput(obj2, cnt_obj2);
		System.out.println(" =====================================================================");
		System.out.println();

	}
	
	//출력 class
	static void performOutput(Personable[] obj, int cnt) {

		for (int i = 0; i < cnt; i++) {
			obj[i].output();
		}
	}	
}
