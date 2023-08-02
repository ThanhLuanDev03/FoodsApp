//package ui;
//
//import java.awt.Color;
//
//import javax.swing.JFrame;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.data.general.PieDataset;
//
//public class TongQuanJInternalFrame extends JFrame {
//	public TongQuanJInternalFrame() {
//	}
////	public TongQuanJInternalFrame() {
////	}
//
//	private static JFreeChart createChart(PieDataset dataset) {
//		JFreeChart chart = ChartFactory.createPieChart("THỐNG KÊ DANH THU LỢI NHUẬN CỦA QUÁN", dataset, true, true,
//				true);
//		return chart;
//	}
//
//	private static PieDataset createDataset() {
//		DefaultPieDataset dataset = new DefaultPieDataset();
//		dataset.setValue("Doanh thu", 25.0);
//		dataset.setValue("Chi phí", 66.0);
//		dataset.setValue("Lợi nhuận", 9.0);
//		return dataset;
//	}
//
//	public static void main(String[] args) {
//		JFreeChart pieChart = createChart(createDataset());
//		ChartPanel chartPanel = new ChartPanel(pieChart);
//		chartPanel.setBackground(Color.WHITE);
//		chartPanel.setBounds(0, 0, 1214, 717);
//		JFrame frame = new JFrame();
//		frame.setUndecorated(true);
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(chartPanel);
//		frame.setTitle("Biểu đồ JFreeChart trong Java Swing");
//		frame.setSize(1230, 756);
//		frame.setLocationRelativeTo(null);
//		frame.setResizable(false);
//		frame.setVisible(true);
//	}
//
//}
