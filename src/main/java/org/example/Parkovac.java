package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parkovac extends Zamestnanec{

    private static final Logger log = LoggerFactory.getLogger(Parkovac.class);

    public Parkovac(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu, Control control) {
        super(jmeno, skladSurovin, skladHotovychProduktu, control);
    }


    @Override
    public void run(){
        while(!interrupted() && getSkladSurovin().getCelkem() < 1000 && getControl().running){
            if (getSkladSurovin().getPocetParku() > 0 && getSkladSurovin().getPocetRohliku() > 0){
                getSkladHotovychProduktu().pridejParkuVRohliku();
            }
            if (getSkladHotovychProduktu().getPocetParkuVRohliku() == 2){
                mimimi(6000);
                log.info("Párkovač si šel zaběhat");
            }
            if (getSkladSurovin().getPocetParku() == 0 || getSkladSurovin().getPocetRohliku() == 0){
                mimimi(5000);
                log.info("párkovač šel nakoupit došli mu suroviny");
                getSkladSurovin().pridejSurovinySObchodu(10, 10);
            }
            mimimi(1000);
        }
    }

    public void mimimi(int time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
