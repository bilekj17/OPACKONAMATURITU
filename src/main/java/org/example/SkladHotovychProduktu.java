package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkladHotovychProduktu {

    private static final Logger log = LoggerFactory.getLogger(SkladHotovychProduktu.class);

    SkladSurovin s =  new SkladSurovin();

    private int pocetPiv;
    private int pocetLimonad;
    private int pocetParkuVRohliku;

    public synchronized void pridejPivo(){
        if (pocetPiv < 3){
            pocetPiv++;
            s.uberPivo();
            s.uberCistySklenice();
        }else{
            log.warn("Zvětralé pivo nikdo nechce je to moc: "+pocetPiv);
        }
    }

    public synchronized void pridejLimonad(){
        if (pocetLimonad <= 5){
            pocetLimonad++;
            s.uberLimonady();
            s.uberCistySklenice();
        }else{
            log.warn("ani vyčpělá limonáda by nebyla top");
        }
    }

    public synchronized void pridejParkuVRohliku(){
        if (pocetParkuVRohliku <= 2){
            pocetParkuVRohliku++;
            s.uberParek();
            s.uberRohlik();
        }else{
            log.warn("moc rozblemcají se");
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
