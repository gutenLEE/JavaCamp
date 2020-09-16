
public class InterfaceVersionOfGradePerform {
	
	final static int MAX = 100;
	static int cnt_obj1 = 0;
	static int cnt_obj2 = 0;
	
	public static void main(String[] args) {
		
		Personable obj1 [] = new Personable[MAX];
		
		Personable obj2 [] = new Personable[MAX];

		
		performInputSungjuk(obj1);
		performInputPersonInfo(obj2);
		
		System.out.println("    ### ����ǥ ###");
		performOutput(obj1, cnt_obj1);
		System.out.println(" =====================================");
		System.out.println();
		
		System.out.println("    ### �������� ###");
		performOutput(obj2, cnt_obj2);
		System.out.println(" =====================================");
		System.out.println();

	}
	
	static void performOutput(Personable[] obj, Object cnt) {

		for (int i = 0; i < cnt_obj1; i++) {
			obj[i].output();
		}
	}


	static void performInputSungjuk(Personable obj1 []) {
		
		Sungjuk sungjuk = new Sungjuk();
		
		for ( int i = 0; i < MAX; i++) {
			
			obj1[cnt_obj1] = new Sungjuk();
			if(obj1[cnt_obj1].input())
				break;
			sungjuk.process(); // �̰� ������ performInput �޼��� �ϳ��� ���� �� ���� ���ΰ�?
			cnt_obj1 ++;
		}
		
	}
	static void performInputPersonInfo(Personable obj2 []) {
		
		PersonInfo personInfo = new PersonInfo();
		
		for ( int i = 0; i < MAX; i++) {
			
			obj2[cnt_obj2] = new Sungjuk();
			if(obj2[cnt_obj2].input())
				break;
			cnt_obj2 ++;
		}
	}
}
