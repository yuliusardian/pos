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
          JOptionPane.showOptionDialog(null, "Kode anggota sudah ada\nApakah data diupdate ?", "Konfirmasi", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, arrOpsi, arrOpsi[0]);
        } else {
          sta.close();
          rset.close();

          simpan = true;
          SQLStatemen = "INSERT INTO merk(nama_merk) VALUES ('"+ namaMerk +"')";
          sta = connection.createStatement();
          jumlahSimpan = sta.executeUpdate(SQLStatemen);

          if (simpan) {
    		    if (jumlahSimpan > 0){
    			  JOptionPane.showMessageDialog(null,"Data merk sudah tersimpan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
      			} else {
      			  adaKesalahan = true;
      			  JOptionPane.showMessageDialog(null,"Gagal menyimpan data merk", "Kesalahan", JOptionPane.ERROR_MESSAGE);
      			}
    		  } else {
    		    adaKesalahan = true;
    		  }

        }
      } catch (Exception ex) {
  		  adaKesalahan = true;
  		  JOptionPane.showMessageDialog(null,"Tidak dapat membuka tabel merk\n"+ex,"Kesalahan", JOptionPane.ERROR_MESSAGE);
  		}
    }
    return !adaKesalahan;
  }

  public void hapus(String idMerk){
    JOptionPane.showMessageDialog(null,"Hapus ini : \n"+idMerk,"Kesalahan",JOptionPane.ERROR_MESSAGE);
  }


  public Object[][] bacaData() {
    boolean adaKesalahan = false;
    Object[][] merkList = new Object[0][0];

    Connection connection;
    if ((connection = koneksi.getConnection()) != null) {
	    try {
        String SQLStatemen = "SELECT merk_id,nama_merk FROM merk";
        Statement sta = connection.createStatement();
        ResultSet rset = sta.executeQuery(SQLStatemen);

        rset.next();
        rset.last();
        if (rset.getRow()>0) {
          merkList = new Object[rset.getRow()][2];
          rset.first();
          int i=0;
          do {
            merkList[i] = new Object[]{rset.getString("merk_id"),rset.getString("nama_merk")};
            i++;
          } while (rset.next());
		    }

  		  sta.close();
  		  rset.close();
      } catch (Exception ex){
  		  adaKesalahan = true;
  		  JOptionPane.showMessageDialog(null,"Tidak dapat membuka tabel merk\n"+ex,"Kesalahan",JOptionPane.ERROR_MESSAGE);
  		}
    } else {
      adaKesalahan = true;
      JOptionPane.showMessageDialog(null,"Tidak dapat melakukan koneksi ke server\n"+koneksi.getPesanKesalahan(),"Kesalahan",JOptionPane.ERROR_MESSAGE);
    }

  	return merkList;
  }


}
