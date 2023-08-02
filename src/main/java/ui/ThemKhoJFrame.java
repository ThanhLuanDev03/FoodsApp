package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.toedter.calendar.JDateChooser;

import dao.KhoDAO;
import entity.NguyenLieu;
import utils.MsgBox;

public class ThemKhoJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenNL;
	private JTextField txtDonVi;
	private JTextField txtDonGia;
	private JTextField txtSoLuong;
	private DefaultTableModel model;
	private JDateChooser dateChooser;
	private String strDate;

	KhoDAO dao = new KhoDAO();

	private JTextField txtGiaTriNhap;
	private JTable table;
	private JTextField txtMaNL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ThemKhoJFrame frame = new ThemKhoJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	NguyenLieu getForm() {

		Date date = dateChooser.getDate();
		SimpleDateFormat formatter = new SimpleDateFormat();
		strDate = formatter.format(date);
		formatter = new SimpleDateFormat("yyyy-M-dd");
		strDate = formatter.format(date);

		NguyenLieu cd = new NguyenLieu();
		cd.setMaNL(this.txtMaNL.getText());
		cd.setTenNL(this.txtTenNL.getText());
		cd.setDonvi(this.txtDonVi.getText());
		cd.setDongia(Integer.valueOf(this.txtDonGia.getText()));
		cd.setSoluong(Float.valueOf(this.txtSoLuong.getText()));
		cd.setGiatrinhap(Integer.valueOf(this.txtGiaTriNhap.getText()));
		cd.setHansudung(strDate);
		return cd;
	}

	public boolean validate1() {
		if (MsgBox.actionForInvalidComponent(txtMaNL, "", "Mã nguyên liệu") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtTenNL, "", "Tên nguyên liệu") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtDonVi, "", "Đơn vị") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtDonGia, "", "Giá thành") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtSoLuong, "", "Số lượng") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtGiaTriNhap, "", "Giá trị nhập") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(dateChooser, "", "Ngày tháng") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtDonGia, "negativenumbers", "Đơn giá") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtSoLuong, "negativenumbers", "Số lượng") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtGiaTriNhap, "negativenumbers", "Giá trị nhập") == false) {
			return false;
		}
		return true;
	}

	void filltotable() {
		Date date = dateChooser.getDate();
		SimpleDateFormat formatter = new SimpleDateFormat();
		strDate = formatter.format(date);
		formatter = new SimpleDateFormat("yyyy-M-dd");
		strDate = formatter.format(date);
		model.addRow(new Object[] { txtMaNL.getText(), txtTenNL.getText(), txtDonVi.getText(), txtDonGia.getText(),
				txtSoLuong.getText(), txtGiaTriNhap.getText(), strDate });
	}

	void insert() {
		
			NguyenLieu model = this.getForm();
			if(this.dao.insert(model)==1) {
				MsgBox.alert(this, "Thêm mới thành công!");
				return;
			}
			MsgBox.alert(this, "Mã nguyên liệu đã tồn tại!");

	}

	/**
	 * Create the frame.
	 */
	public ThemKhoJFrame() {
		this.setLocationRelativeTo(null);
		setBackground(new Color(240, 255, 240));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 724, 435);
		setLocationRelativeTo(contentPane);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin chung", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 41, 427, 206);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Tên nguyên liệu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 61, 110, 20);
		panel_1.add(lblNewLabel_1);

		txtTenNL = new JTextField();
		txtTenNL.setFont(new Font("Tahoma", Font.PLAIN, 11));

		txtTenNL.setBounds(151, 60, 237, 27);
		panel_1.add(txtTenNL);
		txtTenNL.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Đơn vị");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(20, 104, 96, 20);
		panel_1.add(lblNewLabel_1_1);

		txtDonVi = new JTextField();
		txtDonVi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDonVi.setColumns(10);
		txtDonVi.setBounds(151, 97, 237, 27);
		panel_1.add(txtDonVi);

		JLabel lblNewLabel_1_2 = new JLabel("Đơn giá");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(20, 139, 96, 20);
		panel_1.add(lblNewLabel_1_2);

		txtDonGia = new JTextField();
		txtDonGia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(151, 133, 237, 26);
		panel_1.add(txtDonGia);

		JLabel lblNewLabel_1_3 = new JLabel("Số lượng");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(20, 176, 96, 20);
		panel_1.add(lblNewLabel_1_3);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(151, 169, 237, 27);
		panel_1.add(txtSoLuong);

		JLabel lblNewLabel_1_5 = new JLabel("Mã nguyên liệu");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_5.setBounds(20, 24, 110, 20);
		panel_1.add(lblNewLabel_1_5);

		txtMaNL = new JTextField();
		txtMaNL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtMaNL.setColumns(10);
		txtMaNL.setBounds(151, 23, 237, 27);
		panel_1.add(txtMaNL);

		JLabel lblNewLabel_2 = new JLabel("(*)");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(129, 29, 20, 13);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("(*)");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(129, 66, 20, 13);
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("(*)");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_2.setBounds(85, 104, 20, 13);
		panel_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("(*)");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_3.setBounds(85, 139, 20, 13);
		panel_1.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("(*)");
		lblNewLabel_2_4.setForeground(Color.RED);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_4.setBounds(96, 176, 20, 13);
		panel_1.add(lblNewLabel_2_4);

		JLabel lblThmVoKho = new JLabel("Thêm vào kho");
		lblThmVoKho.setOpaque(true);
		lblThmVoKho.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmVoKho.setForeground(Color.WHITE);
		lblThmVoKho.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThmVoKho.setBackground(new Color(0, 102, 204));
		lblThmVoKho.setBounds(10, 400, 144, 25);
		lblThmVoKho.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				if (validate1() == true) {
					filltotable();
					insert();
					KhoJInternalFrame.fillTable();
					dispose();

				} else {
					setVisible(true);
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		contentPane.add(lblThmVoKho);

		JLabel lblHyB = new JLabel("Hủy bỏ");
		lblHyB.setOpaque(true);
		lblHyB.setHorizontalAlignment(SwingConstants.CENTER);
		lblHyB.setForeground(Color.WHITE);
		lblHyB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHyB.setBackground(new Color(0, 102, 204));
		lblHyB.setBounds(164, 400, 97, 25);
		lblHyB.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				exit();

			}
		});
		contentPane.add(lblHyB);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ch\u1EE9ng t\u1EEB", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(447, 69, 253, 180);
		contentPane.add(panel_1_1);

		JLabel lblNewLabel_1_4 = new JLabel("Giá trị nhập");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_4.setBounds(10, 32, 110, 20);
		panel_1_1.add(lblNewLabel_1_4);

		txtGiaTriNhap = new JTextField();
		txtGiaTriNhap.setColumns(10);
		txtGiaTriNhap.setBounds(110, 31, 133, 27);
		panel_1_1.add(txtGiaTriNhap);

		JLabel lblNewLabel_1_1_1 = new JLabel("Hạn sử dụng");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 89, 96, 20);
		panel_1_1.add(lblNewLabel_1_1_1);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-M-dd");
		dateChooser.setBounds(110, 90, 133, 19);

		panel_1_1.add(dateChooser);

		JLabel lblNewLabel_2_5 = new JLabel("(*)");
		lblNewLabel_2_5.setForeground(Color.RED);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_5.setBounds(83, 38, 20, 13);
		panel_1_1.add(lblNewLabel_2_5);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(10, 257, 690, 133);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Chi tiết", null, panel, null);
		panel.setLayout(null);

		table = new JTable();
		String[] columnNames = new String[] { "Mã nguyên liệu", "Tên nguyên liệu", "Đơn vị", "Đơn giá", "Giá trị nhập",
				"Số lượng", "Hạn sử dụng" };
		Object[][] data = null;
		model = new DefaultTableModel(data, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JTableHeader th = table.getTableHeader();
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 10, 685, 108);
		panel.add(scrollPane);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 102, 204));
		panel_2.setBounds(0, 0, 714, 31);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Phiếu nhập kho");
		lblNewLabel.setBounds(10, 0, 188, 31);
		panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
//		scrollPane.setColumnHeaderView(table);

	}

	void exit() {
		this.dispose();
//		this.setVisible(false);
	}
}