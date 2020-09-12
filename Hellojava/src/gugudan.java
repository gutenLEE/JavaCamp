import java.util.Scanner;

public class gugudan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int i = 1;
		int result = i * num;
		
		while(i < 11) {

//			System.out.println(i * num);
			System.out.printf("%d * %d = %d\n", num, i, i* num);
			i++;
		}
	}
}
