package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

//import com.toedter.calendar.JDateChooser;

import com.toedter.calendar.JDateChooser;
import dao.KhoDAO;
import entity.NguyenLieu;
import utils.MsgBox;

public class CapNhatKhoJFrame extends JFrame {

	public static JPanel contentPane;
	private DefaultTableModel model;

	public static JTextField txtTenNLMoi;
	public static JTextField txtDonViMoi;
	public static JTextField txtDonGiaMoi;
	public static JTextField txtSoLuongMoi;
	public static String manguyenlieu;
	public static JTextField txtGiaTriNhapMoi;
	public static JDateChooser dateChooser;
	public static String strDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CapNhatKhoJFrame frame = new CapNhatKhoJFrame();
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
		cd.setMaNL(manguyenlieu);
		cd.setTenNL(txtTenNLMoi.getText());
		cd.setDonvi(txtDonViMoi.getText());
		cd.setDongia(Integer.valueOf(txtDonGiaMoi.getText()));
		cd.setSoluong(Float.valueOf(txtSoLuongMoi.getText()));
		cd.setGiatrinhap(Integer.valueOf(txtGiaTriNhapMoi.getText()));
		cd.setHansudung(strDate);
		return cd;

	}

	boolean validate1() {
		if (MsgBox.actionForInvalidComponent(txtTenNLMoi, "", "Tên nguyên liệu") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtDonViMoi, "", "Đơn vị") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtDonGiaMoi, "", "Giá thành") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtSoLuongMoi, "", "Số lượng") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtGiaTriNhapMoi, "", "Giá trị nhập") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtDonGiaMoi, "negativenumbers", "Đơn giá") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtSoLuongMoi, "negativenumbers", "Số lượng") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtGiaTriNhapMoi, "negativenumbers", "Giá trị nhập") == false) {
			return false;
		}
//	        else if (strDate == null) {
//				JOptionPane.showMessageDialog(this, "Hạn sử dụng còn trống");
//				return false;
//			}
		return true;
	}

	public static void edit(String maNL, String tenNL, String donvi, String dongia, String soluong, String giatrinhap,
			Date hansudung) {
		manguyenlieu = maNL;
		txtTenNLMoi.setText(tenNL);
		txtDonViMoi.setText(donvi);
		txtDonGiaMoi.setText(dongia);
		txtSoLuongMoi.setText(soluong);
		txtGiaTriNhapMoi.setText(giatrinhap);
		dateChooser.setDate(hansudung);
		contentPane.revalidate();
	}

	void update() {
		KhoDAO dao = new KhoDAO();
		if (validate1() == true)
			try {
				NguyenLieu model = this.getForm();
				dao.update(model);
				MsgBox.alert(this, "Cập nhật thành công!");
			} catch (Exception var3) {
				MsgBox.alert(this, "Cập nhật thất bại!");
			}

	}

	/**
	 * Create the frame.
	 */
	public CapNhatKhoJFrame() {
		setBackground(new Color(255, 255, 255));
		setSize(485, 366);
		setLocationRelativeTo(contentPane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 516, 31);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cập nhật");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 0, 133, 31);
		panel.add(lblNewLabel);

		JLabel lblCapNhat = new JLabel("Đồng ý");
		lblCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (validate1() == true) {
					update();
					KhoJInternalFrame.fillTable();
					dispose();
				}
			}
		});
		lblCapNhat.setOpaque(true);
		lblCapNhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapNhat.setForeground(Color.WHITE);
		lblCapNhat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCapNhat.setBackground(new Color(0, 102, 204));
		lblCapNhat.setBounds(97, 326, 111, 25);
		contentPane.add(lblCapNhat);

		JLabel lblHyB = new JLabel("Hủy bỏ");
		lblHyB.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		lblHyB.setOpaque(true);
		lblHyB.setHorizontalAlignment(SwingConstants.CENTER);
		lblHyB.setForeground(Color.WHITE);
		lblHyB.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHyB.setBackground(new Color(0, 102, 204));
		lblHyB.setBounds(255, 326, 111, 25);

		contentPane.add(lblHyB);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin m\u1EDBi", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 18),
				new Color(0, 0, 0)));
		panel_1_1.setBounds(23, 41, 427, 275);
		contentPane.add(panel_1_1);

		JLabel lblNewLabel_1_4 = new JLabel("Tên nguyên liệu");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(10, 34, 110, 20);
		panel_1_1.add(lblNewLabel_1_4);

		txtTenNLMoi = new JTextField();
		txtTenNLMoi.setColumns(10);
		txtTenNLMoi.setBounds(149, 30, 258, 29);
		panel_1_1.add(txtTenNLMoi);

		JLabel lblNewLabel_1_1_1 = new JLabel("Đơn vị");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 72, 96, 20);
		panel_1_1.add(lblNewLabel_1_1_1);

		txtDonViMoi = new JTextField();
		txtDonViMoi.setColumns(10);
		txtDonViMoi.setBounds(149, 69, 258, 31);
		panel_1_1.add(txtDonViMoi);

		JLabel lblNewLabel_1_2_1 = new JLabel("Đơn giá");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(10, 112, 96, 20);
		panel_1_1.add(lblNewLabel_1_2_1);

		txtDonGiaMoi = new JTextField();
		txtDonGiaMoi.setColumns(10);
		txtDonGiaMoi.setBounds(149, 110, 258, 29);
		panel_1_1.add(txtDonGiaMoi);

		JLabel lblNewLabel_1_3_1 = new JLabel("Số lượng");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(10, 148, 96, 20);
		panel_1_1.add(lblNewLabel_1_3_1);

		txtSoLuongMoi = new JTextField();
		txtSoLuongMoi.setColumns(10);
		txtSoLuongMoi.setBounds(149, 149, 258, 29);
		panel_1_1.add(txtSoLuongMoi);

		txtGiaTriNhapMoi = new JTextField();
		txtGiaTriNhapMoi.setColumns(10);
		txtGiaTriNhapMoi.setBounds(149, 189, 258, 29);
		panel_1_1.add(txtGiaTriNhapMoi);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Giá trị nhập");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1_1.setBounds(10, 188, 96, 20);
		panel_1_1.add(lblNewLabel_1_3_1_1);

		JLabel lblNewLabel_1_3_1_2 = new JLabel("Hạn sử dụng");
		lblNewLabel_1_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1_2.setBounds(10, 228, 96, 20);
		panel_1_1.add(lblNewLabel_1_3_1_2);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(149, 228, 163, 29);
		panel_1_1.add(dateChooser);

		JLabel lblNewLabel_2 = new JLabel("(*)");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(119, 40, 20, 13);
		panel_1_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("(*)");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(57, 78, 20, 13);
		panel_1_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("(*)");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_2.setBounds(68, 118, 20, 13);
		panel_1_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("(*)");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_3.setBounds(68, 154, 20, 13);
		panel_1_1.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("(*)");
		lblNewLabel_2_4.setForeground(Color.RED);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_4.setBounds(87, 197, 20, 13);
		panel_1_1.add(lblNewLabel_2_4);

		JLabel lblNewLabel_2_5 = new JLabel("(*)");
		lblNewLabel_2_5.setForeground(Color.RED);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_5.setBounds(100, 234, 20, 13);
		panel_1_1.add(lblNewLabel_2_5);

	}
}