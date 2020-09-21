import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {
	
	static int numArr[] = new int [10];
	static StringBuffer operations;
	
	
	public static void main(String[] args) {
	
		String expression;
		Scanner scan = new Scanner(System.in);
		
		// ���� �Է¹ޱ�.
		while(true) {
			System.out.print("������ �Է��ϼ��� =>");
			expression = scan.next();
			
			System.out.println("����� �ڵ�" + expression);
			
			if(ExpressionToToken(expression) == false)
				break;
		}
		// ���� ����
		int result = Operate(numArr, operations);
		System.out.println("result => " + result);
	
	}
	
	static boolean ExpressionToToken (String expression){
		
		operations = new StringBuffer("");
		StringTokenizer stok = new StringTokenizer(expression, "+-*/", true);
		int index = 0;
		
		// ��ūȭ
		while(stok.hasMoreElements()) {
			
			String token = stok.nextToken();
			
			// ���� ����, ��ȿ�� �˻�
			if (expression.indexOf(token) % 2 == 0) {

				if(validateNum(token)) {
					System.out.println("�Է� ����");
					return true; // break;
				}
				
				numArr[index] = Integer.parseInt(token);
				System.out.println("����� �ڵ� numArr[index] : " + numArr[index]);
				index++;
			} 
			// �����ȣ ����
			else {
				operations.append(token);
			}
		}
		//end for
		return false;
	}
	
		
	static int Operate ( int nums [],StringBuffer operations) {
		
		int result = nums[0];
		System.out.println("����� �ڵ� : result =>" + result);
		System.out.println("����� �ڵ� : operations =>" + operations);
		for(int i = 0; i < operations.length(); i++) {
			
			switch(operations.charAt(i)) {
				case '+':
					result = result + nums[i + 1];
					break;
				case '-':
					result = result - nums[i + 1];
					break;
				case '*':
					result = result * nums[i + 1];
					break;
				case '/':
					result = result / nums[i + 1];
					break;
			}
			System.out.println("����� result =>  " + result);
		}
		return result;
	}
	
	static boolean validateNum(String str) {
		try {
			int num = Integer.parseInt(str);
			return false;
		}
		catch(Exception e){
			return true;
		}
	}
}



// 1. �Է� �ޱ�
// 2. ���� ¥��
// 3. ���� ó���ϱ�.