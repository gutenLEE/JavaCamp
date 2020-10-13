import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExample2 {

	public static void main(String[] args) {
		
	Socket socket = null;
		
		try {                        // ┌> 시스템에서만 쓰이는 ip주소
			
			socket = new Socket("127.0.0.1", 9000); // 서버의 ip주소
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("Hello, Server");
			writer.flush();
			String str = reader.readLine(); // 버퍼를 통해 출력.
			System.out.println(str);
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
