import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {
	
	static int numArr[] = new int [10];
	static StringBuffer operations = new StringBuffer("");
	
	public static void main(String[] args) {
	
		String expression;
		
		while(true) {
			System.out.print("수식을 입력하세요 =>");
			Scanner scan = new Scanner(System.in);
			expression = scan.next();
			
			ExpressionToToken(expression);
			int result = Operate(numArr, operations);
			System.out.println(result);
		}
	}
	
	static boolean ExpressionToToken (String expression){
		
		StringTokenizer stok = new StringTokenizer(expression, "+-*/", true);
		int index = 0;
		
		for(int i = 0; i < expression.length(); i++) {
		
			String token = stok.nextToken();
			
			
			if (i % 2 == 0) {

				if(validateNum(token)) {
					System.out.println("입력 오류");
					return true; // break;
				}
				
				numArr[index] = Integer.parseInt(token);
				index++;
			}
			else {
				operations.append(token);
			}
		}
		//end for
		return false;
	}
	
		
	
	
	static int Operate ( int nums [],StringBuffer operations) {
		
		int result = nums[0];
		
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



// 1. 입력 받기
// 2. 로직 짜기
// 3. 예외 처리하기.