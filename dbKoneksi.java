package promhs;

import java.sql.DriverManager;
import java.sql.Connection;

public class dbKoneksi {
    String DB_URL = "jdbc:mysql://localhost/tabeldata";
    String USER = "root";
    String PASS = "STIKIINDONESIA12$";
    
    private static Connection koneksi;
    
    public Connection koneksi(){
        if(this.koneksi == null){
            try{
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                this.koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            }catch(Exception e){
                System.out.println("Error saat membuat koneksi ke DBMS");
            }
        }
        return this.koneksi;
    }
}
