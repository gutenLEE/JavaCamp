import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TImeCheckProgram_UI {
	
	static DefaultTableModel tableModel;
	static JFrame frame;
	static Container contentPane;
	
	public static void main(String[] args) {
		
		
		frame = new JFrame("�ð� ��� ���α׷�");
		frame.setPreferredSize(new Dimension(700, 600));
		
		contentPane = frame.getContentPane();
		
		String colNames [] = {"ID", "�г���", "��¥", "���۽ð�", "����ð�", "���νð�"};
		tableModel = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(tableModel);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		
		// ��ǲ �ڽ�
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(700, 150));
		panel.setBorder(BorderFactory.createEmptyBorder(30 , 10 , 10 , 10)); // ���ΰ���

		
		// id, �г��� : �ؽ�Ʈ�ʵ� & ��� ��ư
		JTextField textField[] = new JTextField[2];
		
		textField[0] = new JTextField(15);
		panel.add(new JLabel("ID"));
		panel.add(textField[0]);
		
		textField[1] = new JTextField(15);
		panel.add(new JLabel("�г���"));
		panel.add(textField[1]);
		
		JButton btnRegister = new JButton("���");
		btnRegister.setPreferredSize(new Dimension(120, 20));
		JButton btnSearch = new JButton("��ȸ");
		btnSearch.setPreferredSize(new Dimension(120, 20));
		
		JButton btnStart = new JButton("START");
		btnStart.setPreferredSize(new Dimension(200, 40));
	
		JButton btnEnd = new JButton("END");
		btnEnd.setPreferredSize(new Dimension(200, 40));
		
		panel.add(btnRegister);
		panel.add(btnSearch);
		panel.add(btnStart);
		panel.add(btnEnd);
		
		contentPane.add(panel, BorderLayout.SOUTH);
		
		//������ ���
		btnRegister.addActionListener(new JdbcActionListener(table, textField));
		btnSearch.addActionListener(new JdbcActionListener(table, textField));
		btnStart.addActionListener(new JdbcActionListener(table, textField));
		//btnEnd.addActionListener(new JdbcActionListener());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}
	static void Table(DefaultTableModel tableModel) {
		
		String colNames [] = {"ID", "�г���", "��¥", "���۽ð�", "����ð�", "���νð�"};
		tableModel = new DefaultTableModel(colNames, 0);
		
		JTable table = new JTable(tableModel);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		

	}
	static void Frame(JFrame frame) {
		
		frame = new JFrame("�ð� ��� ���α׷�");
		frame.setPreferredSize(new Dimension(500, 600));
		
		contentPane = frame.getContentPane();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
