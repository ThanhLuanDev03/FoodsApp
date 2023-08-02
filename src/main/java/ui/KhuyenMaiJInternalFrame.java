package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import dao.KhuyenMaiDAO;
import entity.KhuyenMai;
import utils.MsgBox;

public class KhuyenMaiJInternalFrame extends JInternalFrame {

	private JPanel contentPane;
	public static JTable table;
	public static DefaultTableModel model;
	public static JLabel lblTongGiaTri;
	public static JLabel lblTongSoLuongThe;
	private int roww;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					KhuyenMaiJInternalFrame frame = new KhuyenMaiJInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void delete() {
		KhuyenMaiDAO dao = new KhuyenMaiDAO();
		if (MsgBox.confirm(this, "Bạn có muốn xóa hay không?") == false) {
		} else {
			String m = (String) this.table.getValueAt(roww, 0);
			try {
				dao.delete(m);
				MsgBox.alert(this, "Xóa thành công!");
			} catch (Exception var3) {
				MsgBox.alert(this, "Xóa thất bại!");
			}
		}
	}

	public static void fillTable() {
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		try {
			List<KhuyenMai> list = KhuyenMaiDAO.selectAll();
			Iterator var3 = list.iterator();
			while (var3.hasNext()) {
				KhuyenMai cd = (KhuyenMai) var3.next();
				Object[] row = new Object[] { cd.getMaKM(), cd.getTenKM(), cd.getMota(), cd.getGiatri(),
						cd.getSoluong() };
				model.addRow(row);
			}
		} catch (Exception var6) {
			System.out.println("Lỗi truy vấn dữ liệu");
		}

	}

	/**
	 * Create the frame.
	 */
	public KhuyenMaiJInternalFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1230, 756);
//		this.setUndecorated(true);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
		ui.setNorthPane(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(null);
		panelTitle.setBackground(new Color(245, 245, 245));
		panelTitle.setBounds(0, 0, 1230, 51);
		contentPane.add(panelTitle);

		JLabel lblKhuyenMaiTitle = new JLabel("Khuyến mại");
		lblKhuyenMaiTitle.setForeground(Color.BLACK);
		lblKhuyenMaiTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblKhuyenMaiTitle.setBounds(10, 0, 198, 51);
		panelTitle.add(lblKhuyenMaiTitle);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(1084, 10, 85, 23);
		panelTitle.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblPhnHi_1 = new JLabel(" Phản hồi");
		panel_1.add(lblPhnHi_1);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tabbedPane.setBounds(10, 68, 1196, 624);
		contentPane.add(tabbedPane);

		JPanel panelVoucher = new JPanel();
		tabbedPane.addTab("Voucher", null, panelVoucher, null);
		panelVoucher.setLayout(null);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(SystemColor.controlHighlight);
		panel_2_1.setBounds(0, 0, 1215, 40);
		panelVoucher.add(panel_2_1);

		JLabel lblThem = new JLabel("Thêm");
		lblThem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ThemVoucherJFrame themvoucher = new ThemVoucherJFrame();
				themvoucher.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblThem.setBackground(new Color(210, 210, 210));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblThem.setBackground(SystemColor.controlHighlight);
			}
		});
		lblThem.setIcon(new ImageIcon(KhuyenMaiJInternalFrame.class.getResource("/icon/icons8_add_20px.png")));
		lblThem.setOpaque(true);
		lblThem.setHorizontalAlignment(SwingConstants.CENTER);
		lblThem.setForeground(Color.BLACK);
		lblThem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThem.setBackground(SystemColor.controlHighlight);
		lblThem.setBounds(0, 0, 90, 40);
		panel_2_1.add(lblThem);

		JLabel lblXoa = new JLabel(" Xóa");
		lblXoa.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				delete();
				fillTable();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblXoa.setBackground(new Color(210, 210, 210));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblXoa.setBackground(SystemColor.controlHighlight);
			}
		});
		lblXoa.setIcon(new ImageIcon(KhuyenMaiJInternalFrame.class.getResource("/icon/icons8_delete_20px_1.png")));
		lblXoa.setOpaque(true);
		lblXoa.setHorizontalAlignment(SwingConstants.CENTER);
		lblXoa.setForeground(Color.BLACK);
		lblXoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblXoa.setBackground(SystemColor.controlHighlight);
		lblXoa.setBounds(90, 0, 90, 40);
		panel_2_1.add(lblXoa);

		JLabel lblSua = new JLabel("Cập nhật");
		lblSua.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				roww = table.getSelectedRow();
				if (roww < 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn voucher để xem chỉnh sửa!");
				} else {
					try {
						CapNhatVoucherJFrame frame = new CapNhatVoucherJFrame();
						frame.setVisible(true);
						String maKM = String.valueOf(table.getValueAt(roww, 0));
						String tenKM = String.valueOf(table.getValueAt(roww, 1));
						String mota = String.valueOf(table.getValueAt(roww, 2));
						String giatri = String.valueOf(table.getValueAt(roww, 3));
						String soluong = String.valueOf(table.getValueAt(roww, 4));
						frame.edit(maKM, tenKM, mota, giatri, soluong);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblSua.setBackground(new Color(210, 210, 210));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblSua.setBackground(SystemColor.controlHighlight);
			}
		});
		lblSua.setIcon(new ImageIcon(KhuyenMaiJInternalFrame.class.getResource("/icon/icons8_update_20px.png")));
		lblSua.setOpaque(true);
		lblSua.setHorizontalAlignment(SwingConstants.CENTER);
		lblSua.setForeground(Color.BLACK);
		lblSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSua.setBackground(SystemColor.controlHighlight);
		lblSua.setBounds(179, 0, 102, 40);
		panel_2_1.add(lblSua);

		JLabel lblXem = new JLabel("Xem");
		lblXem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblXem.setBackground(new Color(210, 210, 210));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblXem.setBackground(SystemColor.controlHighlight);
			}
		});
		lblXem.setIcon(new ImageIcon(KhuyenMaiJInternalFrame.class.getResource("/icon/icons8_view_details_20px.png")));
		lblXem.setOpaque(true);
		lblXem.setHorizontalAlignment(SwingConstants.CENTER);
		lblXem.setForeground(Color.BLACK);
		lblXem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblXem.setBackground(SystemColor.controlHighlight);
		lblXem.setBounds(281, 0, 90, 40);
		panel_2_1.add(lblXem);

		String[] columnNames = new String[] { "Mã Voucher", "Tên mã", "Mô tả", "Giá trị", "Số lượng thẻ" };
		Object[][] data = null;
		model = new DefaultTableModel(data, columnNames);
		table = new JTable();
		JTableHeader th = table.getTableHeader();
		th.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setRowHeight(35);
		table.setShowGrid(false);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(1, 51, 1190, 545);
		panelVoucher.add(scrollPane);
		table.setDefaultEditor(Object.class, null);
		table.setModel(model);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Chương trình khuyến mại", null, panel_2, null);
		
				JPanel panel_4 = new JPanel();
				panel_4.setBounds(487, 689, 242, 29);
				contentPane.add(panel_4);
				panel_4.setBackground(new Color(255, 255, 255));
				panel_4.setLayout(null);
				panel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
				
						JPanel panel_3 = new JPanel();
						panel_3.setBounds(249, 689, 242, 29);
						contentPane.add(panel_3);
						panel_3.setBackground(new Color(255, 255, 255));
						panel_3.setLayout(null);
						panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
						
						
								JPanel panel = new JPanel();
								panel.setBounds(10, 689, 242, 29);
								contentPane.add(panel);
								panel.setBackground(new Color(255, 255, 255));
								panel.setLayout(null);
								panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
								
										JPanel panel_5 = new JPanel();
										panel_5.setBounds(727, 689, 225, 29);
										contentPane.add(panel_5);
										panel_5.setBackground(new Color(255, 255, 255));
										panel_5.setLayout(null);
										panel_5.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
										
												lblTongGiaTri = new JLabel("0");
												lblTongGiaTri.addMouseListener(new MouseAdapter() {
													@Override
													public void mouseEntered(MouseEvent e) {
														lblTongGiaTri.setBackground(new Color(210, 210, 210));
													}

													@Override
													public void mouseExited(MouseEvent e) {
														lblTongGiaTri.setBackground(Color.white);
													}
												});
												lblTongGiaTri.setFont(new Font("Tahoma", Font.PLAIN, 15));
												lblTongGiaTri.setBounds(10, 0, 205, 29);
												panel_5.add(lblTongGiaTri);
												
														JPanel panel_6 = new JPanel();
														panel_6.setBounds(949, 689, 252, 29);
														contentPane.add(panel_6);
														panel_6.setBackground(new Color(255, 255, 255));
														panel_6.setLayout(null);
														panel_6.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
														
																lblTongSoLuongThe = new JLabel("0");
																lblTongSoLuongThe.addMouseListener(new MouseAdapter() {
																	@Override
																	public void mouseEntered(MouseEvent e) {
																		lblTongSoLuongThe.setBackground(new Color(210, 210, 210));
																	}

																	@Override
																	public void mouseExited(MouseEvent e) {
																		lblTongSoLuongThe.setBackground(Color.white);
																	}
																});
																lblTongSoLuongThe.setFont(new Font("Tahoma", Font.PLAIN, 15));
																lblTongSoLuongThe.setBounds(10, 0, 213, 29);
																panel_6.add(lblTongSoLuongThe);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				roww = table.getSelectedRow();
				if (e.getClickCount() == 2) {
					if (roww < 0) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn món để xem chi tiết!");
					} else {
						try {
							CapNhatVoucherJFrame frame = new CapNhatVoucherJFrame();
							frame.setVisible(true);
							String maKM = String.valueOf(table.getValueAt(roww, 0));
							String tenKM = String.valueOf(table.getValueAt(roww, 1));
							String mota = String.valueOf(table.getValueAt(roww, 2));
							String giatri = String.valueOf(table.getValueAt(roww, 3));
							String soluong = String.valueOf(table.getValueAt(roww, 4));
							frame.edit(maKM, tenKM, mota, giatri, soluong);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}

		});
		fillTable();
		saveTable();
	}

	public static void saveTable() {
		int totalGiatri = 0;
		int totalSoluong = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			int Amount = Integer.parseInt(table.getValueAt(i, 3) + "");
			totalGiatri = Amount + totalGiatri;

			int Amount2 = Integer.parseInt(table.getValueAt(i, 4) + "");
			totalSoluong = Amount2 + totalSoluong;
		}
		NumberFormat df = new DecimalFormat("#,###");
		String tonggt = df.format(totalGiatri);
		lblTongGiaTri.setText(tonggt);

		String str = df.format(totalSoluong);
		lblTongSoLuongThe.setText(String.valueOf(totalSoluong));

	}

}