package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MycSklenic extends Zamestnanec{

    private static final Logger log = LoggerFactory.getLogger(MycSklenic.class);

    public MycSklenic(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu, Control control) {
        super(jmeno, skladSurovin, skladHotovychProduktu, control);
    }


    @Override
    public void run(){
        while(!interrupted() && getSkladSurovin().getCelkem() < 1000 && getControl().running){
            if (getSkladSurovin().getSpinavySklenice() >= 5){
                getSkladSurovin().pridejCistySklenice(5);
            }
            if (getSkladSurovin().getPocetCistychSklenic() > 30){
                sleepy(1000);
                log.info("myč si šel odpočinout");
            }
            sleepy(1000);
        }
    }

    public void sleepy(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
