package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.border.LineBorder;

public class SuDungVoucherJFrame extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					SuDungVoucherJFrame frame = new SuDungVoucherJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SuDungVoucherJFrame() {
		setBounds(100, 100, 518, 347);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 588, 47);
		contentPane.add(panel);

		JLabel lblSDngVoucher = new JLabel("Sử dụng Voucher");
		lblSDngVoucher.setForeground(Color.WHITE);
		lblSDngVoucher.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSDngVoucher.setBounds(10, 10, 175, 27);
		panel.add(lblSDngVoucher);

		JLabel lblLoaiThe = new JLabel("Loại thẻ");
		lblLoaiThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoaiThe.setBounds(22, 69, 61, 29);
		contentPane.add(lblLoaiThe);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(142, 68, 350, 35);
		contentPane.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("(*)");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(75, 79, 20, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSoLuong.setBounds(22, 128, 61, 29);
		contentPane.add(lblSoLuong);

		JLabel lblGiaTri = new JLabel("Giá trị");
		lblGiaTri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiaTri.setBounds(22, 184, 61, 29);
		contentPane.add(lblGiaTri);

		JLabel lblApDungCho = new JLabel("Áp dụng cho");
		lblApDungCho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApDungCho.setBounds(22, 246, 93, 29);
		contentPane.add(lblApDungCho);

		JLabel lblNewLabel_2_1 = new JLabel("(*)");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(108, 256, 20, 13);
		contentPane.add(lblNewLabel_2_1);

		JRadioButton rdbtnTatCa = new JRadioButton("Tất cả");
		rdbtnTatCa.setBackground(new Color(255, 255, 255));
		rdbtnTatCa.setBounds(137, 254, 61, 21);
		contentPane.add(rdbtnTatCa);

		JRadioButton rdbtMonAn = new JRadioButton("Món ăn");
		rdbtMonAn.setBackground(new Color(255, 255, 255));
		rdbtMonAn.setBounds(209, 252, 80, 21);
		contentPane.add(rdbtMonAn);

		JRadioButton rdbtNuocUong = new JRadioButton("Nước uống");
		rdbtNuocUong.setBackground(new Color(255, 255, 255));
		rdbtNuocUong.setBounds(291, 252, 84, 21);
		contentPane.add(rdbtNuocUong);

		JLabel txtGiaTri = new JLabel("290.000");
		txtGiaTri.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGiaTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaTri.setBounds(144, 181, 134, 35);
		contentPane.add(txtGiaTri);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnTatCa);
		bg.add(rdbtNuocUong);
		bg.add(rdbtMonAn);

		JSpinner spinner = new JSpinner();
		spinner.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 13));
		spinner.setBounds(144, 126, 134, 35);
		contentPane.add(spinner);

		JLabel lblDongY = new JLabel("Đồng ý");
		lblDongY.setOpaque(true);
		lblDongY.setHorizontalAlignment(SwingConstants.CENTER);
		lblDongY.setForeground(Color.WHITE);
		lblDongY.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDongY.setBackground(new Color(0, 102, 204));
		lblDongY.setBounds(144, 302, 111, 25);
		contentPane.add(lblDongY);

		JLabel lblHuyBo = new JLabel("Hủy bỏ");
		lblHuyBo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		lblHuyBo.setOpaque(true);
		lblHuyBo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHuyBo.setForeground(Color.WHITE);
		lblHuyBo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblHuyBo.setBackground(new Color(0, 102, 204));
		lblHuyBo.setBounds(265, 302, 111, 25);
		contentPane.add(lblHuyBo);
	}
}
