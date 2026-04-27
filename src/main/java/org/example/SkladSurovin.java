package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SkladSurovin {
    private static final Logger log = LoggerFactory.getLogger(SkladSurovin.class);

    private int pocetRohliku = 20;
    private int pocetParku = 20;
    private double pocetLitruPiva = 500;
    private double pocetLitruLimonady = 500;
    private int pocetCistychSklenic = 20;
    private int spinavySklenice;

    private int cenaPiva = 0;
    private int cenaLimonady = 0;
    private int cenaParkuVRohliku = 0;

    public synchronized boolean uberRohlik() {
        if (pocetRohliku > 0){
            pocetRohliku--;
            log.info("Počet rohlíků: {}",pocetRohliku);
        }
        return false;
    }

    public synchronized boolean uberParek() {
        if (pocetParku > 0){
            pocetParku--;
            log.info("Počet párků: {}",pocetParku);
        }
        return false;
    }

    public synchronized void pridejSurovinySObchodu(int addParek, int addRohlik){
        pocetRohliku += addParek;
        pocetParku += addRohlik;

        log.info("Počet párků: {}, Počet rohlíků: {}", pocetParku, pocetRohliku);
    }

    public synchronized void platbaZaPivo(int pocet){
       cenaPiva += pocet * 40;
    }

    public synchronized void platbaZaLimonady(int pocet){
        cenaLimonady += pocet * 25;
    }

    public synchronized void platbaZaParekVRohliku(int pocet){
        cenaParkuVRohliku += pocet * 30;
    }

    public synchronized boolean uberPivo() {
        if (pocetLitruPiva > 0.5){
            pocetLitruPiva -= 0.5;
            log.info("Počet litrů piva: {}",pocetLitruPiva);
        }
        return false;
    }

    public synchronized boolean uberLimonady() {
        if (pocetLitruLimonady > 0.5){
            pocetLitruLimonady -= 0.5;
            log.info("Počet litrů limonády: {}",pocetLitruLimonady);
        }
        return false;
    }

    public synchronized boolean uberCistySklenice() {
        if (pocetCistychSklenic > 0){
            pocetCistychSklenic--;
            spinavySklenice++;
            log.info("Počet špinavých sklenic: {}",spinavySklenice);
        }
        return false;
    }

    public synchronized void pridejCistySklenice(int addCistychSklenic) {
        pocetCistychSklenic += addCistychSklenic;
        spinavySklenice -= addCistychSklenic;
        log.info("Počet čistých sklenic: {}",pocetCistychSklenic);
    }

    public synchronized int getCelkem(){
        return cenaPiva + cenaLimonady + cenaParkuVRohliku;
    }


    public int getPocetRohliku() {
        return pocetRohliku;
    }

    public void setPocetRohliku(int pocetRohliku) {
        this.pocetRohliku = pocetRohliku;
    }

    public int getPocetParku() {
        return pocetParku;
    }

    public void setPocetParku(int pocetParku) {
        this.pocetParku = pocetParku;
    }

    public double getPocetLitruPiva() {
        return pocetLitruPiva;
    }

    public void setPocetLitruPiva(int pocetLitruPiva) {
        this.pocetLitruPiva = pocetLitruPiva;
    }

    public double getPocetLitruLimonady() {
        return pocetLitruLimonady;
    }

    public void setPocetLitruLimonady(int pocetLitruLimonady) {
        this.pocetLitruLimonady = pocetLitruLimonady;
    }

    public int getPocetCistychSklenic() {
        return pocetCistychSklenic;
    }

    public void setPocetCistychSklenic(int pocetCistychSklenic) {
        this.pocetCistychSklenic = pocetCistychSklenic;
    }

    public int getCenaPiva() {
        return cenaPiva;
    }

    public void setCenaPiva(int cenaPiva) {
        this.cenaPiva = cenaPiva;
    }

    public int getCenaLimonady() {
        return cenaLimonady;
    }

    public void setCenaLimonady(int cenaLimonady) {
        this.cenaLimonady = cenaLimonady;
    }

    public int getCenaParkuVRohliku() {
        return cenaParkuVRohliku;
    }

    public void setCenaParkuVRohliku(int cenaParkuVRohliku) {
        this.cenaParkuVRohliku = cenaParkuVRohliku;
    }
}
