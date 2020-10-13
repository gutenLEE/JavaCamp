import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample1 {

	public static void main(String[] args) {
		
		Socket socket = null;
		
		try {                        // ��> �ý��ۿ����� ���̴� ip�ּ�
			
			socket = new Socket("127.0.0.1", 9000); // ������ ip�ּ�
			
			InputStream in = socket.getInputStream();     // ���� ��ü
			OutputStream out = socket.getOutputStream();  // �۽� ��ü
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
