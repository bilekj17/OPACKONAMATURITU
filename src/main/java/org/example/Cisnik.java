package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cisnik extends Zamestnanec{

    private static final Logger log = LoggerFactory.getLogger(Cisnik.class);

    public Cisnik(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu) {
        super(jmeno, skladSurovin, skladHotovychProduktu);
    }

    @Override
    public void run(){
        Random rand = ThreadLocalRandom.current();

        while(!interrupted()){
            int random =  rand.nextInt(1, 7);
            if (random == 1){
                if (getSkladHotovychProduktu().getPocetPiv() == 0){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().pridejPivo(-1);
                    log.info("zákazník chce pivo. Počet piv je: "+getSkladHotovychProduktu().getPocetPiv());
                }
            }else if (random == 2){
                if (getSkladHotovychProduktu().getPocetLimonad() == 0){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().pridejLimonad(-1);
                    log.info("zákazník chce limonadu. Počet limonad je: "+getSkladHotovychProduktu().getPocetLimonad());
                }
            }else if (random == 3){
                if (getSkladHotovychProduktu().getPocetParkuVRohliku() == 0){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().pridejParkuVRohliku(-1);
                    log.info("zákazník chce párek v rohlíku. Počet párků v rohlíku je: "+getSkladHotovychProduktu().getPocetParkuVRohliku());
                }
            }else if (random == 4){
                if (getSkladHotovychProduktu().getPocetPiv() < 2 && getSkladHotovychProduktu().getPocetLimonad() == 0){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().pridejPivo(-2);
                    getSkladHotovychProduktu().pridejLimonad(-1);
                    log.info("zákazník chce 2 piva a 1 limonadu. Počet piv je: "+getSkladHotovychProduktu().getPocetPiv()+ " a pocet limonad je: "+getSkladHotovychProduktu().getPocetLimonad());
                }
            }else if (random == 5){
                if (getSkladHotovychProduktu().getPocetLimonad() < 3){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().pridejLimonad(-3);
                    log.info("zákazník chce 3 limonady. Počet limonad je: "+getSkladHotovychProduktu().getPocetLimonad());
                }
            } else if (random == 6){
                log.info("Zákazník je naštvaný prý je draho");
            }
        }
    }

    public void cekej(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
