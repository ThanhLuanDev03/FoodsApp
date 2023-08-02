package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import dao.HoaDonDao;
import entity.HoaDon;

public class ChoThanhToanJInternalFrame extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtTimKiem;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private ArrayList<HoaDon> list;
	private JLabel txtTongTien;
	private JComboBox comboBox;
	public String trangthai = "%";
	private JDateChooser txtTuNgay;
	private JDateChooser txtDenNgay;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ChoThanhToanJInternalFrame frame = new ChoThanhToanJInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ChoThanhToanJInternalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 765);
//		this.setUndecorated(true);
		this.setResizable(false);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTuNgay = new JLabel("Từ ngày");
		lblTuNgay.setBounds(10, 11, 57, 33);
		lblTuNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuNgay.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		contentPane.add(lblTuNgay);

		txtTuNgay = new JDateChooser();
		txtTuNgay.setBounds(77, 11, 147, 33);
		JTextFieldDateEditor editorTuNgay = (JTextFieldDateEditor) txtTuNgay.getDateEditor();
		editorTuNgay.setEditable(false);
		txtTuNgay.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		txtTuNgay.setDateFormatString("dd-MM-yy");
		contentPane.add(txtTuNgay);

		JLabel lblDenNgay = new JLabel("Đến ngày");
		lblDenNgay.setBounds(233, 11, 72, 33);
		lblDenNgay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDenNgay.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		contentPane.add(lblDenNgay);

		txtDenNgay = new JDateChooser();
		txtDenNgay.setBounds(315, 11, 147, 33);
		JTextFieldDateEditor editorDenNgay = (JTextFieldDateEditor) txtDenNgay.getDateEditor();
		editorDenNgay.setEditable(false);
		txtDenNgay.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		txtDenNgay.setDateFormatString("dd-MM-yy");
		contentPane.add(txtDenNgay);

		comboBox = new JComboBox();
		comboBox.setBounds(483, 11, 129, 33);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(comboBox.getSelectedItem()).equals("Tất cả")) {
					trangthai = "%";
					fillToTableByTrangThai("%");
					return;
				}
				if (String.valueOf(comboBox.getSelectedItem()).equals("Chờ thanh toán")) {
					trangthai = "Chờ thanh toán";
					fillToTableByTrangThai("Chờ thanh toán");
					return;
				}
				if (String.valueOf(comboBox.getSelectedItem()).equals("Đã thanh toán")) {
					trangthai = "Đã thanh toán";
					fillToTableByTrangThai("Đã thanh toán");
					return;
				}
			}
		});
		comboBox.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Tất cả", "Chờ thanh toán", "Đã thanh toán" }));
		contentPane.add(comboBox);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(637, 11, 738, 33);
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				fillToTableDoSearch(txtTimKiem.getText(), trangthai);
			}
		});
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().trim().equals("Tìm kiếm theo mã hóa đơn, số bàn, tên nhân viên...")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText("  Tìm kiếm theo mã hóa đơn, số bàn, tên nhân viên...");
				}
			}
		});
		txtTimKiem.setForeground(Color.GRAY);
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setText("  Tìm kiếm theo mã hóa đơn, số bàn, tên nhân viên...");
		contentPane.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		JLabel btnTimKiem = new JLabel("");
		btnTimKiem.setBounds(1385, 11, 45, 33);
		btnTimKiem.setBackground(UIManager.getColor("CheckBox.light"));
		btnTimKiem.setOpaque(true);
		btnTimKiem.setHorizontalAlignment(SwingConstants.CENTER);
		btnTimKiem.setIcon(new ImageIcon(ChoThanhToanJInternalFrame.class.getResource("/icon/search-13-16.png")));
		contentPane.add(btnTimKiem);

		JPanel panel = new JPanel();
		panel.setBounds(10, 55, 1420, 650);
		panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1, 2, 1418, 43);
		panel.add(panel_1);
		panel_1.setBackground(UIManager.getColor("CheckBox.light"));
		panel_1.setLayout(null);

		JLabel lblHoaDon = new JLabel("Order/Hóa đơn");
		lblHoaDon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHoaDon.setBounds(0, 11, 118, 20);
		panel_1.add(lblHoaDon);

		JLabel lblTenNhanVien = new JLabel("Tên nhân viên");
		lblTenNhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenNhanVien.setBounds(174, 11, 103, 20);
		panel_1.add(lblTenNhanVien);

		JLabel lblSoBan = new JLabel("Số bàn");
		lblSoBan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoBan.setBounds(527, 11, 56, 20);
		panel_1.add(lblSoBan);

		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTrangThai.setBounds(705, 11, 76, 20);
		panel_1.add(lblTrangThai);

		JLabel lblGioTamTInh = new JLabel("Giờ tạm tính");
		lblGioTamTInh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioTamTInh.setBounds(882, 11, 96, 20);
		panel_1.add(lblGioTamTInh);

		JLabel lblGioThanhToan = new JLabel("Giờ thanh toán");
		lblGioThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGioThanhToan.setBounds(1060, 11, 108, 20);
		panel_1.add(lblGioThanhToan);

		JLabel lblTongTien = new JLabel("Tổng tiền");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongTien.setBounds(1238, 11, 76, 20);
		panel_1.add(lblTongTien);

		JLabel lblHinhThuc = new JLabel("Hình thức");
		lblHinhThuc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHinhThuc.setBounds(352, 11, 76, 20);
		panel_1.add(lblHinhThuc);

		table = new JTable();
		table.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		table.setRowHeight(50);
		table.setShowGrid(false);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionBackground(new Color(153, 204, 255));
		table.setSelectionForeground(Color.BLACK);
		JTableHeader th = table.getTableHeader();
		th.setPreferredSize(new Dimension(100, 0));
		String[] columnNames = new String[] { "", "", "", "", "", "", "", "" };
		Object[][] data = {
				{ "HD0001", "nguyenthanhluan", "Tại bàn", "33", "Đã thanh toán", "14:14 06/05/2022", "14:43 06/05/2022",
						"543,000" },
				{ "HD0002", "vongoctu", "Tại bàn", "14", "Chờ thanh toán", "14:14 06/05/2022", "", "200,000" },
				{ "HD0003", "nguyenthanhluan", "Mang về", "", "Đã thanh toán", "14:14 06/05/2022", "14:43 06/05/2022",
						"605,000" },
				{ "HD0004", "phamhuytrieu", "Tại bàn", "22", "Đã thanh toán", "14:14 06/05/2022", "14:43 06/05/2022",
						"112,000" },
				{ "HD0005", "vongoctu", "Mang về", "", "Đã thanh toán", "14:14 06/05/2022", "", "348,000" } };
		defaultTableModel = new DefaultTableModel(data, columnNames);
		table.setModel(defaultTableModel);
//		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(1, 44, 1418, 541);
		jScrollPane.setBorder(BorderFactory.createEmptyBorder());
		jScrollPane.getViewport().setBackground(Color.WHITE);
		panel.add(jScrollPane);

		JLabel lblTongTien2 = new JLabel("Tổng tiền:");
		lblTongTien2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTongTien2.setBounds(1112, 604, 78, 35);
		panel.add(lblTongTien2);

		txtTongTien = new JLabel("1.292.000");
		txtTongTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTongTien.setHorizontalAlignment(SwingConstants.CENTER);
		txtTongTien.setBounds(1192, 604, 218, 35);
		panel.add(txtTongTien);

		JLabel btnXoa = new JLabel("Xóa");
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (table.getSelectedRow() != -1) {
					if (String.valueOf(table.getValueAt(table.getSelectedRow(), 4)).equals("Chờ thanh toán")) {
						defaultTableModel.removeRow(table.getSelectedRow());
						tongTien();
					} else {
						JOptionPane.showMessageDialog(null, "Chỉ được xóa những hóa đơn chờ thanh toán !!");
					}
				}
			}
		});
		btnXoa.setIcon(new ImageIcon(ChoThanhToanJInternalFrame.class.getResource("/icon/trash-2-24.png")));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(new Color(255, 102, 51));
		btnXoa.setOpaque(true);
		btnXoa.setHorizontalAlignment(SwingConstants.CENTER);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnXoa.setBounds(960, 598, 107, 41);
		panel.add(btnXoa);

		JLabel lblChinhSua = new JLabel("Chỉnh sửa");
		lblChinhSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (String.valueOf(table.getValueAt(table.getSelectedRow(), 4)).equals("Chờ thanh toán")) {
					try {
						FoodsAppJframe.doChinhSua();
						GoiMonJInternalFrame.doChinhSua(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)),
								String.valueOf(table.getValueAt(table.getSelectedRow(), 3)));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Chỉ được chỉnh sữa với hóa đơn chờ thanh toán");
				}
			}
		});
		lblChinhSua.setIcon(new ImageIcon(ChoThanhToanJInternalFrame.class.getResource("/icon/edit-9-24.png")));
		lblChinhSua.setForeground(Color.WHITE);
		lblChinhSua.setOpaque(true);
		lblChinhSua.setHorizontalAlignment(SwingConstants.CENTER);
		lblChinhSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChinhSua.setBackground(new Color(30, 144, 255));
		lblChinhSua.setBounds(819, 598, 115, 41);
		panel.add(lblChinhSua);

		JLabel btnThanhToan = new JLabel("Thanh Toán");
		btnThanhToan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (table.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn hóa đơn trước khi thanh toán");
					return;
				} else {
					if (String.valueOf(table.getValueAt(table.getSelectedRow(), 4)).equals("Chờ thanh toán")) {
						try {
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
							ThanhToanJframe frame = new ThanhToanJframe(
									String.valueOf(table.getValueAt(table.getSelectedRow(), 7)));
							frame.maHoaDon = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
							frame.tongtien = Integer.parseInt(
									String.valueOf(table.getValueAt(table.getSelectedRow(), 7)).replace(",", ""));
							frame.giaoDien = "Nhấn từ form thanh toán";
							frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "Hóa đơn này đã được thanh toán");
						return;
					}
				}
			}
		});
		btnThanhToan.setIcon(new ImageIcon(ChoThanhToanJInternalFrame.class.getResource("/icon/bill-24.png")));
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setOpaque(true);
		btnThanhToan.setHorizontalAlignment(SwingConstants.CENTER);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThanhToan.setBackground(Color.ORANGE);
		btnThanhToan.setBounds(661, 598, 132, 43);
		panel.add(btnThanhToan);

		JLabel btnNext = new JLabel(">");
		btnNext.setBounds(1384, 716, 46, 38);
		btnNext.setBackground(UIManager.getColor("CheckBox.light"));
		btnNext.setOpaque(true);
		btnNext.setHorizontalAlignment(SwingConstants.CENTER);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnNext);

		JLabel btnPrev = new JLabel("<");
		btnPrev.setBounds(1329, 716, 46, 38);
		btnPrev.setOpaque(true);
		btnPrev.setBackground(UIManager.getColor("CheckBox.light"));
		btnPrev.setHorizontalAlignment(SwingConstants.CENTER);
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(btnPrev);

		fillToTable();
	}

	public void fillToTable() {
		defaultTableModel.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		list = HoaDonDao.selectAll();
		for (HoaDon hd : list) {
			defaultTableModel.addRow(new Object[] { hd.getMaHD(), hd.getNhanvien(), hd.getHinhthuc(), hd.getSoban(),
					hd.getTrangthai(), hd.getGiotamtinh(), hd.getGiothanhtoan(), df.format(hd.getTongtien()) });
		}
		tongTien();
	}

	public void fillToTableByTrangThai(String tt) {
		defaultTableModel.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		list = HoaDonDao.selectByTrangThai(tt);
		for (HoaDon hd : list) {
			defaultTableModel.addRow(new Object[] { hd.getMaHD(), hd.getNhanvien(), hd.getHinhthuc(), hd.getSoban(),
					hd.getTrangthai(), hd.getGiotamtinh(), hd.getGiothanhtoan(), df.format(hd.getTongtien()) });
		}
		tongTien();
	}

	public void fillToTableDoSearch(String txtSearch, String tt) {
		defaultTableModel.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		list = HoaDonDao.selectDoSearch(txtSearch, tt);
		for (HoaDon hd : list) {
			defaultTableModel.addRow(new Object[] { hd.getMaHD(), hd.getNhanvien(), hd.getHinhthuc(), hd.getSoban(),
					hd.getTrangthai(), hd.getGiotamtinh(), hd.getGiothanhtoan(), df.format(hd.getTongtien()) });
		}
		tongTien();
	}

	public void tongTien() {
		int tong = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			tong += Integer.parseInt(String.valueOf(table.getValueAt(i, 7)).replace(",", ""));
		}
		NumberFormat df = new DecimalFormat("#,###");
		txtTongTien.setText(df.format(tong));
	}
}
