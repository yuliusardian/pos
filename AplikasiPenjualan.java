import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import view.*;

public class AplikasiPenjualan extends JFrame {
  private FormAnggota formAnggota;
  private FormSepatu  formSepatu;
  private FormMerk    formMerk;
  private FormUkuran  formUkuran;

  public AplikasiPenjualan(){
    initComponents();
  }

  private void initComponents(){
  setTitle("Aplikasi Penjualan Sepatu");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLayout(null);

	Dimension dimensi = Toolkit.getDefaultToolkit(). getScreenSize();
	double skala = 0.85;
	setSize((int)(skala * dimensi.getWidth()), (int)(skala * dimensi.getHeight()));
	setLocation((int)((dimensi.getWidth()-getWidth())/2), (int)((dimensi.getHeight()-getHeight())/2));

	mdiDesktopPane = new JDesktopPane();
	menuBar = new JMenuBar();

	aplikasiMenu = new JMenu("Aplikasi");
	masterDataMenu = new JMenu("Master Data");
	transaksiMenu = new JMenu("Transaksi");
	//laporanMenu = new JMenu("Laporan");

  /*
  	deskripsiMenuItem = new JMenuItem("Deskripsi");
  	aksesMenuItem = new JMenuItem("Login");
  */
	keluarMenuItem                 = new JMenuItem("Keluar");

	sepatuMenuItem                 = new JMenuItem("Sepatu");
  jenisSepatuMenuItem            = new JMenuItem("Merk");
	ukuranSepatuMenuItem           = new JMenuItem("Ukuran");

  //--------------------------------------------------------
  /*
  anggotaMenuItem                = new JMenuItem("Anggota");
	petugasMenuItem                = new JMenuItem("Petugas");
  */
	peminjamanMenuItem             = new JMenuItem("Penjualan");
  /*
	pengembalianMenuItem           = new JMenuItem("Pengembalian");
  */
	peminjamanLaporanMenuItem      = new JMenuItem("Penjualan");
  /*
	pengembalianLaporanMenuItem    = new JMenuItem("Pengembalian");
  */
  bukuLaporanMenuItem            = new JMenuItem("Buku");
	anggotaLaporanMenuItem         = new JMenuItem("Anggota");
	petugasLaporanMenuItem         = new JMenuItem("Petugas");

	separator1 = new JSeparator();
	separator2 = new JSeparator();
	separator3 = new JSeparator();

	setContentPane(mdiDesktopPane);
	setJMenuBar(menuBar);

	menuBar.add(aplikasiMenu);
	menuBar.add(masterDataMenu);
	menuBar.add(transaksiMenu);
	//menuBar.add(laporanMenu);

	/*
    aplikasiMenu.add(deskripsiMenuItem);
    aplikasiMenu.add(aksesMenuItem);
  */
	aplikasiMenu.add(separator1);
	aplikasiMenu.add(keluarMenuItem);

	masterDataMenu.add(sepatuMenuItem);
  masterDataMenu.add(jenisSepatuMenuItem);
	masterDataMenu.add(ukuranSepatuMenuItem);
  /*
	masterDataMenu.add(separator2);
  masterDataMenu.add(anggotaMenuItem);
	masterDataMenu.add(petugasMenuItem);
  */
	transaksiMenu.add(peminjamanMenuItem);
	//transaksiMenu.add(pengembalianMenuItem);
  /*
	laporanMenu.add(peminjamanLaporanMenuItem);
	laporanMenu.add(pengembalianLaporanMenuItem);
	laporanMenu.add(separator3);
	laporanMenu.add(bukuLaporanMenuItem);
	laporanMenu.add(anggotaLaporanMenuItem);
	laporanMenu.add(petugasLaporanMenuItem);
  */
	keluarMenuItem.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent evt){
	    keluarMenuItemActionPerformed(evt);
	  }
	});

	jenisSepatuMenuItem.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent evt){
	    jenisSepatuMenuItemActionPerformed(evt);
	  }
	});

  ukuranSepatuMenuItem.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent evt){
	    ukuranSepatuMenuItemActionPerformed(evt);
	  }
	});

	sepatuMenuItem.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent evt){
	    sepatuMenuItemActionPerformed(evt);
	  }
	});

  /*
  anggotaMenuItem.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent evt){
	    anggotaMenuItemActionPerformed(evt);
	  }
	});

	petugasMenuItem.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent evt){
	    petugasMenuItemActionPerformed(evt);
	  }
	});
  */
  }

  private void keluarMenuItemActionPerformed(ActionEvent evt){
    System.exit(0);
  }

  private void jenisSepatuMenuItemActionPerformed(ActionEvent evt){
    formMerk = new FormMerk();
	  mdiDesktopPane.add(formMerk);
	  formMerk.setVisible(true);
  }

  private void ukuranSepatuMenuItemActionPerformed(ActionEvent evt){
    formUkuran = new FormUkuran();
    mdiDesktopPane.add(formUkuran);
    formUkuran.setVisible(true);
  }

  private void sepatuMenuItemActionPerformed(ActionEvent evt){
	  formSepatu = new FormSepatu();
	  mdiDesktopPane.add(formSepatu);
	  formSepatu.setVisible(true);
  }

  private void anggotaMenuItemActionPerformed(ActionEvent evt){
    if ((formAnggota != null) && formAnggota.isVisible()){
	  try {
	    formAnggota.setSelected(true);
	  } catch (Exception ex){}
	} else {
	  formAnggota = new FormAnggota();
	  mdiDesktopPane.add(formAnggota);
	  formAnggota.setVisible(true);
	}
  }

  private void petugasMenuItemActionPerformed(ActionEvent evt){

  }

  public static void main(String[] args){
    new AplikasiPenjualan().setVisible(true);
  }

  private JDesktopPane mdiDesktopPane;

  private JMenuBar menuBar;

  private JMenu aplikasiMenu;
  private JMenu masterDataMenu;
  private JMenu transaksiMenu;
  //private JMenu laporanMenu;

  /*
    private JMenuItem deskripsiMenuItem;
    private JMenuItem aksesMenuItem;
  */
  private JMenuItem keluarMenuItem;

  private JMenuItem sepatuMenuItem;
  private JMenuItem jenisSepatuMenuItem;
  private JMenuItem ukuranSepatuMenuItem;
  private JMenuItem anggotaMenuItem;
  private JMenuItem petugasMenuItem;

  private JMenuItem peminjamanMenuItem;
  //private JMenuItem pengembalianMenuItem;

  private JMenuItem peminjamanLaporanMenuItem;
  //private JMenuItem pengembalianLaporanMenuItem;
  private JMenuItem bukuLaporanMenuItem;
  private JMenuItem anggotaLaporanMenuItem;
  private JMenuItem petugasLaporanMenuItem;

  private JSeparator separator1;
  private JSeparator separator2;
  private JSeparator separator3;
}
