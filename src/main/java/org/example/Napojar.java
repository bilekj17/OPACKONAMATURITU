package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Napojar extends Zamestnanec{

    private static final Logger log = LoggerFactory.getLogger(Napojar.class);

    private int pivLimit = 3;
    private int limLimit = 5;

    public Napojar(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu, Control control) {
        super(jmeno, skladSurovin, skladHotovychProduktu, control);
    }


    @Override
    public void run() {
        while (getSkladSurovin().getPocetLitruPiva() != 0 && !interrupted() && getSkladSurovin().getCelkem() < 1000 && getControl().running) {
            int pivaCount = getSkladHotovychProduktu().getPocetPiv();
            int limonadyCount = getSkladHotovychProduktu().getPocetLimonad();

            if (pivaCount < pivLimit && limonadyCount < limLimit) {

                // both can increase
                if (pivaCount < limonadyCount) {
                    getSkladHotovychProduktu().pridejPivo();
                } else if (limonadyCount < pivaCount) {
                    getSkladHotovychProduktu().pridejLimonad();
                } else {
                    // equal counts
                    getSkladHotovychProduktu().pridejPivo(); // or getSkladHotovychProduktu().pridejLimonad(), your choice
                }

            } else if (pivaCount < pivLimit) {

                // only A can increase
                getSkladHotovychProduktu().pridejPivo();

            } else if (limonadyCount < limLimit) {

                // only B can increase
                getSkladHotovychProduktu().pridejLimonad();
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
