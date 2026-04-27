package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ArrayList<Thread> threads = new ArrayList<>();

        SkladSurovin skladSurovin = new SkladSurovin();
        SkladHotovychProduktu skladHotovychProduktu = new SkladHotovychProduktu(skladSurovin);

        Napojar napojar1 = new Napojar("Bartender1", skladSurovin, skladHotovychProduktu);
        Napojar napojar2 = new Napojar("Bartender2", skladSurovin, skladHotovychProduktu);

        Parkovac parkovac = new Parkovac("Ms. Párkovač", skladSurovin, skladHotovychProduktu);

        MycSklenic mycSklenic = new MycSklenic("Cleaner", skladSurovin, skladHotovychProduktu);

        Cisnik cisnik1 = new Cisnik("Waiter1", skladSurovin, skladHotovychProduktu);
        Cisnik cisnik2 = new Cisnik("Waiter2", skladSurovin, skladHotovychProduktu);

        threads.add(napojar1);
        threads.add(napojar2);
        threads.add(parkovac);
        threads.add(mycSklenic);
        threads.add(cisnik1);
        threads.add(cisnik2);

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
