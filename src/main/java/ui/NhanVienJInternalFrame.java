package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;

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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.NhanVien;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class NhanVienJInternalFrame extends JInternalFrame {

	private JPanel contentPane;
	public static JTable table;
	private JTextField txtTimKiem;
	private DefaultTableModel model;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienJInternalFrame frame = new NhanVienJInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NhanVienJInternalFrame() {
		init();
		fillToTable();
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1230, 756);
//		this.setUndecorated(true);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(245, 245, 245));
		panelHeader.setBounds(0, 0, 1230, 51);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);

		JLabel lblTitleThucDon = new JLabel("Nhân Viên");
		lblTitleThucDon.setBounds(10, 0, 142, 51);
		panelHeader.add(lblTitleThucDon);
		lblTitleThucDon.setForeground(Color.BLACK);
		lblTitleThucDon.setFont(new Font("Tahoma", Font.PLAIN, 25));

		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		JTableHeader th = table.getTableHeader();
		table.setRowHeight(35);
		table.setShowGrid(false);
		table.setFont(new Font("tahoma", Font.PLAIN, 15));
		th.setFont(new Font("Tahoma", Font.BOLD, 15));
		String[] columsName = { "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Ngày sinh", "Ngày làm việc",
				"Ca làm việc", "Vai trò", "Lương cơ bản)" };
		Object[][] data = null;
		model = new DefaultTableModel(data, columsName);
		table.setModel(model);
		JScrollPane jScrollPane = new JScrollPane(table);
		jScrollPane.setBounds(10, 164, 1210, 554);
		contentPane.add(jScrollPane);

		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchByName(txtTimKiem.getText());
			}
		});
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
		txtTimKiem.setBounds(327, 112, 893, 41);
		contentPane.add(txtTimKiem);
		txtTimKiem.setColumns(10);

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedItem().equals("Tất cả")) {
					System.out.println(comboBox.getSelectedItem());
					fillToTable();
				} else {
					String cbx =(String) comboBox.getSelectedItem();
					System.out.println(cbx);
					searchByVaiTro(cbx);
				}

			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Tất cả", "Admin", "Phục vụ", "Thu ngân", "Đầu bếp", "Tạp vụ" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(134, 112, 194, 41);
		contentPane.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("Lọc nhanh");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(new Color(30, 144, 255));
		lblNewLabel_2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 112, 125, 41);
		contentPane.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBounds(10, 62, 1210, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel btnThemNV = new JLabel("Thêm nhân viên");
		btnThemNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThemNV.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThemNV.setBackground(new Color(240,240,240));
			}
		});
		btnThemNV.setBounds(0, 0, 157, 40);
		panel.add(btnThemNV);
		btnThemNV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QuanLyNhanVienJFrame themNV = new QuanLyNhanVienJFrame();
				themNV.setVisible(true);
			}
		});
		btnThemNV.setForeground(Color.BLACK);
		btnThemNV.setBackground(UIManager.getColor("Button.light"));
		btnThemNV.setOpaque(true);
		btnThemNV.setIcon(new ImageIcon(NhanVienJInternalFrame.class.getResource("/icon/icons8_add_20px.png")));
		btnThemNV.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemNV.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel btnChiTiet = new JLabel("  Chi tiết");
		btnChiTiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnChiTiet.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnChiTiet.setBackground(new Color(240,240,240));
			}
		});
		btnChiTiet.setBounds(157, 0, 125, 41);
		panel.add(btnChiTiet);
		btnChiTiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "vui lòng chọn nhân viên!");
				} else {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						QuanLyNhanVienJFrame frame = new QuanLyNhanVienJFrame();
						frame.txtMaNhanVien.setEditable(false);
						frame.setVisible(true);
						String maNV = String.valueOf(table.getValueAt(table.getSelectedRow(), 0));
						frame.edit(NhanVienDAO.selectByMaNV(maNV), TaiKhoanDAO.selectByMaNV(maNV));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		btnChiTiet.setIcon(new ImageIcon(NhanVienJInternalFrame.class.getResource("/icon/search-13-16.png")));
		btnChiTiet.setOpaque(true);
		btnChiTiet.setHorizontalAlignment(SwingConstants.CENTER);
		btnChiTiet.setForeground(Color.BLACK);
		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnChiTiet.setBackground(UIManager.getColor("Button.light"));

		JLabel btnXoa = new JLabel("Xóa nhân viên");
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnXoa.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnXoa.setBackground(new Color(240,240,240));
			}
		});
		btnXoa.setBounds(281, 0, 151, 41);
		panel.add(btnXoa);
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (table.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn món cần xóa!");
				} else {
					int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (comfirm == JOptionPane.YES_NO_OPTION) {
						detele();
					}

				}
			}
		});
		btnXoa.setIcon(new ImageIcon(NhanVienJInternalFrame.class.getResource("/icon/icons8_delete_20px_1.png")));
		btnXoa.setOpaque(true);
		btnXoa.setHorizontalAlignment(SwingConstants.CENTER);
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBackground(UIManager.getColor("Button.light"));

	}

	public static void fillToTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		for (NhanVien nv : NhanVienDAO.getAllNhanVien()) {
			Object rowData[] = new Object[8];
			rowData[0] = nv.getMaNV();
			rowData[1] = nv.getTenNV();
			rowData[2] = nv.getSDT();
			rowData[3] = nv.getNgaySinh();
			rowData[4] = nv.getNgayLamViec();
			rowData[5] = nv.getCalamviec();
			rowData[6] = nv.getCongviec();
			rowData[7] = df.format(nv.getMucluong());
			model.addRow(rowData);
		}
	}

	public static void searchByName(String tenNV) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		for (NhanVien nv : NhanVienDAO.selectAllTen(tenNV)) {
			Object rowData[] = new Object[8];
			rowData[0] = nv.getMaNV();
			rowData[1] = nv.getTenNV();
			rowData[2] = nv.getSDT();
			rowData[3] = nv.getNgaySinh();
			rowData[4] = nv.getNgayLamViec();
			rowData[5] = nv.getCalamviec();
			rowData[6] = nv.getCongviec();
			rowData[7] = df.format(nv.getMucluong());
			model.addRow(rowData);
		}
	}

	public static void searchByVaiTro(String vaiTro) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		for (NhanVien nv : NhanVienDAO.selectAllByVaiTro(vaiTro)) {
			Object rowData[] = new Object[8];
			rowData[0] = nv.getMaNV();
			rowData[1] = nv.getTenNV();
			rowData[2] = nv.getSDT();
			rowData[3] = nv.getNgaySinh();
			rowData[4] = nv.getNgayLamViec();
			rowData[5] = nv.getCalamviec();
			rowData[6] = nv.getCongviec();
			rowData[7] = df.format(nv.getMucluong());
			model.addRow(rowData);
		}
	}

	public void detele() {
		String maNV = (String) table.getValueAt(table.getSelectedRow(), 0);
		try {
			NhanVienDAO.deleteByMaNV(maNV);
			fillToTable();
			JOptionPane.showMessageDialog(this, "Xóa thành công!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Xóa thất bại!");
		}
	}
}