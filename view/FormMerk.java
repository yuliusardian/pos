package view;

import model.Merk;
import javax.swing.*;
import java.awt.event.*;

public class FormMerk extends JInternalFrame {
  private Merk merk                   = new Merk();
  private FormLihatMerk formLihatMerk = new FormLihatMerk(null,true);

  public FormMerk() {
    super("Master Data Merk", true, true);
    inisialisasiKomponen();
  }

  private void inisialisasiKomponen() {
    setSize(500,250);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    panel = new JPanel();

    idMerkLabel       = new JLabel("ID Merk");
    idMerkTextField   = new JTextField();
    /*
    idMerkTextField.setText("Auto Increment");
    idMerkTextField.setEditable(false);
    */

    namaMerkLabel     = new JLabel("Nama Merk");
    namaMerkTextField = new JTextField();

    lihatButton       = new JButton("Lihat");
    cariButton        = new JButton("Cari");
    simpanButton      = new JButton("Simpan");
    hapusButton       = new JButton("Hapus");
    tutupButton       = new JButton("Tutup");

    panel.setLayout(null);
    getContentPane().add(panel);

    panel.add(idMerkLabel);
  	panel.add(idMerkTextField);

    panel.add(namaMerkLabel);
  	panel.add(namaMerkTextField);

    panel.add(lihatButton);
  	panel.add(cariButton);
  	panel.add(simpanButton);
  	panel.add(hapusButton);
  	panel.add(tutupButton);

    idMerkLabel.setBounds(10,10,100,25);
    idMerkTextField.setBounds(130,10,200,25);

    namaMerkLabel.setBounds(10,50,100,25);
    namaMerkTextField.setBounds(130,50,300,25);

  	simpanButton.setBounds(10,180,100,25);
  	hapusButton.setBounds(120,180,100,25);
    lihatButton.setBounds(230,180,100,25);
    cariButton.setBounds(340,10,90,25);
  	tutupButton.setBounds(340,180,100,25);

    lihatButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        lihatButtonActionPerformed(evt);
      }
    });

    cariButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        cariButtonActionPerformed(evt);
      }
    });

    simpanButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        simpanButtonActionPerformed(evt);
      }
    });

    hapusButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        hapusButtonActionPerformed(evt);
      }
    });

    tutupButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        tutupButtonActionPerformed(evt);
      }
    });

  }

  private void lihatButtonActionPerformed(ActionEvent evt) {
    formLihatMerk.tampilkanData(merk.bacaData());
    formLihatMerk.setVisible(true);
  }

  private void cariButtonActionPerformed(ActionEvent evt) {
    if(idMerkTextField.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "ID merk harus diisi", "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } else {
      String abcdg = merk.cari(idMerkTextField.getText());
      namaMerkTextField.setText(abcdg);
    }
  }

  private void simpanButtonActionPerformed(ActionEvent evt) {
    if(namaMerkTextField.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Nama merk harus diisi", "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } else {
      int konfirm = JOptionPane.showConfirmDialog(null, "Apakah yakin merk sepatunya : "+namaMerkTextField.getText(), "Konfirmasi" ,JOptionPane.YES_NO_OPTION);
      if (konfirm == JOptionPane.YES_OPTION) {
        merk.setNamaMerk(namaMerkTextField.getText());

        if (merk.simpan()){
          namaMerkTextField.setText("");
    	  }

      } else {
         JOptionPane.showMessageDialog(null, "Silahkan isi data kembali");
      }
    }
  }

  private void hapusButtonActionPerformed(ActionEvent evt) {
    if(idMerkTextField.getText().equals("")) {
      JOptionPane.showMessageDialog(null, "Tidak ada data yang dipilih");
    }
  }

  private void tutupButtonActionPerformed(ActionEvent evt) {
    dispose();
  }

  private JPanel panel;

  private JLabel idMerkLabel;
  private JTextField idMerkTextField;

  private JLabel namaMerkLabel;
  private JTextField namaMerkTextField;

  private JButton lihatButton;
  private JButton cariButton;
  private JButton simpanButton;
  private JButton hapusButton;
  private JButton tutupButton;

}
