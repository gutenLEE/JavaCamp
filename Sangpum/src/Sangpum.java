import java.util.Scanner;

public class Sangpum {
	String code, irum, grade;
	int su, dan, price;
	
	static int cnt = 0; // ��ǰ�� ī��Ʈ
	static int total_price = 0; // �ݾ״���
	
	Sangpum(){
		
	}
	
	void input_sangpum() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("��ǰ�ڵ� �Է� => ");
		code = scan.next();
		System.out.print("��ǰ�� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		su = scan.nextInt();
		System.out.print("�ܰ� �Է� => ");
		dan = scan.nextInt();
		
		System.out.println();

	}
	
	void process_sangpum() {
		
		price = su * dan;
		
		if (su >= 100)
			grade = "���";
		else if (su >= 70)
			grade = "����";
		else
			grade = "�й�";
	}
	
	void output_sangpum() {
		System.out.printf("%7s  %7s     %8d  %8d %8d   %2s\n",
				code, irum, su, dan, price, grade);
	}
	
	static int getTotalPrice() {
		return total_price; // static �ʵ常 ��� ����.
	}
}
