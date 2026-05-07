package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ArrayList<Thread> threads = new ArrayList<>();

        SkladSurovin skladSurovin = new SkladSurovin();
        SkladHotovychProduktu skladHotovychProduktu = new SkladHotovychProduktu(skladSurovin);
        Control control = new Control();

        Napojar napojar1 = new Napojar("Bartender1", skladSurovin, skladHotovychProduktu, control);
        Napojar napojar2 = new Napojar("Bartender2", skladSurovin, skladHotovychProduktu, control);

        Parkovac parkovac = new Parkovac("Ms. Párkovač", skladSurovin, skladHotovychProduktu, control);

        MycSklenic mycSklenic = new MycSklenic("Cleaner", skladSurovin, skladHotovychProduktu, control);

        Cisnik cisnik1 = new Cisnik("Waiter1", skladSurovin, skladHotovychProduktu, control);
        Cisnik cisnik2 = new Cisnik("Waiter2", skladSurovin, skladHotovychProduktu, control);

        threads.add(napojar1);
        threads.add(napojar2);
        threads.add(parkovac);
        threads.add(mycSklenic);
        threads.add(cisnik1);
        threads.add(cisnik2);

        for (Thread thread : threads) {
            thread.start();
        }

        //while (skladSurovin.getCelkem() < 1000) {
        //    try {
        //        Thread.sleep(100);
        //    } catch (InterruptedException e) {
        //        throw new RuntimeException(e);
        //    }
        //}

        for (Thread thread : threads) {
            //thread.interrupt();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
