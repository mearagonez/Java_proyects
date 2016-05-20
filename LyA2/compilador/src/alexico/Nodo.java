package alexico;

public class Nodo {
    private String info,tipo;
    private Nodo sigui,ante;

    public Nodo(Nodo ante,String tipo,String info, Nodo sigui) {
        this.info = info;
        this.tipo=tipo;
        this.sigui = sigui;
        this.ante=ante;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

    public String getInfo() {
        return info;
    }

    public String getTipo() {
        return tipo;
    }

    public void setAnte(Nodo ante) {
        this.ante = ante;
    }

    public Nodo getAnte() {
        return ante;
    }


    public Nodo getSigui() {
        return sigui;
    }


    public void setSigui(Nodo sigui) {
        this.sigui = sigui;
    }
    
    
}
