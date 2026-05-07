package org.example;

public abstract class Zamestnanec extends Thread{
    private String jmeno;
    private SkladSurovin skladSurovin;
    private SkladHotovychProduktu skladHotovychProduktu;
    private Control control;

    public Zamestnanec(String jmeno, SkladSurovin skladSurovin, SkladHotovychProduktu skladHotovychProduktu, Control control) {
        this.jmeno = jmeno;
        this.skladSurovin = skladSurovin;
        this.skladHotovychProduktu = skladHotovychProduktu;
        this.control = control;
    }

    public SkladSurovin getSkladSurovin() {
        return skladSurovin;
    }

    public void setSkladSurovin(SkladSurovin skladSurovin) {
        this.skladSurovin = skladSurovin;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public SkladHotovychProduktu getSkladHotovychProduktu() {
        return skladHotovychProduktu;
    }

    public void setSkladHotovychProduktu(SkladHotovychProduktu skladHotovychProduktu) {
        this.skladHotovychProduktu = skladHotovychProduktu;
    }

    public Control getControl() {
        return control;
    }
}
