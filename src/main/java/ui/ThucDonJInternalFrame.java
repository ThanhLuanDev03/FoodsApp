package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.ThucDonDAO;
import entity.ThucDon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class ThucDonJInternalFrame extends JInternalFrame {

	private JPanel contentPane;
	public static JTextField txtTimKiem;
	public static JTable tableThucDon;
	public DefaultTableModel model;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					ThucDonJInternalFrame frame = new ThucDonJInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ThucDonJInternalFrame() {
		init();
		loadToTable();
	}

	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1230, 756);
		this.setResizable(false);
//	  this.setUndecorated(true);
//	  this.setLocationRelativeTo(null);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);

		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 1230, 764);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtTimKiem = new JTextField();
		txtTimKiem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
					search(txtTimKiem.getText());

			}
		});
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiem.setBounds(317, 113, 903, 41);
		panel_1.add(txtTimKiem);
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals("Nhập tên món để tìm kiếm...")) {
					txtTimKiem.setText("");
					txtTimKiem.setFont(new Font("tahoma", Font.PLAIN, 15));
					txtTimKiem.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().equals("")) {
					txtTimKiem.setText("Nhập tên món để tìm kiếm...");
					txtTimKiem.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtTimKiem.setForeground(Color.LIGHT_GRAY);
		txtTimKiem.setBackground(Color.WHITE);
		txtTimKiem.setText("Nhập tên món để tìm kiếm...");
		txtTimKiem.setColumns(10);

		tableThucDon = new JTable();
		tableThucDon.setDefaultEditor(Object.class, null);
		JTableHeader th = tableThucDon.getTableHeader();
		th.setFont(new Font("Tahoma", Font.BOLD, 15));
		String[] columnNames = new String[] { "Nhóm thực đơn", "Mã món", "Tên món", "Đơn vị tính", "Giá bán (VND)",
				"Hình ảnh" };
		Object[][] data = null;
		model = new DefaultTableModel(data, columnNames);
		tableThucDon.setModel(model);
		tableThucDon.setVerifyInputWhenFocusTarget(false);
		tableThucDon.setRowHeight(35);
		tableThucDon.setShowGrid(false);
		tableThucDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JScrollPane jScrollPaneThucDon = new JScrollPane(tableThucDon);
		jScrollPaneThucDon.setBounds(10, 166, 1210, 567);
		panel_1.add(jScrollPaneThucDon);
		int rows = tableThucDon.getRowCount();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 1230, 51);
		panel_1.add(panel);
		panel.setLayout(null);

		JLabel lblTitleThucDon = new JLabel("Thực Đơn");
		lblTitleThucDon.setBounds(10, 0, 142, 51);
		panel.add(lblTitleThucDon);
		lblTitleThucDon.setForeground(Color.BLACK);
		lblTitleThucDon.setFont(new Font("Tahoma", Font.PLAIN, 25));

		comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {

				if (comboBox.getSelectedIndex() == 0) {
					loadToTable();

				} else {
					String cbx = (String) comboBox.getSelectedItem();
					searchLoai(cbx);
				}

			}
		});

		comboBox.setBackground(new Color(175, 238, 238));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Tất cả", "Thức ăn", "Đồ uống", "Khác" }));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(123, 113, 195, 41);
		panel_1.add(comboBox);

		JLabel lblLcNhanh = new JLabel("Lọc nhanh");
		lblLcNhanh.setOpaque(true);
		lblLcNhanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblLcNhanh.setForeground(Color.WHITE);
		lblLcNhanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLcNhanh.setBackground(new Color(30, 144, 255));
		lblLcNhanh.setBounds(10, 113, 113, 41);
		panel_1.add(lblLcNhanh);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 62, 1210, 40);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		

		JLabel btnThemMoi = new JLabel("Thêm mới");
		btnThemMoi.setBackground(UIManager.getColor("Button.light"));
		btnThemMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThemMoi.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThemMoi.setBackground(new Color(240,240,240));
			}
		});
		btnThemMoi.setBounds(0, 0, 118, 40);
		panel_2.add(btnThemMoi);
		btnThemMoi.setForeground(new Color(0, 0, 0));
		btnThemMoi.setIcon(new ImageIcon(ThucDonJInternalFrame.class.getResource("/icon/icons8_add_20px.png")));
		btnThemMoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				QuanLyThucDonJFrame themTD = new QuanLyThucDonJFrame();
				themTD.setVisible(true);
			}
		});
		btnThemMoi.setHorizontalAlignment(SwingConstants.CENTER);
		btnThemMoi.setOpaque(true);
		btnThemMoi.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblChnhSaMn = new JLabel("Chi tiết món");
		lblChnhSaMn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblChnhSaMn.setBackground(Color.LIGHT_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblChnhSaMn.setBackground(new Color(240,240,240));
			}
		});
		lblChnhSaMn.setBounds(117, 0, 141, 40);
		panel_2.add(lblChnhSaMn);
		lblChnhSaMn.setIcon(new ImageIcon(ThucDonJInternalFrame.class.getResource("/icon/search-13-16.png")));
		lblChnhSaMn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tableThucDon.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn món để xem chi tiết!");
				} else {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						QuanLyThucDonJFrame frame = new QuanLyThucDonJFrame();
						frame.setVisible(true);
						String maTD = String.valueOf(tableThucDon.getValueAt(tableThucDon.getSelectedRow(), 1));
						frame.edit(ThucDonDAO.selectByMaTD(maTD));
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}
		});
		lblChnhSaMn.setOpaque(true);
		lblChnhSaMn.setHorizontalAlignment(SwingConstants.CENTER);
		lblChnhSaMn.setForeground(Color.BLACK);
		lblChnhSaMn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblChnhSaMn.setBackground(UIManager.getColor("Button.light"));

		JLabel btnXoa = new JLabel("Xóa món đã chọn");
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
		btnXoa.setBounds(258, 0, 156, 41);
		panel_2.add(btnXoa);
		btnXoa.setIcon(new ImageIcon(ThucDonJInternalFrame.class.getResource("/icon/icons8_delete_20px_1.png")));
		btnXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (tableThucDon.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn món cần xóa!");
				} else {
					int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (comfirm == JOptionPane.YES_NO_OPTION) {
						try {
							detele();
						} catch (Exception ex) {
							throw new RuntimeException(ex);
						}
					}

				}
			}
		});
		btnXoa.setOpaque(true);
		btnXoa.setHorizontalAlignment(SwingConstants.CENTER);
		btnXoa.setForeground(Color.BLACK);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXoa.setBackground(UIManager.getColor("Button.light"));

	}

	public boolean ValidateForm() {
		if (txtTimKiem.getText().equals("") || txtTimKiem.getText().equals("Nhập tên để tìm kiếm...")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập nội dung tìm kiếm!");
			txtTimKiem.requestFocus();
			return false;
		}

		return true;
	}

	public static void loadToTable() {
		DefaultTableModel model = (DefaultTableModel) tableThucDon.getModel();
		model.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		for (ThucDon td : ThucDonDAO.getAllThucDon()) {
			Object rowData[] = new Object[6];
			rowData[0] = td.getLoai();
			rowData[1] = td.getMaTD();
			rowData[2] = td.getTenTD();
			rowData[3] = td.getDonViTinh();
			rowData[4] = df.format(td.getGia());
			rowData[5] = td.getHinhanh();
			model.addRow(rowData);

		}

	}

	public static void search(String tenTD ) {
		DefaultTableModel model = (DefaultTableModel) tableThucDon.getModel();
		model.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		for (ThucDon td : ThucDonDAO.selectAllTen(tenTD )) {
			Object rowData[] = new Object[6];
			rowData[0] = td.getLoai();
			rowData[1] = td.getMaTD();
			rowData[2] = td.getTenTD();
			rowData[3] = td.getDonViTinh();
			rowData[4] = df.format(td.getGia());
			rowData[5] = td.getHinhanh();
			model.addRow(rowData);

		}

	}

	public static void searchLoai(String loai) {
		DefaultTableModel model = (DefaultTableModel) tableThucDon.getModel();
		model.setRowCount(0);
		NumberFormat df = new DecimalFormat("#,###");
		for (ThucDon td : ThucDonDAO.selectAllByLoai(loai)) {
			Object rowData[] = new Object[6];
			rowData[0] = td.getLoai();
			rowData[1] = td.getMaTD();
			rowData[2] = td.getTenTD();
			rowData[3] = td.getDonViTinh();
			rowData[4] = df.format(td.getGia());
			rowData[5] = td.getHinhanh();
			model.addRow(rowData);

		}

	}

	public void detele() throws Exception{
		String m = (String) tableThucDon.getValueAt(tableThucDon.getSelectedRow(), 1);
		try {
			ThucDonDAO.deleteByMaTD(m);
			loadToTable();
			JOptionPane.showMessageDialog(this, "Xóa thành công!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Xóa thất bại!");
		}
	}
}