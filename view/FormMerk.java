package view;

import model.Merk;
import javax.swing.*;
import java.awt.event.*;

public class FormMerk extends JInternalFrame{
  private Merk merk = new Merk();
  private FormLihatMerk formLihatMerk = new FormLihatMerk(null,true);

  public FormMerk(){
    super("Master Data Merk", true, true);
    inisialisasiKomponen();
  }

  private void inisialisasiKomponen(){
    setSize(490,270);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    panel = new JPanel();

    namaMerkLabel = new JLabel("Merk");

    namaMerkTextField = new JTextField();

    lihatButton = new JButton("Lihat");
    simpanButton = new JButton("Simpan");
    hapusButton = new JButton("Hapus");
    tutupButton = new JButton("Tutup");

    panel.setLayout(null);
    getContentPane().add(panel);

    panel.add(namaMerkLabel);

  	panel.add(namaMerkTextField);

  	panel.add(lihatButton);
  	panel.add(simpanButton);
  	panel.add(hapusButton);
  	panel.add(tutupButton);

    namaMerkLabel.setBounds(30,60,90,25);

    namaMerkTextField.setBounds(130,60,220,25);

  	simpanButton.setBounds(10,180,100,25);
  	hapusButton.setBounds(120,180,100,25);
  	tutupButton.setBounds(230,180,100,25);
    lihatButton.setBounds(340,180,100,25);

    lihatButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent evt){
        lihatButtonActionPerformed(evt);
      }
    });

    simpanButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent evt){
        simpanButtonActionPerformed(evt);
      }
    });

    hapusButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent evt){
        hapusButtonActionPerformed(evt);
      }
    });

    tutupButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent evt){
        tutupButtonActionPerformed(evt);
      }
    });

  }

  private void lihatButtonActionPerformed(ActionEvent evt) {
    JOptionPane.showMessageDialog(null, "TAI KUDA 3");
  }

  private void simpanButtonActionPerformed(ActionEvent evt) {
    int konfirm = JOptionPane.showConfirmDialog(null, "Apakah yakin merk sepatunya : "+namaMerkTextField.getText(), "Konfirmasi" ,JOptionPane.YES_NO_OPTION);
    if (konfirm == JOptionPane.YES_OPTION) {
      merk.setNamaMerk(namaMerkTextField.getText());

      if (merk.simpan()){
        namaMerkTextField.setText("");
  	  }

    }
    else {
       JOptionPane.showMessageDialog(null, "GOODBYE");
    }
  }

  private void hapusButtonActionPerformed(ActionEvent evt) {
    JOptionPane.showMessageDialog(null, "TAI KUDA");
  }

  private void tutupButtonActionPerformed(ActionEvent evt) {
    dispose();
  }

  private JPanel panel;

  private JLabel namaMerkLabel;

  private JTextField namaMerkTextField;

  private JButton lihatButton;
  private JButton simpanButton;
  private JButton hapusButton;
  private JButton tutupButton;

}
