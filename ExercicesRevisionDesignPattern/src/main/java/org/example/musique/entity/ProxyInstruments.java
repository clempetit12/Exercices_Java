package org.example.musique.entity;

public class ProxyInstruments implements Instruments{

    private Instruments instruments;

    public ProxyInstruments(Instruments instruments) {
        this.instruments = instruments;
    }
    @Override
    public String getInstrument() {
        System.out.println("Proxy contrôle");
        return instruments.getInstrument();
    }

    @Override
    public String toString() {
        return "ProxyInstruments{" +
                "instruments=" + instruments +
                '}';
    }
}
