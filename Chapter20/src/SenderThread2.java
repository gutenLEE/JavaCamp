import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//��Ƽ ä�� �ڵ�

public class SenderThread2 extends Thread {
	
	Socket socket; //
	String name;
	SenderThread2(Socket socket, String name){
		this.socket = socket;
		this.name = name;
	}
	
	public void run() {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Ű����� �Է� �������� �����Ѵ�.
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); // 
			
			writer.println(name);
			writer.flush();
			
			
			while(true) {
				String str = reader.readLine(); // �޼��� �Է� �ޱ�.
				if(str.equals("bye"))
					break;
				writer.println(str); // bye�� �ƴϸ� �۽�.
				writer.flush();      // ���� ����.
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception ignored) {
				
			}
		}
	}
}
