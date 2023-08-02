package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import dao.ChiTietHoaDonDao;
import dao.GoiMonDAO;
import dao.HoaDonDao;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.ThucDon;

public class GoiMonJInternalFrame extends JInternalFrame {

	private JPanel contentPane;
	private JLabel lblMonAn;
	private JLabel lblHayDung;
	private JLabel lblDoUong;
	private JTextField txtSearch;
	private JLabel lblSearch;
	private JPanel panelThucDon;
	private JLabel lblPhimTat;
	private JLabel lblPrevTD;
	private JLabel lblNextTD;
	private JPanel panelTableHeader;
	private JLabel lbltenTD;
	private JLabel lblSL;
	private JLabel lblDonGia;
	private JLabel lblThanhTien;
	public static JTable tableHoaDon;
	public static DefaultTableModel defaultTableModel;
	private JLabel lblQuaTang;
	private JLabel lblSinhNhat;
	private JLabel lblGhiChu;
	private JLabel lblMangVe;
	private JLabel lblTaiBan;
	public static JTextField txtSoBan;
	private JLabel lblTongHoaDon;
	public static JLabel txtTongHoaDon;
	private JLabel lblTongThanhToan;
	public static JLabel txtTongThanhToan;
	private JLabel lblPrevHD;
	private JLabel lblNextHD;
	private JLabel lblThuTien;
	private JLabel lblLuuNhap;
	private JLabel lblHuyBo;
	public static JLabel lblMaHoaDon;
	public static String hinhThuc = "Tại bàn";
	public static String loai = "%";
	public static int step = -1;
	public static ArrayList<ChiTietHoaDon> list;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					GoiMonJInternalFrame frame = new GoiMonJInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GoiMonJInternalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1440, 765);
//		this.setUndecorated(true);
		this.setResizable(false);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 870, 700);
		contentPane.add(panel);
		panel.setLayout(null);

		lblHayDung = new JLabel(" Hay dùng");
		lblHayDung.setBackground(new Color(0, 102, 204));
		lblHayDung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblHayDung.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/favorite-5-24.png")));
				lblHayDung.setBackground(new Color(0, 102, 204));
				lblHayDung.setForeground(Color.WHITE);

				lblMonAn.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24 blue.png")));
				lblMonAn.setForeground(new Color(0, 102, 204));
				lblMonAn.setBackground(UIManager.getColor("CheckBox.light"));

				lblDoUong.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24 blue.png")));
				lblDoUong.setBackground(UIManager.getColor("CheckBox.light"));
				lblDoUong.setForeground(new Color(0, 102, 204));

				loai = "%";
				panelThucDon.removeAll();
				fillThucDon(GoiMonDAO.selectAll());
				validate();
			}
		});
		lblHayDung.setOpaque(true);
		lblHayDung.setForeground(Color.WHITE);
		lblHayDung.setHorizontalAlignment(SwingConstants.CENTER);
		lblHayDung.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/favorite-5-24.png")));
		lblHayDung.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHayDung.setBounds(0, 11, 120, 45);
		panel.add(lblHayDung);

		lblMonAn = new JLabel(" Món ăn");
		lblMonAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblMonAn.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24.png")));
				lblMonAn.setBackground(new Color(0, 102, 204));
				lblMonAn.setForeground(Color.WHITE);

				lblHayDung.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/heart-24.png")));
				lblHayDung.setForeground(new Color(0, 102, 204));
				lblHayDung.setBackground(UIManager.getColor("CheckBox.light"));

				lblDoUong.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24 blue.png")));
				lblDoUong.setBackground(UIManager.getColor("CheckBox.light"));
				lblDoUong.setForeground(new Color(0, 102, 204));

				loai = "Thức ăn";
				panelThucDon.removeAll();
				fillThucDon(GoiMonDAO.selectAllLoai("Thức ăn"));
				validate();

			}
		});
		lblMonAn.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24 blue.png")));
		lblMonAn.setOpaque(true);
		lblMonAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonAn.setForeground(new Color(0, 102, 204));
		lblMonAn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMonAn.setBackground(UIManager.getColor("CheckBox.light"));
		lblMonAn.setBounds(122, 11, 120, 45);
		panel.add(lblMonAn);

		lblDoUong = new JLabel("Đồ uống");
		lblDoUong.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblDoUong.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24.png")));
				lblDoUong.setBackground(new Color(0, 102, 204));
				lblDoUong.setForeground(Color.WHITE);

				lblHayDung.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/heart-24.png")));
				lblHayDung.setForeground(new Color(0, 102, 204));
				lblHayDung.setBackground(UIManager.getColor("CheckBox.light"));

				lblMonAn.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24 blue.png")));
				lblMonAn.setBackground(UIManager.getColor("CheckBox.light"));
				lblMonAn.setForeground(new Color(0, 102, 204));

				loai = "Đồ uống";
				panelThucDon.removeAll();
				fillThucDon(GoiMonDAO.selectAllLoai("Đồ uống"));
				validate();
			}
		});
		lblDoUong.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24 blue.png")));
		lblDoUong.setOpaque(true);
		lblDoUong.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoUong.setForeground(new Color(0, 102, 204));
		lblDoUong.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoUong.setBackground(UIManager.getColor("CheckBox.light"));
		lblDoUong.setBounds(243, 11, 120, 45);
		panel.add(lblDoUong);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				panelThucDon.removeAll();
				fillThucDon(GoiMonDAO.selectAllTen(txtSearch.getText(), loai));
				validate();
			}
		});
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtSearch.getText().trim().equals("Nhập mã/Tên món cần tìm...")) {
					txtSearch.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtSearch.getText().equals("")) {
					txtSearch.setText("  Nhập mã/Tên món cần tìm...");
				}
			}
		});
		txtSearch.setForeground(Color.GRAY);
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSearch.setText("  Nhập mã/Tên món cần tìm...");
		txtSearch.setBounds(0, 67, 817, 34);
		panel.add(txtSearch);
		txtSearch.setColumns(10);

		lblSearch = new JLabel("");
		lblSearch.setOpaque(true);
		lblSearch.setBackground(UIManager.getColor("CheckBox.light"));
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/search-13-16.png")));
		lblSearch.setBounds(814, 65, 46, 37);
		panel.add(lblSearch);

		panelThucDon = new JPanel();
		panelThucDon.setBackground(Color.WHITE);
		JScrollPane jScrollPaneThucDon = new JScrollPane(panelThucDon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelThucDon.setLayout(new GridLayout(0, 5, 5, 15));
		jScrollPaneThucDon.setBounds(0, 112, 870, 588);
		jScrollPaneThucDon.getVerticalScrollBar().setUnitIncrement(16);
		panel.add(jScrollPaneThucDon);

		JPanel panelHoaDon = new JPanel();
		panelHoaDon.setBackground(Color.WHITE);
		panelHoaDon.setBounds(874, 53, 565, 547);
		contentPane.add(panelHoaDon);
		panelHoaDon.setLayout(null);

		panelTableHeader = new JPanel();
		panelTableHeader.setBackground(UIManager.getColor("CheckBox.light"));
		panelTableHeader.setBounds(0, 0, 565, 47);
		panelHoaDon.add(panelTableHeader);
		panelTableHeader.setLayout(null);

		lbltenTD = new JLabel("Tên món");
		lbltenTD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltenTD.setBounds(0, 11, 72, 25);
		panelTableHeader.add(lbltenTD);

		lblSL = new JLabel("SL");
		lblSL.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSL.setBounds(230, 11, 19, 25);
		panelTableHeader.add(lblSL);

		lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDonGia.setBounds(333, 11, 62, 25);
		panelTableHeader.add(lblDonGia);

		lblThanhTien = new JLabel("Thành tiền");
		lblThanhTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThanhTien.setBounds(438, 11, 78, 25);
		panelTableHeader.add(lblThanhTien);

		tableHoaDon = new JTable();
		tableHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				step = tableHoaDon.getSelectedRow();
			}
		});
		tableHoaDon.setDefaultEditor(Object.class, null);
		tableHoaDon.setSelectionBackground(new Color(153, 204, 255));
		tableHoaDon.setSelectionForeground(Color.BLACK);
		tableHoaDon.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
		tableHoaDon.setRowHeight(50);
		tableHoaDon.setShowGrid(false);
		JTableHeader th = tableHoaDon.getTableHeader();
		th.setPreferredSize(new Dimension(100, 0));
		String[] columnNames = new String[] { "", "", "", "" };
		Object[][] data = { { "Hamberger bò", "1", "75.000", "75.000" },
				{ "Pizza đùi heo xong khói", "2", "60.000", "120.000" },
				{ "Salat cà chua dưa chuột", "3", "50.000", "150.000" } };
		defaultTableModel = new DefaultTableModel(null, columnNames);
		tableHoaDon.setModel(defaultTableModel);
		tableHoaDon.getColumnModel().getColumn(0).setPreferredWidth(200);
		JScrollPane jScrollPaneHoaDon = new JScrollPane(tableHoaDon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPaneHoaDon.setBounds(0, 48, 565, 442);
		jScrollPaneHoaDon.setBorder(BorderFactory.createEmptyBorder());
		jScrollPaneHoaDon.getViewport().setBackground(Color.WHITE);
		panelHoaDon.add(jScrollPaneHoaDon);

		lblQuaTang = new JLabel("");
		lblQuaTang.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Hiện tại không có Khuyến mãi!");
			}
		});
		lblQuaTang.setBackground(UIManager.getColor("CheckBox.light"));
		lblQuaTang.setOpaque(true);
		lblQuaTang.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuaTang.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/gift-24.png")));
		lblQuaTang.setBounds(7, 502, 46, 37);
		panelHoaDon.add(lblQuaTang);

		lblSinhNhat = new JLabel("");
		lblSinhNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Hiện tại không áp dụng được Voucher!");
			}
		});
		lblSinhNhat.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/christmas-59-24.png")));
		lblSinhNhat.setOpaque(true);
		lblSinhNhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblSinhNhat.setBackground(SystemColor.controlHighlight);
		lblSinhNhat.setBounds(63, 502, 46, 37);
		panelHoaDon.add(lblSinhNhat);

		lblGhiChu = new JLabel("");
		lblGhiChu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Chức năng đang cập nhật!");
			}
		});
		lblGhiChu.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/edit-11-24 blue.png")));
		lblGhiChu.setOpaque(true);
		lblGhiChu.setHorizontalAlignment(SwingConstants.CENTER);
		lblGhiChu.setBackground(SystemColor.controlHighlight);
		lblGhiChu.setBounds(119, 502, 46, 37);
		panelHoaDon.add(lblGhiChu);

		lblTaiBan = new JLabel("Tại bàn");
		lblTaiBan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblTaiBan.setBackground(new Color(0, 102, 204));
				lblTaiBan.setForeground(Color.WHITE);
				lblMangVe.setForeground(new Color(0, 102, 204));
				lblMangVe.setBackground(UIManager.getColor("CheckBox.light"));
				txtSoBan.setEnabled(true);
				hinhThuc = "Tại bàn";
			}
		});
		lblTaiBan.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaiBan.setOpaque(true);
		lblTaiBan.setForeground(Color.WHITE);
		lblTaiBan.setBackground(new Color(0, 102, 204));
		lblTaiBan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTaiBan.setBounds(407, 502, 72, 37);
		panelHoaDon.add(lblTaiBan);

		lblMangVe = new JLabel("Mang về");
		lblMangVe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblMangVe.setBackground(new Color(0, 102, 204));
				lblMangVe.setForeground(Color.WHITE);
				lblTaiBan.setForeground(new Color(0, 102, 204));
				lblTaiBan.setBackground(UIManager.getColor("CheckBox.light"));
				txtSoBan.setText("Nhập số bàn...");
				txtSoBan.setEnabled(false);
				hinhThuc = "Mang về";
			}
		});
		lblMangVe.setOpaque(true);
		lblMangVe.setHorizontalAlignment(SwingConstants.CENTER);
		lblMangVe.setForeground(new Color(0, 102, 204));
		lblMangVe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMangVe.setBackground(UIManager.getColor("CheckBox.light"));
		lblMangVe.setBounds(480, 502, 72, 37);
		panelHoaDon.add(lblMangVe);

		txtSoBan = new JTextField();
		txtSoBan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		txtSoBan.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtSoBan.getText().trim().equals("Nhập số bàn...")) {
					txtSoBan.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtSoBan.getText().equals("")) {
					lblMangVe.setHorizontalAlignment(SwingConstants.CENTER);
					txtSoBan.setText("Nhập số bàn...");
				}
			}
		});
		txtSoBan.setForeground(Color.GRAY);
		txtSoBan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSoBan.setText("Nhập số bàn...");
		txtSoBan.setBounds(263, 502, 133, 37);
		panelHoaDon.add(txtSoBan);
		txtSoBan.setColumns(10);

		JLabel lblXoaMon = new JLabel("Xóa món");
		lblXoaMon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tableHoaDon.getSelectedRow() != -1) {
					if (tableHoaDon.getRowCount() == 1) {
						int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắn chắn hủy hóa đơn này không ?",
								"Confirm", JOptionPane.YES_NO_OPTION);
						if (choice == JOptionPane.NO_OPTION) {
							return;
						}
					}
					defaultTableModel.removeRow(tableHoaDon.getSelectedRow());
//					tongHoaDon();
					if (tableHoaDon.getRowCount() == 0) {
						lblMaHoaDon.setText("");
						txtSoBan.setText("");
						step = -1;
					}
				}
			}
		});
		lblXoaMon.setOpaque(true);
		lblXoaMon.setBackground(new Color(255, 182, 193));
		lblXoaMon.setForeground(Color.RED);
		lblXoaMon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblXoaMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblXoaMon.setBounds(175, 502, 79, 37);
		panelHoaDon.add(lblXoaMon);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(UIManager.getColor("CheckBox.light"));
		panel_2.setBounds(0, 699, 870, 65);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		lblPhimTat = new JLabel("Phím tắt");
		lblPhimTat.setOpaque(true);
		lblPhimTat.setBackground(UIManager.getColor("CheckBox.background"));
		lblPhimTat.setForeground(new Color(0, 102, 204));
		lblPhimTat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhimTat.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhimTat.setBounds(10, 11, 73, 43);
		panel_2.add(lblPhimTat);

		lblPrevTD = new JLabel("<");
		lblPrevTD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (loai.equals("%")) {
					lblDoUong.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24.png")));
					lblDoUong.setBackground(new Color(0, 102, 204));
					lblDoUong.setForeground(Color.WHITE);

					lblHayDung.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/heart-24.png")));
					lblHayDung.setForeground(new Color(0, 102, 204));
					lblHayDung.setBackground(UIManager.getColor("CheckBox.light"));

					lblMonAn.setIcon(
							new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24 blue.png")));
					lblMonAn.setBackground(UIManager.getColor("CheckBox.light"));
					lblMonAn.setForeground(new Color(0, 102, 204));

					loai = "Đồ uống";
					panelThucDon.removeAll();
					fillThucDon(GoiMonDAO.selectAllLoai("Đồ uống"));
					validate();
					return;
				}
				if (loai.equals("Đồ uống")) {
					lblMonAn.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24.png")));
					lblMonAn.setBackground(new Color(0, 102, 204));
					lblMonAn.setForeground(Color.WHITE);

					lblHayDung.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/heart-24.png")));
					lblHayDung.setForeground(new Color(0, 102, 204));
					lblHayDung.setBackground(UIManager.getColor("CheckBox.light"));

					lblDoUong.setIcon(
							new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24 blue.png")));
					lblDoUong.setBackground(UIManager.getColor("CheckBox.light"));
					lblDoUong.setForeground(new Color(0, 102, 204));

					loai = "Thức ăn";
					panelThucDon.removeAll();
					fillThucDon(GoiMonDAO.selectAllLoai("Thức ăn"));
					validate();
					return;
				}
				if (loai.equals("Thức ăn")) {
					lblHayDung
							.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/favorite-5-24.png")));
					lblHayDung.setBackground(new Color(0, 102, 204));
					lblHayDung.setForeground(Color.WHITE);

					lblMonAn.setIcon(
							new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24 blue.png")));
					lblMonAn.setForeground(new Color(0, 102, 204));
					lblMonAn.setBackground(UIManager.getColor("CheckBox.light"));

					lblDoUong.setIcon(
							new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24 blue.png")));
					lblDoUong.setBackground(UIManager.getColor("CheckBox.light"));
					lblDoUong.setForeground(new Color(0, 102, 204));

					loai = "%";
					panelThucDon.removeAll();
					fillThucDon(GoiMonDAO.selectAll());
					validate();
					return;
				}
			}
		});
		lblPrevTD.setOpaque(true);
		lblPrevTD.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrevTD.setForeground(Color.GRAY);
		lblPrevTD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrevTD.setBackground(SystemColor.menu);
		lblPrevTD.setBounds(740, 7, 55, 43);
		panel_2.add(lblPrevTD);

		lblNextTD = new JLabel(">");
		lblNextTD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (loai.equals("%")) {
					lblMonAn.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24.png")));
					lblMonAn.setBackground(new Color(0, 102, 204));
					lblMonAn.setForeground(Color.WHITE);

					lblHayDung.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/heart-24.png")));
					lblHayDung.setForeground(new Color(0, 102, 204));
					lblHayDung.setBackground(UIManager.getColor("CheckBox.light"));

					lblDoUong.setIcon(
							new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24 blue.png")));
					lblDoUong.setBackground(UIManager.getColor("CheckBox.light"));
					lblDoUong.setForeground(new Color(0, 102, 204));

					loai = "Thức ăn";
					panelThucDon.removeAll();
					fillThucDon(GoiMonDAO.selectAllLoai("Thức ăn"));
					validate();
					return;
				}
				if (loai.equals("Thức ăn")) {
					lblDoUong.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24.png")));
					lblDoUong.setBackground(new Color(0, 102, 204));
					lblDoUong.setForeground(Color.WHITE);

					lblHayDung.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/heart-24.png")));
					lblHayDung.setForeground(new Color(0, 102, 204));
					lblHayDung.setBackground(UIManager.getColor("CheckBox.light"));

					lblMonAn.setIcon(
							new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24 blue.png")));
					lblMonAn.setBackground(UIManager.getColor("CheckBox.light"));
					lblMonAn.setForeground(new Color(0, 102, 204));

					loai = "Đồ uống";
					panelThucDon.removeAll();
					fillThucDon(GoiMonDAO.selectAllLoai("Đồ uống"));
					validate();
					return;
				}
				if (loai.equals("Đồ uống")) {
					lblHayDung
							.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/favorite-5-24.png")));
					lblHayDung.setBackground(new Color(0, 102, 204));
					lblHayDung.setForeground(Color.WHITE);

					lblMonAn.setIcon(
							new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/pizza-2-24 blue.png")));
					lblMonAn.setForeground(new Color(0, 102, 204));
					lblMonAn.setBackground(UIManager.getColor("CheckBox.light"));

					lblDoUong.setIcon(
							new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/drink-2-24 blue.png")));
					lblDoUong.setBackground(UIManager.getColor("CheckBox.light"));
					lblDoUong.setForeground(new Color(0, 102, 204));

					loai = "%";
					panelThucDon.removeAll();
					fillThucDon(GoiMonDAO.selectAll());
					validate();

					return;
				}
			}
		});
		lblNextTD.setOpaque(true);
		lblNextTD.setHorizontalAlignment(SwingConstants.CENTER);
		lblNextTD.setForeground(Color.GRAY);
		lblNextTD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNextTD.setBackground(SystemColor.menu);
		lblNextTD.setBounds(805, 7, 55, 43);
		panel_2.add(lblNextTD);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(UIManager.getColor("CheckBox.light"));
		panel_3.setBounds(874, 600, 565, 165);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		lblTongHoaDon = new JLabel("Tổng hóa đơn:");
		lblTongHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongHoaDon.setBounds(10, 11, 93, 24);
		panel_3.add(lblTongHoaDon);

		txtTongHoaDon = new JLabel("0");
		txtTongHoaDon.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTongHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		txtTongHoaDon.setBounds(113, 17, 137, 14);
		panel_3.add(txtTongHoaDon);

		lblTongThanhToan = new JLabel("Tổng thanh toán:");
		lblTongThanhToan.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTongThanhToan.setBounds(254, 11, 112, 24);
		panel_3.add(lblTongThanhToan);

		txtTongThanhToan = new JLabel("0");
		txtTongThanhToan.setForeground(Color.RED);
		txtTongThanhToan.setHorizontalAlignment(SwingConstants.LEFT);
		txtTongThanhToan.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtTongThanhToan.setBounds(376, 11, 179, 24);
		panel_3.add(txtTongThanhToan);

		lblPrevHD = new JLabel("<");
		lblPrevHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tableHoaDon.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thực đơn !!");
					return;
				}
				step--;
				if (step < 0) {
					step = tableHoaDon.getRowCount() - 1;
					tableHoaDon.setRowSelectionInterval(step, step);
				} else {
					tableHoaDon.setRowSelectionInterval(step, step);
				}
			}
		});
		lblPrevHD.setOpaque(true);
		lblPrevHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrevHD.setForeground(Color.GRAY);
		lblPrevHD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPrevHD.setBackground(SystemColor.menu);
		lblPrevHD.setBounds(10, 111, 55, 43);
		panel_3.add(lblPrevHD);

		lblNextHD = new JLabel(">");
		lblNextHD.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tableHoaDon.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thực đơn !!");
					return;
				}
				step++;
				if (step == tableHoaDon.getRowCount()) {
					step = 0;
					tableHoaDon.setRowSelectionInterval(step, step);
				} else {
					tableHoaDon.setRowSelectionInterval(step, step);
				}
			}
		});
		lblNextHD.setOpaque(true);
		lblNextHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblNextHD.setForeground(Color.GRAY);
		lblNextHD.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNextHD.setBackground(SystemColor.menu);
		lblNextHD.setBounds(75, 111, 55, 43);
		panel_3.add(lblNextHD);

		lblThuTien = new JLabel("Thu tiền");
		lblThuTien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (defaultTableModel.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thực đơn trước khi thanh toán !!");
					return;
				}
				if (hinhThuc.equals("Tại bàn")) {
					if (txtSoBan.getText().equals("") || txtSoBan.getText().equals("Nhập số bàn...")) {
						JOptionPane.showMessageDialog(null, "Bạn phải nhập số bàn !!");
						return;
					}
				}
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ThanhToanJframe frame = new ThanhToanJframe(txtTongThanhToan.getText());
					frame.giaoDien = "Nhấn từ form gọi món";
					frame.maHoaDon = lblMaHoaDon.getText();
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblThuTien.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/us-dollar-24.png")));
		lblThuTien.setBackground(Color.ORANGE);
		lblThuTien.setOpaque(true);
		lblThuTien.setForeground(Color.WHITE);
		lblThuTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThuTien.setHorizontalAlignment(SwingConstants.CENTER);
		lblThuTien.setBounds(443, 111, 112, 43);
		panel_3.add(lblThuTien);

		lblLuuNhap = new JLabel("Lưu nháp");
		lblLuuNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (defaultTableModel.getRowCount() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn thực đơn trước khi lưu nháp !!");
					return;
				}
				if (hinhThuc.equals("Tại bàn")) {
					if (txtSoBan.getText().equals("") || txtSoBan.getText().equals("Nhập số bàn...")) {
						JOptionPane.showMessageDialog(null, "Bạn phải nhập số bàn !!");
						return;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Không được phép lưu nháp với hình thức mang về !!");
					return;
				}
				if (HoaDonDao.selectById(lblMaHoaDon.getText()) == 1) {
					int tongtien = Integer.parseInt(String.valueOf(txtTongThanhToan.getText()).replace(",", ""));
					HoaDonDao.update(lblMaHoaDon.getText(), "Chờ thanh toán", null, tongtien);
				} else {
					insetHoaDon("Chờ thanh toán", null);
				}
				insertChiTietHoaDon();
				FoodsAppJframe.loadGoiMon();
				JOptionPane.showMessageDialog(null, "Lưu nháp thành công");

			}
		});
		lblLuuNhap.setIcon(new ImageIcon(GoiMonJInternalFrame.class.getResource("/icon/save-24.png")));
		lblLuuNhap.setOpaque(true);
		lblLuuNhap.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuuNhap.setForeground(new Color(0, 102, 204));
		lblLuuNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLuuNhap.setBackground(Color.WHITE);
		lblLuuNhap.setBounds(321, 111, 112, 43);
		panel_3.add(lblLuuNhap);

		lblHuyBo = new JLabel("X  Hủy bỏ");
		lblHuyBo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tableHoaDon.getRowCount() > 0) {
					int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn hủy hóa đơn này không ?",
							"Confirm", JOptionPane.YES_NO_OPTION);
					if (choice == JOptionPane.YES_OPTION) {
						txtTongHoaDon.setText("0");
						txtTongThanhToan.setText("0");
						lblMaHoaDon.setText("");
						txtSoBan.setText("");
						step = -1;
						defaultTableModel.setRowCount(0);
					}
				}
			}
		});
		lblHuyBo.setOpaque(true);
		lblHuyBo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHuyBo.setForeground(Color.RED);
		lblHuyBo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHuyBo.setBackground(new Color(255, 160, 122));
		lblHuyBo.setBounds(193, 115, 112, 43);
		panel_3.add(lblHuyBo);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(874, 0, 565, 48);
		contentPane.add(panel_4);
		panel_4.setLayout(null);

		lblMaHoaDon = new JLabel("");
		lblMaHoaDon.setForeground(Color.BLACK);
		lblMaHoaDon.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblMaHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaHoaDon.setBounds(442, 3, 123, 43);
		panel_4.add(lblMaHoaDon);

		fillThucDon(GoiMonDAO.selectAll());
	}

	public void fillThucDon(ArrayList<ThucDon> list) {
//		ArrayList<ThucDon> list = GoiMonDAO.selectAll();
		int leng = list.size();
		for (ThucDon td : list) {
			Panel panela = new Panel();
			panela.setBackground(UIManager.getColor("CheckBox.light"));
			panela.setPreferredSize(new Dimension(155, 130));
			panela.setLayout(new BorderLayout(0, 0));

			JLabel hinhanh = new JLabel();
			hinhanh.setLayout(new GridLayout(3, 3));
			panela.add(hinhanh);
			ImageIcon imageIcon = new ImageIcon(
					new ImageIcon(GoiMonJInternalFrame.class.getResource("/image/" + td.getHinhanh())).getImage()
							.getScaledInstance(175, 175, Image.SCALE_DEFAULT));
			hinhanh.setIcon(imageIcon);

			String gb = String.valueOf(td.getGia());
			JLabel gia = new JLabel(gb.substring(0, gb.length() - 3) + "K");
			gia.setFont(new Font("Tahoma", Font.PLAIN, 15));
			gia.setHorizontalAlignment(SwingConstants.CENTER);
			gia.setForeground(Color.WHITE);
			gia.setSize(46, 24);
			gia.setOpaque(true);
			gia.setBackground(new Color(0, 102, 204, 155));
			for (int i = 1; i <= 9; i++) {
				JLabel label = new JLabel();
				label.setPreferredSize(new Dimension(10, 10));
				hinhanh.add(label);
				if (i == 3) {
					hinhanh.add(gia);
				}
			}

			JLabel tenTD = new JLabel(
					"<HTML> <body align=\"center\">" + td.getTenTD().toUpperCase() + "</body> </HTML>");
			tenTD.setPreferredSize(new Dimension(175, 35));
			tenTD.setHorizontalAlignment(SwingConstants.CENTER);
			tenTD.setFont(new Font("Bahnschrift", Font.PLAIN, 13));
			panela.add(tenTD, BorderLayout.SOUTH);
			panelThucDon.add(panela);

			panela.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					if (lblMaHoaDon.getText().equals("")) {
						SimpleDateFormat formatter = new SimpleDateFormat("'HD'yyMMddHHmmss");
						Date date = new Date(System.currentTimeMillis());
						lblMaHoaDon.setText(formatter.format(date));
					}
					tangSoLuong(td.getTenTD(), td.getGia());
//					tongHoaDon();
				}
			});
		}
		if (leng < 21) {
			for (int i = 0; i < 21 - leng; i++) {
				Panel panelq = new Panel();
				panelq.setPreferredSize(new Dimension(155, 140));
				panelq.setLayout(new BorderLayout(0, 0));
				panelThucDon.add(panelq);
			}
		}
	}

	public void fillTable(String tenmon, int gia) {
		NumberFormat df = new DecimalFormat("#,###");
		String str = df.format(gia);
		defaultTableModel.addRow(new Object[] { tenmon, 1, str, str });
		tableHoaDon.setModel(defaultTableModel);
	}

	public void tangSoLuong(String tenTD, int gia) {
		for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
			if (String.valueOf(tableHoaDon.getValueAt(i, 0)).equals(tenTD)) {
				int sl = Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 1))) + 1;
				tableHoaDon.setValueAt(sl, i, 1);
				NumberFormat df = new DecimalFormat("#,###");
				String str = df.format(sl * gia);
				tableHoaDon.setValueAt(str, i, 3);
				return;
			}
		}
		fillTable(tenTD, gia);
	}

	public static void tongHoaDon() {
		int tong = 0;
		for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
			String thanhTien = String.valueOf(tableHoaDon.getValueAt(i, 3)).replace(",", "");
			tong += Integer.parseInt(thanhTien);
		}
		NumberFormat df = new DecimalFormat("#,###");
		String str = df.format(tong);
		txtTongHoaDon.setText(str);
		txtTongThanhToan.setText(str);
	}

	public static void insetHoaDon(String tt, String gtt) {
		// Tạo đối tượng hoaDon
		String maHD = lblMaHoaDon.getText();
		String tenNV = FoodsAppJframe.tenUser;
		int soBan = 0;
		if (hinhThuc.equals("Tại bàn")) {
			soBan = Integer.parseInt(txtSoBan.getText());
		}
		String trangThai = tt;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String gioTamTinh = formatter.format(date);
		String gioThanhToan = gtt;
		int tongTien = Integer.parseInt(txtTongThanhToan.getText().replace(",", ""));
		HoaDon hd = new HoaDon(maHD, tenNV, hinhThuc, soBan, trangThai, gioTamTinh, gioThanhToan, tongTien);
		HoaDonDao.insert(hd);

	}

	public static void insertChiTietHoaDon() {
		// Tạo đối tượng chi tiết hóa đơn
		String maHD = lblMaHoaDon.getText();
		ChiTietHoaDonDao.delete(maHD);
		for (int i = 0; i < tableHoaDon.getRowCount(); i++) {
			String tenTD = String.valueOf(tableHoaDon.getValueAt(i, 0));
			int soluong = Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 1)));
			int gia = Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 2)).replace(",", ""));
//			int thanhtien = Integer.parseInt(String.valueOf(tableHoaDon.getValueAt(i, 3)).replace(",", ""));
			ChiTietHoaDon cthd = new ChiTietHoaDon(maHD, tenTD, gia, soluong);
			ChiTietHoaDonDao.insert(cthd);
		}
	}

	public static void doChinhSua(String maHD, String soban) {
		defaultTableModel.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		txtSoBan.setText(soban);
		list = ChiTietHoaDonDao.selectAllByID(maHD);
		lblMaHoaDon.setText(maHD);
		for (ChiTietHoaDon cthd : list) {
			defaultTableModel.addRow(new Object[] { cthd.getTenTD(), cthd.getSoluong(), cthd.getGia(),
					df.format(cthd.getSoluong() * cthd.getGia()) });
		}
//		tongHoaDon();
	}
}
