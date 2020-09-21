import java.util.Scanner;
import java.util.StringTokenizer;

public class Calculator {
	
	static int numArr[] = new int [10];
	static StringBuffer operations;
	
	
	public static void main(String[] args) {
	
		String expression;
		Scanner scan = new Scanner(System.in);
		
		// 수식 입력받기.
		while(true) {
			System.out.print("수식을 입력하세요 =>");
			expression = scan.next();
			
			System.out.println("디버깅 코드" + expression);
			
			if(ExpressionToToken(expression) == false)
				break;
		}
		// 연산 수행
		int result = Operate(numArr, operations);
		System.out.println("result => " + result);
	
	}
	
	static boolean ExpressionToToken (String expression){
		
		operations = new StringBuffer("");
		StringTokenizer stok = new StringTokenizer(expression, "+-*/", true);
		int index = 0;
		
		// 토큰화
		while(stok.hasMoreElements()) {
			
			String token = stok.nextToken();
			
			// 숫자 추출, 유효성 검사
			if (expression.indexOf(token) % 2 == 0) {

				if(validateNum(token)) {
					System.out.println("입력 오류");
					return true; // break;
				}
				
				numArr[index] = Integer.parseInt(token);
				System.out.println("디버깅 코드 numArr[index] : " + numArr[index]);
				index++;
			} 
			// 연산기호 추출
			else {
				operations.append(token);
			}
		}
		//end for
		return false;
	}
	
		
	static int Operate ( int nums [],StringBuffer operations) {
		
		int result = nums[0];
		System.out.println("디버깅 코드 : result =>" + result);
		System.out.println("디버깅 코드 : operations =>" + operations);
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
			System.out.println("디버깅 result =>  " + result);
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