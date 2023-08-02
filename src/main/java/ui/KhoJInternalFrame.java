package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

//import com.raven.datechooser.DateChooser;

import dao.KhoDAO;
import entity.NguyenLieu;
import utils.MsgBox;
//import com.toedter.calendar.JDateChooser;

public class KhoJInternalFrame extends JInternalFrame {

	private JPanel contentPane;
	private DefaultTableModel model;

	public static JTable table_1;
	public int roww = 0;
	public int row = 0;
	private float tong = 0;
	private JLabel lblTngTin;
	public String manl;
	KhoDAO dao = new KhoDAO();
	private JTable table;
	private JTextField txtNhp;
//	private DateChooser chDate = new DateChooser();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					KhoJInternalFrame frame = new KhoJInternalFrame();
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
	public KhoJInternalFrame() {
		setSize(1230, 753);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
//		this.setUndecorated(true);
//		this.setLocationRelativeTo(null);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(245, 245, 245));
		panelTitle.setBounds(0, 0, 1230, 51);
		contentPane.add(panelTitle);
		panelTitle.setLayout(null);

		JLabel lblNewLabel = new JLabel("Kho");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 0, 60, 51);
		panelTitle.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_1.setBackground(new Color(255, 255, 255));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				panel_1.setBackground(new Color(200, 200, 200));
			}
		});

		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(1135, 16, 85, 23);

		panelTitle.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblPhnHi_1 = new JLabel(" Phản hồi");
		panel_1.add(lblPhnHi_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 55, 1210, 699);
		tabbedPane.setFont(new Font("tahoma", Font.PLAIN, 15));
		contentPane.add(tabbedPane);

		JPanel panelXuatKho = new JPanel();
		tabbedPane.addTab("Xuất kho", null, panelXuatKho, null);
		panelXuatKho.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1215, 40);
		panelXuatKho.add(panel_2);
		panel_2.setBackground(UIManager.getColor("Button.light"));
		panel_2.setLayout(null);

		JLabel lblThem = new JLabel("Thêm");
		lblThem.setBounds(0, 0, 90, 40);
		panel_2.add(lblThem);
		lblThem.setIcon(new ImageIcon(KhoJInternalFrame.class.getResource("/icon/icons8_add_20px.png")));
		lblThem.setOpaque(true);
		lblThem.setHorizontalAlignment(SwingConstants.CENTER);
		lblThem.setForeground(new Color(0, 0, 0));
		lblThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThem.setBackground(UIManager.getColor("Button.light"));

		JLabel lblXoa = new JLabel(" Xóa");
		lblXoa.setBounds(90, 0, 90, 40);
		panel_2.add(lblXoa);
		lblXoa.setIcon(new ImageIcon(KhoJInternalFrame.class.getResource("/icon/icons8_delete_20px_1.png")));
		lblXoa.setOpaque(true);
		lblXoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblXoa.setForeground(new Color(0, 0, 0));
		lblXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblXoa.setBackground(UIManager.getColor("Button.light"));

		JLabel lblSua = new JLabel("Cập nhật");
		lblSua.setBounds(183, 0, 98, 40);
		panel_2.add(lblSua);
		lblSua.setIcon(new ImageIcon(KhoJInternalFrame.class.getResource("/icon/icons8_update_20px.png")));
		lblSua.setOpaque(true);
		lblSua.setHorizontalAlignment(SwingConstants.CENTER);
		lblSua.setForeground(new Color(0, 0, 0));
		lblSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSua.setBackground(UIManager.getColor("Button.light"));

		JLabel lblXem = new JLabel("Xem");
		lblXem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblXem.setBackground(UIManager.getColor("Button.light"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblXem.setBackground(new Color(200, 200, 200));

			}
		});
		lblXem.setBounds(281, 0, 90, 40);
		panel_2.add(lblXem);
		lblXem.setBackground(UIManager.getColor("Button.light"));
		lblXem.setForeground(new Color(0, 0, 0));
		lblXem.setIcon(new ImageIcon(KhoJInternalFrame.class.getResource("/icon/icons8_view_details_20px.png")));
		lblXem.setHorizontalAlignment(SwingConstants.CENTER);
		lblXem.setOpaque(true);

		lblXem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSua.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				roww = table_1.getSelectedRow();
				if (roww < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn nguyên liệu để xem chi tiết!");
				} else {
					try {
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
						String dateInString = String.valueOf(table_1.getValueAt(roww, 6));
						Date date = formatter.parse(dateInString);

						CapNhatKhoJFrame frame = new CapNhatKhoJFrame();
						frame.setVisible(true);
						String maNL = String.valueOf(table_1.getValueAt(roww, 0));
						String tenNL = String.valueOf(table_1.getValueAt(roww, 1));
						String donvi = String.valueOf(table_1.getValueAt(roww, 2));
						String dongia = String.valueOf(table_1.getValueAt(roww, 3));
						String soluong = String.valueOf(table_1.getValueAt(roww, 5));
						String giatrinhap = String.valueOf(table_1.getValueAt(row, 4));
						Date hansudung = date;
						frame.edit(maNL, tenNL, donvi, dongia, soluong, giatrinhap, hansudung);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSua.setBackground(UIManager.getColor("Button.light"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSua.setBackground(new Color(200, 200, 200));

			}

		});
		lblXoa.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (roww < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn nguyên liệu cần xóa", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					delete();

				}

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblXoa.setBackground(UIManager.getColor("Button.light"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblXoa.setBackground(new Color(200, 200, 200));

			}

		});
		lblThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblThem.setBackground(UIManager.getColor("Button.light"));

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblThem.setBackground(new Color(200, 200, 200));

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				ThemKhoJFrame th = new ThemKhoJFrame();
				th.setVisible(true);

			}
		});
		String[] columnNames = new String[] { "Mã nguyên liệu", "Tên nguyên liệu", "Đơn vị", "Đơn giá", "Giá trị nhập",
				"Số lượng", "Hạn sử dụng" };
		Object[][] data = null;
		model = new DefaultTableModel(data, columnNames);
		table_1 = new JTable();
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableHeader th = table_1.getTableHeader();
		th.setFont(new Font("Tahoma", Font.BOLD, 15));
		JScrollPane scrollPane = new JScrollPane(table_1);
		scrollPane.setBounds(0, 102, 1205, 500);
		panelXuatKho.add(scrollPane);
		table_1.setDefaultEditor(Object.class, null);
		table_1.setModel(model);
		table_1.setVerifyInputWhenFocusTarget(false);
		table_1.setRowHeight(35);
		table_1.setShowGrid(false);
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		TableCustom.apply(scrollPane, TableCustom.TableType.MULTI_LINE);
		table_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				roww = table_1.getSelectedRow();
				int giathanh = (int) table_1.getValueAt(roww, 3);
				Float soluong = (Float) table_1.getValueAt(roww, 5);
				tong = soluong * giathanh;
				lblTngTin.setText("" + tong);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				roww = table_1.getSelectedRow();
				if (e.getClickCount() == 2) {
					if (roww < 0) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn nguyên liệu để xem chi tiết!");
					} else {
						try {
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
							String dateInString = String.valueOf(table_1.getValueAt(roww, 6));
							Date date = formatter.parse(dateInString);

							CapNhatKhoJFrame frame = new CapNhatKhoJFrame();
							frame.setVisible(true);
							String maNL = String.valueOf(table_1.getValueAt(roww, 0));
							String tenNL = String.valueOf(table_1.getValueAt(roww, 1));
							String donvi = String.valueOf(table_1.getValueAt(roww, 2));
							String dongia = String.valueOf(table_1.getValueAt(roww, 3));
							String soluong = String.valueOf(table_1.getValueAt(roww, 5));
							String giatrinhap = String.valueOf(table_1.getValueAt(row, 4));
							Date hansudung = date;
							frame.edit(maNL, tenNL, donvi, dongia, soluong, giatrinhap, hansudung);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(0, 602, 193, 29);
		panelXuatKho.add(panel);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setLayout(null);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_3.setBounds(179, 602, 183, 29);
		panelXuatKho.add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setLayout(null);
		panel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_4.setBounds(526, 602, 183, 29);
		panelXuatKho.add(panel_4);

		lblTngTin = new JLabel("");
		lblTngTin.setBounds(10, 10, 128, 17);
		panel_4.add(lblTngTin);
		lblTngTin.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setLayout(null);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_6.setBounds(874, 602, 164, 29);
		panelXuatKho.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setLayout(null);
		panel_7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_7.setBounds(348, 602, 183, 29);
		panelXuatKho.add(panel_7);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(255, 255, 255));
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_4_1.setBounds(706, 602, 175, 29);
		panelXuatKho.add(panel_4_1);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBackground(new Color(255, 255, 255));
		panel_6_1.setLayout(null);
		panel_6_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_6_1.setBounds(1028, 602, 177, 29);
		panelXuatKho.add(panel_6_1);

		txtNhp = new JTextField();
		txtNhp.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtNhp.getText().equals("Nhập tên nguyên liệu để tìm kiếm ...")) {
					txtNhp.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtNhp.getText().equals("")) {
					txtNhp.setText("Nhập tên nguyên liệu để tìm kiếm ...");
				}
			}
		});
		txtNhp.setForeground(Color.GRAY);
		txtNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				fillTableDoSearch(KhoDAO.selectAllTen(txtNhp.getText()));
			}
		});
		txtNhp.setText("Nhập tên nguyên liệu để tìm kiếm ...");
		txtNhp.setBounds(0, 51, 1205, 40);
		panelXuatKho.add(txtNhp);
		txtNhp.setColumns(10);

		JPanel panelChuyenKho = new JPanel();
		tabbedPane.addTab("Chuyển kho", null, panelChuyenKho, null);
		panelChuyenKho.setLayout(null);

		JPanel panelNhapKho = new JPanel();
		tabbedPane.addTab("Nhập kho", null, panelNhapKho, null);
		panelNhapKho.setLayout(null);

		fillTable();
		manl = (String) table_1.getValueAt(roww, 0);
//		setDChooser();
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	}

//	void setDChooser() {
//		this.chDate.setTextField(textField);
//		this.chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
//	}
//	
	public static void fillTable() {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
		try {
			List<NguyenLieu> list = KhoDAO.selectAll();
			Iterator var3 = list.iterator();

			while (var3.hasNext()) {
				NguyenLieu cd = (NguyenLieu) var3.next();
				Object[] row = new Object[] { cd.getMaNL(), cd.getTenNL(), cd.getDonvi(), cd.getDongia(),
						cd.getGiatrinhap(), cd.getSoluong(), cd.getHansudung() };
				model.addRow(row);
			}
		} catch (Exception var6) {
			System.out.println("Lỗi truy vấn dữ liệu");
		}

	}
	
	public static void fillTableDoSearch(List<NguyenLieu> list) {
		DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		model.setRowCount(0);
		try {
//			List<NguyenLieu> list = KhoDAO.selectAll();
			Iterator var3 = list.iterator();

			while (var3.hasNext()) {
				NguyenLieu cd = (NguyenLieu) var3.next();
				Object[] row = new Object[] { cd.getMaNL(), cd.getTenNL(), cd.getDonvi(), cd.getDongia(),
						cd.getGiatrinhap(), cd.getSoluong(), cd.getHansudung() };
				model.addRow(row);
			}
		} catch (Exception var6) {
			System.out.println("Lỗi truy vấn dữ liệu");
		}

	}

	void delete() {
		if (MsgBox.confirm(this, "Bạn có muốn xóa hay không?") == false) {
		} else {
			String m = (String) this.table_1.getValueAt(roww, 0);
			try {
				this.dao.delete(m);
				fillTable();
				MsgBox.alert(this, "Xóa thành công!");
			} catch (Exception var3) {
				MsgBox.alert(this, "Xóa thất bại!");
			}
		}
	}

}