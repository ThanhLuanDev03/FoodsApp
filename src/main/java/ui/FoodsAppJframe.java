package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class FoodsAppJframe extends JFrame {

	private JPanel contentPane;
	public static JLabel lblThanhToan;
	public static JLabel lblGoiMon;
	public static JLabel lblUser;
	private JLabel lblContact;
	private JLabel lblGlobal;
	private JLabel lblDangXuat;
	private JLabel lblOrder;
	public static JLabel txtTenUser;
	public static String tenUser;
	public static JDesktopPane PanelGoiMon;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					FoodsAppJframe frame = new FoodsAppJframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FoodsAppJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 810);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel Header = new JPanel();
		Header.setBackground(new Color(0, 102, 204));
		Header.setBounds(0, 0, 1440, 45);
		contentPane.add(Header);
		Header.setLayout(null);

		JLabel lblHome = new JLabel("");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/house-24.png")));
		lblHome.setBounds(0, 10, 46, 34);
		Header.add(lblHome);

		lblGoiMon = new JLabel("Gọi món");
		lblGoiMon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblGoiMon.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/purchase-order-24 blue.png")));
				lblGoiMon.setBackground(Color.WHITE);
				lblGoiMon.setForeground(new Color(0, 102, 204));
				lblThanhToan.setBackground(new Color(0, 102, 204));
				lblThanhToan.setForeground(Color.WHITE);
				try {
					PanelGoiMon.removeAll();
					GoiMonJInternalFrame dialog = new GoiMonJInternalFrame();
					PanelGoiMon.add(dialog).setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblGoiMon.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoiMon.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/purchase-order-24 blue.png")));
		lblGoiMon.setOpaque(true);
		lblGoiMon.setBackground(Color.WHITE);
		lblGoiMon.setForeground(new Color(0, 102, 204));
		lblGoiMon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGoiMon.setBounds(56, 11, 110, 34);
		Header.add(lblGoiMon);

		lblThanhToan = new JLabel("Thanh toán");
		lblThanhToan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				lblGoiMon.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/purchase-order-24.png")));
				lblThanhToan.setBackground(Color.WHITE);
				lblThanhToan.setForeground(new Color(0, 102, 204));
				lblGoiMon.setBackground(new Color(0, 102, 204));
				lblGoiMon.setForeground(Color.WHITE);
				// Gọi chờ thanh toán
				try {
					PanelGoiMon.removeAll();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ChoThanhToanJInternalFrame dialog = new ChoThanhToanJInternalFrame();
					PanelGoiMon.add(dialog).setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		lblThanhToan.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanhToan.setOpaque(true);
		lblThanhToan.setBackground(new Color(0, 102, 204));
		lblThanhToan.setForeground(Color.WHITE);
		lblThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThanhToan.setBounds(166, 11, 120, 34);
		Header.add(lblThanhToan);

		lblUser = new JLabel("");
		lblUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int comfirm = JOptionPane.showConfirmDialog(null, "Đăng xuất ?", "Xác nhận",
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
		});
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/user-24.png")));
		lblUser.setBounds(1214, -1, 46, 45);
		Header.add(lblUser);

		lblContact = new JLabel("");
		lblContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				TroGiupJInternalFrame trogiup = new TroGiupJInternalFrame();
				trogiup.setVisible(true);
			}
		});
		lblContact.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/phone-30-24.png")));
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setBounds(1270, -1, 46, 45);
		Header.add(lblContact);

		lblGlobal = new JLabel("");
		lblGlobal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(null,"Chức năng đang cập nhật!");
			}
		});
		
		lblGlobal.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/globe-2-24.png")));
		lblGlobal.setHorizontalAlignment(SwingConstants.CENTER);
		lblGlobal.setBounds(1326, -1, 46, 45);
		Header.add(lblGlobal);

		lblDangXuat = new JLabel("");
		lblDangXuat.addMouseListener(new MouseAdapter() {
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
		});
		lblDangXuat.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/menu-4-24.png")));
		lblDangXuat.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangXuat.setBounds(1384, -1, 46, 45);
		Header.add(lblDangXuat);

		txtTenUser = new JLabel("");
		txtTenUser.setForeground(Color.WHITE);
		txtTenUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenUser.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTenUser.setBounds(1014, 0, 190, 44);
		Header.add(txtTenUser);

//		lblOrder = new JLabel("   ORDER");
//		lblOrder.setForeground(Color.WHITE);
//		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lblOrder.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/plus-2-24.png")));
//		lblOrder.setHorizontalAlignment(SwingConstants.LEFT);
//		lblOrder.setBounds(1137, 0, 100, 45);
//		Header.add(lblOrder);

		PanelGoiMon = new JDesktopPane();
		PanelGoiMon.setBounds(0, 46, 1440, 765);
		contentPane.add(PanelGoiMon);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			PanelGoiMon.removeAll();
			GoiMonJInternalFrame dialog = new GoiMonJInternalFrame();
			PanelGoiMon.add(dialog).setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadGoiMon() {
		try {
			PanelGoiMon.removeAll();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			GoiMonJInternalFrame dialog = new GoiMonJInternalFrame();
			PanelGoiMon.add(dialog).setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void loadThanhToan() {
		try {
			PanelGoiMon.removeAll();
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			ChoThanhToanJInternalFrame dialog = new ChoThanhToanJInternalFrame();
			PanelGoiMon.add(dialog).setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doChinhSua() {
		PanelGoiMon.removeAll();
		GoiMonJInternalFrame dialog = new GoiMonJInternalFrame();
		PanelGoiMon.add(dialog).setVisible(true);
		lblGoiMon.setIcon(new ImageIcon(FoodsAppJframe.class.getResource("/icon/edit-11-24 blue.png")));
		lblGoiMon.setBackground(Color.WHITE);
		lblGoiMon.setForeground(new Color(0, 102, 204));
		lblThanhToan.setBackground(new Color(0, 102, 204));
		lblThanhToan.setForeground(Color.WHITE);
	}

	public static void setTenUser() {
		txtTenUser.setText(tenUser);
	}
}
