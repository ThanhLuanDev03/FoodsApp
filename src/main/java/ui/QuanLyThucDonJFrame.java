package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import dao.ThucDonDAO;
import entity.ThucDon;

public class QuanLyThucDonJFrame extends JFrame {
	dao.ThucDonDAO thucDonDAO = new ThucDonDAO();
	public static JLabel lblTitle;
	public static JTextArea txtNCC;
	public static JTextArea txtMoTa;
	public static JPanel contentPane;
	public static JTextField txtTenMon;
	public static JTextField txtMaMon;
	public static JTextField txtGiaBan;
	public static JComboBox cbxDonViTinh;
	public static JPanel panel_1;
	public static JLabel lblHinhAnh;
	public static JComboBox cbxLoaiMon;
	public static JLabel lblnVTnh;
	public static JLabel btnThemMon;
	public static String valuesAnh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					QuanLyThucDonJFrame frame = new QuanLyThucDonJFrame();
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
	public QuanLyThucDonJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 900, 530);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 900, 41);
		contentPane.add(panel);
		panel.setLayout(null);

		lblTitle = new JLabel("Thêm món mới");
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitle.setBounds(10, 11, 163, 19);
		panel.add(lblTitle);

		txtTenMon = new JTextField();
		txtTenMon.setForeground(Color.BLACK);
		txtTenMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenMon.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00EAn m\u00F3n ( * )", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13),
				new Color(0, 0, 0)));
		txtTenMon.setBounds(10, 66, 563, 55);
		contentPane.add(txtTenMon);
		txtTenMon.setColumns(10);

		txtMaMon = new JTextField();
		txtMaMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaMon.setForeground(Color.BLACK);
		txtMaMon.setColumns(10);
		txtMaMon.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"M\u00E3 m\u00F3n ( * )", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13),
				new Color(0, 0, 0)));
		txtMaMon.setBounds(10, 132, 563, 55);
		contentPane.add(txtMaMon);

		cbxLoaiMon = new JComboBox();
		cbxLoaiMon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbxLoaiMon.setBackground(Color.WHITE);
		cbxLoaiMon.setModel(new DefaultComboBoxModel(new String[] { "Thức ăn", "Đồ uống", "Khác" }));
		cbxLoaiMon.setBounds(10, 234, 272, 49);
		contentPane.add(cbxLoaiMon);

		txtMoTa = new JTextArea();
		JScrollPane jScrollPane = new JScrollPane(txtMoTa);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMoTa.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"M\u00F4 t\u1EA3", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13),
				new Color(0, 0, 0)));
		jScrollPane.setBounds(298, 312, 592, 141);
		contentPane.add(jScrollPane);

		txtGiaBan = new JTextField();
		txtGiaBan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		txtGiaBan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaBan.setColumns(10);
		txtGiaBan.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Gi\u00E1 B\u00E1n ( * )", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 13),
				new Color(0, 0, 0)));
		txtGiaBan.setBounds(10, 312, 272, 55);
		contentPane.add(txtGiaBan);

		cbxDonViTinh = new JComboBox();
		cbxDonViTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbxDonViTinh.setModel(new DefaultComboBoxModel(
				new String[] { "Dĩa ", "Tô", "Lon", "Chai", "Thùng", "Cái", "Bộ", "Phần", "Lạng ", "Kg" }));
		cbxDonViTinh.setBounds(301, 234, 272, 49);
		contentPane.add(cbxDonViTinh);

		panel_1 = new JPanel();
		panel_1.setBounds(626, 72, 215, 211);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		// images
		lblHinhAnh = new JLabel("");
		lblHinhAnh.setIcon(new ImageIcon(QuanLyThucDonJFrame.class.getResource("/icon/uploadBlue-32 .png")));
		lblHinhAnh.setOpaque(true);
		lblHinhAnh.setBackground(new Color(224, 255, 255));
		lblHinhAnh.setToolTipText("Chọn hình ảnh");
		lblHinhAnh.setBounds(0, 0, 215, 211);
		panel_1.add(lblHinhAnh);
		lblHinhAnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHinhAnh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					JFileChooser choose = new JFileChooser();
					String s1 = String.valueOf(QuanLyThucDonJFrame.class.getResource("/image/"));
					String s2 = s1.replace("/", "\\\\");
					File file = new File(s2.replace("file:", ""));
					choose.setCurrentDirectory(file);
					int response = choose.showOpenDialog(null);
					if (response == choose.APPROVE_OPTION) {
						lblHinhAnh.setName(choose.getSelectedFile().getName());
						ImageIcon imageIcon = new ImageIcon(new ImageIcon(choose.getSelectedFile().getPath()).getImage()
								.getScaledInstance(panel_1.getWidth(), panel_1.getHeight(), Image.SCALE_DEFAULT));
						lblHinhAnh.setIcon(imageIcon);
						valuesAnh = lblHinhAnh.getName();
					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
			}
		});

		lblHinhAnh.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel = new JLabel("Loại");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 210, 63, 19);
		contentPane.add(lblNewLabel);

		lblnVTnh = new JLabel("Đơn vị tính");
		lblnVTnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblnVTnh.setBounds(301, 210, 81, 19);
		contentPane.add(lblnVTnh);
		// btn exit
		JLabel btnThoat = new JLabel("Thoát");
		btnThoat.setBounds(612, 478, 124, 41);
		contentPane.add(btnThoat);
		btnThoat.setIcon(new ImageIcon(QuanLyThucDonJFrame.class.getResource("/icon/account-logout-24.png")));
		btnThoat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn thoát?", "Xác nhận",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (comfirm == JOptionPane.YES_NO_OPTION) {
					dispose();
				}
			}
		});
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThoat.setBackground(Color.ORANGE);
		btnThoat.setHorizontalAlignment(SwingConstants.CENTER);
		btnThoat.setOpaque(true);
		// btn add
		btnThemMon = new JLabel("Lưu món");
		btnThemMon.setBounds(756, 478, 134, 41);
		contentPane.add(btnThemMon);
		btnThemMon.setIcon(new ImageIcon(QuanLyThucDonJFrame.class.getResource("/icon/saveWhite-24.png")));
		btnThemMon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				perForm();
			}
		});

		btnThemMon.setForeground(Color.WHITE);
		btnThemMon.setOpaque(true);
		btnThemMon.setHorizontalAlignment(SwingConstants.CENTER);
		btnThemMon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnThemMon.setBackground(new Color(30, 144, 255));

		txtNCC = new JTextArea();
		JScrollPane croll = new JScrollPane(txtNCC);
		croll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		croll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		txtNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNCC.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Nh\u00E0 cung c\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, new Font("tahoma", Font.BOLD, 13),
				new Color(0, 0, 0)));
		croll.setBounds(10, 378, 272, 75);
		contentPane.add(croll);
	}

	public boolean validateForm() {
		if (txtTenMon.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập tên món!");
			txtTenMon.requestFocus();
			return false;

		}
		if (txtMaMon.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã món!");
			txtMaMon.requestFocus();
			return false;
		}

		if (txtGiaBan.getText().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập giá bán!");
			txtGiaBan.requestFocus();

			return false;
		}

		if (valuesAnh == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn hình ảnh!");
			return false;
		}

		return true;
	}

	public void addThucDon() {
		ThucDon TD = new ThucDon();
		TD.setMaTD(txtMaMon.getText());
		TD.setTenTD(txtTenMon.getText());
		String s = String.valueOf(cbxLoaiMon.getSelectedItem());
		TD.setLoai(s);
		String s2 = String.valueOf(cbxDonViTinh.getSelectedItem());
		TD.setDonViTinh(s2);
		String giaBanText = txtGiaBan.getText();
		int giaBan = 0;
		if (giaBanText != null && !giaBanText.isEmpty()) {
			giaBan = Integer.parseInt(giaBanText);
			TD.setGia(giaBan);
		}

		TD.setHinhanh(lblHinhAnh.getName());
		TD.setNCC(txtNCC.getText());
		TD.setMoTa(txtMoTa.getText());
		if (thucDonDAO.add(TD) > 0) {
			JOptionPane.showMessageDialog(null, "Món đã được thêm thành công!");
		} else {
			JOptionPane.showMessageDialog(null, "Thực hiện thêm món thất bại!");
		}
	}

	public static void edit(ThucDon TD) {
		txtMaMon.setText(TD.getMaTD());
		txtTenMon.setText(TD.getTenTD());
		String gia = String.valueOf(TD.getGia());
		txtGiaBan.setText(gia);
		cbxDonViTinh.setSelectedItem(TD.getDonViTinh());
		cbxLoaiMon.setSelectedItem(TD.getLoai());
		txtMoTa.setText(TD.getMoTa());
		txtNCC.setText(TD.getNCC());
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon(QuanLyThucDonJFrame.class.getResource("/image/" + TD.getHinhanh())).getImage()
						.getScaledInstance(panel_1.getWidth(), panel_1.getHeight(), Image.SCALE_DEFAULT));
		lblHinhAnh.setIcon(imageIcon);
		valuesAnh = TD.getHinhanh();
		lblTitle.setText("Chi tiết món ăn");
		btnThemMon.setText("Cập nhật");
		btnThemMon.setIcon(new ImageIcon(QuanLyThucDonJFrame.class.getResource("/icon/editWhite-24.png")));
		txtMaMon.setEditable(false);
		contentPane.revalidate();
	}

	public void update() {
		try {
			ThucDon TD = getForm();
			thucDonDAO.updateThucDonByMaTD(TD);
			JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
			ThucDonJInternalFrame.loadToTable();
			dispose();
		} catch (Exception var3) {
			JOptionPane.showMessageDialog(this, "Cập nhật thất bại!");
		}
	}

	ThucDon getForm() {
		ThucDon TD = new ThucDon();
		TD.setMaTD(txtMaMon.getText());
		TD.setTenTD(txtTenMon.getText());
		TD.setGia(Integer.parseInt(txtGiaBan.getText()));
		String textLoaiMon = String.valueOf(cbxLoaiMon.getSelectedItem());
		TD.setLoai(textLoaiMon);
		String textDonViTinh = String.valueOf(cbxDonViTinh.getSelectedItem());
		TD.setDonViTinh(textDonViTinh);
		TD.setHinhanh(valuesAnh);
		TD.setNCC(txtNCC.getText());
		TD.setMoTa(txtMoTa.getText());
		return TD;
	}

	public void perForm() {
		if (btnThemMon.getText().equals("Lưu món")) {
			if (validateForm()) {
				addThucDon();
				ThucDonJInternalFrame.loadToTable();
				dispose();
			}
		} else {
			if (validateForm()) {
				update();
				ThucDonJInternalFrame.loadToTable();
				dispose();

			}
		}
	}

}