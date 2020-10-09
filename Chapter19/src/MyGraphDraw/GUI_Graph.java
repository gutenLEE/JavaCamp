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
		
		JFrame frame = new JFrame("성적 그래프 프로그램");
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
		
		String colNames [] = {"학번", "이름", "국어", "영어", "수학", "총점", "평균", "등급"};
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

// 질문) staic 클래스는 성능 저하의 원인이 되기도 하는가? 항상 참조할 수 있기에?