package view;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import TuDien.Tu;
import TuDien.TuDien;

import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;

import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JSeparator;

public class App extends JFrame {

	private JPanel panelMain;
	private static JTextField txtTimKiem;
	private JButton btnLuuTu;
	private JPanel panelTrangChu;
	private JPanel panelTuDaLuu;
	private JPanel panelTuDaTra;
	private JPanel panelShowBtnLoginRegister;
	
	private TuDien tudien;
	private JTextField txtTimKiem2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		tudien = new TuDien();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 572);
		setLocationRelativeTo(null);
		panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		panelMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		//panelMain.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(191, 191, 191)));
		BufferedImage image_icon_jframe = null;
		try {
			image_icon_jframe = ImageIO.read(getClass().getResource("../images/icon-translate.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setIconImage(image_icon_jframe);
		setTitle("Từ điển");

		setContentPane(panelMain);
		panelMain.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(232, 232, 232));
		panelMenu.setBounds(0, 0, 896, 32);
		panelMain.add(panelMenu);
		
		JButton btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTrangChu.setBackground(new Color(212, 210, 210));
		btnTrangChu.setBorder(BorderFactory.createLineBorder(new Color(212, 210, 210), 5));
		btnTrangChu.setFocusable(false);
		btnTrangChu.setFocusTraversalKeysEnabled(false);
		btnTrangChu.setFocusPainted(false);
		btnTrangChu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(btnTrangChu);
		
		JButton btnTaiKhoan = new JButton("Tài khoản");
		btnTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTaiKhoan.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
		btnTaiKhoan.setFocusable(false);
		btnTaiKhoan.setFocusTraversalKeysEnabled(false);
		btnTaiKhoan.setFocusPainted(false);
		btnTaiKhoan.setBackground(new Color(232, 232, 232));
		btnTaiKhoan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(btnTaiKhoan);
		
		JButton btnTuDaTra = new JButton("Từ đã tra");
		btnTuDaTra.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTuDaTra.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
		btnTuDaTra.setFocusable(false);
		btnTuDaTra.setFocusTraversalKeysEnabled(false);
		btnTuDaTra.setFocusPainted(false);
		btnTuDaTra.setBackground(new Color(232, 232, 232));
		btnTuDaTra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(btnTuDaTra);
		
		JButton btnTuDaLuu = new JButton("Từ đã lưu");
		btnTuDaLuu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTuDaLuu.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
		btnTuDaLuu.setFocusable(false);
		btnTuDaLuu.setFocusTraversalKeysEnabled(false);
		btnTuDaLuu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTuDaLuu.setFocusPainted(false);
		btnTuDaLuu.setBackground(new Color(232, 232, 232));
		panelMenu.add(btnTuDaLuu);
		
		//
		trangChu();
		formTuDaLuu();
		formTuDaTra();
		formShowBtnLoginRegister();
		
		//
		panelTrangChu.setVisible(true);
		panelTuDaLuu.setVisible(false);
		panelTuDaTra.setVisible(false);
		panelShowBtnLoginRegister.setVisible(false);
		
		btnTrangChu.addActionListener(e->{
			btnTrangChu.setBackground(new Color(212, 210, 210));
			btnTaiKhoan.setBackground(new Color(232, 232, 232));
			btnTuDaLuu.setBackground(new Color(232, 232, 232));
			btnTuDaTra.setBackground(new Color(232, 232, 232));
			
			btnTrangChu.setBorder(BorderFactory.createLineBorder(new Color(212, 210, 210), 5));
			btnTaiKhoan.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			btnTuDaLuu.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			btnTuDaTra.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			
			panelTrangChu.setVisible(true);
			panelTuDaLuu.setVisible(false);
			panelTuDaTra.setVisible(false);
			panelShowBtnLoginRegister.setVisible(false);
		});
		
		btnTaiKhoan.addActionListener(e->{
			btnTaiKhoan.setBackground(new Color(212, 210, 210));
			btnTrangChu.setBackground(new Color(232, 232, 232));
			btnTuDaLuu.setBackground(new Color(232, 232, 232));
			btnTuDaTra.setBackground(new Color(232, 232, 232));
			
			btnTaiKhoan.setBorder(BorderFactory.createLineBorder(new Color(212, 210, 210), 5));
			btnTrangChu.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			btnTuDaLuu.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			btnTuDaTra.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			
			panelTrangChu.setVisible(false);
			panelTuDaLuu.setVisible(false);
			panelTuDaTra.setVisible(false);
			panelShowBtnLoginRegister.setVisible(true);
		});
		
		btnTuDaLuu.addActionListener(e->{
			btnTuDaLuu.setBackground(new Color(212, 210, 210));
			btnTaiKhoan.setBackground(new Color(232, 232, 232));
			btnTrangChu.setBackground(new Color(232, 232, 232));
			btnTuDaTra.setBackground(new Color(232, 232, 232));
			
			btnTuDaLuu.setBorder(BorderFactory.createLineBorder(new Color(212, 210, 210), 5));
			btnTaiKhoan.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			btnTrangChu.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			btnTuDaTra.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			
			remove(panelTuDaLuu);
			remove(panelTuDaTra);
			formTuDaLuu();
			formTuDaTra();
			
			panelTrangChu.setVisible(false);
			panelTuDaLuu.setVisible(true);
			panelTuDaTra.setVisible(false);
			panelShowBtnLoginRegister.setVisible(false);
		});
		
		btnTuDaTra.addActionListener(e->{
			btnTuDaTra.setBackground(new Color(212, 210, 210));
			btnTaiKhoan.setBackground(new Color(232, 232, 232));
			btnTuDaLuu.setBackground(new Color(232, 232, 232));
			btnTrangChu.setBackground(new Color(232, 232, 232));
			
			btnTuDaTra.setBorder(BorderFactory.createLineBorder(new Color(212, 210, 210), 5));
			btnTaiKhoan.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			btnTuDaLuu.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			btnTrangChu.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232), 5));
			
			remove(panelTuDaLuu);
			remove(panelTuDaTra);
			formTuDaLuu();
			formTuDaTra();
			
			panelTrangChu.setVisible(false);
			panelTuDaLuu.setVisible(false);
			panelTuDaTra.setVisible(true);
			panelShowBtnLoginRegister.setVisible(false);
		});
		
//		trangChu();
//		formTuDaLuu();
//		formTuDaTra();
//		formShowBtnLoginRegister();
		
	}
	
	public void trangChu() {
		panelTrangChu = new JPanel();
		panelTrangChu.setBackground(new Color(255, 255, 255));
		panelTrangChu.setBounds(0, 31, 896, 502);
		panelMain.add(panelTrangChu);
		panelTrangChu.setLayout(null);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimKiem.setBounds(10, 47, 320, 32);
		txtTimKiem.setBorder(BorderFactory.createLineBorder(new Color(61, 61, 61), 1));
		panelTrangChu.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(new Color(255, 255, 255));
		btnTimKiem.setBackground(new Color(0, 0, 255));
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTimKiem.setBorder(null);
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFocusTraversalKeysEnabled(false);
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBounds(329, 47, 89, 32);
		btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelTrangChu.add(btnTimKiem);
		
		JButton btnTitleAnhViet = new JButton("Anh-Việt");
		btnTitleAnhViet.setBorderPainted(false);
		btnTitleAnhViet.setFocusable(false);
		btnTitleAnhViet.setFocusTraversalKeysEnabled(false);
		btnTitleAnhViet.setFocusPainted(false);
		btnTitleAnhViet.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnTitleAnhViet.setForeground(new Color(255, 255, 255));
		btnTitleAnhViet.setBackground(new Color(128, 0, 255));
		btnTitleAnhViet.setBounds(10, 13, 116, 26);
		panelTrangChu.add(btnTitleAnhViet);
		
		btnLuuTu = new JButton("Lưu");
		btnLuuTu.setBorderPainted(false);
		btnLuuTu.setFocusable(false);
		btnLuuTu.setFocusTraversalKeysEnabled(false);
		btnLuuTu.setFocusPainted(false);
		btnLuuTu.setBackground(new Color(128, 255, 255));
		btnLuuTu.setBounds(359, 90, 59, 23);
		btnLuuTu.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLuuTu.setVisible(false);
		panelTrangChu.add(btnLuuTu);
		
		JLabel lblKetQuaTimKiem = new JLabel();
		lblKetQuaTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblKetQuaTimKiem.setBackground(new Color(128, 255, 255));
		lblKetQuaTimKiem.setBounds(20, 111, 398, 380);
		lblKetQuaTimKiem.setVerticalAlignment(JLabel.TOP);
		panelTrangChu.add(lblKetQuaTimKiem);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(App.class.getResource("/images/background-home.png")));
		lblBackground.setBounds(317, 104, 641, 448);
		panelTrangChu.add(lblBackground);
		
		JDialog formSaveMean = new JDialog(this, true);
		
		JButton btnSaveMean = new JButton("Lưu");
		btnSaveMean.setBounds(20, 160, 345, 30);
		btnSaveMean.setFont(new Font("Verdana", Font.PLAIN, 14));
		btnSaveMean.setBackground(new Color(255, 255, 255));
		btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(170, 170, 170)));
		btnSaveMean.setFocusable(false);
		btnSaveMean.setFocusTraversalKeysEnabled(false);
		btnSaveMean.setFocusPainted(false);
		btnSaveMean.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JTextField txtTuLoai = new JTextField();
		txtTuLoai.setBounds(10,45,365, 30);
		txtTuLoai.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		JTextField txtMean = new JTextField();
		txtMean.setBounds(10,115,365, 30);
		txtMean.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		btnTimKiem.addActionListener(e->{
			if(txtTimKiem.getText().length() > 0) {
				Tu tu = new Tu(tudien.timKiem(txtTimKiem.getText().toLowerCase()));
				if(tu.layTiengViet().length() > 0) {
					btnLuuTu.setVisible(true);
					lblKetQuaTimKiem.setText("<html>" + tu.layTiengViet() +"</html");
					if(tu.layTiengViet().length() > 0 && !kiemtraTuDaTonTaiCoTrongFile(tu.layTiengAnh())) {
						try {
							FileWriter fw = new FileWriter("D:\\java\\Dictionary\\src\\TuDien\\tudatra.txt", true);
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(tu.layTiengAnh());
							bw.newLine();
							bw.close();
							fw.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else {
					lblKetQuaTimKiem.setText("<html><h4>Không tìm thấy</h4></html");
					btnLuuTu.setVisible(false);
				}
				tu=null;
			}
		});
		
		btnLuuTu.addActionListener(e->{
			String st = txtTimKiem.getText().toLowerCase();
			
			JPanel panelSaveMean = new JPanel();
			panelSaveMean.setBackground(Color.WHITE);
			panelSaveMean.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(191, 191, 191)));
			panelSaveMean.setLayout(null);
			formSaveMean.setContentPane(panelSaveMean);
			
			JLabel lblTitle = new JLabel("Nghĩa của từ " + st + " bạn muốn lưu");
			lblTitle.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblTitle.setBounds(10, 80, 380, 30);
			panelSaveMean.add(lblTitle);
			
			JLabel lblTitle2 = new JLabel("Từ loại");
			lblTitle2.setFont(new Font("Verdana", Font.PLAIN, 14));
			lblTitle2.setBounds(10, 10, 380, 30);
			panelSaveMean.add(lblTitle2);
			
			panelSaveMean.add(txtMean);
			panelSaveMean.add(txtTuLoai);
			
			btnSaveMean.setEnabled(false);
			panelSaveMean.add(btnSaveMean);
			
			formSaveMean.setTitle("Nghĩa của từ " + st);
			formSaveMean.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2 + 100, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2 + 100);
			formSaveMean.setSize(400, 240);
			formSaveMean.setVisible(true);
		});
		
		btnSaveMean.addActionListener(e1->{
			if(txtTimKiem.getText().length() > 0 && txtMean.getText().length() > 0) {
				Tu tu = new Tu(tudien.timKiem(txtTimKiem.getText().toLowerCase()));
				if(tu.layTiengViet().length() > 0) {
					try {
						FileWriter fw = new FileWriter("D:\\java\\Dictionary\\src\\TuDien\\tudaluu.txt", true);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write("@" + tu.layTiengAnh());
						bw.newLine();
						bw.write("-" + txtTuLoai.getText());
						bw.newLine();
						bw.write(txtMean.getText());
						bw.newLine();
						bw.close();
						fw.close();
						formSaveMean.setVisible(false);
						formSaveMean.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						txtMean.setText("");
						txtTuLoai.setText("");
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				tu=null;
			}
		});
		
		txtMean.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(txtMean.getText().length() > 0 && txtTuLoai.getText().length() > 0) {
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(50, 50, 50)));
					btnSaveMean.setEnabled(true);
				} else {
					btnSaveMean.setEnabled(false);
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(170, 170, 170)));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(txtMean.getText().length() > 0 && txtTuLoai.getText().length() > 0) {
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(50, 50, 50)));
					btnSaveMean.setEnabled(true);
				} else {
					btnSaveMean.setEnabled(false);
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(170, 170, 170)));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if(txtMean.getText().length() > 0 && txtTuLoai.getText().length() > 0) {
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(50, 50, 50)));
					btnSaveMean.setEnabled(true);
				} else {
					btnSaveMean.setEnabled(false);
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(170, 170, 170)));
				}
			}
		});
		
		txtTuLoai.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(txtMean.getText().length() > 0 && txtTuLoai.getText().length() > 0) {
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(50, 50, 50)));
					btnSaveMean.setEnabled(true);
				} else {
					btnSaveMean.setEnabled(false);
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(170, 170, 170)));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(txtMean.getText().length() > 0 && txtTuLoai.getText().length() > 0) {
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(50, 50, 50)));
					btnSaveMean.setEnabled(true);
				} else {
					btnSaveMean.setEnabled(false);
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(170, 170, 170)));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if(txtMean.getText().length() > 0 && txtTuLoai.getText().length() > 0) {
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(50, 50, 50)));
					btnSaveMean.setEnabled(true);
				} else {
					btnSaveMean.setEnabled(false);
					btnSaveMean.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(170, 170, 170)));
				}
			}
		});
	}
	
	public void formTuDaLuu() {
		panelTuDaLuu = new JPanel();
		panelTuDaLuu.setBorder(null);
		panelTuDaLuu.setBackground(new Color(255, 255, 255));
		panelTuDaLuu.setBounds(0, 31, 896, 502);
		panelMain.add(panelTuDaLuu);
		panelTuDaLuu.setLayout(null);
		
		JPanel panelDSTuDaLuu = new JPanel();
		panelDSTuDaLuu.setBackground(Color.WHITE);
		
		File file = new File("D:\\java\\Dictionary\\src\\TuDien\\tudaluu.txt");
		ArrayList<Tu> arrayListTuDaLuu = new ArrayList<Tu>();
		try {
			List<String> conText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
			Collections.reverse(conText);
			String tienganh = new String("");
			String tuloai = new String("");
			String tiengviet = new String("");
			
			for(String line: conText) {
				if(line.length() > 0) {
					if(line.indexOf("@") == 0) {
						tienganh = line.substring(1, line.length());
					} else if(line.indexOf("-") >= 0) {
						tuloai = line.substring(1, line.length());
					} else {
						tiengviet = line;
					}
				}
				if(tienganh.length() > 0 && tuloai.length() > 0 && tiengviet.length() > 0) {
					arrayListTuDaLuu.add(new Tu(tienganh, tuloai, tiengviet));
					tienganh = "";
					tuloai = "";
					tiengviet = "";
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		ArrayList<JPanel> panelDanhSachTuDaLuu = new ArrayList<JPanel>();
		JButton[] arrayBtnDelete = new JButton[arrayListTuDaLuu.size()];
		JButton[] arrayBtnEdit = new JButton[arrayListTuDaLuu.size()];
		JButton[] arrayBtnSearch = new JButton[arrayListTuDaLuu.size()];
		JLabel[] arayLblTiengViet = new JLabel[arrayListTuDaLuu.size()];
		JLabel[] arayLblTiengAnh = new JLabel[arrayListTuDaLuu.size()];
		
		for(int i=0;i<arrayListTuDaLuu.size();i++) {
			JPanel panelItem = new JPanel();
			panelItem.setBackground(new Color(171, 251, 255));
			panelItem.setLayout(null);
			
			arayLblTiengAnh[i] = new JLabel(arrayListTuDaLuu.get(i).layTiengAnh() + "(" + arrayListTuDaLuu.get(i).layTuLoai() +"): ");
			arayLblTiengAnh[i].setBounds(10, 0, 222, 41);
			arayLblTiengAnh[i].setFont(new Font("Verdana", Font.PLAIN, 14));
			panelItem.add(arayLblTiengAnh[i]);
			
			arayLblTiengViet[i] = new JLabel(arrayListTuDaLuu.get(i).layTiengViet());
			arayLblTiengViet[i].setFont(new Font("Verdana", Font.PLAIN, 14));
			arayLblTiengViet[i].setBounds(249, 0, 310, 41);
			panelItem.add(arayLblTiengViet[i]);
			
			arrayBtnSearch[i] = new JButton();
			arrayBtnSearch[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			arrayBtnSearch[i].setBorder(new EmptyBorder(0, 0, 0, 0));
			arrayBtnSearch[i].setFocusTraversalKeysEnabled(false);
			arrayBtnSearch[i].setFocusPainted(false);
			arrayBtnSearch[i].setBackground(new Color(255, 255, 255));
			ImageIcon icon_search = new ImageIcon(App.class.getResource("/images/search.png"));
			Image img_search = icon_search.getImage() ;  
			icon_search = new ImageIcon( img_search.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) );
			arrayBtnSearch[i].setIcon(icon_search);
			arrayBtnSearch[i].setBounds(670, 6, 57, 30);
			panelItem.add(arrayBtnSearch[i]);
			
			arrayBtnEdit[i] = new JButton();
			arrayBtnEdit[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			arrayBtnEdit[i].setBorder(new EmptyBorder(0, 0, 0, 0));
			arrayBtnEdit[i].setFocusTraversalKeysEnabled(false);
			arrayBtnEdit[i].setFocusPainted(false);
			arrayBtnEdit[i].setBackground(new Color(255, 255, 255));
			ImageIcon icon_edit = new ImageIcon(App.class.getResource("/images/edit.png"));
			Image img_edit = icon_edit.getImage() ;  
			icon_edit = new ImageIcon( img_edit.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) );
			arrayBtnEdit[i].setIcon(icon_edit);
			arrayBtnEdit[i].setBounds(735, 6, 57, 30);
			panelItem.add(arrayBtnEdit[i]);
			
			arrayBtnDelete[i] = new JButton();
			arrayBtnDelete[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			arrayBtnDelete[i].setBorder(new EmptyBorder(0, 0, 0, 0));
			arrayBtnDelete[i].setFocusTraversalKeysEnabled(false);
			arrayBtnDelete[i].setFocusPainted(false);
			arrayBtnDelete[i].setBackground(new Color(255, 255, 255));
			ImageIcon icon_trash = new ImageIcon(App.class.getResource("/images/trash.png"));
			Image img_trash = icon_trash.getImage() ;  
			icon_edit = new ImageIcon( img_trash.getScaledInstance( 25, 25,  java.awt.Image.SCALE_SMOOTH ) );
			arrayBtnDelete[i].setIcon(icon_edit);
			arrayBtnDelete[i].setBounds(800, 6, 57, 30);
			panelItem.add(arrayBtnDelete[i]);
			
			panelDanhSachTuDaLuu.add(panelItem);
		}
		
		
		for(int i=0;i<panelDanhSachTuDaLuu.size();i++) {
			panelDanhSachTuDaLuu.get(i).setBounds(10, 10 + i*60, 870, 42);
			if(i==0) {
				panelDanhSachTuDaLuu.get(i).setBounds(10, 12, 870, 42);
			}
			panelDSTuDaLuu.add(panelDanhSachTuDaLuu.get(i));
		}
		
		panelDSTuDaLuu.setPreferredSize(new Dimension(870, panelDanhSachTuDaLuu.size() * 60));
		
		for(int i = 0; i < arrayBtnEdit.length; i++){
		    int index = i;  
		    arrayBtnEdit[i].addActionListener(e->{
		    	JDialog formEdit = new JDialog(this, true);
		    	JPanel panelEdit = new JPanel();
		    	panelEdit.setLayout(null);
		    	
		    	JLabel lblTiengAnh = new JLabel(arrayListTuDaLuu.get(index).layTiengAnh(), SwingConstants.CENTER);
		    	lblTiengAnh.setFont(new Font("Verdana", Font.BOLD, 16));
		    	lblTiengAnh.setBounds(10, 10, 365, 30);
		    	panelEdit.add(lblTiengAnh);
		    	
		    	JLabel lblTuLoai = new JLabel("Từ loại:");
		    	lblTuLoai.setFont(new Font("Verdana", Font.PLAIN, 14));
		    	lblTuLoai.setBounds(10, 40, 365, 30);
		    	panelEdit.add(lblTuLoai);
		    	
		    	JTextField txtTuLoai = new JTextField();
		    	txtTuLoai.setText(arrayListTuDaLuu.get(index).layTuLoai());
		    	txtTuLoai.setFont(new Font("Verdana", Font.PLAIN, 14));
		    	txtTuLoai.setBounds(10, 80, 365, 30);
		    	panelEdit.add(txtTuLoai);
		    	
		    	JLabel lblTiengViet = new JLabel("Tiếng Việt:");
		    	lblTiengViet.setFont(new Font("Verdana", Font.PLAIN, 14));
		    	lblTiengViet.setBounds(10, 120, 365, 30);
		    	panelEdit.add(lblTiengViet);
		    	
		    	JTextField txtTiengViet = new JTextField();
		    	txtTiengViet.setText(arrayListTuDaLuu.get(index).layTiengViet());
		    	txtTiengViet.setFont(new Font("Verdana", Font.PLAIN, 14));
		    	txtTiengViet.setBounds(10, 160, 365, 30);
		    	panelEdit.add(txtTiengViet);
		    	
		    	JButton btnLuuChinhSua = new JButton("Lưu");
		    	btnLuuChinhSua.setFont(new Font("Verdana", Font.PLAIN, 14));
		    	btnLuuChinhSua.setBounds(10, 200, 365, 30);
		    	btnLuuChinhSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
		    	btnLuuChinhSua.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(170, 170, 170)));
		    	btnLuuChinhSua.setFocusTraversalKeysEnabled(false);
		    	btnLuuChinhSua.setFocusPainted(false);
		    	btnLuuChinhSua.setBackground(new Color(255, 255, 255));
		    	panelEdit.add(btnLuuChinhSua);
		    	
		    	btnLuuChinhSua.addActionListener(e1->{
		    		Boolean ok = false;
		    		if(!txtTiengViet.getText().equals(arrayListTuDaLuu.get(index).layTiengViet()) && txtTiengViet.getText().length() > 0) {
		    			arrayListTuDaLuu.get(index).thayDoiTiengViet(txtTiengViet.getText());
		    			arayLblTiengViet[index].setText(txtTiengViet.getText());
		    			ok = true;
		    		}
		    		if(!txtTuLoai.getText().equals(arrayListTuDaLuu.get(index).layTuLoai()) && txtTuLoai.getText().length() > 0) {
		    			arrayListTuDaLuu.get(index).thayDoiTuLoai(txtTuLoai.getText());
		    			arayLblTiengAnh[index].setText(arrayListTuDaLuu.get(index).layTiengAnh() + "(" + arrayListTuDaLuu.get(index).layTuLoai() +"): ");
		    			ok = true;
		    		}
		    		if(ok == true) {
		    			try {
							FileWriter fw = new FileWriter("D:\\java\\Dictionary\\src\\TuDien\\tudaluu.txt");
							BufferedWriter bw = new BufferedWriter(fw);
							for(int j=0;j<arrayListTuDaLuu.size();j++) {
								bw.write("@" + arrayListTuDaLuu.get(j).layTiengAnh());
								bw.newLine();
								bw.write("-" + arrayListTuDaLuu.get(j).layTuLoai());
								bw.newLine();
								bw.write(arrayListTuDaLuu.get(j).layTiengViet());
								bw.newLine();
							}
							bw.close();
							fw.close();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
		    		}
		    		txtTiengViet.setText("");
		    		txtTuLoai.setText("");
		    		formEdit.dispose();
		    	});
		    	
		    	panelEdit.setBackground(Color.WHITE);
		    	formEdit.setContentPane(panelEdit);
		    	formEdit.setTitle("Chỉnh sửa từ " + arrayListTuDaLuu.get(index).layTiengAnh());
		    	formEdit.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2 + 100, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2 + 100);
		    	formEdit.setSize(400, 290);
		    	formEdit.setVisible(true);
		    	
		    });
		}
		
		for(int i = 0; i < arrayBtnDelete.length; i++){
		    int index = i;  
		    arrayBtnDelete[i].addActionListener(e->{
		    	panelDanhSachTuDaLuu.get(index).setVisible(false);
		    	panelDanhSachTuDaLuu.remove(index);
		    	arrayListTuDaLuu.remove(index);
		    	for(int j=0;j<panelDanhSachTuDaLuu.size();j++) {
					panelDanhSachTuDaLuu.get(j).setBounds(10, 30 + j*60, 874, 42);
					panelDSTuDaLuu.add(panelDanhSachTuDaLuu.get(j));
				}
		    	panelDSTuDaLuu.setPreferredSize(new Dimension(855, panelDanhSachTuDaLuu.size() * 60 + 20));
		    	try {
					FileWriter fw = new FileWriter("D:\\java\\Dictionary\\src\\TuDien\\tudaluu.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					for(int j=0;j<arrayListTuDaLuu.size();j++) {
						bw.write("@" + arrayListTuDaLuu.get(j).layTiengAnh());
						bw.newLine();
						bw.write("-" + arrayListTuDaLuu.get(j).layTuLoai());
						bw.newLine();
						bw.write(arrayListTuDaLuu.get(j).layTiengViet());
						bw.newLine();
					}
					bw.close();
					fw.close();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
		    });
		}
		
		for(int i = 0; i < arrayBtnSearch.length; i++){
		    int index = i;
		    arrayBtnSearch[i].addActionListener(e->{
		    	Tu t = new Tu(tudien.timKiem(arrayListTuDaLuu.get(index).layTiengAnh()));
		    	JDialog dialogD = new JDialog(this, true);
		    	
		    	JPanel panelForm = new JPanel();
		    	panelForm.setLayout(null);
		    	panelForm.setBackground(Color.WHITE);
		    	dialogD.setContentPane(panelForm);
		    	
		    	JLabel lblShowD = new JLabel("<html>" + t.layTiengViet() + "</html>");
		    	lblShowD.setBorder(new EmptyBorder(10,10,10,10));
		    	lblShowD.setBackground(Color.WHITE);
		    	lblShowD.setFont(new Font("Verdana", Font.PLAIN, 15));
		    	
		    	int width = (int) lblShowD.getPreferredSize().getWidth() > 600 ? 600:(int) lblShowD.getPreferredSize().getWidth();
		    	int height = (int) lblShowD.getPreferredSize().getHeight() > 600 ? 600:(int) lblShowD.getPreferredSize().getHeight();
		    	
		    	JScrollPane scrollD = new JScrollPane(lblShowD);
		    	scrollD.setBounds(-1, -1, width - 18, height - 45);
		    	scrollD.getViewport().setBackground(Color.WHITE);
		    	panelForm.add(scrollD);
		    	
		    	
		    	dialogD.setTitle("Từ " + t.layTiengAnh() + " trong từ điển");
		    	dialogD.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2 + 100, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
		    	dialogD.setSize(width, height);
		    	dialogD.setVisible(true);
		    	
		    });
		}
		
		ScrollBarCustom sp = new ScrollBarCustom();
		JScrollPane scrollPaneTuDaLuu = new JScrollPane();
		ScrollBarCustom scrollBarCustom1 = new ScrollBarCustom();

        sp.setForeground(new java.awt.Color(170, 83, 242));
        scrollPaneTuDaLuu.setBorder(null);

        scrollBarCustom1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        
        scrollPaneTuDaLuu.setVerticalScrollBar(new ScrollBarCustom());
        sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPaneTuDaLuu.setHorizontalScrollBar(sp);
		
		scrollPaneTuDaLuu.setBounds(0, 62, 896, 440);
		panelDSTuDaLuu.setLayout(null);
		scrollPaneTuDaLuu.setViewportView(panelDSTuDaLuu);
		panelTuDaLuu.add(scrollPaneTuDaLuu);
		
		txtTimKiem2 = new JTextField();
		txtTimKiem2.setBounds(10, 15, 340, 30);
		panelTuDaLuu.add(txtTimKiem2);
		txtTimKiem2.setColumns(10);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(201, 218, 255));
		btnTimKiem.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnTimKiem.setFocusable(false);
		btnTimKiem.setFocusTraversalKeysEnabled(false);
		btnTimKiem.setFocusPainted(false);
		btnTimKiem.setBounds(349, 15, 89, 30);
		btnTimKiem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelTuDaLuu.add(btnTimKiem);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(192, 192, 192));
		separator.setBounds(0, 60, 896, 5);
		panelTuDaLuu.add(separator);
		
		txtTimKiem2.getDocument().addDocumentListener(new DocumentListener(){
			@Override
			public void insertUpdate(DocumentEvent e) {
				if(txtTimKiem2.getText().length()>0) {
					String st = txtTimKiem2.getText().toLowerCase();
					int j = 0;
					for(int i=0;i<arrayListTuDaLuu.size();i++) {
						panelDanhSachTuDaLuu.get(i).setVisible(true);
						if(arrayListTuDaLuu.get(i).layTiengAnh().indexOf(st) > -1) {
							panelDanhSachTuDaLuu.get(i).setBounds(10, 10 + j*60, 870, 42);
							if(j==0) {
								panelDanhSachTuDaLuu.get(i).setBounds(10, 12, 870, 42);
							}
							j++;
						} else {
							panelDanhSachTuDaLuu.get(i).setVisible(false);
						}
					}
					panelDSTuDaLuu.setPreferredSize(new Dimension(870, (j+1) * 60));
				} else {
					for(int i=0;i<arrayListTuDaLuu.size();i++) {
						panelDanhSachTuDaLuu.get(i).setVisible(true);
						panelDanhSachTuDaLuu.get(i).setBounds(10, 10 + i*60, 870, 42);
						if(i==0) {
							panelDanhSachTuDaLuu.get(i).setBounds(10, 12, 870, 42);
						}
					}
					panelDSTuDaLuu.setPreferredSize(new Dimension(870, panelDanhSachTuDaLuu.size() * 60));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if(txtTimKiem2.getText().length()>0) {
					String st = txtTimKiem2.getText().toLowerCase();
					int j = 0;
					for(int i=0;i<arrayListTuDaLuu.size();i++) {
						panelDanhSachTuDaLuu.get(i).setVisible(true);
						if(arrayListTuDaLuu.get(i).layTiengAnh().indexOf(st) > -1) {
							panelDanhSachTuDaLuu.get(i).setBounds(10, 10 + j*60, 870, 42);
							if(j==0) {
								panelDanhSachTuDaLuu.get(i).setBounds(10, 12, 870, 42);
							}
							j++;
						} else {
							panelDanhSachTuDaLuu.get(i).setVisible(false);
						}
					}
					panelDSTuDaLuu.setPreferredSize(new Dimension(870, (j+1) * 60));
				} else {
					for(int i=0;i<arrayListTuDaLuu.size();i++) {
						panelDanhSachTuDaLuu.get(i).setVisible(true);
						panelDanhSachTuDaLuu.get(i).setBounds(10, 10 + i*60, 870, 42);
						if(i==0) {
							panelDanhSachTuDaLuu.get(i).setBounds(10, 12, 870, 42);
						}
					}
					panelDSTuDaLuu.setPreferredSize(new Dimension(870, panelDanhSachTuDaLuu.size() * 60));
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				if(txtTimKiem2.getText().length()>0) {
					String st = txtTimKiem2.getText().toLowerCase();
					int j = 0;
					for(int i=0;i<arrayListTuDaLuu.size();i++) {
						panelDanhSachTuDaLuu.get(i).setVisible(true);
						if(arrayListTuDaLuu.get(i).layTiengAnh().indexOf(st) > -1) {
							panelDanhSachTuDaLuu.get(i).setBounds(10, 10 + j*60, 870, 42);
							if(j==0) {
								panelDanhSachTuDaLuu.get(i).setBounds(10, 12, 870, 42);
							}
							j++;
						} else {
							panelDanhSachTuDaLuu.get(i).setVisible(false);
						}
					}
					panelDSTuDaLuu.setPreferredSize(new Dimension(870, (j+1) * 60));
				} else {
					for(int i=0;i<arrayListTuDaLuu.size();i++) {
						panelDanhSachTuDaLuu.get(i).setVisible(true);
						panelDanhSachTuDaLuu.get(i).setBounds(10, 10 + i*60, 870, 42);
						if(i==0) {
							panelDanhSachTuDaLuu.get(i).setBounds(10, 12, 870, 42);
						}
					}
					panelDSTuDaLuu.setPreferredSize(new Dimension(870, panelDanhSachTuDaLuu.size() * 60));
				}
			}
		});
	}
	
	public void formTuDaTra() {
		panelTuDaTra = new JPanel();
		panelTuDaTra.setBackground(new Color(255, 255, 255));
		panelTuDaTra.setBounds(0, 30, 896, 503);
		panelMain.add(panelTuDaTra);
		panelTuDaTra.setLayout(null);
		
		File file = new File("D:\\java\\Dictionary\\src\\TuDien\\tudatra.txt");
		List<String> dsTuDaTra = new ArrayList<String>();
		try {
			dsTuDaTra = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.reverse(dsTuDaTra);
		
		JPanel panelFormTuDaTra = new JPanel();
		panelFormTuDaTra.setLayout(null);
		panelFormTuDaTra.setBackground(Color.WHITE);
		
		JPanel[] panelLine = new JPanel[dsTuDaTra.size()];
		
		for(int i=0;i<dsTuDaTra.size();i++) {
			panelLine[i] = new JPanel();
			JLabel lblItem = new JLabel(dsTuDaTra.get(i));
			lblItem.setBounds(10, 0, 100, 30);
			lblItem.setFont(new Font("Verdana", Font.PLAIN, 15));
			
			panelLine[i].setLayout(null);
			panelLine[i].setBackground(new Color(219, 253, 255));
			panelLine[i].add(lblItem);
			panelLine[i].setBounds(0,i*40,880, 35);
			panelLine[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
			panelFormTuDaTra.add(panelLine[i]);
		}
		
		panelFormTuDaTra.setPreferredSize(new Dimension(880, dsTuDaTra.size()*40));
		
		JScrollPane scrollPaneTuDaTra = new JScrollPane(panelFormTuDaTra);
		ScrollBarCustom sp = new ScrollBarCustom();
		ScrollBarCustom scrollBarCustom1 = new ScrollBarCustom();

        sp.setForeground(new java.awt.Color(170, 83, 242));
        scrollPaneTuDaTra.setBorder(null);

        scrollBarCustom1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        
        scrollPaneTuDaTra.setVerticalScrollBar(new ScrollBarCustom());
        sp = new ScrollBarCustom();
        sp.setOrientation(JScrollBar.HORIZONTAL);
        scrollPaneTuDaTra.setHorizontalScrollBar(sp);
        
		scrollPaneTuDaTra.setBounds(0, 0, 896, 503);
		panelTuDaTra.add(scrollPaneTuDaTra);
		
		for(int i=0;i<dsTuDaTra.size();i++) {
			String st = dsTuDaTra.get(i);
			JFrame frame = this;
			panelLine[i].addMouseListener((MouseListener) new MouseAdapter() {
			    @Override
			    public void mouseClicked(MouseEvent e) {
			        Tu t = new Tu(tudien.timKiem(st));
			    	JDialog dialogD = new JDialog(frame, true);
			    	
			    	JPanel panelForm = new JPanel();
			    	panelForm.setLayout(null);
			    	panelForm.setBackground(Color.WHITE);
			    	dialogD.setContentPane(panelForm);
			    	
			    	JLabel lblShowD = new JLabel("<html>" + t.layTiengViet() + "</html>");
			    	lblShowD.setBorder(new EmptyBorder(10,10,10,10));
			    	lblShowD.setBackground(Color.WHITE);
			    	lblShowD.setFont(new Font("Verdana", Font.PLAIN, 15));
			    	
			    	int width = (int) lblShowD.getPreferredSize().getWidth() > 600 ? 600:(int) lblShowD.getPreferredSize().getWidth();
			    	int height = (int) lblShowD.getPreferredSize().getHeight() > 600 ? 600:(int) lblShowD.getPreferredSize().getHeight();
			    	
			    	JScrollPane scrollD = new JScrollPane(lblShowD);
			    	scrollD.setBounds(-1, -1, width - 18, height - 45);
			    	scrollD.getViewport().setBackground(Color.WHITE);
			    	panelForm.add(scrollD);
			    	
			    	
			    	dialogD.setTitle("Từ " + t.layTiengAnh() + " trong từ điển");
			    	dialogD.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - getWidth()/2 + 100, (Toolkit.getDefaultToolkit().getScreenSize().height)/2 - getHeight()/2);
			    	dialogD.setSize(width, height);
			    	dialogD.setVisible(true);
			    }
			});
		}
	}
	
	public void formShowBtnLoginRegister() {
		panelShowBtnLoginRegister = new JPanel();
		panelShowBtnLoginRegister.setBackground(new Color(255, 255, 255));
		panelShowBtnLoginRegister.setBounds(0, 30, 896, 503);
		panelMain.add(panelShowBtnLoginRegister);
		panelShowBtnLoginRegister.setLayout(null);
		
		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBounds(374, 167, 131, 32);
		panelShowBtnLoginRegister.add(btnNewButton);
		
		JButton btnngK = new JButton("Đăng ký");
		btnngK.setForeground(new Color(255, 255, 255));
		btnngK.setBackground(new Color(79, 214, 0));
		btnngK.setFocusable(false);
		btnngK.setFocusTraversalKeysEnabled(false);
		btnngK.setFocusPainted(false);
		btnngK.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnngK.setBounds(374, 221, 131,32);
		panelShowBtnLoginRegister.add(btnngK);
	}
	
	public Boolean kiemtraTuDaTonTaiCoTrongFile(String st) {
		Boolean kt = false;
		File file = new File("D:\\java\\Dictionary\\src\\TuDien\\tudatra.txt");
		try {
			List<String> conText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
			for(String line: conText) {
				if(st.equals(line)) {
					kt=true;
					break;
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return kt;
	}
}
