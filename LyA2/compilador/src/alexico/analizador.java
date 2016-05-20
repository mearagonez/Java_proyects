
package alexico;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class analizador {
 String patron=("(Manzana|Zarzamora|Fresa|Durazno|Melon|Sandia|Kiwi|Toronja|Naranja|Uva|Frambuesa|Lima|Granada|Higo|Guayaba|Ciruela|Tamarindo|Datil)|"
         + "([\\'][\\w\\W]+[\\'])|([dce][0-9]+[a-zA-Z0-9]*)|(\\(=)|(\\+1)|(-1)|(-#)|([0-9]+[.][0-9]+)|([/])|"
         + "(\\)=)|([\\(])|([\\)])|([?])|"
         + "(\\-)|([#-]{2})|([!])|([¡])|([&])|([,])|([.])|(==)|([+])|([*])|([=])|([0-9]+)");
 String error=("([@]|[~]|[%]|[\\$]|[\\^]|[<]|[>]|[;]|[:]|[\\{]|[\\}]|[_])|([\\'][\\w\\W]+[\\'])|"
         + "([dce][a-zA-Z]+[0-9]*[a-zA-Z0-9]*)|([A-Z][a-zA-Z0-9]*)|([ab|f-z][a-zA-Z0-9]*)|([0-9]+[a-zA-Z]+[a-zA-Z0-9]*)");
     
ListaDoble ld,e;
StringBuilder Text;
int n=0,m;

    public analizador() {
        ld=new ListaDoble();
        e=new ListaDoble();
    }

    public StringBuilder getText() {
        return Text;
    }
    public String type(int c){
        if(c==1){
         return ld.tipo();
        }else{
          return ld.info();
        }      
    }
     public String type1(int c){
        if(c==1){
         return ld.tipo1();
        }else{
          return ld.info1();
        }      
    }
    public void next(){
        ld.next();
    }     
    
    
    public int getN() {
       int a= ld.get();
        return a;
    }
    public int cnodos(){
        return ld.contarNodos();
    }

    public void after(int c,int d) {
       ld.next(c,d);
    } 
    
public int errorc(StringBuilder text){
this.Text=text;
Text = new StringBuilder(text);
Pattern pat =Pattern.compile(error);
Matcher m= pat.matcher(Text); 

int matchPointer = 0;     
while(m.find(matchPointer)){
       matchPointer= m.end();
       String ca = m.group(2);
       if(ca!=null){           
       }
       String a = m.group(1);
       if(a!=null){
           e.agregarNodo("Error caracter", a);
          Text.replace(m.start(), m.end(), "<c> "+ m.group()+"</c> ");
          matchPointer += 9;
          n++;
       }
       String b =m.group(3);
       if(b!=null){
           e.agregarNodo("Error de variable", b);
          Text.replace(m.start(), m.end(), "<v> "+ m.group()+"</v> ");
          matchPointer += 9; 
          n++;
      }
       String c =m.group(4);
       if(c!=null){
           if(pr(m.group())){               
           }else{
          e.agregarNodo("Error Palabra Reservada", c);
          Text.replace(m.start(), m.end(), "<M> "+ m.group()+"</M> ");
          matchPointer += 9; 
          n++;
           }
       }       
       String d =m.group(5);
       if(d!=null){
          e.agregarNodo("Error Escritura", d);
          Text.replace(m.start(), m.end(), "<L> "+ m.group()+"</L> ");
          matchPointer += 9;
          n++;         
      }
       String f =m.group(6);
       if(f!=null){
          e.agregarNodo("Error Digito", f);
          Text.replace(m.start(), m.end(), "<D> "+ m.group()+"</D> ");
          matchPointer += 9;
          n++;         
      } 

       
}
if(n>0){ 
    JOptionPane.showMessageDialog(null, "Revise su gramatica", "Error", JOptionPane.ERROR_MESSAGE);
}    
return n;
}

 public void lexico(StringBuilder Text){
     Pattern pa =Pattern.compile(patron);
     Matcher matcher= pa.matcher(Text);      
   if(errorc(Text)==0){       
     while(matcher.find()){         
         String a = matcher.group(1);
         if(a!=null){         
          ld.agregarNodo("Palabra reservada", a);
         }         
         String b = matcher.group(3);
         if(b!=null){
             ld.agregarNodo("Variable", b);             
         }
         String c = matcher.group(4);
         if(c!=null){
             ld.agregarNodo("Mayor igual", c);             
         }
         String d = matcher.group(5);
         if(d!=null){
             ld.agregarNodo("Plus 1", d);             
         }
         String e = matcher.group(6);
         if(e!=null){
             ld.agregarNodo("Sub 1",e);
             }
         String f = matcher.group(7);
         if(f!=null){
             ld.agregarNodo("CGato", f);          
         }
         String g = matcher.group(8);
         if(g!=null){
             ld.agregarNodo("Digito R", g);          
         }
         String h = matcher.group(9);
         if(h!=null){
             ld.agregarNodo("Div",h);          
         }
         String l = matcher.group(10);
         if(l!=null){
             ld.agregarNodo("Menor igual",l);          
         }
         String i = matcher.group(11);
         if(i!=null){
             ld.agregarNodo("Mayor",i);          
         }
         String j = matcher.group(12);
         if(j!=null){
             ld.agregarNodo("Menor",j);          
         }
         String m = matcher.group(13);
         if(m!=null){
             ld.agregarNodo("Dif",m);          
         }
         String o = matcher.group(14);
         if(o!=null){
             ld.agregarNodo("Sub",o);          
         }
         String n = matcher.group(15);
         if(n!=null){
             ld.agregarNodo("AGato",n);          
         }
         String q = matcher.group(16);
         if(q!=null){
             ld.agregarNodo("CAdmiracion",q);          
         }
         String r = matcher.group(17);
         if(r!=null){
             ld.agregarNodo("AAdmiracion",r);          
         }
         String s = matcher.group(18);
         if(s!=null){
             ld.agregarNodo("Fin",s);          
         }
         String t = matcher.group(19);
         if(t!=null){
             ld.agregarNodo("Coma",t);          
         }
         String u = matcher.group(20);
         if(u!=null){
             ld.agregarNodo("Punto",u);          
         }
         String v = matcher.group(21);
         if(v!=null){
             ld.agregarNodo("Igual",v);          
         }
         String x = matcher.group(22);
         if(x!=null){
             ld.agregarNodo("Add",x);          
         }
         String z = matcher.group(23);
         if(z!=null){
             ld.agregarNodo("Mul",z);          
         }
         String za = matcher.group(24);
         if(za!=null){
             ld.agregarNodo("Asig",za);          
         }
         String zb = matcher.group(2);
         if(zb!=null){
             ld.agregarNodo("Cade",zb);          
         }
         String zc = matcher.group(25);
         if(zc!=null){
             ld.agregarNodo("Digito E",zc);          
         }

        }    
   }
   
     }
 
 public String imprimircadena(){
     if(n==0){
       return ld.getelementos();  
     }else{
       return e.getelementos();
     }     
 }
 public void eliminar(){
    // ld.eliminarNodos();
     ld.setInicio();
    // e.eliminarNodos();
     e.setInicio();
     n=0;
 }
     public boolean pr(String m){
        boolean a=false;
        if(m.equals("Manzana")||m.equals("Zarzamora")||m.equals("Fresa")||m.equals("Durazno")
                ||m.equals("Melon")||m.equals("Sandia")||m.equals("Kiwi")
                ||m.equals("Toronja")||m.equals("Naranja")||m.equals("Uva")
                ||m.equals("Frambuesa")||m.equals("Lima")||m.equals("Granada")
                ||m.equals("Higo")||m.equals("Guayaba")||m.equals("Kiwi")
                ||m.equals("Ciruela")
                ||m.equals("Tamarindo")||m.equals("Datil")){
            a=true;
        }
        return a;
    }

    void constd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     
}    

