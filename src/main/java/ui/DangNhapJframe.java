package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.TaiKhoan;

public class DangNhapJframe extends JFrame {

	private JPanel contentPane;
	public JTextField txtTenDangNhap;
	public JTextField txtMatKhau;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					DangNhapJframe frame = new DangNhapJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DangNhapJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFoodsAppVn = new JLabel("FOODSAPP.VN");
		lblFoodsAppVn.setVerticalAlignment(SwingConstants.TOP);
		lblFoodsAppVn.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoodsAppVn.setForeground(Color.WHITE);
		lblFoodsAppVn.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblFoodsAppVn.setBounds(136, 62, 672, 61);
		contentPane.add(lblFoodsAppVn);

		JLabel lblTieuDe1 = new JLabel("PHẦN MỀM QUẢN LÝ NHÀ HÀNG");
		lblTieuDe1.setForeground(Color.WHITE);
		lblTieuDe1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTieuDe1.setBounds(274, 123, 401, 35);
		contentPane.add(lblTieuDe1);

		JSeparator separator = new JSeparator();
		separator.setBounds(333, 169, 280, 2);
		contentPane.add(separator);

		JLabel lblTieuDe2 = new JLabel("DÀNH CHO BÁN HÀNG");
		lblTieuDe2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDe2.setForeground(Color.WHITE);
		lblTieuDe2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTieuDe2.setBounds(333, 182, 280, 29);
		contentPane.add(lblTieuDe2);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(286, 245, 376, 148);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblKetNoiOffline = new JLabel("  kẾT NỐI OFFLINE");
		lblKetNoiOffline.setIcon(new ImageIcon(DangNhapJframe.class.getResource("/icon/computer-4-24.png")));
		lblKetNoiOffline.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKetNoiOffline.setForeground(Color.WHITE);
		lblKetNoiOffline.setHorizontalAlignment(SwingConstants.CENTER);
		lblKetNoiOffline.setOpaque(true);
		lblKetNoiOffline.setBackground(new Color(30, 144, 255));
		lblKetNoiOffline.setBounds(0, 0, 376, 44);
		panel.add(lblKetNoiOffline);

		JLabel iconTenDangNhap = new JLabel("");
		iconTenDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		iconTenDangNhap.setIcon(new ImageIcon(DangNhapJframe.class.getResource("/icon/contacts-24.png")));
		iconTenDangNhap.setBounds(10, 55, 46, 35);
		panel.add(iconTenDangNhap);

		txtTenDangNhap = new JTextField();
		txtTenDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kiemTra()) {
					DangNhap();
					return;
				}
			}
		});
		txtTenDangNhap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTenDangNhap.getText().equals("Tên đăng nhập")) {
					txtTenDangNhap.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTenDangNhap.getText().equals("")) {
					txtTenDangNhap.setText("Tên đăng nhập");
				}
			}
		});
		txtTenDangNhap.setForeground(Color.GRAY);
		txtTenDangNhap.setText("Tên đăng nhập");
		txtTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenDangNhap.setBorder(null);
		txtTenDangNhap.setBounds(55, 55, 321, 35);
		panel.add(txtTenDangNhap);
		txtTenDangNhap.setColumns(10);

		JLabel iconMatKhau = new JLabel("");
		iconMatKhau.setHorizontalAlignment(SwingConstants.CENTER);
		iconMatKhau.setIcon(new ImageIcon(DangNhapJframe.class.getResource("/icon/lock-24.png")));
		iconMatKhau.setBounds(10, 102, 46, 35);
		panel.add(iconMatKhau);

		txtMatKhau = new JTextField();
		txtMatKhau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (kiemTra()) {
					DangNhap();
					return;
					
				}
			}
		});
		txtMatKhau.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtMatKhau.getText().equals("Mật khẩu")) {
					txtMatKhau.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtMatKhau.getText().equals("")) {
					txtMatKhau.setText("Mật khẩu");
				}
			}
		});
		txtMatKhau.setForeground(Color.GRAY);
		txtMatKhau.setText("Mật khẩu");
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMatKhau.setBorder(null);
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(55, 105, 321, 35);
		panel.add(txtMatKhau);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOpaque(true);
		separator_1.setBackground(Color.LIGHT_GRAY);
		separator_1.setBounds(5, 95, 365, 1);
		panel.add(separator_1);

		JLabel btnDangNhap = new JLabel("ĐĂNG NHẬP");
		btnDangNhap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (kiemTra()) {
					DangNhap();
					return;
				}
			}
		});
		btnDangNhap.setForeground(new Color(30, 144, 255));
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangNhap.setBackground(Color.WHITE);
		btnDangNhap.setOpaque(true);
		btnDangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		btnDangNhap.setBounds(286, 411, 376, 35);
		contentPane.add(btnDangNhap);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int comfirm = JOptionPane.showConfirmDialog(null, "Đóng chương trình?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (comfirm == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(914, 0, 46, 40);
		contentPane.add(lblNewLabel);
	}

	public boolean kiemTra() {
		if (txtTenDangNhap.getText().trim().equals("") || txtTenDangNhap.getText().trim().equals("Tên đăng nhập")) {
			JOptionPane.showMessageDialog(this, "Tên đăng nhập không được bỏ trống !!");
			txtTenDangNhap.requestFocus();
			return false;
		}
		if (txtMatKhau.getText().trim().equals("") || txtMatKhau.getText().trim().equals("Mật khẩu")) {
			JOptionPane.showMessageDialog(this, "Mật khẩu không được bỏ trống !!");
			txtMatKhau.requestFocus();
			return false;
		}
		return true;
	}
	public boolean DangNhap() {
		TaiKhoan TK = TaiKhoanDAO.selectTKByTenDN(txtTenDangNhap.getText());
		if (TK == null || !txtTenDangNhap.getText().equals(TK.getTenTaiKhoan())) {
			JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại!");
			txtTenDangNhap.requestFocus();
			return false;
		} else {
			if (!txtMatKhau.getText().equals(TK.getMatKhau())) {
				JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác!");
				txtMatKhau.requestFocus();
				return false;
			} else {
				if (TK.getVaiTro().equalsIgnoreCase("Thu ngân")) {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						FoodsAppJframe frame = new FoodsAppJframe();
						frame.setVisible(true);
						frame.tenUser = NhanVienDAO.selectByMaNV(TK.getMaNV()).getTenNV();
						frame.setTenUser();
						dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					return true;
				}

				if (TK.getVaiTro().equalsIgnoreCase("Admin")) {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						AdminJFrame frame = new AdminJFrame();
						frame.setVisible(true);
						dispose();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					return true;
				}
			}

			return false;
		}
	}
}
