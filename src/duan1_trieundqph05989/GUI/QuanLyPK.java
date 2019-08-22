package duan1_trieundqph05989.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import duan1_trieundqph05989.DAOImpl.BenhnhanDAOimpl;
import duan1_trieundqph05989.DAOImpl.NhanvienDAOimpl;
import duan1_trieundqph05989.DAOImpl.PhieukhamDAOimpl;
import duan1_trieundqph05989.DAOImpl.PhongkhamDAOimpl;
import duan1_trieundqph05989.entity.Benhnhan;
import duan1_trieundqph05989.entity.Nhanvien;
import duan1_trieundqph05989.entity.Phieukham;
import duan1_trieundqph05989.entity.Phongkham;

public class QuanLyPK extends JFrame {
	private JSplitPane spl1, spl2;
	private JTextField tfngaykham, tfmabn, tfhoten, tfngaysinh, tfchandoan, tftimkiem, tfphongkham, tfbacsikham;
	private JLabel lbphongkham, lbngaykham, lbbacsikham, lbmabn, lbhoten, lbgioitinh, lbngaysinh, lbchandoan,
			lbhuongdieutri, lbdonthuoc, lbtimkiem,lblbacsikham,lblphongkham;
	private JPasswordField ádf;
	private JRadioButton jdonam, jdonu, jdochove, jdonhapvien;
	private JButton btthem, btsua, btxoa, btluu, btboqua, bttimkiem, btketxuat;
	private JComboBox<String> cbophongkham, cbogioitinh, cbohuongdieutri;
	private JCheckBox chkHT, chkdonthuoc;
	private JTable tblphongkham, tblphieukham;
	DefaultTableModel modelphieukham, modelphongkham;
	ArrayList<Phongkham> listphongkham;
	ArrayList<Phieukham> listphieukham;
	ArrayList<Nhanvien> listnv;
	ArrayList<Benhnhan> listbn;
	PhongkhamDAOimpl phongkhamDAOImpl;
	PhieukhamDAOimpl phieukhamDAOImpl;
	NhanvienDAOimpl nhanvienDAOImpl;
	BenhnhanDAOimpl benhnhanDAOImpl;
	int vitri, stt;
	int tt = 0;
	final int thempk = 1;
	final int suapk = 2;

	public QuanLyPK() {

		setLayout(new BorderLayout());
		setTitle("Quản Lý Phiếu Khám");
		setSize(1300, 700);
		setLocationRelativeTo(null);

		setResizable(false);
		add(split1());
		modelphieukham = (DefaultTableModel) tblphieukham.getModel();
		modelphongkham = (DefaultTableModel) tblphongkham.getModel();
		hander();
		addtbalePhongKham();
		addCombohuongdieutri();
		hienthinhanvien();
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private JSplitPane split1() {
		spl1 = new JSplitPane();
		spl1.setLeftComponent(add(pwest()));
		spl1.setRightComponent(add(split2()));
		spl1.setDividerSize(0);
		spl1.setDividerLocation(350);
		return spl1;
	}

	private JSplitPane split2() {
		spl2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		spl2.add(pnorth());
		spl2.add(pcenter());
		spl2.setDividerSize(0);
		spl2.setDividerLocation(400);
		return spl2;
	}

	private JPanel pnorth() {
		JPanel pn = new JPanel(new GridBagLayout());

		lbphongkham = new JLabel("Phòng Khám ");
		pn.add(lbphongkham, new GridBagConstraints(0, 1, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 50, 0, 0), 0, 0));
		lblphongkham = new JLabel();
		lblphongkham.setPreferredSize(new Dimension(700, 27));
		pn.add(lblphongkham, new GridBagConstraints(1, 1, 1, 1, 1, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 10, 0, 20), 0, 0));

		lbbacsikham = new JLabel("Bác sĩ khám ");
		pn.add(lbbacsikham, new GridBagConstraints(0, 2, 1, 1, 0, 0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(20, 50, 0, 20), 0, 0));
		 lblbacsikham = new JLabel();
		lblbacsikham.setPreferredSize(new Dimension(280, 27));
		pn.add(lblbacsikham, new GridBagConstraints(1, 2, 1, 1, 1, 0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(20, 10, 0, 20), 0, 0));

		lbngaykham = new JLabel("Ngày Khám ");
		pn.add(lbngaykham, new GridBagConstraints(1, 2, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 330, 0, 0), 0, 0));

		tfngaykham = new JTextField();
		tfngaykham.setPreferredSize(new Dimension(280, 27));
		pn.add(tfngaykham, new GridBagConstraints(1, 2, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 430, 0, 0), 0, 0));

		lbmabn = new JLabel("Mã bệnh nhân ");
		pn.add(lbmabn, new GridBagConstraints(0, 3, 1, 1, 0, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(20, 50, 0, 20), 0, 0));
		tfmabn = new JTextField();
		tfmabn.setPreferredSize(new Dimension(280, 27));
		pn.add(tfmabn, new GridBagConstraints(1, 3, 1, 1, 1, 0.0, GridBagConstraints.SOUTHWEST, GridBagConstraints.NONE,
				new Insets(20, 10, 0, 20), 0, 0));

		lbhoten = new JLabel("Tên bệnh nhân");
		pn.add(lbhoten, new GridBagConstraints(1, 3, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 330, 0, 0), 0, 0));

		tfhoten = new JTextField();
		tfhoten.setPreferredSize(new Dimension(280, 27));
		pn.add(tfhoten, new GridBagConstraints(1, 3, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 429, 0, 80), 0, 0));

		lbngaysinh = new JLabel("Ngày sinh");
		pn.add(lbngaysinh, new GridBagConstraints(0, 4, 1, 1, 0, 0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(20, 50, 0, 20), 0, 0));
		tfngaysinh = new JTextField();
		tfngaysinh.setPreferredSize(new Dimension(280, 27));
		pn.add(tfngaysinh, new GridBagConstraints(1, 4, 1, 1, 1, 0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(20, 10, 0, 20), 0, 0));

		lbgioitinh = new JLabel("Giới tính");
		pn.add(lbgioitinh, new GridBagConstraints(1, 4, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 330, 0, 20), 0, 0));

		jdonam = new JRadioButton("Nam", true);
		pn.add(jdonam, new GridBagConstraints(1, 4, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 430, 0, 20), 0, 0));
		jdonu = new JRadioButton("Nữ", false);
		pn.add(jdonu, new GridBagConstraints(1, 4, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 500, 0, 20), 0, 0));
		ButtonGroup group = new ButtonGroup();
		group.add(jdonam);
		group.add(jdonu);

		lbchandoan = new JLabel("Chẩn đoán");
		pn.add(lbchandoan, new GridBagConstraints(0, 5, 1, 1, 0, 0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(20, 50, 0, 0), 0, 0));
		tfchandoan = new JTextField();
		tfchandoan.setPreferredSize(new Dimension(700, 27));
		pn.add(tfchandoan, new GridBagConstraints(1, 5, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 10, 0, 20), 0, 0));
		lbhuongdieutri = new JLabel("Hướng điều trị ");
		pn.add(lbhuongdieutri, new GridBagConstraints(0, 6, 1, 1, 0, 0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(0, 40, 0, 20), 0, 0));
		cbohuongdieutri = new JComboBox();
		cbohuongdieutri.setPreferredSize(new Dimension(280, 27));
		pn.add(cbohuongdieutri, new GridBagConstraints(1, 6, 1, 1, 0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(20, 10, 0, 00), 0, 0));

		lbdonthuoc = new JLabel("Đơn thuốc");
		pn.add(lbdonthuoc, new GridBagConstraints(1, 6, 1, 1, 0, 0.0, GridBagConstraints.SOUTHWEST,
				GridBagConstraints.NONE, new Insets(20, 490, 0, 20), 0, 0));
		chkdonthuoc = new JCheckBox();
		chkdonthuoc.setPreferredSize(new Dimension(20, 27));
		pn.add(chkdonthuoc, new GridBagConstraints(1, 6, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(30, 430, 0, 0), 0, 0));
		btthem = new JButton("Thêm");
		btthem.setPreferredSize(new Dimension(75, 25));
		pn.add(btthem, new GridBagConstraints(1, 7, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 50, 0, 110), 0, 0));
		btsua = new JButton("Sửa");
		btsua.setPreferredSize(new Dimension(75, 25));
		pn.add(btsua, new GridBagConstraints(1, 7, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 180, 0, 0), 0, 0));
		btxoa = new JButton("Xóa");
		btxoa.setPreferredSize(new Dimension(75, 25));
		pn.add(btxoa, new GridBagConstraints(1, 7, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 310, 0, 0), 0, 0));
		btluu = new JButton("Lưu");
		btluu.setPreferredSize(new Dimension(75, 25));
		pn.add(btluu, new GridBagConstraints(1, 7, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 430, 0, 0), 0, 0));
		btboqua = new JButton("Bỏ Qua");
		btboqua.setPreferredSize(new Dimension(75, 25));
		pn.add(btboqua, new GridBagConstraints(1, 7, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 560, 0, 90), 0, 0));

		lbtimkiem = new JLabel("Tìm kiếm");
		pn.add(lbtimkiem, new GridBagConstraints(0, 8, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 50, 0, 20), 0, 0));
		tftimkiem = new JTextField();
		tftimkiem.setPreferredSize(new Dimension(280, 27));
		pn.add(tftimkiem, new GridBagConstraints(1, 8, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 10, 0, 20), 0, 0));
		bttimkiem = new JButton("Tìm kiếm");
		bttimkiem.setPreferredSize(new Dimension(90, 25));
		pn.add(bttimkiem, new GridBagConstraints(1, 8, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(20, 300, 0, 0), 0, 0));
		btketxuat = new JButton("Kết xuất");
		btketxuat.setPreferredSize(new Dimension(90, 25));
		pn.add(btketxuat, new GridBagConstraints(1, 8, 1, 1, 0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(33, 690, 0, 0), 0, 0));

		return pn;

	}

	private JPanel pcenter() {
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		tblphieukham = new JTable();
		int with[] = { 30, 200 };
		String title[] = { "Mã Bệnh Nhân", "Họ Tên", "Ngày Khám" };
		String data[][] = {};
		modelphieukham = new DefaultTableModel(data, title);
		tblphieukham.setModel(modelphieukham);
		for (int i = 0; i < with.length; i++) {
			tblphieukham.getColumnModel().getColumn(0).setPreferredWidth(50);
			tblphieukham.getColumnModel().getColumn(1).setPreferredWidth(100);
			tblphieukham.getColumnModel().getColumn(2).setPreferredWidth(100);
		
		}
		modelphieukham.setRowCount(4);
		JScrollPane sp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pn.add(sp);
		sp.getViewport().add(tblphieukham);
		return pn;
	}

	private JPanel pwest() {
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		tblphongkham = new JTable();
		int with[] = { 100, 230 };
		String title[] = { "Mã pk", "Tên phòng khám" };
		String data[][] = {};
		modelphongkham = new DefaultTableModel(data, title);
		tblphongkham.setModel(modelphongkham);
		for (int i = 0; i < with.length; i++) {
			tblphongkham.getColumnModel().getColumn(0).setPreferredWidth(50);
			tblphongkham.getColumnModel().getColumn(1).setPreferredWidth(282);
		}
		tblphongkham.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane sp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pn.add(sp);
		sp.getViewport().add(tblphongkham);

		return pn;
	}

	private void hander() {
		tblphongkham.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				hienthinhanvien();
				addCombo();
				 addCombotenbacsi();
			}
		});
		tblphieukham.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				doMousePhieukham();
			}
		});

	}

	private void hienthinhanvien() {
		int row = tblphongkham.getSelectedRow();
//		int row1 =(int)  tblphongkham.getValueAt(row, 1);
		Phongkham phongkham = new Phongkham();
		phongkham.setMaphongkham(row);
		phieukhamDAOImpl = new PhieukhamDAOimpl();
		listphieukham = (ArrayList<Phieukham>) phieukhamDAOImpl.getAlls(row);
		System.out.println(listphieukham.size());
		modelphieukham.setRowCount(0);
		stt = 1;
		for (Phieukham x : listphieukham) {
			modelphieukham.addRow(new Object[] { x.getBenhnhan().getMabn(), x.getBenhnhan().getTenbn(), x.getNgaykham(),
					x.getPhongkham().getNhanvien().getTennv() });
		}

	}
	private void addCombo() {
		phongkhamDAOImpl = new PhongkhamDAOimpl();
		listphongkham = (ArrayList<Phongkham>) phongkhamDAOImpl.getAlls(vitri);
		for (Phongkham x : listphongkham) {
			lblphongkham.setText(x.getMaphongkham() + " - " + x.getTenphongkham());
		}
		int row = tblphongkham.getSelectedRow();
		String mapk = tblphongkham.getValueAt(row, 0).toString();
		stt = 1;
		int a = 0;
		for (int i = 0; i < listphongkham.size(); i++) {
			a = a + 1;
			if (mapk.equalsIgnoreCase(stt++ + "")) {
				lblphongkham.setText(listphongkham.get(i).getMaphongkham()+ " - " + listphongkham.get(i).getTenphongkham());
			}
		}
	
	}
	private void addCombotenbacsi() {
		phongkhamDAOImpl = new PhongkhamDAOimpl();
		listphongkham = (ArrayList<Phongkham>) phongkhamDAOImpl.getAlls(vitri);
		for (Phongkham x : listphongkham) {
			lblbacsikham.setText(x.getNhanvien().getTennv());
		}
		int row = tblphongkham.getSelectedRow();
		String mapk = tblphongkham.getValueAt(row, 0).toString();
		stt = 1;
		int a = 0;
		for (int i = 0; i < listphongkham.size(); i++) {
			a = a + 1;
			if (mapk.equalsIgnoreCase(stt++ + "")) {
				lblbacsikham.setText(listphongkham.get(i).getNhanvien().getTennv());
			}
		}
	
	}


	private void addtbalePhongKham() {
		int row = tblphongkham.getSelectedRow();
//		int tenpk = (int) tblphongkham.getValueAt(row, 0) ;

		phongkhamDAOImpl = new PhongkhamDAOimpl();
		listphongkham = (ArrayList<Phongkham>) phongkhamDAOImpl.getAlls(row);
		modelphongkham.setRowCount(0);
		stt = 1;
		for (Phongkham x : listphongkham) {
			System.out.println("maphongkham: " + x.getMaphongkham());
			System.out.println("tenphongkham: " + x.getTenphongkham());
			System.out.println("BÁc sĩ khám:"+ x.getNhanvien().getTennv());
			modelphongkham.addRow(new Object[] { x.getMaphongkham(), x.getTenphongkham()});
		}

		int rowKT = tblphongkham.getRowCount();
		if (rowKT >= 0) {
			tblphongkham.setRowSelectionInterval(0, 0);

		}
	}	
	private void doMousePhieukham() {
		int row = tblphieukham.getSelectedRow();
		if (row > 0) {
			return;
		} else {
			vitri = row;
			displayphieukham(vitri);
		}
		tblphieukham.setRowSelectionInterval(vitri, vitri);
	}

	private void displayphieukham(int vitri) {
//		tfphongkham.setText(listpik.get(vitri).getPhongkham().getTenpk());

		tfngaykham.setText(listphieukham.get(vitri).getNgaykham());
//		cbobacsikham.setTransferHandler(listpik.get(vitri).getNhanvien().getTennv());
		tfmabn.setText(listphieukham.get(vitri).getBenhnhan().getMabn());
		tfhoten.setText(listphieukham.get(vitri).getBenhnhan().getTenbn());
		tfngaysinh.setText(listphieukham.get(vitri).getBenhnhan().getNgaysinh());
		tfbacsikham.setText(listphieukham.get(vitri).getPhongkham().getNhanvien().getTennv());
		tfchandoan.setText(listphieukham.get(vitri).getChandoan());
		boolean vaitro = listphieukham.get(vitri).getBenhnhan().isGioitinh();
        if (vaitro == true) {
            jdonam.setSelected(true);
        } else {
            jdonu.setSelected(true);
        }
		if (listphieukham.get(vitri).getHuongdieutri().equals("Cho về")) {
			cbohuongdieutri.setSelectedItem("Cho về");
		} else {
			cbohuongdieutri.setSelectedItem("Nhập viện");
		}
		tblphieukham.setRowSelectionInterval(vitri, vitri);
	}
	private boolean Gioitinh() {
		for (Benhnhan x : listbn) {
			if (x.isGioitinh() == true) {
				x.setGioitinh(false);
			} else {
				return true;
			}
		}
		return true;
	}

	private void addCombohuongdieutri() {
		cbohuongdieutri.addItem("Cho về");
		cbohuongdieutri.addItem("Nhập viện");
	}

	public static void main(String[] args) {
		QuanLyPK qlpk = new QuanLyPK();
		qlpk.setVisible(true);

	}

}
