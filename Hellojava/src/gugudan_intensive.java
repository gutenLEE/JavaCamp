import java.util.Scanner;

public class gugudan_intensive {

	public static void main(String[] args) {
		
		// �Է¹ޱ�
		Scanner scan = new Scanner(System.in);
		
		System.out.println("input num1 =>");
		int num1 = scan.nextInt();
		System.out.println("input num2 =>");
		int num2 = scan.nextInt();
		
		// ���� ����
		if (num1 > num2) {
			num1 = num2;
			num2 = num1;
		}
		
		int i;
		int j;
		int num;
		
		for ( i = num1; i <= num2; i++) {
			System.out.printf("*** %d�� ***     ", i);
		}
		System.out.println();
		
		for(j = 1; j < 10; j++) {
			
			for ( num = num1; num <= num2; num++) {
				System.out.printf("%d * %d = %3d     ", num, j, num * j);		
			}
			System.out.println();
		}
	}
}
