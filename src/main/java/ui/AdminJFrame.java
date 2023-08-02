package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AdminJFrame extends JFrame {

	private JPanel contentPane;
	private final JPanel functionList = new JPanel();
	public static JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AdminJFrame frame = new AdminJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminJFrame() {
		init();

	}

	/**
	 * Create the frame.
	 */
	public void init() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 810);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		;
		functionList.setBounds(0, 0, 210, 811);
		contentPane.add(functionList);
		functionList.setBackground(new Color(30, 144, 255));
		functionList.setLayout(null);

		desktopPane = new JDesktopPane();
		desktopPane.setBounds(210, 54, 1230, 756);
		contentPane.add(desktopPane);

		desktopPane.removeAll();
		ThucDonJInternalFrame thucdon = new ThucDonJInternalFrame();
		desktopPane.add(thucdon).setVisible(true);

		JPanel btnTongQuan = new JPanel();
		btnTongQuan.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				if (!(btnTongQuan.getBackground() == new Color(0, 0, 204))) {
					btnTongQuan.setBackground(new Color(0, 0, 205));
				}
				btnTongQuan.setBackground(new Color(0, 0, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				if (!(btnTongQuan.getBackground() == new Color(0, 0, 204))) {
					btnTongQuan.setBackground(new Color(30, 144, 255));
				}
			}
		});
		btnTongQuan.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnTongQuan.setBackground(new Color(30, 144, 255));
		btnTongQuan.setBounds(0, 55, 210, 45);
		functionList.add(btnTongQuan);
		btnTongQuan.setLayout(null);

		JLabel lblTongQuan = new JLabel("Tổng quan");
		lblTongQuan.setBounds(65, 0, 145, 45);
		btnTongQuan.add(lblTongQuan);
		lblTongQuan.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongQuan.setForeground(Color.WHITE);
		lblTongQuan.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 51, 45);
		btnTongQuan.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/globe-2-24.png")));

		JPanel btnThucDon = new JPanel();
		btnThucDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnThucDon.setBackground(new Color(0, 0, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnThucDon.setBackground(new Color(30, 144, 255));
			}
		});
		btnThucDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				desktopPane.removeAll();
				;
				ThucDonJInternalFrame td = new ThucDonJInternalFrame();
				desktopPane.add(td).setVisible(true);
			}
		});
		btnThucDon.setLayout(null);
		btnThucDon.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnThucDon.setBackground(new Color(30, 144, 255));
		btnThucDon.setBounds(0, 99, 210, 45);
		functionList.add(btnThucDon);

		JLabel lblThucDon = new JLabel("Thực đơn");
		lblThucDon.setHorizontalAlignment(SwingConstants.LEFT);
		lblThucDon.setForeground(Color.WHITE);
		lblThucDon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThucDon.setBounds(65, 0, 148, 45);
		btnThucDon.add(lblThucDon);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/purchase-order-24.png")));
		lblNewLabel_1.setBounds(11, 0, 41, 45);
		btnThucDon.add(lblNewLabel_1);

		JPanel btnKhuyenMai = new JPanel();
		btnKhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				desktopPane.removeAll();
				KhuyenMaiJInternalFrame km = new KhuyenMaiJInternalFrame();
				desktopPane.add(km).setVisible(true);
			}
		});
		btnKhuyenMai.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKhuyenMai.setBackground(new Color(0, 0, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKhuyenMai.setBackground(new Color(30, 144, 255));
			}
		});
		btnKhuyenMai.setLayout(null);
		btnKhuyenMai.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnKhuyenMai.setBackground(new Color(30, 144, 255));
		btnKhuyenMai.setBounds(0, 187, 210, 45);
		functionList.add(btnKhuyenMai);

		JLabel lblKLhuyenMai = new JLabel("Khuyến mãi");
		lblKLhuyenMai.setHorizontalAlignment(SwingConstants.LEFT);
		lblKLhuyenMai.setForeground(Color.WHITE);
		lblKLhuyenMai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKLhuyenMai.setBounds(65, 0, 133, 45);
		btnKhuyenMai.add(lblKLhuyenMai);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/giftWhite-24.png")));
		lblNewLabel_1_1.setBounds(11, 0, 41, 45);
		btnKhuyenMai.add(lblNewLabel_1_1);

		JPanel btnBaoCao = new JPanel();
		btnBaoCao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBaoCao.setBackground(new Color(0, 0, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBaoCao.setBackground(new Color(30, 144, 255));
			}
		});
		btnBaoCao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
//				desktopPane.removeAll();
//				BaoCaoThongKeJInternalFrame baocao = new BaoCaoThongKeJInternalFrame();
//				desktopPane.add(baocao).setVisible(true);;

			}
		});
		btnBaoCao.setLayout(null);
		btnBaoCao.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnBaoCao.setBackground(new Color(30, 144, 255));
		btnBaoCao.setBounds(0, 143, 210, 45);
		functionList.add(btnBaoCao);

		JLabel lblBaoCaoThongKe = new JLabel("Báo cáo thống kê");
		lblBaoCaoThongKe.setHorizontalAlignment(SwingConstants.LEFT);
		lblBaoCaoThongKe.setForeground(Color.WHITE);
		lblBaoCaoThongKe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBaoCaoThongKe.setBounds(65, 0, 145, 45);
		btnBaoCao.add(lblBaoCaoThongKe);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/pie-chart-24 (1).png")));
		lblNewLabel_2.setBounds(0, 0, 52, 45);
		btnBaoCao.add(lblNewLabel_2);

		JPanel btnKho = new JPanel();
		btnKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				desktopPane.removeAll();
				KhoJInternalFrame kho = new KhoJInternalFrame();
				desktopPane.add(kho).setVisible(true);
			}
		});
		btnKho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnKho.setBackground(new Color(0, 0, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnKho.setBackground(new Color(30, 144, 255));
			}
		});

		btnKho.setLayout(null);
		btnKho.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnKho.setBackground(new Color(30, 144, 255));
		btnKho.setBounds(0, 230, 210, 45);
		functionList.add(btnKho);

		JLabel lblKho = new JLabel("Kho");

		lblKho.setHorizontalAlignment(SwingConstants.LEFT);
		lblKho.setForeground(Color.WHITE);
		lblKho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKho.setBounds(65, 0, 95, 45);
		btnKho.add(lblKho);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/house-24.png")));
		lblNewLabel_3.setBounds(11, 0, 41, 45);
		btnKho.add(lblNewLabel_3);

		JPanel btnTroGiup = new JPanel();
		btnTroGiup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				TroGiupJInternalFrame trogiup = new TroGiupJInternalFrame();
				trogiup.setVisible(true);
			}
		});
		btnTroGiup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnTroGiup.setBackground(new Color(0, 0, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnTroGiup.setBackground(new Color(30, 144, 255));
			}
		});
		btnTroGiup.setLayout(null);
		btnTroGiup.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnTroGiup.setBackground(new Color(30, 144, 255));
		btnTroGiup.setBounds(0, 317, 210, 45);
		functionList.add(btnTroGiup);

		JLabel lblTongQuan_2_2 = new JLabel("Trợ giúp");
		
		lblTongQuan_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongQuan_2_2.setForeground(Color.WHITE);
		lblTongQuan_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongQuan_2_2.setBounds(65, 0, 95, 45);
		btnTroGiup.add(lblTongQuan_2_2);

		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/question-mark-8-24.png")));
		lblNewLabel_2_2.setBounds(11, 0, 41, 45);
		btnTroGiup.add(lblNewLabel_2_2);

		JPanel btnNhanVIen = new JPanel();
		btnNhanVIen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNhanVIen.setBackground(new Color(0, 0, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNhanVIen.setBackground(new Color(30, 144, 255));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				desktopPane.removeAll();
				NhanVienJInternalFrame nhanVien = new NhanVienJInternalFrame();
				desktopPane.add(nhanVien).setVisible(true);
			}
		});
		btnNhanVIen.setLayout(null);
		btnNhanVIen.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnNhanVIen.setBackground(new Color(30, 144, 255));
		btnNhanVIen.setBounds(0, 273, 210, 45);
		functionList.add(btnNhanVIen);

		JLabel lblTongQuan_1_3 = new JLabel("Nhân Viên");
		lblTongQuan_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongQuan_1_3.setForeground(Color.WHITE);
		lblTongQuan_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongQuan_1_3.setBounds(65, 0, 95, 45);
		btnNhanVIen.add(lblTongQuan_1_3);

		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/conference-24.png")));
		lblNewLabel_1_3.setBounds(11, 0, 41, 45);
		btnNhanVIen.add(lblNewLabel_1_3);

		JLabel lblNewLabel_6 = new JLabel("  FOODSAPP");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/menu-4-24.png")));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_6.setBounds(10, 0, 190, 44);
		functionList.add(lblNewLabel_6);

		JPanel btnDangXuat = new JPanel();
		btnDangXuat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int comfirm = JOptionPane.showConfirmDialog(null, "Thoát chương trình?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (comfirm == JOptionPane.YES_NO_OPTION) {
					
					dispose();
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						DangNhapJframe frame = new DangNhapJframe();
						frame.setVisible(true);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		
				@Override
				public void mouseEntered(MouseEvent e) {
					btnDangXuat.setBackground(new Color(0, 0, 205));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnDangXuat.setBackground(new Color(30, 144, 255));
				}
			
		});
		btnDangXuat.setLayout(null);
		btnDangXuat.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnDangXuat.setBackground(new Color(30, 144, 255));
		btnDangXuat.setBounds(-12, 766, 222, 45);
		functionList.add(btnDangXuat);
		JLabel lblDngXuat = new JLabel("   Đăng xuất");
		
		

		lblDngXuat.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/account-logout-24.png")));
		lblDngXuat.setBounds(28, 0, 150, 45);
		btnDangXuat.add(lblDngXuat);
		lblDngXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblDngXuat.setForeground(Color.WHITE);
		lblDngXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JPanel header = new JPanel();
		header.setBounds(210, 0, 1230, 55);
		contentPane.add(header);
		header.setBackground(new Color(30, 144, 255));
		header.setLayout(null);

		JLabel iconWeb = new JLabel("");
		iconWeb.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/globe-2-24.png")));
		iconWeb.setBounds(1039, 15, 31, 24);
		header.add(iconWeb);

		JComboBox cbxNgonNgu = new JComboBox();
		cbxNgonNgu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbxNgonNgu.setModel(new DefaultComboBoxModel(new String[] { "Vietnamese", "English" }));
		cbxNgonNgu.setBounds(870, 11, 140, 28);
		header.add(cbxNgonNgu);

		JLabel lblTenNguoiDung = new JLabel("  Võ Ngọc Tú");
		lblTenNguoiDung.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNguoiDung.setIcon(new ImageIcon(AdminJFrame.class.getResource("/icon/user-24.png")));
		lblTenNguoiDung.setForeground(Color.WHITE);
		lblTenNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenNguoiDung.setBounds(1080, 15, 140, 24);
		header.add(lblTenNguoiDung);

	}
}