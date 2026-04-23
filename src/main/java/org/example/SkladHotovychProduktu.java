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
        if (pocetPiv <= 3){
            pocetPiv++;
            s.uberPivo();
            s.uberCistySklenice();
        }else{
            log.warn("Zvětralé pivo nikdo nechce je to moc: "+pocetPiv);
        }
    }

    public synchronized void uberVelkyPivo(){
        pocetPiv--;

    }
}
