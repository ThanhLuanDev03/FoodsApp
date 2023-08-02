package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import dao.HoaDonDao;

public class ThanhToanJframe extends JFrame {

	private JPanel contentPane;
	private JTextField textInput;
	private JLabel txtTienMat;
	private JLabel txtTienThu;
	private JLabel txtTienTra;
	public String maHoaDon;
	public int tongtien;
	public String giaoDien;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ThanhToanJframe frame = new ThanhToanJframe("0");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ThanhToanJframe(String soTienThu) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 675, 575);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setResizable(true);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.GRAY));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 675, 40);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblThuTien = new JLabel("Thu tiền");
		lblThuTien.setForeground(Color.WHITE);
		lblThuTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThuTien.setBounds(10, 11, 69, 18);
		panel.add(lblThuTien);

		JLabel lblExiy = new JLabel("X");
		lblExiy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		lblExiy.setForeground(Color.WHITE);
		lblExiy.setHorizontalAlignment(SwingConstants.CENTER);
		lblExiy.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExiy.setBounds(648, 10, 27, 20);
		panel.add(lblExiy);

		JLabel lblHuongDan = new JLabel("Nhập số tiền khách đưa - Hình thức thanh toán");
		lblHuongDan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHuongDan.setBounds(10, 41, 335, 40);
		contentPane.add(lblHuongDan);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(346, 41, 328, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTienThu = new JLabel("Số tiền còn phải thu");
		lblTienThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienThu.setBounds(10, 0, 137, 40);
		panel_1.add(lblTienThu);

		txtTienThu = new JLabel("0.000");
		txtTienThu.setText(soTienThu);
		txtTienThu.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTienThu.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTienThu.setBounds(149, 0, 170, 40);
		panel_1.add(txtTienThu);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(1, 81, 346, 445);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textInput = new JTextField();
		textInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c) || textInput.getText().trim().length() > 8) {
					e.consume();
					return;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (textInput.getText().trim().equals("")) {
					txtTienMat.setText("0");
					txtTienTra.setText("0");
					return;
				}

				NumberFormat df = new DecimalFormat("#,###");
				Long soTien = Long.parseLong(textInput.getText());
				String str = df.format(soTien);
				txtTienMat.setText(str);
				int tienTra = Integer.parseInt(txtTienMat.getText().replace(",", ""))
						- Integer.parseInt(soTienThu.replace(",", ""));
				if (tienTra > 0) {
					NumberFormat df1 = new DecimalFormat("#,###");
					String str1 = df1.format(tienTra);
					txtTienTra.setText(str1);
				} else {
					txtTienTra.setText("Còn thiếu");
				}
			}
		});
		textInput.setBackground(new Color(230, 230, 250));
		textInput.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textInput.setHorizontalAlignment(SwingConstants.RIGHT);
		textInput.setBounds(10, 11, 326, 40);
		panel_2.add(textInput);
		textInput.setColumns(10);

		JLabel lblMenhGia = new JLabel("Nhập số tiền theo mệnh giá");
		lblMenhGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia.setBounds(10, 62, 326, 32);
		panel_2.add(lblMenhGia);

		JLabel lblMenhGia1 = new JLabel("500.000");
		lblMenhGia1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("500000");
				txtTienMat.setText("500,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia1.setOpaque(true);
		lblMenhGia1.setBackground(UIManager.getColor("CheckBox.light"));
		lblMenhGia1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia1.setBounds(10, 105, 103, 54);
		panel_2.add(lblMenhGia1);

		JLabel lblMenhGia2 = new JLabel("200.000");
		lblMenhGia2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("200000");
				txtTienMat.setText("200,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia2.setOpaque(true);
		lblMenhGia2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia2.setBackground(SystemColor.controlHighlight);
		lblMenhGia2.setBounds(123, 105, 99, 54);
		panel_2.add(lblMenhGia2);

		JLabel lblMenhGia3 = new JLabel("100.000");
		lblMenhGia3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("100000");
				txtTienMat.setText("100,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia3.setOpaque(true);
		lblMenhGia3.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia3.setBackground(SystemColor.controlHighlight);
		lblMenhGia3.setBounds(232, 105, 104, 54);
		panel_2.add(lblMenhGia3);

		JLabel lblMenhGia4 = new JLabel("50.000");
		lblMenhGia4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("50000");
				txtTienMat.setText("50,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia4.setOpaque(true);
		lblMenhGia4.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia4.setBackground(SystemColor.controlHighlight);
		lblMenhGia4.setBounds(10, 170, 103, 54);
		panel_2.add(lblMenhGia4);

		JLabel lblMenhGia5 = new JLabel("20.000");
		lblMenhGia5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("20000");
				txtTienMat.setText("20,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia5.setOpaque(true);
		lblMenhGia5.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia5.setBackground(SystemColor.controlHighlight);
		lblMenhGia5.setBounds(123, 170, 99, 54);
		panel_2.add(lblMenhGia5);

		JLabel lblMenhGia6 = new JLabel("10.000");
		lblMenhGia6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("10000");
				txtTienMat.setText("10,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia6.setOpaque(true);
		lblMenhGia6.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia6.setBackground(SystemColor.controlHighlight);
		lblMenhGia6.setBounds(232, 170, 104, 54);
		panel_2.add(lblMenhGia6);

		JLabel lblMenhGia7 = new JLabel("5.000");
		lblMenhGia7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("5000");
				txtTienMat.setText("5,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia7.setOpaque(true);
		lblMenhGia7.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia7.setBackground(SystemColor.controlHighlight);
		lblMenhGia7.setBounds(10, 233, 103, 54);
		panel_2.add(lblMenhGia7);

		JLabel lblMenhGia8 = new JLabel("2.000");
		lblMenhGia8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("2000");
				txtTienMat.setText("2,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia8.setOpaque(true);
		lblMenhGia8.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia8.setBackground(SystemColor.controlHighlight);
		lblMenhGia8.setBounds(123, 235, 99, 54);
		panel_2.add(lblMenhGia8);

		JLabel lblMenhGia9 = new JLabel("1.000");
		lblMenhGia9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText("1000");
				txtTienMat.setText("1,000");
				doTienTra(soTienThu);
			}
		});
		lblMenhGia9.setOpaque(true);
		lblMenhGia9.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenhGia9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMenhGia9.setBackground(SystemColor.controlHighlight);
		lblMenhGia9.setBounds(232, 233, 104, 54);
		panel_2.add(lblMenhGia9);

		JLabel lblGoiY = new JLabel("Gợi ý tiền mặt");
		lblGoiY.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGoiY.setBounds(10, 327, 99, 19);
		panel_2.add(lblGoiY);

		NumberFormat df = new DecimalFormat("#,###");
		JLabel lblTienMat1 = new JLabel(String.valueOf(Integer.parseInt(soTienThu.replace(",", "")) + 1000));
		lblTienMat1.setText(df.format(Integer.valueOf(lblTienMat1.getText())));
		lblTienMat1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText(lblTienMat1.getText().replace(",", ""));
				txtTienMat.setText(lblTienMat1.getText());
				doTienTra(soTienThu);
			}
		});
		lblTienMat1.setBackground(new Color(60, 179, 113));
		lblTienMat1.setOpaque(true);
		lblTienMat1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienMat1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienMat1.setBounds(14, 357, 99, 32);
		panel_2.add(lblTienMat1);

		JLabel lblTienMat2 = new JLabel(String.valueOf(Integer.parseInt(soTienThu.replace(",", "")) + 2000));
		lblTienMat2.setText(df.format(Integer.valueOf(lblTienMat2.getText())));
		lblTienMat2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText(lblTienMat2.getText().replace(",", ""));
				txtTienMat.setText(lblTienMat2.getText());
				doTienTra(soTienThu);
			}
		});
		lblTienMat2.setOpaque(true);
		lblTienMat2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienMat2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienMat2.setBackground(new Color(60, 179, 113));
		lblTienMat2.setBounds(123, 357, 99, 32);
		panel_2.add(lblTienMat2);

		JLabel lblTienMat3 = new JLabel(String.valueOf(Integer.parseInt(soTienThu.replace(",", "")) + 5000));
		lblTienMat3.setText(df.format(Integer.valueOf(lblTienMat3.getText())));
		lblTienMat3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText(lblTienMat3.getText().replace(",", ""));
				txtTienMat.setText(lblTienMat3.getText());
				doTienTra(soTienThu);
			}
		});
		lblTienMat3.setOpaque(true);
		lblTienMat3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienMat3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienMat3.setBackground(new Color(60, 179, 113));
		lblTienMat3.setBounds(232, 357, 99, 32);
		panel_2.add(lblTienMat3);

		JLabel lblTienMat4 = new JLabel(String.valueOf(Integer.parseInt(soTienThu.replace(",", "")) + 10000));
		lblTienMat4.setText(df.format(Integer.valueOf(lblTienMat4.getText())));
		lblTienMat4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText(lblTienMat4.getText().replace(",", ""));
				txtTienMat.setText(lblTienMat4.getText());
				doTienTra(soTienThu);
			}
		});
		lblTienMat4.setOpaque(true);
		lblTienMat4.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienMat4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienMat4.setBackground(new Color(60, 179, 113));
		lblTienMat4.setBounds(14, 400, 99, 32);
		panel_2.add(lblTienMat4);

		JLabel lblTienMat5 = new JLabel(String.valueOf(Integer.parseInt(soTienThu.replace(",", "")) + 20000));
		lblTienMat5.setText(df.format(Integer.valueOf(lblTienMat5.getText())));
		lblTienMat5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText(lblTienMat5.getText().replace(",", ""));
				txtTienMat.setText(lblTienMat5.getText());
				doTienTra(soTienThu);
			}
		});
		lblTienMat5.setOpaque(true);
		lblTienMat5.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienMat5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienMat5.setBackground(new Color(60, 179, 113));
		lblTienMat5.setBounds(123, 400, 99, 32);
		panel_2.add(lblTienMat5);

		JLabel lblTienMat6 = new JLabel(String.valueOf(Integer.parseInt(soTienThu.replace(",", "")) + 50000));
		lblTienMat6.setText(df.format(Integer.valueOf(lblTienMat6.getText())));
		lblTienMat6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textInput.setText(lblTienMat6.getText().replace(",", ""));
				txtTienMat.setText(lblTienMat6.getText());
				doTienTra(soTienThu);
			}
		});
		lblTienMat6.setOpaque(true);
		lblTienMat6.setHorizontalAlignment(SwingConstants.CENTER);
		lblTienMat6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienMat6.setBackground(new Color(60, 179, 113));
		lblTienMat6.setBounds(232, 400, 99, 32);
		panel_2.add(lblTienMat6);

		JLabel lblHinhThucTT = new JLabel("Hình thức thanh toán");
		lblHinhThucTT.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHinhThucTT.setBounds(356, 92, 177, 14);
		contentPane.add(lblHinhThucTT);

		JLabel lblSoTien = new JLabel("Số tiền");
		lblSoTien.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSoTien.setBounds(575, 92, 52, 14);
		contentPane.add(lblSoTien);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(346, 117, 327, 409);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 204, 255));
		panel_4.setBounds(0, 0, 329, 60);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblTienMat = new JLabel("Tiền mặt");
		lblTienMat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienMat.setBounds(10, 11, 157, 38);
		panel_4.add(lblTienMat);

		txtTienMat = new JLabel("0");
		txtTienMat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTienMat.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTienMat.setBounds(177, 11, 106, 38);
		panel_4.add(txtTienMat);

		JSeparator separator = new JSeparator();
		separator.setBorder(new LineBorder(Color.LIGHT_GRAY));
		separator.setBounds(0, 216, 329, 2);
		panel_3.add(separator);

		JLabel lblTienTra = new JLabel("Tiền mặt trả lại cho khách");
		lblTienTra.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTienTra.setBounds(10, 229, 170, 32);
		panel_3.add(lblTienTra);

		txtTienTra = new JLabel("0");
		txtTienTra.setForeground(Color.RED);
		txtTienTra.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtTienTra.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTienTra.setBounds(190, 233, 129, 25);
		panel_3.add(txtTienTra);

		JLabel lblThongTinPhimTat = new JLabel("Lưu: ALN + N hoặc F8 | In & Lưu ALN + I hoặc F9");
		lblThongTinPhimTat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblThongTinPhimTat.setBounds(10, 537, 307, 27);
		contentPane.add(lblThongTinPhimTat);

		JLabel lblHuyBo = new JLabel("HỦY BỎ");
		lblHuyBo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});
		lblHuyBo.setOpaque(true);
		lblHuyBo.setBackground(new Color(255, 250, 240));
		lblHuyBo.setForeground(new Color(255, 165, 0));
		lblHuyBo.setHorizontalAlignment(SwingConstants.CENTER);
		lblHuyBo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHuyBo.setBounds(575, 537, 90, 27);
		contentPane.add(lblHuyBo);

		JLabel lblinVaLuu = new JLabel("IN & LƯU");
		lblinVaLuu.setOpaque(true);
		lblinVaLuu.setHorizontalAlignment(SwingConstants.CENTER);
		lblinVaLuu.setForeground(Color.WHITE);
		lblinVaLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblinVaLuu.setBackground(new Color(30, 144, 255));
		lblinVaLuu.setBounds(419, 537, 146, 27);
		contentPane.add(lblinVaLuu);

		JLabel lblLuu = new JLabel("LƯU");
		lblLuu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				doLuu();
			}
		});
		lblLuu.setOpaque(true);
		lblLuu.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuu.setForeground(Color.WHITE);
		lblLuu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLuu.setBackground(new Color(30, 144, 255));
		lblLuu.setBounds(319, 536, 90, 27);
		contentPane.add(lblLuu);

	}

	public void doTienTra(String soTienThu) {
		int tienTra = Integer.parseInt(txtTienMat.getText().replace(",", ""))
				- Integer.parseInt(soTienThu.replace(",", ""));
		if (tienTra > 0) {
			NumberFormat df1 = new DecimalFormat("#,###");
			String str1 = df1.format(tienTra);
			txtTienTra.setText(str1);
		} else {
			txtTienTra.setText("Còn thiếu");
		}
	}

	public void doLuu() {
		if (giaoDien.equals("Nhấn từ form thanh toán")) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());
			String giothanhtoan = formatter.format(date);
			HoaDonDao.update(maHoaDon, "Đã thanh toán", giothanhtoan, tongtien);
			JOptionPane.showMessageDialog(null, "Thanh toán thành công");
			FoodsAppJframe.loadThanhToan();
			dispose();
			return;
		}
		if (giaoDien.equals("Nhấn từ form gọi món")) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			if (HoaDonDao.selectById(GoiMonJInternalFrame.lblMaHoaDon.getText()) == 1) {
				int tongtien = Integer
						.parseInt(String.valueOf(GoiMonJInternalFrame.txtTongThanhToan.getText()).replace(",", ""));
				HoaDonDao.update(GoiMonJInternalFrame.lblMaHoaDon.getText(), "Đã thanh toán", formatter.format(date), tongtien);
			} else {
				GoiMonJInternalFrame.insetHoaDon("Đã thanh toán", formatter.format(date));
			}
			JOptionPane.showMessageDialog(null, "Thanh toán thành công");
			GoiMonJInternalFrame.insertChiTietHoaDon();
			FoodsAppJframe.loadGoiMon();
			dispose();
			return;
		}
	}

}
