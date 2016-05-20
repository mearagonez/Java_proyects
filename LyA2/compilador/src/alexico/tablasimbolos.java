
package alexico;

public class tablasimbolos {
    private NodoTabla inicio;
    private int num=0;
    private void aumentar(){
        num++;
    }
        public void eliminar() {        
        this.inicio = null;
        System.gc();
    } 
   private void agregarsimbolo(String variable,String tipo,String valor) {
        NodoTabla nuevo;
        nuevo = new NodoTabla(null,num,variable,tipo,valor, null);
        if (inicio == null) {
            inicio = nuevo;
            aumentar();
        } else {
            NodoTabla aux = inicio;
            while (aux.getSigui() != null) {
                aux = aux.getSigui();
            }
            aux.setSigui(nuevo);
            nuevo.setAnte(aux); 
            aumentar();
        }            
    }
   private boolean search(String variable) {
        boolean search=false;
        NodoTabla aux = inicio;        
        while (aux!= null) {
         if(variable.equals(aux.getVariable())){
            search = true;            
        }
        aux=aux.getSigui();        
    }
        return search; 
    } 
   public String getelemento() {
        String cade= "";
        NodoTabla aux = inicio;        
        while (aux!= null) {
        cade= cade+"<"+aux.getVariable()+", "+aux.getTipo()+", "+aux.getValor()+">";
        aux=aux.getSigui();
    }
        return cade; 
    }
   private boolean searchtipo(String variable) {
        boolean search=false;
        NodoTabla aux = inicio;        
        while (aux!= null) {
         if(variable.equals(aux.getVariable())){
            if(aux.getTipo().equals("Zarzamora")||aux.getTipo().equals("Datil")){
                search=true;                
            }
        }
        aux=aux.getSigui();        
    }
        return search; 
    }
   public void check(String variable){
    if(search(variable)){   
       if(searchtipo(variable)){
           ErrorMessage.print("The operation can't be made");
       }
    }else{
         ErrorMessage.print("Variable not inicialized");
    }
   }
   private void addvalor(String variable,String valor) {        
        NodoTabla aux = inicio;        
        while (aux!= null) {
         if(variable.equals(aux.getVariable())){
            aux.setValor(valor);            
        }
        aux=aux.getSigui();        
    }        
    }
   public void var(String variable, String tipo, String valor){
       if(search(variable)){
          ErrorMessage.print("The id has already been declared");
       }else{
           agregarsimbolo(variable, tipo, valor);
       }
   }
   public void val(String variable,String valor){
       if(search(variable)){
           addvalor(variable, valor);
       }else{
           ErrorMessage.print("The id has not been declared");
       }
   }
   private  String obtvalor(String variable){          
        String search="";
        NodoTabla aux = inicio;        
        while (aux!= null) {
         if(variable.equals(aux.getVariable())){
            search = aux.getValor();
        }
        aux=aux.getSigui();       
    }
        return search;    
      }
   public String getvalor(String variable){
          if(search(variable)){
             if(obtvalor(variable).equals("Ny")){
                 ErrorMessage.print("The id has not been inicialized");
             }else{
                 return obtvalor(variable);
             } 
          }else{
              ErrorMessage.print("The id has not been declared");
          }
          return "";
      }
   private  String obttipo(String variable){          
        String search="";
        NodoTabla aux = inicio;        
        while (aux!= null) {
         if(variable.equals(aux.getVariable())){
            search = aux.getTipo();
        }
        aux=aux.getSigui();       
    }
        return search;    
      }
   public String gettipo(String variable){
          if(search(variable)){
             return obttipo(variable) ; 
          }else{
              ErrorMessage.print("The id has not been declared");
          }
          return "";
      }
   private boolean wait(String variable,String type){
     boolean search=false;
        NodoTabla aux = inicio;        
        while (aux!= null) {
         if(variable.equals(aux.getVariable())){
            if(aux.getTipo().equals(type)){
                search=true;                
            }
        }
        aux=aux.getSigui();        
    }
        return search; 
      }   
   public void zarza(String variable, String valor){
       if(search(variable)){
           if(wait(variable,"Zarzamora")){
               if(valor.equals("Manzana")||valor.equals("Durazno")){
                   val(variable,valor);
               }else{
                   ErrorMessage.print("Not same type");
               }
           }
       }else{
           ErrorMessage.print("The id has not been declared");
       }
   }
   public void cade(String variable, String valor,String cadena){
     if(search(variable)){
       if(wait(variable,"Datil")){
               if(valor.equals("Cade")){
                   val(variable,cadena);
               }else{
                   ErrorMessage.print("Not same type");
               }               
           }
   }else{
           ErrorMessage.print("The id has not been declared");
       }
}
   public void exis(String variable){
      if(search(variable)){          
      }else{
          ErrorMessage.print("The id has not been declared");
      } 
   }
}
