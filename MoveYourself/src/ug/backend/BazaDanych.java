/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.backend;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author deerx
 */
public class BazaDanych {
     public static Connection getConnection(){
         Connection polaczenie = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            polaczenie  = DriverManager.getConnection(
            "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Błąd"+ ex.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
        return polaczenie;
    }
    
     public ArrayList pobierzZajecia(){
        ArrayList<Zajecia> zajecia=new ArrayList();
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection polaczenie = DriverManager.getConnection(
           "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
            
            PreparedStatement ps =polaczenie.prepareStatement("{call dbo.pobierzZajecia}");
            ResultSet rezultat = ps.executeQuery();
            while (rezultat.next()){
               zajecia.add(new Zajecia(rezultat.getString("zajecia_nazwa"),
               rezultat.getString("zajecia_instruktor"),
               rezultat.getString("zajecia_dzien_tygodnia"),
               rezultat.getString("zajecia_godzina")));
           }

            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
         return zajecia;
    }
    
    public void zapiszNaZajecia(int rezerwacja_klient_id, String zajecia_nazwa){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection polaczenie = DriverManager.getConnection(
            "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
            
            CallableStatement procedura = 
                    polaczenie.prepareCall("{call dbo.zapiszNaZajecia(?,?)}");
                    procedura.setInt(1,rezerwacja_klient_id);
                    procedura.setString(2,zajecia_nazwa);
                    procedura.execute();
            

            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList pobierzMojeZajecia(int klient_id){
        ArrayList<Zajecia> mojeZajecia=new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection polaczenie = DriverManager.getConnection(
            "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
            
             CallableStatement procedura = 
                    polaczenie.prepareCall("{call dbo.pobierzMojeZajecia(?)}");
             procedura.setInt(1,klient_id);
             ResultSet rezultat = procedura.executeQuery();
             while (rezultat.next()){
               mojeZajecia.add(new Zajecia(rezultat.getString("zajecia_nazwa"),
               rezultat.getString("zajecia_instruktor"),
               rezultat.getString("zajecia_dzien_tygodnia"),
               rezultat.getString("zajecia_godzina")));
           }
             

            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
        return mojeZajecia;
    }
    
    public void wypiszZZajec(int rezerwacja_klient_id, String zajecia_nazwa){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection polaczenie = DriverManager.getConnection(
            "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
            
            CallableStatement procedura = 
                    polaczenie.prepareCall("{call dbo.wypiszZZajec(?,?)}");
                    procedura.setInt(1,rezerwacja_klient_id);
                    procedura.setString(2,zajecia_nazwa);
                    procedura.execute();
            

            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ArrayList pobierzKlienta(int klient_id){
         ArrayList<Klient> klient=new ArrayList();
          try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection polaczenie = DriverManager.getConnection(
           "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
          
           CallableStatement procedura = 
                    polaczenie.prepareCall("{call dbo.pobierzKlienta(?)}");
             procedura.setInt(1,klient_id);
             ResultSet rezultat = procedura.executeQuery();
             while (rezultat.next()){
               klient.add(new Klient(rezultat.getString("klient_imie"),
               rezultat.getString("klient_nazwisko"),
               rezultat.getString("klient_email"),
               rezultat.getString("klient_haslo"),
               rezultat.getDate("klient_durodzenia")));
           }
            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
          return klient;
    }
    
    public void modyfikujKlienta(int klient_id, String klient_imie, String klient_nazwisko, String klient_email, String klient_haslo, Date klient_dUrodzenia){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection polaczenie = DriverManager.getConnection(
           "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
            java.sql.Date dataUrodzenia = new java.sql.Date(klient_dUrodzenia.getTime());
            CallableStatement procedura = 
                    polaczenie.prepareCall("{call dbo.modyfikujKlienta(?,?,?,?,?,?)}");
                    procedura.setInt(1, klient_id);
                    procedura.setString(2,klient_imie);
                    procedura.setString(3,klient_nazwisko);
                    procedura.setString(4,klient_email);
                    procedura.setString(5,klient_haslo);
                    procedura.setDate(6,dataUrodzenia);
                    procedura.execute();
            
            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void pobierzKlientów(int klient_id, String klient_imie, String klient_nazwisko, String klient_email, String klient_haslo, Date klient_dUrodzenia){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection polaczenie = DriverManager.getConnection(
           "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
            CallableStatement procedura = 
                    polaczenie.prepareCall("{call dbo.pobierzKlientów}");
                    procedura.execute();
            
            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void usunZajecia(String zajecia_nazwa){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection polaczenie = DriverManager.getConnection(
            "jdbc:sqlserver://localhost;databaseName=MoveYourself",
                    "s2232","s2232");
            
            CallableStatement procedura = 
                    polaczenie.prepareCall("{call dbo.usunZajecia(?)}");
                    procedura.setString(1,zajecia_nazwa);
                    procedura.execute();
            

            polaczenie.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                    "Błąd aplikacji", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}


     
    

    

