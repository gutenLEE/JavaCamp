package MyGraphDraw;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Graph_drawing.DrawingPanel;

public class GUI_Graph {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("���� �׷��� ���α׷�");
		frame.setPreferredSize(new Dimension(900, 500));
		frame.setLocation(150, 150);  
		Container contentPane = frame.getContentPane();
		
		
		JPanel outer = new JPanel();
		JPanel tablePanel = table();
		JPanel graphPanel = graph();
		
		outer.add(tablePanel);
		outer.add(graphPanel);
		
		contentPane.add(outer);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	static JPanel table( ) {
		
		JPanel tablePanel = new JPanel();
		
		String colNames [] = {"�й�", "�̸�", "����", "����", "����", "����", "���", "���"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		
		table.setPreferredSize(new Dimension(380, 400));
		
		
		
		
		
		
		tablePanel.add(new JScrollPane(table));
		
		return tablePanel;
	}
	
	static JPanel graph() {
		
		JPanel graphPanel = new JPanel();
		
		DrawingGraph graphDraw = new DrawingGraph();
		graphDraw.setPreferredSize(new Dimension(380, 400));
		
		
		
		
		
		
		graphPanel.add(graphDraw);
		
		return graphPanel;
	}
}

// ����) staic Ŭ������ ���� ������ ������ �Ǳ⵵ �ϴ°�? �׻� ������ �� �ֱ⿡?