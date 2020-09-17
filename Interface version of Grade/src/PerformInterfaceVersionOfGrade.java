
public class PerformInterfaceVersionOfGrade {
	
	final static int MAX = 100;
	
	public static void main(String[] args) {
		
		Sungjuk obj1[] = new Sungjuk[MAX];
		PersonInfo obj2[] = new PersonInfo[MAX];
		int cnt_obj1 = 0, cnt_obj2 = 0;
		
		cnt_obj1 = inputData(obj1);
		cnt_obj2 = inputData(obj2);
	
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
	
	//출력 class                             ┌형식 매개 변수(가인수)
	static void performOutput(Personable[] obj, int cnt) {
		
		for (int i = 0; i < cnt; i++) {
			obj[i].output();
		//   └ 실매개변수
		}
	}	
	
	// instanceof 키워드로 나의 고민을 해결했다.
	static int inputData(Personable obj[]) {
		
		int i, cnt = 0;
		
		if(obj instanceof Sungjuk[]) {
			
			Sungjuk[] data = (Sungjuk[])obj;
			
 			System.out.println("              ### 성적 입력 ###");
 			
			for(i = 0; i < MAX; i++) {
				
				data[i] = new Sungjuk();
				
				if(data[i].input())
					break;
				data[i].process();
				cnt++;
				
				System.out.println();
			}	
		}
		else {
			
			PersonInfo[] data = (PersonInfo[]) obj;
			
			System.out.println("             ### 개인정보 입력 ###");
			
			for(i = 0; i < MAX; i++) {
				
				data[i] = new PersonInfo();
				
				if(data[i].input())
					break;
				cnt++;
				System.out.println();
			}
		}
		return cnt;
	}
}
