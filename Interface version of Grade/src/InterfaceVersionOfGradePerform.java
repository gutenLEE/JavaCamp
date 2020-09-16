
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
		System.out.println("=====================================================================");
		System.out.println("�й�      �̸�     ����      ����     ����      ����      ���       ���");
		performOutput(obj1, cnt_obj1);
		System.out.println("=====================================================================");
		System.out.println();
		
		System.out.println("    ### �������� ###");
		System.out.println("=====================================================================");
		System.out.println("�й�      �̸�     �ּ�     ��ȭ��ȣ       �̸���");
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
			sungjuk.process(); // �̰� ������ performInput �޼��� �ϳ��� ���� �� ���� ���ΰ�?
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
