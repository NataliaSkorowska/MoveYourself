/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ug.backend;

/**
 *
 * @author deerx
 */
public class Zajecia {
    private String zajecia_nazwa, zajecia_instruktor, zajecia_dzien_tygodnia, zajecia_godzina;
            
            public Zajecia (String zajecia_nazwa, String zajecia_instruktor, String zajecia_dzien_tygodnia, String zajecia_godzina ){
                this.zajecia_nazwa = zajecia_nazwa;
                this.zajecia_instruktor=zajecia_instruktor;
                this.zajecia_dzien_tygodnia=zajecia_dzien_tygodnia;
                this.zajecia_godzina=zajecia_godzina;
            }

    public String getZajecia_nazwa() {
        return zajecia_nazwa;
    }

    public void setZajecia_nazwa(String zajecia_nazwa) {
        this.zajecia_nazwa = zajecia_nazwa;
    }

    public String getZajecia_instruktor() {
        return zajecia_instruktor;
    }

    public void setZajecia_instruktor(String zajecia_instruktor) {
        this.zajecia_instruktor = zajecia_instruktor;
    }

    public String getZajecia_dzien_tygodnia() {
        return zajecia_dzien_tygodnia;
    }

    public void setZajecia_dzien_tygodnia(String zajecia_dzien_tygodnia) {
        this.zajecia_dzien_tygodnia = zajecia_dzien_tygodnia;
    }

    public String getZajecia_godzina() {
        return zajecia_godzina;
    }

    public void setZajecia_godzina(String zajecia_godzina) {
        this.zajecia_godzina = zajecia_godzina;
    }
            
            
}
