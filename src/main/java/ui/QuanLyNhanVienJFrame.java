package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.NhanVien;
import entity.TaiKhoan;

public class QuanLyNhanVienJFrame extends JFrame {

	public static JPanel contentPane;
	public static JTextField txtTenNhanVien;
	public static JTextField txtTenTaiKhoan;
	public static JTextField txtSDT;
	public static JLabel lblHinhAnh;
	public static JTextField txtMaNhanVien;
	public static JTextField txtLuongCoban;
	public static JComboBox cbxVaiTro;
	public static JPasswordField txtMatKhau;
	public static JPasswordField txtXacNhanMatKhau;
	public static JDateChooser txtNgayLamViec;
	public static JDateChooser txtNgaySinh;
	public static JTextArea txtDiaChi;
	public static JComboBox bxCaLamViec;
	public static JComboBox cbxCaLamViec;
	public static JLabel btnPerForm;
	public static String valuesHinhAnh = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					QuanLyNhanVienJFrame frame = new QuanLyNhanVienJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JTextArea txtMoTa;
	private JPanel panel_1;
	public static JLabel lblHeader;

	public QuanLyNhanVienJFrame() {
		init();

	}

	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(new Color(30, 144, 255));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 900, 41);
		contentPane.add(panel);
		panel.setLayout(null);

		lblHeader = new JLabel("Thêm mới nhân viên");
		lblHeader.setBackground(Color.BLACK);
		lblHeader.setForeground(new Color(30, 144, 255));
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setBounds(10, 0, 217, 41);
		panel.add(lblHeader);

		txtTenNhanVien = new JTextField();
		txtTenNhanVien.setForeground(Color.BLACK);
		txtTenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNhanVien.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00EAn nh\u00E2n vi\u00EAn ( * )", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), Color.black));
		txtTenNhanVien.setBounds(10, 63, 513, 55);
		contentPane.add(txtTenNhanVien);
		txtTenNhanVien.setColumns(10);

		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenTaiKhoan.setForeground(Color.BLACK);
		txtTenTaiKhoan.setColumns(10);
		txtTenTaiKhoan.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00EAn T\u00E0i Kho\u1EA3n ( * )", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		txtTenTaiKhoan.setBounds(544, 403, 346, 55);
		contentPane.add(txtTenTaiKhoan);

		cbxVaiTro = new JComboBox();
		cbxVaiTro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textCBX = String.valueOf(cbxVaiTro.getSelectedItem());
				if (textCBX.equals("Phục vụ") || textCBX.equals("Bảo vệ") || textCBX.equals("Tạp vụ")
						|| textCBX.equals("Đầu bếp")) {
					txtTenTaiKhoan.setEditable(false);
					txtMatKhau.setEditable(false);
					txtXacNhanMatKhau.setEditable(false);
					txtTenTaiKhoan.setText("");
					txtMatKhau.setText("");
					txtXacNhanMatKhau.setText("");

				} else {
					txtTenTaiKhoan.setEditable(true);
					txtMatKhau.setEditable(true);
					txtXacNhanMatKhau.setEditable(true);
				}

			}
		});

		cbxVaiTro.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbxVaiTro.setModel(
				new DefaultComboBoxModel(new String[] { "Thu ngân", "Phục vụ", "Tạp vụ", "Bảo vệ", "Đầu bếp" }));
		cbxVaiTro.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Vai tr\u00F2 ", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.BOLD, 13),
				new Color(0, 0, 0)));
		cbxVaiTro.setBounds(544, 65, 346, 50);
		contentPane.add(cbxVaiTro);

		txtSDT = new JTextField();
		txtSDT.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || txtSDT.getText().trim().length() > 9) {
					e.consume();
				}

			}
		});
		txtSDT.setForeground(Color.BLACK);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setColumns(10);
		txtSDT.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i ( * )", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		txtSDT.setBounds(10, 219, 513, 55);
		contentPane.add(txtSDT);

		txtDiaChi = new JTextArea();
		txtDiaChi.setForeground(Color.BLACK);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setBorder(new TitledBorder(null, "\u0110\u1ECBa ch\u1EC9", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), null));
		txtDiaChi.setBounds(10, 285, 513, 116);
		contentPane.add(txtDiaChi);

		txtMoTa = new JTextArea();
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMoTa.setBorder(new TitledBorder(null, "M\u00F4 t\u1EA3 ", TitledBorder.LEADING, TitledBorder.ABOVE_TOP,
				new Font("tahoma", Font.BOLD, 13), null));
		txtMoTa.setBounds(217, 445, 306, 220);
		contentPane.add(txtMoTa);

		JLabel lblThongTinKhac = new JLabel("Thông tin khác");
		lblThongTinKhac.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinKhac.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinKhac.setBounds(12, 412, 143, 41);
		contentPane.add(lblThongTinKhac);

		panel_1 = new JPanel();

		panel_1.setBounds(10, 463, 197, 200);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setToolTipText("Chọn hình ảnh");
		lblHinhAnh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					JFileChooser choose = new JFileChooser();
					String s1 = String.valueOf(QuanLyThucDonJFrame.class.getResource("/imageNV/"));
					String s2 = s1.replace("/", "\\\\");
					File file = new File(s2.replace("file:", ""));
					choose.setCurrentDirectory(file);
					int response = choose.showOpenDialog(null);
					if (response == choose.APPROVE_OPTION) {
						lblHinhAnh.setName(choose.getSelectedFile().getName());
						ImageIcon imageIcon = new ImageIcon(new ImageIcon(choose.getSelectedFile().getPath()).getImage()
								.getScaledInstance(panel_1.getWidth(), panel_1.getHeight(), Image.SCALE_DEFAULT));
						lblHinhAnh.setIcon(imageIcon);
						valuesHinhAnh = lblHinhAnh.getName();
					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});
		lblHinhAnh.setIcon(new ImageIcon(QuanLyNhanVienJFrame.class.getResource("/icon/uploadBlue-32 .png")));
		lblHinhAnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHinhAnh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHinhAnh.setBounds(0, 0, 197, 200);
		panel_1.add(lblHinhAnh);

		JLabel btnThoat = new JLabel("Thoát");
		btnThoat.setIcon(new ImageIcon(QuanLyNhanVienJFrame.class.getResource("/icon/account-logout-24.png")));
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn  thoát?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (comfirm == JOptionPane.YES_NO_OPTION) {
					dispose();
				}
			}
		});
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setBackground(Color.ORANGE);
		btnThoat.setHorizontalAlignment(SwingConstants.CENTER);
		btnThoat.setOpaque(true);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThoat.setBounds(645, 624, 112, 41);
		contentPane.add(btnThoat);

		btnPerForm = new JLabel("Lưu");
		btnPerForm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (validateForm()) {
					perForm();
					NhanVienJInternalFrame.fillToTable();
					dispose();
				}
			}
		});
		btnPerForm.setIcon(new ImageIcon(QuanLyNhanVienJFrame.class.getResource("/icon/saveWhite-24.png")));
		btnPerForm.setForeground(Color.WHITE);
		btnPerForm.setOpaque(true);
		btnPerForm.setHorizontalAlignment(SwingConstants.CENTER);
		btnPerForm.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPerForm.setBackground(new Color(30, 144, 255));
		btnPerForm.setBounds(776, 624, 101, 41);
		contentPane.add(btnPerForm);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setForeground(Color.BLACK);
		txtMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"M\u00E3 nh\u00E2n vi\u00EAn ( * )", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		txtMaNhanVien.setBounds(10, 143, 295, 55);
		contentPane.add(txtMaNhanVien);

		txtLuongCoban = new JTextField();
		txtLuongCoban.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || txtLuongCoban.getText().trim().length() > 9) {
					e.consume();
				}

			}
		});
		txtLuongCoban.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLuongCoban.setColumns(10);
		txtLuongCoban.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"L\u01B0\u01A1ng c\u01A1 b\u1EA3n( * )", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		txtLuongCoban.setBounds(544, 219, 346, 55);
		contentPane.add(txtLuongCoban);

		JLabel lblThongTinDangNhap = new JLabel("Thông tin đăng nhập hệ thống");
		lblThongTinDangNhap.setHorizontalAlignment(SwingConstants.LEFT);
		lblThongTinDangNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThongTinDangNhap.setBounds(544, 351, 346, 41);
		contentPane.add(lblThongTinDangNhap);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMatKhau.setBorder(new TitledBorder(null, "M\u1EADt kh\u1EA9u ( * )", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), null));
		txtMatKhau.setBounds(544, 483, 346, 55);
		contentPane.add(txtMatKhau);

		txtXacNhanMatKhau = new JPasswordField();
		txtXacNhanMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtXacNhanMatKhau.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"X\u00E1c nh\u1EADn m\u1EADt kh\u1EA9u ( * )", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		txtXacNhanMatKhau.setBounds(544, 558, 346, 55);
		contentPane.add(txtXacNhanMatKhau);

		cbxCaLamViec = new JComboBox();
		cbxCaLamViec.setModel(new DefaultComboBoxModel(
				new String[] { "Ca 1 ( 6:00 - 12:00) ", "Ca 2 ( 12:00 - 18:00) ", "Ca 3 ( 18:00 - 22:00)" }));
		cbxCaLamViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbxCaLamViec.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ca l\u00E0m vi\u1EC7c ", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Tahoma", Font.BOLD, 13),
				new Color(0, 0, 0)));
		cbxCaLamViec.setBounds(544, 144, 346, 50);
		contentPane.add(cbxCaLamViec);
		txtNgaySinh = new JDateChooser();
		JTextFieldDateEditor editorNgaySinh = (JTextFieldDateEditor) txtNgaySinh.getDateEditor();
		editorNgaySinh.setEditable(false);
		txtNgaySinh.setBackground(Color.WHITE);

		txtNgaySinh.setBorder(new TitledBorder(null, "Ng\u00E0y sinh", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), null));
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgaySinh.setDateFormatString("yyyy-MM-dd");
		txtNgaySinh.setBounds(324, 144, 199, 50);
		contentPane.add(txtNgaySinh);

		txtNgayLamViec = new JDateChooser();
		JTextFieldDateEditor editorNgayLamViec = (JTextFieldDateEditor) txtNgayLamViec.getDateEditor();
		editorNgayLamViec.setEditable(false);
		txtNgayLamViec.setBackground(Color.WHITE);
		txtNgayLamViec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgayLamViec.setDateFormatString("yyyy-MM-dd");
		txtNgayLamViec.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ng\u00E0y l\u00E0m vi\u1EC7c ", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Tahoma", Font.BOLD, 13), new Color(0, 0, 0)));
		txtNgayLamViec.setBounds(544, 290, 346, 50);
		contentPane.add(txtNgayLamViec);

	}

	public boolean validateForm() {
		if (txtTenNhanVien.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên!");
			txtTenNhanVien.requestFocus();
			return false;
		}
		if (txtMaNhanVien.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhân viên!");
			txtMaNhanVien.requestFocus();
			return false;
		}
		String d1 = ((JTextField) txtNgaySinh.getDateEditor().getUiComponent()).getText();
		if (d1.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh!");
			return false;
		}
		if (txtSDT.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại!");
			txtSDT.requestFocus();
			return false;
		}
		if (txtLuongCoban.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập lương cơ bản!");
			return false;
		}
		String d2 = ((JTextField) txtNgayLamViec.getDateEditor().getUiComponent()).getText();
		if (d2.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày làm việc!");
			return false;
		}
		if (valuesHinhAnh == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn hình ảnh!");
			return false;
		}
		String tesst = (String) cbxVaiTro.getSelectedItem();
		if (tesst.equals("Thu ngân") || tesst.equals("Admin")) {
			if (txtTenTaiKhoan.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên tài khoản!");
				txtTenTaiKhoan.requestFocus();
				return false;
			}
			String matKhau = String.valueOf(txtMatKhau.getPassword());
			if (matKhau.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mật khẩu!");
				txtMatKhau.requestFocus();
				return false;

			}
			String xacNhanMK = String.valueOf(txtXacNhanMatKhau.getPassword());

			if (xacNhanMK.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập xác nhận mật khẩu!");
				txtXacNhanMatKhau.requestFocus();
				return false;
			}
			if (!matKhau.equals(xacNhanMK)) {
				JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu không chính xác!");
				return false;
			}

		}

		return true;
	}

	public void addNhanVien() {
		NhanVien NV = new NhanVien();
		NV.setMaNV(txtMaNhanVien.getText());
		NV.setTenNV(txtTenNhanVien.getText());
		NV.setSDT(txtSDT.getText());
		String d1 = ((JTextField) txtNgaySinh.getDateEditor().getUiComponent()).getText();
		NV.setNgaySinh(d1);
		NV.setDiaChi(txtDiaChi.getText());
		String d2 = ((JTextField) txtNgayLamViec.getDateEditor().getUiComponent()).getText();
		NV.setNgayLamViec(d2);
		String selectcbxCaLamViec = String.valueOf(cbxCaLamViec.getSelectedItem());
		NV.setCalamviec(selectcbxCaLamViec);
		String selectcbxVaiTro = String.valueOf(cbxVaiTro.getSelectedItem());
		NV.setCongviec(selectcbxVaiTro);
		NV.setMucluong(Integer.parseInt(txtLuongCoban.getText()));
		NV.setHinhAnh(lblHinhAnh.getName());
		NV.setMoTa(txtMoTa.getText());
		if (NhanVienDAO.insertNhanVien(NV) == 1) {
			JOptionPane.showMessageDialog(null, "Nhân viên đã được thêm thành công !");
		} else {
			JOptionPane.showMessageDialog(null, "Thêm mới nhân viên thất bại !");
		}
	}

	public void addTaiKhoan() {
		TaiKhoan TK = new TaiKhoan();
		TK.setTenTaiKhoan(txtTenTaiKhoan.getText());
		String matKhau = String.valueOf(txtMatKhau.getPassword());
		TK.setMatKhau(matKhau);
		String selectcbxVaiTro = String.valueOf(cbxVaiTro.getSelectedItem());
		TK.setVaiTro(selectcbxVaiTro);
		TK.setMaNV(txtMaNhanVien.getText());
		if(TaiKhoanDAO.insertTaiKhoan(TK) == 0 ) {
			JOptionPane.showMessageDialog(null,"tên tài khoản đã tồn tại");
			return;
		}
		TaiKhoanDAO.insertTaiKhoan(TK);
		

	}

	public void edit(NhanVien NV, TaiKhoan TK) {
		txtMaNhanVien.setText(NV.getMaNV());
		txtTenNhanVien.setText(NV.getTenNV());
		txtSDT.setText(NV.getSDT());
		String date = NV.getNgaySinh();
		java.util.Date date1;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			txtNgaySinh.setDate(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String date2 = NV.getNgayLamViec();
		java.util.Date date3;
		try {
			date3 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
			txtNgayLamViec.setDate(date3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtDiaChi.setText(NV.getDiaChi());
		cbxCaLamViec.setSelectedItem(NV.getCalamviec());
		String vaiTro = String.valueOf(NV.getCongviec());
		cbxVaiTro.setSelectedItem(vaiTro);
		String mucLuong = String.valueOf(NV.getMucluong());
		txtLuongCoban.setText(mucLuong);
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(QuanLyNhanVienJFrame.class.getResource("/imageNV/" + NV.getHinhAnh())).getImage()
						.getScaledInstance(panel_1.getWidth(), panel_1.getHeight(), Image.SCALE_DEFAULT));
		lblHinhAnh.setIcon(imageIcon);
		valuesHinhAnh = NV.getHinhAnh();
		txtMoTa.setText(NV.getMoTa());
		if (TK == null) {
			txtTenTaiKhoan.setText("");
			txtMatKhau.setText("");
		} else {
			txtTenTaiKhoan.setText(TK.getTenTaiKhoan());
			txtMatKhau.setText(TK.getMatKhau());
		}
		txtTenTaiKhoan.setEditable(false);
		lblHeader.setText("Thông tin chi tiết");
		btnPerForm.setText("Cập nhật");
		btnPerForm.setIcon(new ImageIcon(QuanLyThucDonJFrame.class.getResource("/icon/editWhite-24.png")));
		txtMaNhanVien.setEditable(false);
		contentPane.revalidate();
	}

	public void updateTaiKhoan() {
		try {
			
			TaiKhoan TK = getFormTK();
			TaiKhoanDAO.updateByMaTenTK(TK);
			dispose();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	TaiKhoan getFormTK() {
		TaiKhoan TK = new TaiKhoan();
		TK.setTenTaiKhoan(txtTenTaiKhoan.getText());
		String matKhau = String.valueOf(txtMatKhau.getPassword());
		TK.setMatKhau(matKhau);
		String vaiTro = String.valueOf(cbxVaiTro.getSelectedItem());
		TK.setVaiTro(vaiTro);
		TK.setMaNV(txtMaNhanVien.getText());
		return TK;
	}

	public void updateNhanVien() {
		try {
			NhanVien NV = getForm();
			NhanVienDAO.updateByMaMaNV(NV);
			JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
			ThucDonJInternalFrame.loadToTable();
			dispose();
		} catch (Exception var3) {
			JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
		}
	}

	NhanVien getForm() {
		NhanVien NV = new NhanVien();
		NV.setMaNV(txtMaNhanVien.getText());
		NV.setTenNV(txtTenNhanVien.getText());
		NV.setSDT(txtSDT.getText());
		String d1 = ((JTextField) txtNgaySinh.getDateEditor().getUiComponent()).getText();
		NV.setNgaySinh(d1);
		NV.setDiaChi(txtDiaChi.getText());
		String d2 = ((JTextField) txtNgayLamViec.getDateEditor().getUiComponent()).getText();
		NV.setNgayLamViec(d2);
		String selectcbxCaLamViec = String.valueOf(cbxCaLamViec.getSelectedItem());
		NV.setCalamviec(selectcbxCaLamViec);
		String selectcbxVaiTro = String.valueOf(cbxVaiTro.getSelectedItem());
		NV.setCongviec(selectcbxVaiTro);
		NV.setMucluong(Integer.parseInt(txtLuongCoban.getText()));
		NV.setHinhAnh(valuesHinhAnh);
		NV.setMoTa(txtMoTa.getText());
		return NV;
	}

	public void perForm() {
		if (btnPerForm.getText().equals("Lưu")) {
			if (validateForm()) {
				addNhanVien();
				if (txtTenTaiKhoan.getText().trim().length() > 0 || txtMatKhau.getPassword().length > 0
						|| txtXacNhanMatKhau.getPassword().length > 0) {
					addTaiKhoan();
				}
				NhanVienJInternalFrame.fillToTable();
				
				dispose();
			}
		} else {
			if (validateForm()) {
				updateNhanVien();
				if (txtTenTaiKhoan.getText().trim().length() > 0 || txtMatKhau.getPassword().length > 0
						|| txtXacNhanMatKhau.getPassword().length > 0) {
					if (TaiKhoanDAO.selectTKByMaNV(txtMaNhanVien.getText()) == true) {
						updateTaiKhoan();
					} else {
						addTaiKhoan();
					}
				}
				NhanVienJInternalFrame.fillToTable();
				dispose();

			}
		}
	}

}