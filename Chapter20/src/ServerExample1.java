import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//ClientExample is a pair of ServerExample1
// ������ ���� �������� ���� ���
// ���� �� 
public class ServerExample1 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept();         // accept ������ ������. Ŭ���̾�Ʈ���� �޼����� ������ ���� accept�� ���� ����. => ���� ���� socket�� ����.
			InputStream in = socket.getInputStream(); // ���ſ� ��ü
			OutputStream out = socket.getOutputStream(); // ��ſ� ��ü
			
			byte arr[] = new byte[100]; // Ŭ���̾�Ʈ���� �� �޼��� ũ�⸸ŭ �о���̰ڵ�.
			in.read(arr);                        // ����
			System.out.println(new String(arr)); // ���
			
			String str = "hello client";
			out.write(str.getBytes());     // Ŭ���̾�Ʈ���� �����Ѵ�. str�� ����ƮŸ������ ��ȯ�Ͽ� ����.
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
