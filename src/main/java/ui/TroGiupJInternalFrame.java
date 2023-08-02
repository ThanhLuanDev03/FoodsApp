package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class TroGiupJInternalFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TroGiupJInternalFrame frame = new TroGiupJInternalFrame();
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
	public TroGiupJInternalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1017, 616);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Các kênh tư vấn và hỗ trợ khách hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(0, 30, 1001, 62);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("   Tra cứu tài liệu hướng dẫn sử dụng Online");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
		});
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/books-24.png")));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(34, 142, 408, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("   Khóa học phần mềm Online");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
		});
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/online-course.png")));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(34, 187, 338, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("   Cộng đồng hổ trợ miễn phí qua Facebook");
		lblNewLabel_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
		});
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/facebook-4-24.png")));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(34, 232, 420, 34);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("   Diễn đàn hổ trợ TLT");
		lblNewLabel_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1_3.setFont(new Font("Tahoma", Font.ITALIC, 18));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
		});
		lblNewLabel_1_3.setForeground(Color.BLACK);
		lblNewLabel_1_3.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/assistant-24.png")));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(34, 281, 338, 34);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("   Tổng đài tư vấn hổ trợ : 0794529281");
		lblNewLabel_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1_4.setFont(new Font("Tahoma", Font.ITALIC, 18));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			}
		});
		lblNewLabel_1_4.setForeground(Color.BLACK);
		lblNewLabel_1_4.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/phone-46-24.png")));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(34, 332, 393, 34);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/foodapp.jpg")));
		lblNewLabel_2.setBounds(689, 122, 214, 144);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PHẦN MỀM QUẢN LÝ NHÀ HÀNG");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(616, 292, 363, 34);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(657, 280, 280, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Câu hỏi thường gặp");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_1.setForeground(Color.BLACK);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_4_1.setBounds(0, 377, 1001, 34);
		contentPane.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Cài đặt và thiết lập ");
		lblNewLabel_1_4_2.setForeground(Color.BLACK);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_2.setBounds(10, 532, 167, 34);
		contentPane.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Nhân viên order");
		lblNewLabel_1_4_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_2_1.setBounds(227, 532, 167, 34);
		contentPane.add(lblNewLabel_1_4_2_1);
		
		JLabel lblNewLabel_1_4_2_1_1 = new JLabel("Nhân viên thu ngân");
		lblNewLabel_1_4_2_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_2_1_1.setBounds(426, 532, 167, 34);
		contentPane.add(lblNewLabel_1_4_2_1_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1 = new JLabel("Dành cho bếp ");
		lblNewLabel_1_4_2_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_4_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_2_1_1_1.setBounds(660, 532, 126, 34);
		contentPane.add(lblNewLabel_1_4_2_1_1_1);
		
		JLabel lblNewLabel_1_4_2_1_1_2 = new JLabel("Dành cho chủ/quản lý");
		lblNewLabel_1_4_2_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_2_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_4_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_4_2_1_1_2.setBounds(813, 532, 188, 34);
		contentPane.add(lblNewLabel_1_4_2_1_1_2);
		
		JLabel lblNewLabel_1_4_2_2 = new JLabel("X");
		lblNewLabel_1_4_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel_1_4_2_2.setOpaque(true);
		lblNewLabel_1_4_2_2.setBackground(Color.WHITE);
		lblNewLabel_1_4_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_4_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4_2_2.setBounds(977, 1, 39, 34);
		contentPane.add(lblNewLabel_1_4_2_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/services-64.png")));
		lblNewLabel_4.setBounds(52, 447, 64, 74);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/cook-64.png")));
		lblNewLabel_4_1.setBounds(689, 447, 64, 74);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/guest-64.png")));
		lblNewLabel_4_1_1.setBounds(259, 447, 64, 74);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("");
		lblNewLabel_4_1_2.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/businesswoman-64.png")));
		lblNewLabel_4_1_2.setBounds(469, 447, 64, 74);
		contentPane.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("");
		lblNewLabel_4_1_3.setIcon(new ImageIcon(TroGiupJInternalFrame.class.getResource("/icon/manager-64.png")));
		lblNewLabel_4_1_3.setBounds(882, 447, 64, 74);
		contentPane.add(lblNewLabel_4_1_3);
	}
}
