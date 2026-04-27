package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkladHotovychProduktu {

    private static final Logger log = LoggerFactory.getLogger(SkladHotovychProduktu.class);

    private SkladSurovin s;

    private int pocetPiv;
    private int pocetLimonad;
    private int pocetParkuVRohliku;

    public SkladHotovychProduktu(SkladSurovin s) {
        this.s = s;
    }

    public synchronized void pridejPivo(int pocet){
        if (pocetPiv + pocet >= 0){
            if (pocetPiv < 3){
                pocetPiv += pocet;
                s.uberPivo();
                s.uberCistySklenice();
            }else{
                log.warn("Zvětralé pivo nikdo nechce je to moc: "+pocetPiv);
            }
        }
    }

    public synchronized void pridejLimonad(int pocet){
        if (pocetLimonad + pocet >= 0){
            if (pocetLimonad < 5){
                pocetLimonad += pocet;
                s.uberLimonady();
                s.uberCistySklenice();
            }else{
                log.warn("ani vyčpělá limonáda by nebyla top");
            }
        }
    }

    public synchronized void pridejParkuVRohliku(int pocet){
        if (pocetParkuVRohliku + pocet >= 0){
            if (pocetParkuVRohliku < 2){
                pocetParkuVRohliku += pocet;
                s.uberParek();
                s.uberRohlik();
            }else{
                log.warn("moc rozblemcají se");
            }
        }
    }

    public int getPocetPiv() {
        return pocetPiv;
    }

    public void setPocetPiv(int pocetPiv) {
        this.pocetPiv = pocetPiv;
    }

    public int getPocetLimonad() {
        return pocetLimonad;
    }

    public void setPocetLimonad(int pocetLimonad) {
        this.pocetLimonad = pocetLimonad;
    }

    public int getPocetParkuVRohliku() {
        return pocetParkuVRohliku;
    }

    public void setPocetParkuVRohliku(int pocetParkuVRohliku) {
        this.pocetParkuVRohliku = pocetParkuVRohliku;
    }
}
