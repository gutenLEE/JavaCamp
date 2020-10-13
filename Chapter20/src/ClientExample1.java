import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample1 {

	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {                        // ┌> 시스템에서만 쓰이는 ip주소
			
			socket = new Socket("127.0.0.1", 9000); // 서버의 ip주소
			
			InputStream in = socket.getInputStream();     // 수신 객체
			OutputStream out = socket.getOutputStream();  // 송신 객체
			String str = "hello Server";                  // 
			out.write(str.getBytes());
			byte arr[] = new byte[100];
			in.read(arr);
			System.out.println(new String(arr));
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch (Exception e) {	
			}
		}
	}

}
