
package alexico;


public class NodoTabla {
       private String valor,tipo,variable;
       private int num;
    private NodoTabla sigui,ante;

    public NodoTabla(NodoTabla ante,int num,String variable,String tipo,String valor, NodoTabla sigui) {
        this.valor = valor;
        this.variable=variable;
        this.tipo=tipo;
        this.sigui = sigui;
        this.ante=ante;
        this.num=num;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public NodoTabla getSigui() {
        return sigui;
    }

    public void setSigui(NodoTabla sigui) {
        this.sigui = sigui;
    }

    public NodoTabla getAnte() {
        return ante;
    }

    public void setAnte(NodoTabla ante) {
        this.ante = ante;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }
 
    
}
