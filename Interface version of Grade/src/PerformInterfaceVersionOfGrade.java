
public class PerformInterfaceVersionOfGrade {
	
	final static int MAX = 100;
	
	public static void main(String[] args) {
		
		Sungjuk obj1[] = new Sungjuk[MAX];
		PersonInfo obj2[] = new PersonInfo[MAX];
		int cnt_obj1 = 0, cnt_obj2 = 0;
		
		cnt_obj1 = inputData(obj1);
		cnt_obj2 = inputData(obj2);
	
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
	
	//��� class                             ������ �Ű� ����(���μ�)
	static void performOutput(Personable[] obj, int cnt) {
		
		for (int i = 0; i < cnt; i++) {
			obj[i].output();
		//   �� �ǸŰ�����
		}
	}	
	
	// instanceof Ű����� ���� ����� �ذ��ߴ�.
	static int inputData(Personable obj[]) {
		
		int i, cnt = 0;
		
		if(obj instanceof Sungjuk[]) {
			
			Sungjuk[] data = (Sungjuk[])obj;
			
 			System.out.println("              ### ���� �Է� ###");
 			
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
			
			System.out.println("             ### �������� �Է� ###");
			
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
