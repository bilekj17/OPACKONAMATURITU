package org.example;

public class MycSklenic extends Zamestnanec{

    public MycSklenic(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu) {
        super(jmeno, skladSurovin, skladHotovychProduktu);
    }

    @Override
    public void run(){
        while(!interrupted()){
            getSkladSurovin().pridejCistySklenice(5);
            if (getSkladSurovin().getPocetCistychSklenic() > 30){
                sleepy(1000);
            }
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
