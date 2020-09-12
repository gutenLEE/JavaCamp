
public class OverFlow_exam01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		num = 1000000000 + 2000000000;
		System.out.println(num); // ==> result : -1294967296, overflow 현상
		
		byte a = 127, b = 1, c;
		c = (byte)(a + b);
		System.out.println(c); // ==> result : -1294967296, overflow 현상

	}
}
