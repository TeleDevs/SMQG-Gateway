package io.bytehala.eclipsemqtt.sample;

public class Coletas {
    private String idGateway;
    private String id;
    private String temp;
    private String umi;
    private String data;

    public Coletas(String idGateway, String id, String temp, String umi, String data) {
        this.idGateway = idGateway;
        this.id = id;
        this.temp = temp;
        this.umi = umi;
        this.data = data;
    }

    public Coletas(String id, String temp, String umi) {
        this.id = id;
        this.temp = temp;
        this.umi = umi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getUmi() {
        return umi;
    }

    public void setUmi(String umi) {
        this.umi = umi;
    }

    @Override
    public String toString() {
        return "{\"idGateway\":" + idGateway + ",\"idSensor\":" + id + ",\"temperature\":" +
               temp + ",\"humidity\":" + umi + ",\"datetime\":" + data + '}';
    }
}
