import java.util.Scanner;

public class Sangpum_Ex01 {

	public static void main(String[] args) {
		String code, irum, grade;
		int su, dan, price;

		Scanner scan = new Scanner(System.in);
		System.out.print("��ǰ�ڵ� �Է� => ");
		code = scan.next();
		System.out.print("��ǰ�� �Է� => ");
		irum = scan.next();
		System.out.print("���� �Է� => ");
		su = scan.nextInt();
		System.out.print("�ܰ� �Է� => ");
		dan = scan.nextInt();
		
		price = su * dan;
		
		if (su >= 100)
			grade = "���";
		else if (su >= 70)
			grade = "����";
		else
			grade = "�й�";
		
		System.out.println("\n             *** �Ǹ� ��Ȳ ***");
		System.out.println("==========================================");
		System.out.println("��ǰ�ڵ�      ��ǰ��        ����        �ܰ�          �ݾ�           ��");
		System.out.println("==========================================");
		System.out.printf("%4s  %6s     %4d  %7d %8d   %2s\n",
				code, irum, su, dan, price, grade);
		System.out.println("==========================================");
	}
}