package org.example;

public class Parkovac extends Zamestnanec{
    public Parkovac(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu) {
        super(jmeno, skladSurovin, skladHotovychProduktu);
    }

    @Override
    public void run(){
        while(true){
            if (getSkladHotovychProduktu().getPocetParkuVRohliku() == 2){
                mimimi(6000);
            }
            if (getSkladSurovin().getPocetParku() == 0 || getSkladSurovin().getPocetRohliku() == 0){
                mimimi(5000);
                getSkladSurovin().pridejSurovinySObchodu(10, 10);
            }
        }
    }

    public void mimimi(int time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
