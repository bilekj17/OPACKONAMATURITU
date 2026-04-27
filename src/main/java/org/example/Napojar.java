package org.example;

public class Napojar extends Zamestnanec{

    public Napojar(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu) {
        super(jmeno, skladSurovin, skladHotovychProduktu);
    }

    @Override
    public void run() {
        while (getSkladSurovin().getPocetLitruPiva() != 0 && !interrupted() && getSkladSurovin().getCelkem() < 1000) {
            //připravení nápoje kterého je aktuálně méně
            if (getSkladHotovychProduktu().getPocetLimonad() > getSkladHotovychProduktu().getPocetPiv() && getSkladHotovychProduktu().getPocetPiv() != 3) {
                getSkladHotovychProduktu().pridejPivo(1);
            }else if(getSkladHotovychProduktu().getPocetPiv() > getSkladHotovychProduktu().getPocetLimonad() && getSkladHotovychProduktu().getPocetLimonad() !=5){
                getSkladHotovychProduktu().pridejLimonad(1);
            }
            //pokud je u nápoje dosažen maximální počet připravených kůsu připravuje se druhej
            if (getSkladHotovychProduktu().getPocetLimonad() == 5 && getSkladHotovychProduktu().getPocetPiv() != 3) {
                getSkladHotovychProduktu().pridejPivo(1);
            }
            if (getSkladHotovychProduktu().getPocetPiv() == 3 && getSkladHotovychProduktu().getPocetLimonad() != 5) {
                getSkladHotovychProduktu().pridejLimonad(1);
            }
            //pokud jsou oba nápoje připravené v maximálním množství, nápojář čeká 1s
            if (getSkladHotovychProduktu().getPocetPiv() == 3 && getSkladHotovychProduktu().getPocetLimonad() == 5){
                spinkejHolatko(1000);
            }
            //když se rovnají
            if (getSkladHotovychProduktu().getPocetLimonad() == getSkladHotovychProduktu().getPocetPiv() && getSkladHotovychProduktu().getPocetPiv() != 3) {
                getSkladHotovychProduktu().pridejPivo(1);
            }
            spinkejHolatko(1000);
        }
    }

    public void spinkejHolatko(int time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
