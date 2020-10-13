import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExample2 {

	public static void main(String[] args) {
		
	Socket socket = null;
		
		try {                        // ��> �ý��ۿ����� ���̴� ip�ּ�
			
			socket = new Socket("127.0.0.1", 9000); // ������ ip�ּ�
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println("Hello, Server");
			writer.flush();
			String str = reader.readLine(); // ���۸� ���� ���.
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
