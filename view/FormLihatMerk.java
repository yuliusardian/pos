package view;

import java.awt.event.*;
import java.awt.Frame;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;

public class FormLihatMerk extends JDialog {
  private final String judulKolomTabelMerk[] = {"ID Merk","Nama Merk"};

  public FormLihatMerk(Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
  }

  private void initComponents() {
    setTitle("Data Merk");
    setSize(400,300);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setAlwaysOnTop(true);

    Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    setLocation((dimensi.width-getWidth())/2,(dimensi.height-getHeight())/2);

    panel = new JPanel();
    panel.setLayout(null);

    merkTableModel = new DefaultTableModel(null,judulKolomTabelMerk);
    merkTable = new JTable() {
      public boolean isCellEditable(int rowIndex, int colIndex) {
        return false;
    }};

    merkScrollPane = new JScrollPane();

    tutupButton = new JButton("Tutup");

    merkTable.setModel(merkTableModel);
    merkTable.getColumnModel().getColumn(0).setMinWidth(80);
    merkTable.getColumnModel().getColumn(0).setPreferredWidth(80);
    merkTable.getColumnModel().getColumn(0).setMaxWidth(80);

    merkScrollPane.getViewport().add(merkTable);
    panel.add(merkScrollPane);
    panel.add(tutupButton);

    this.add(panel);

    merkScrollPane.setBounds(0,0,380,200);
    tutupButton.setBounds(10,230,360,25);

    tutupButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        tutupButtonActionPerformed(evt);
  	  }
  	});
  }

  public void tampilkanData(Object[][] list) {
    merkTableModel.setRowCount(0);
    if ((list != null) && (list.length > 0)) {
      for (int i=0; i<list.length; i++) {
        merkTableModel.addRow(list[i]);
      }
    }
  }

  private void tutupButtonActionPerformed(ActionEvent evt){
    dispose();
  }

  private JPanel panel;
  private DefaultTableModel merkTableModel;
  private JTable merkTable;
  private JScrollPane merkScrollPane;
  private JButton tutupButton;

}
