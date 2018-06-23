package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Merk {
  private String namaMerk;
  private Koneksi koneksi = new Koneksi();

  public Merk(){
    namaMerk = "";
  }

  public void setNamaMerk(String namaMerk) {
    this.namaMerk = namaMerk;
  }

  public String getNamaMerk() {
    return namaMerk;
  }

  public boolean simpan() {
    boolean adaKesalahan = false;
    Connection connection;

    if ((connection = koneksi.getConnection()) != null) {
      int jumlahSimpan=0;
		  boolean simpan = false;

      try {
        String SQLStatemen = "SELECT * FROM merk WHERE nama_merk='"+ namaMerk + "'";
  		  Statement sta = connection.createStatement();
  		  ResultSet rset = sta.executeQuery(SQLStatemen);

  		  rset.next();
  		  if (rset.getRow()>0) {
          sta.close();
          rset.close();
          Object[] arrOpsi = {"Ya","Tidak"};
          JOptionPane.showOptionDialog(null, "Kode anggota sudah ada\nApakah data diupdate?","Konfirmasi", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, arrOpsi, arrOpsi[0]);
        } else {
          sta.close();
          rset.close();

          simpan = true;
          SQLStatemen = "INSERT INTO merk(nama_merk) VALUES ('"+ namaMerk +"')";
          sta = connection.createStatement();
          jumlahSimpan = sta.executeUpdate(SQLStatemen);

          if (simpan) {
    		    if (jumlahSimpan > 0){
    			  JOptionPane.showMessageDialog(null,"Data merk sudah tersimpan",
    			              "Informasi", JOptionPane.INFORMATION_MESSAGE);
      			} else {
      			  adaKesalahan = true;
      			  JOptionPane.showMessageDialog(null,"Gagal menyimpan data anggota",
      			              "Kesalahan", JOptionPane.ERROR_MESSAGE);
      			}
    		  } else {
    		    adaKesalahan = true;
    		  }

        }
      } catch (Exception ex) {
  		  adaKesalahan = true;
  		  JOptionPane.showMessageDialog(null,"Tidak dapat membuka tabel merk\n"
  		              +ex,"Kesalahan", JOptionPane.ERROR_MESSAGE);
  		}
    }
    return !adaKesalahan;
  }

}
