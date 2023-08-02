package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import dao.KhuyenMaiDAO;
import entity.KhuyenMai;
import utils.MsgBox;

public class CapNhatVoucherJFrame extends JFrame {

	public static JPanel contentPane;
	public static JTextField txtGiaTri;
	public static JTextField txtTenMa;
	public static JTextField txtSoLuong;
	public static JTextArea textAreaMoTa;
	public static String ma;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					CapNhatVoucherJFrame frame = new CapNhatVoucherJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void edit(String maKM, String tenKM, String mota, String giatri, String soluong) {
		ma = maKM;
		txtTenMa.setText(tenKM);
		textAreaMoTa.setText(mota);
		txtGiaTri.setText(giatri);
		txtSoLuong.setText(soluong);
		contentPane.revalidate();
	}

	KhuyenMai getForm() {
		KhuyenMai cd = new KhuyenMai();
		cd.setMaKM(ma);
		cd.setTenKM(this.txtTenMa.getText());
		cd.setMota(this.textAreaMoTa.getText());
		cd.setGiatri(Integer.valueOf(this.txtGiaTri.getText()));
		cd.setSoluong(Integer.valueOf(this.txtSoLuong.getText()));
		return cd;
	}

	boolean validate1() {
		if (MsgBox.actionForInvalidComponent(txtTenMa, "", "Tên mã") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtGiaTri, "", "Giá trị") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtSoLuong, "", "Số lượng") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtGiaTri, "negativenumbers", "Giá trị") == false) {
			return false;
		} else if (MsgBox.actionForInvalidComponent(txtSoLuong, "negativenumbers", "Số lượng") == false) {
			return false;
		}
		return true;
	}

	void update() {
		KhuyenMaiDAO dao = new KhuyenMaiDAO();
		try {
			KhuyenMai model = this.getForm();
			dao.update(model);
			MsgBox.alert(this, "Cập nhật thành công!");
		} catch (Exception var3) {
			MsgBox.alert(this, "Cập nhật thất bại!");
		}

	}

	/**
	 * Create the frame.
	 */
	public CapNhatVoucherJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 470);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 623, 47);
		contentPane.add(panel);

		JLabel lblCpNhtVoucher = new JLabel("Cập nhật Voucher");
		lblCpNhtVoucher.setForeground(Color.WHITE);
		lblCpNhtVoucher.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCpNhtVoucher.setBounds(10, 10, 175, 27);
		panel.add(lblCpNhtVoucher);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin voucher", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.PLAIN, 18), null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 57, 434, 133);
		contentPane.add(panel_1);

		txtGiaTri = new JTextField();
		txtGiaTri.setColumns(10);
		txtGiaTri.setBounds(110, 89, 290, 24);
		panel_1.add(txtGiaTri);

		JLabel lblNewLabel_1_1 = new JLabel("Tên mã");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 35, 90, 24);
		panel_1.add(lblNewLabel_1_1);

		txtTenMa = new JTextField();
		txtTenMa.setColumns(10);
		txtTenMa.setBounds(110, 38, 290, 24);
		panel_1.add(txtTenMa);

		JLabel lblNewLabel_2_1 = new JLabel("(*)");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(62, 43, 20, 13);
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("(*)");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_2.setBounds(80, 94, 20, 13);
		panel_1.add(lblNewLabel_2_2);

		JLabel lblNewLabel_1_2 = new JLabel("Giá trị (%)");
		lblNewLabel_1_2.setBounds(10, 86, 78, 24);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.PLAIN, 18), null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(8, 189, 436, 246);
		contentPane.add(panel_2);

		EtchedBorder lborder = new EtchedBorder();
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setLineWrap(true);
		textAreaMoTa.setBounds(110, 95, 293, 118);
		textAreaMoTa.setBorder(lborder);
		panel_2.add(textAreaMoTa);

		JLabel lblNewLabel_1_2_1 = new JLabel("Mô tả");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(10, 93, 90, 24);
		panel_2.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_2 = new JLabel("Số lượng");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(10, 34, 90, 24);
		panel_2.add(lblNewLabel_1_2_2);

		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(112, 37, 291, 24);
		panel_2.add(txtSoLuong);

		JLabel lblNewLabel_2_3 = new JLabel("(*)");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_3.setBounds(68, 42, 20, 13);
		panel_2.add(lblNewLabel_2_3);

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
		lblHyB.setBounds(333, 435, 111, 25);
		contentPane.add(lblHyB);

		JLabel lblCapNhat = new JLabel("Cập nhật");
		lblCapNhat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (validate1() == true) {
					update();
					KhuyenMaiJInternalFrame.fillTable();
					KhuyenMaiJInternalFrame.saveTable();
					dispose();
				}

			}
		});
		lblCapNhat.setOpaque(true);
		lblCapNhat.setHorizontalAlignment(SwingConstants.CENTER);
		lblCapNhat.setForeground(Color.WHITE);
		lblCapNhat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCapNhat.setBackground(new Color(0, 102, 204));
		lblCapNhat.setBounds(212, 435, 111, 25);
		contentPane.add(lblCapNhat);
	}
}