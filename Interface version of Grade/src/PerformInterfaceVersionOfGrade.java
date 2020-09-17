
public class PerformInterfaceVersionOfGrade {
	
	final static int MAX = 100;
	
	public static void main(String[] args) {
		
		Sungjuk obj1[] = new Sungjuk[MAX];
		PersonInfo obj2[] = new PersonInfo[MAX];
		int i, cnt_obj1 = 0, cnt_obj2 = 0;
		
		// input
		System.out.println("              ### ���� �Է� ###");
		for(i = 0; i < MAX; i++) {
			
			obj1[i] = new Sungjuk();
			
			if(obj1[i].input())
				break;
			obj1[i].process();
			
			cnt_obj1++;
			System.out.println();
		}
		
		System.out.println("             ### �������� �Է� ###");
		for(i = 0; i < MAX; i++) {
			
			obj2[i] = new PersonInfo();
			
			if(obj2[i].input())
				break;
			
			cnt_obj2++;
			System.out.println();
		}
		
		// output
		System.out.println("                          ### ����ǥ ###                             ");
		System.out.println("=====================================================================");
		System.out.println("�й�      �̸�     ����      ����     ����      ����      ���       ���");
		performOutput(obj1, cnt_obj1);
		System.out.println("=====================================================================");
		System.out.println();
		
		System.out.println("                         ### �������� ###                            ");
		System.out.println("=====================================================================");
		System.out.println("�й�      �̸�     �ּ�     ��ȭ��ȣ       �̸���");
		performOutput(obj2, cnt_obj2);
		System.out.println(" =====================================================================");
		System.out.println();

	}
	
	//��� class
	static void performOutput(Personable[] obj, int cnt) {

		for (int i = 0; i < cnt; i++) {
			obj[i].output();
		}
	}	
}
