import java.net.ServerSocket;
import java.net.Socket;

//��Ƽ ä�� �ڵ�

// �� server �� �޼��� �ۼ� ����� ���� �޼����� �ѷ��ִ� ��ɸ� �ִ�. 
public class ServerExample4 {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(9002);
			
			while(true) { // while ���� ���� => ��Ƽ ä���̴ϱ�. ���� ��û�� ���� ������ ���� ��ü ����. ������ ����.
				Socket socket = serverSocket.accept();
				Thread thread = new PerClientThread(socket); // Ŭ���̾�Ʈ���� ���� �޼����� ����ִ� socket�ΰǰ�?
				thread.start();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
