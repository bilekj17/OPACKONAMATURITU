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

    public synchronized void pridejPivo(){
        if (pocetPiv>= 0){
            if (pocetPiv < 3){
                pocetPiv++;
                s.uberPivo();
                s.uberCistySklenice();
                log.info("bylo připraveno jedno pivo");
            }else{
                log.warn("počet piv je příliš velký: "+pocetPiv);
            }
        }
    }

    public synchronized void uberPivo(int pocet){
        pocetPiv -= pocet;
    }

    public synchronized void pridejLimonad(){
        if (pocetLimonad>= 0){
            if (pocetLimonad < 5){
                pocetLimonad++;
                s.uberLimonady();
                s.uberCistySklenice();
                log.info("byla připravena jedna limonáda");
            }else{
                log.warn("počet limonád je příliš velký: "+pocetLimonad);
            }
        }
    }

    public synchronized void uberLimonadu(int pocet){
        pocetLimonad -= pocet;
    }

    public synchronized void pridejParkuVRohliku(){
        if (pocetParkuVRohliku >= 0){
            if (pocetParkuVRohliku < 2){
                pocetParkuVRohliku++;
                s.uberParek();
                s.uberRohlik();
                log.info("párek v rohlíku byl vyroben");
            }else{
                log.warn("počet párků v rohlíku je příliš velký: "+pocetParkuVRohliku);
            }
        }
    }

    public synchronized void uberParekVRohliku(int pocet){
        pocetParkuVRohliku -= pocet;
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
