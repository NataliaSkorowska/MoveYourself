/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.backend;

import java.util.Date;

/**
 *
 * @author deerx
 */
public class Klient {

    public String klient_imie;
    private String klient_nazwisko, klient_email, klient_haslo;
    Date klient_durodzenia = new Date();
    
    public Klient(String klient_imie, String klient_nazwisko, String klient_email, String klient_haslo, Date klient_durodzenia){
        this.klient_imie=klient_imie;
        this.klient_nazwisko=klient_nazwisko;
        this.klient_email=klient_email;
        this.klient_haslo=klient_haslo;
        this.klient_durodzenia=klient_durodzenia;
    }

    public Klient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getKlient_imie() {
        return klient_imie;
    }

    public void setKlient_imie(String klient_imie) {
        this.klient_imie = klient_imie;
    }

    public String getKlient_nazwisko() {
        return klient_nazwisko;
    }

    public void setKlient_nazwisko(String klient_nazwisko) {
        this.klient_nazwisko = klient_nazwisko;
    }

    public String getKlient_email() {
        return klient_email;
    }

    public void setKlient_email(String klient_email) {
        this.klient_email = klient_email;
    }

    public String getKlient_haslo() {
        return klient_haslo;
    }

    public void setKlient_haslo(String klient_haslo) {
        this.klient_haslo = klient_haslo;
    }

    public Date getKlient_durodzenia() {
        return klient_durodzenia;
    }

    public void setKlient_durodzenia(Date klient_durodzenia) {
        this.klient_durodzenia = klient_durodzenia;
    }
    
    
}
