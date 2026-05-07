package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cisnik extends Zamestnanec{

    private static final Logger log = LoggerFactory.getLogger(Cisnik.class);

    public Cisnik(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu, Control control) {
        super(jmeno, skladSurovin, skladHotovychProduktu, control);
    }


    @Override
    public void run(){
        Random rand = ThreadLocalRandom.current();

        while(!interrupted() && getSkladSurovin().getCelkem() < 1000 && getControl().running){
            int random =  rand.nextInt(1, 10);
            if (random == 1){
                if (getSkladHotovychProduktu().getPocetPiv() <= 0){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().uberPivo(1);
                    getSkladSurovin().platbaZaPivo(1);
                    log.info("V kase je: "+getSkladSurovin().getCelkem());
                    log.info("zákazník chce pivo. Počet piv je: "+getSkladHotovychProduktu().getPocetPiv());
                    log.info("zákazník byl obsloužen");
                }
            }else if (random == 2){
                if (getSkladHotovychProduktu().getPocetLimonad() <= 0){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().uberLimonadu(1);
                    getSkladSurovin().platbaZaLimonady(1);
                    log.info("V kase je: "+getSkladSurovin().getCelkem());
                    log.info("zákazník chce limonadu. Počet limonad je: "+getSkladHotovychProduktu().getPocetLimonad());
                    log.info("zákazník byl obsloužen");
                }
            }else if (random == 3){
                if (getSkladHotovychProduktu().getPocetParkuVRohliku() <= 0){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().uberParekVRohliku(1);
                    getSkladSurovin().platbaZaParekVRohliku(1);
                    log.info("V kase je: "+getSkladSurovin().getCelkem());
                    log.info("zákazník chce párek v rohlíku. Počet párků v rohlíku je: "+getSkladHotovychProduktu().getPocetParkuVRohliku());
                }
            }else if (random == 4){
                if (getSkladHotovychProduktu().getPocetPiv() < 2 || getSkladHotovychProduktu().getPocetLimonad() <= 0){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().uberPivo(2);
                    getSkladSurovin().platbaZaPivo(2);
                    getSkladHotovychProduktu().uberLimonadu(1);
                    getSkladSurovin().platbaZaLimonady(1);
                    log.info("V kase je: "+getSkladSurovin().getCelkem());
                    log.info("zákazník chce 2 piva a 1 limonadu. Počet piv je: "+getSkladHotovychProduktu().getPocetPiv()+ " a pocet limonad je: "+getSkladHotovychProduktu().getPocetLimonad());
                    log.info("zákazník byl obsloužen");
                }
            }else if (random == 5){
                if (getSkladHotovychProduktu().getPocetLimonad() < 3){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().uberLimonadu(3);
                    getSkladSurovin().platbaZaLimonady(3);
                    log.info("V kase je: "+getSkladSurovin().getCelkem());
                    log.info("zákazník chce 3 limonady. Počet limonad je: "+getSkladHotovychProduktu().getPocetLimonad());
                    log.info("zákazník byl obsloužen");
                }
            } else if (random == 6){
                log.info("Zákazník je naštvaný prý je draho");
            } else if (random == 7){
                if (getSkladHotovychProduktu().getPocetPiv() < 3 || getSkladHotovychProduktu().getPocetLimonad() < 4 || getSkladHotovychProduktu().getPocetParkuVRohliku() < 2){
                    cekej(1000);
                }else{
                    getSkladHotovychProduktu().uberPivo(3);
                    getSkladSurovin().platbaZaPivo(3);
                    getSkladHotovychProduktu().uberLimonadu(4);
                    getSkladSurovin().platbaZaLimonady(4);
                    getSkladHotovychProduktu().uberParekVRohliku(2);
                    getSkladSurovin().platbaZaParekVRohliku(2);
                    log.info("V kase je: "+getSkladSurovin().getCelkem());
                    log.info("Počet piv je: {} Počet limonad je: {} Počet párků v rohlíku je: {}", getSkladHotovychProduktu().getPocetPiv(), getSkladHotovychProduktu().getPocetLimonad(), getSkladHotovychProduktu().getPocetParkuVRohliku());
                    log.info("zákazník byl obsloužen");
                }
            } else if (random == 8) {
                int kradez = rand.nextInt(1,4);
                if (kradez == 1){
                    log.info("zloděj byl chycen o nic jsme nepřišli");
                }else if (kradez == 2 || kradez == 3){
                    log.info("Zloděj unikl vše bylo straceno");
                    getSkladSurovin().kradezPenez();
                }
            }else if (random == 9){
                int dest =  rand.nextInt(1,4);
                if (dest == 1){
                    log.info("déšť ustal restaurace zůstává v provozu");
                }else if (dest == 2 || dest == 3){
                    getControl().running = false;
                    log.info("PRŠÍ ZAVÍRÁME");
                }
            }
            cekej(1000);
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
