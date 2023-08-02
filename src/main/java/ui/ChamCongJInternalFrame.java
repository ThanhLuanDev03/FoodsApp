package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ChamCongJInternalFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtTimKiem;
	private DefaultTableModel model;
	private JTable tableChamCong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChamCongJInternalFrame frame = new ChamCongJInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChamCongJInternalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1230, 756);
		this.setUndecorated(true);
//		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
//		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
//		ui.setNorthPane(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(245, 245, 245));
		panelHeader.setBounds(0, 0, 1230, 51);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);
		
		JLabel lblTitleChamCong = new JLabel("Chấm công");
		lblTitleChamCong.setBounds(10, 0, 142, 51);
		panelHeader.add(lblTitleChamCong);
		lblTitleChamCong.setForeground(Color.BLACK);
		lblTitleChamCong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBorder(new LineBorder(Color.GRAY));
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals("   Nhập tên nhân viên để tìm kiếm...")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText("   Nhập tên nhân viên để tìm kiếm...");
				}
			}
		});
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiem.setForeground(Color.LIGHT_GRAY);
		txtTimKiem.setText("   Nhập tên nhân viên để tìm kiếm...");
		txtTimKiem.setBounds(482, 62, 683, 40);
		contentPane.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new LineBorder(Color.GRAY));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(NhanVienJInternalFrame.class.getResource("/icon/search-13-16.png")));
		lblNewLabel_1.setBounds(1175, 62, 45, 40);
		contentPane.add(lblNewLabel_1);
		
		tableChamCong = new JTable();
		tableChamCong.setDefaultEditor(Object.class, null);
		JTableHeader th = tableChamCong.getTableHeader();
		tableChamCong.setRowHeight(35);
		tableChamCong.setShowGrid(false);
		tableChamCong.setFont(new Font("tahoma", Font.PLAIN, 15));
		th.setFont(new Font("Tahoma", Font.BOLD, 15));
		String[] columsName = { "Mã nhân viên", "Tên nhân viên", 
				"Ca làm việc", "Vai trò", "Tổng số Công","Ghi chú", "Tổng lương" };
		Object[][] data = null;
		model = new DefaultTableModel(data, columsName);
		tableChamCong.setModel(model);
		JScrollPane jScrollPane = new JScrollPane(tableChamCong);
		jScrollPane.setBounds(10, 171, 1210, 558);
		contentPane.add(jScrollPane);
	}

}
