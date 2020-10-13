import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample2 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();         // accept ������ ������. Ŭ���̾�Ʈ���� �޼����� ������ ���� accept�� ���� ����. => ���� ���� socket�� ����.
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ���� ��ü ����. 
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			
			String str = reader.readLine(); // �� ������ �б�.
			System.out.println(str);
			
			writer.println("hello Client");
			writer.flush();                 // �� ���ۿ� ������� ���۵ɶ�, �� ���۸� ������ ���� ���� ��. 
											// ���۰� �� ���� ������� ������. 
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();   // ��Ʈ �ݱ�
			}
			catch(Exception ignored) {
			}
			try {
				serverSocket.close(); // ���� ���� �ݱ�.
			}
			catch(Exception ignored) {
				
			}
		}
		
	}

}
