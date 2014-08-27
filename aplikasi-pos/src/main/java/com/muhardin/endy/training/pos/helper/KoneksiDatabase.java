package com.muhardin.endy.training.pos.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KoneksiDatabase {
    private static final String DATABASE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String DATABASE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DATABASE_USERNAME = "pelatihan";
    private static final String DATABASE_PASSWORD = "1";
    
    public static Connection bukaKoneksi() throws SQLException {
        Connection koneksi = null;
        try {
        // 1. Inisialisasi driver database
        Class.forName(DATABASE_DRIVER);
        
        // 2. Connect ke database
            koneksi = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pelatihan", "1");
 //                   .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // 3. Return ke pemanggil method
        return koneksi;
    }
    
    public static void tutupKoneksi(Connection c){
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
