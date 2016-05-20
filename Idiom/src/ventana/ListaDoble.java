package ventana;

public class ListaDoble {
        private Nodo inicio;
        int n=0,nn=0;

    public void setInicio() {        
        this.inicio = null;
        System.gc();
    } 
    public int get(){
        return n;
    }
        

    public ListaDoble() {
        inicio = null;
    }
        public void agregarNodo(String tipo,String info) {
        Nodo nuevo;
        nuevo = new Nodo(null,tipo,info, null);
        if (inicio == null) {
            inicio = nuevo;            
        } else {
            Nodo aux = inicio;
            while (aux.getSigui() != null) {
                aux = aux.getSigui();
            }
            aux.setSigui(nuevo);
            nuevo.setAnte(aux);          
        }
            
    }

        public String getelementos() {
        String cade= "";
        Nodo aux = inicio;        
        while (aux!= null) {
        cade= cade+"<"+aux.getTipo()+", "+aux.getInfo()+">";
        aux=aux.getSigui();
    }
        return cade; 
    }
    public String tipo(){
       String cade="";
       if(n<contarNodos()){
        if (inicio.getSigui() == null) {
            cade=cade+inicio.getTipo();            
        } else {
            Nodo aux = inicio;
            int m=0;
            while (m!=n) {
                aux = aux.getSigui();
                m++;
            }
            cade=cade+aux.getTipo();            
        }
       }
        return cade;
    }
        public String info(){
       String cade="";
       if(n<contarNodos()){
        if (inicio.getSigui() == null) {
            cade=cade+inicio.getInfo();            
        } else {
            Nodo aux = inicio;
            int m=0;
            while (m!=n) {
                aux = aux.getSigui();
                m++;
            }
            cade=cade+aux.getInfo();            
        }
       }
        return cade;
    }
    public void next(){       
       if(n<contarNodos()&&n>=0){           
        if (inicio.getSigui() == null) {            
            n++;
        } else {
            Nodo aux = inicio;
            int m=0;
            while (m!=n) {
                aux = aux.getSigui();
                m++;
            }            
            n++;
        }
       }       
    }
        public String tipo1(){
       String cade="";
       if(nn<=contarNodos()){
        if (inicio.getSigui() == null) {
            cade=cade+inicio.getTipo();            
        } else {
            Nodo aux = inicio;
            int m=0;
            while (m!=nn) {
                aux = aux.getSigui();
                m++;
            }
            cade=cade+aux.getTipo();            
        }
       }
        return cade;
    }
   public String info1(){
       String cade="";
       if(nn<=contarNodos()){
        if (inicio.getSigui() == null) {
            cade=cade+inicio.getInfo();            
        } else {
            Nodo aux = inicio;
            int m=0;
            while (m!=nn) {
                aux = aux.getSigui();
                m++;
            }
            cade=cade+aux.getInfo();            
        }
       }
        return cade;
    }

       public int contarNodos(){
        int cont =0;
        Nodo aux=inicio;
        while(aux!=null){
        cont++;
        aux=aux.getSigui();
        }
        return cont;
    }
     public void next(int c,int d){
      if(c==1){
         nn=n; 
      }if(d==1){   
       if(nn<=contarNodos()&&n>=0){
        if (inicio.getSigui() == null) {            
            n++;
        } else {
            Nodo aux = inicio;
            int m=0;
            while (m!=nn) {
                aux = aux.getSigui();
                m++;
            }            
            nn++;
        }
       }        
    }
  }
}
