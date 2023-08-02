package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatIntelliJLaf;

import dao.KhuyenMaiDAO;
import entity.KhuyenMai;
import entity.NguyenLieu;
import utils.MsgBox;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThemVoucherJFrame extends JFrame {

	KhuyenMaiDAO dao = new KhuyenMaiDAO();

	private JPanel contentPane;
	private JTextField txtMa;
	private JTextField txtTenMa;
	private JTextField txtGiaTri;
	private JTextField txtSoLuong;
	private JTextArea textAreaMoTa;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					ThemVoucherJFrame frame = new ThemVoucherJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	KhuyenMai getForm() {
       KhuyenMai cd = new KhuyenMai();
       cd.setMaKM(this.txtMa.getText());
       cd.setTenKM(this.txtTenMa.getText());
       cd.setMota(this.textAreaMoTa.getText());
       cd.setGiatri(Integer.valueOf(this.txtGiaTri.getText()));
       cd.setSoluong(Integer.valueOf(this.txtSoLuong.getText()));
       return cd;
}
	boolean validate1(){
		 if (MsgBox.actionForInvalidComponent(txtMa, "", "Mã voucher")==false) {
			return false;
		 	}else if (MsgBox.actionForInvalidComponent(txtTenMa,"","Tên mã")==false){
	            return false;
	        }else if (MsgBox.actionForInvalidComponent(txtGiaTri,"","Giá trị")==false){
	            return false;
	        }else if(MsgBox.actionForInvalidComponent(txtSoLuong,"","Số lượng")==false){
	            return false;
	        }else if (MsgBox.actionForInvalidComponent(txtGiaTri, "negativenumbers", "Giá trị")==false) {
				return false;
			}else if (MsgBox.actionForInvalidComponent(txtSoLuong, "negativenumbers", "Số lượng")==false) {
				return false;
			}
	        return true;
	    }
	
	void insert() {
		
			 try {
		            KhuyenMai model = this.getForm();
		            this.dao.insert(model);
		            MsgBox.alert(this, "Thêm mới thành công!");
		        } catch (Exception var3) {
		            MsgBox.alert(this, "Thêm mới thất bại!");
		        }
		
       

    }
	/**
	 * Create the frame.
	 */
	public ThemVoucherJFrame() {
		setBounds(100, 100, 601, 351);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 204));
		panel.setBounds(0, 0, 623, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm Voucher");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 175, 27);
		panel.add(lblNewLabel);
		EtchedBorder lborder = new EtchedBorder();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin voucher", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel_1.setBounds(10, 57, 253, 246);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtGiaTri = new JTextField();
		txtGiaTri.setBounds(110, 137, 124, 24);
		panel_1.add(txtGiaTri);
		txtGiaTri.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Giá trị");
		lblNewLabel_1_2.setBounds(10, 134, 90, 24);
		panel_1.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên mã");
		lblNewLabel_1_1.setBounds(10, 83, 90, 24);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtTenMa = new JTextField();
		txtTenMa.setBounds(110, 86, 124, 24);
		panel_1.add(txtTenMa);
		txtTenMa.setColumns(10);
		
		txtMa = new JTextField();
		txtMa.setBounds(110, 34, 124, 24);
		panel_1.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Voucher");
		lblNewLabel_1.setBounds(10, 31, 74, 24);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("(*)");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(90, 39, 20, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("(*)");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_1.setBounds(62, 91, 20, 13);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("(*)");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_2.setBounds(48, 142, 20, 13);
		panel_1.add(lblNewLabel_2_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(null, "Chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 18), null));
		panel_2.setBounds(273, 57, 314, 246);
contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textAreaMoTa = new JTextArea();
		textAreaMoTa.setBounds(86, 95, 203, 118);
		panel_2.add(textAreaMoTa);
		textAreaMoTa.setLineWrap(true);
		textAreaMoTa.setBorder(lborder);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Mô tả");
		lblNewLabel_1_2_1.setBounds(10, 93, 90, 24);
		panel_2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Số lượng");
		lblNewLabel_1_2_2.setBounds(10, 34, 90, 24);
		panel_2.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtSoLuong = new JTextField();
		txtSoLuong.setBounds(86, 37, 203, 24);
		panel_2.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lblNewLabel_2_3 = new JLabel("(*)");
		lblNewLabel_2_3.setForeground(Color.RED);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2_3.setBounds(68, 42, 20, 13);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblThm = new JLabel("Thêm");
		lblThm.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(validate1()==true) {
					insert();
					KhuyenMaiJInternalFrame.fillTable();
					KhuyenMaiJInternalFrame.saveTable();
					dispose();
				}
				
			}
			
		});
		lblThm.setOpaque(true);
		lblThm.setHorizontalAlignment(SwingConstants.CENTER);
		lblThm.setForeground(Color.WHITE);
		lblThm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThm.setBackground(new Color(0, 102, 204));
		lblThm.setBounds(345, 313, 111, 25);
		contentPane.add(lblThm);
		
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
		lblHyB.setBounds(476, 313, 111, 25);
		contentPane.add(lblHyB);
	}
}