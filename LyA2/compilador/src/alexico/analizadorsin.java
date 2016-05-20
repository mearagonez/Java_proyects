package alexico;
import java.util.ArrayList;
public class analizadorsin {
analizador lexico;
tablasimbolos tabla;
ScientificCalculator rp; 
String variable="",tipo="",id="",infix="", cadena="";
boolean debug = false;
ArrayList<String> asPostfix ;
 private int saber=0;
  public analizadorsin(StringBuilder text) {        
        lexico = new analizador();
        tabla = new tablasimbolos();
        lexico.lexico(text);
        rp = new ScientificCalculator(debug);
    }
  private void asig(String name){
      variable=name;
  }
  private void asigt(String tipos){
      tipo=tipos;
  }
  private void id(String name){
      id=name;
  }
  private void real(){
      saber=1;
  }
  private void resetsaber(){
      saber=0;
  }
  public String imprimir(){
      return lexico.imprimircadena();
  }
  public String tablasim(){
      return tabla.getelemento();
  }
  public StringBuilder getText() {
        return lexico.Text;
    }
  public void eliminar(){
        lexico.eliminar();
        cadena="";
        tabla.eliminar();
    }
  private boolean finish(){
      boolean a = false;
      if(lexico.getN()==lexico.cnodos()){
          a=true;
      }      
      return a;
  }
  public void init(){
        if(lexico.getN()==0){
            start();           
        }
    }    
  private void constDeclaration () {
    if (lexico.type(1).equals("Variable")) {
        asig(lexico.type(0));
        lexico.next();
      if (lexico.type(1).equals("Asig")) {
          lexico.next();
        if (lexico.type(1).equals("Digito E")){
            tabla.var(variable,"Frambuesa",lexico.type(0));            
             lexico.next();
        }else{
          ErrorMessage.print ("Integer expected");
        }
      }
      else ErrorMessage.print ("= expected");
    }
    else ErrorMessage.print ( "id expected");
  }
  private void dobleDeclaration () {
    if (lexico.type(1).equals("Variable")) {
        asig(lexico.type(0));
        lexico.next();
      if (lexico.type(1).equals("Asig")) {
          lexico.next();
        if (lexico.type(1).equals("Digito R")||lexico.type(1).equals("Digito E")){
            tabla.var(variable,"Toronja",lexico.type(0));            
             lexico.next();
        }else{
          ErrorMessage.print ("Dobule expected");
        }
      }
      else ErrorMessage.print ("= expected");
    }
    else ErrorMessage.print ( "id expected");
  }
  private void stringDeclaration () {
    if (lexico.type(1).equals("Variable")) {
        asig(lexico.type(0));
        lexico.next();
      if (lexico.type(1).equals("Asig")) {
          lexico.next();
        if (lexico.type(1).equals("Cade")){
            tabla.var(variable,"Datil",lexico.type(0));            
             lexico.next();
        }else{
          ErrorMessage.print ("Cade expected");
        }
      }
      else ErrorMessage.print ("= expected");
    }
    else ErrorMessage.print ( "id expected");
  } 
  private void bolDeclaration () {
    if (lexico.type(1).equals("Variable")) {
        asig(lexico.type(0));
        lexico.next();
      if (lexico.type(1).equals("Asig")) {
          lexico.next();
        if (lexico.type(1).equals("Manzana")||lexico.type(1).equals("Durazno")){
            tabla.var(variable,"Zarzamora",lexico.type(0));            
             lexico.next();
        }else{
          ErrorMessage.print ("Manzana or Durazno expected");
        }
      }
      else ErrorMessage.print ("= expected");
    }
    else ErrorMessage.print ( "id expected");
  }   
  private void constd(){
      if (lexico.type(1).equals("Variable")){
          tabla.var(lexico.type(0),tipo,"Ny");
          lexico.next();
      }else{
          ErrorMessage.print ( "id expected");
      }  
  } 
  private void declaracioni(){
    while(lexico.type(0).equals("Frambuesa")||lexico.type(0).equals("Toronja")||lexico.type(0).equals("Datil")||lexico.type(0).equals("Zarzamora")) {
      if (lexico.type(0).equals("Frambuesa")) {          
          lexico.after(1,1);          
          if(lexico.type1(1).equals("Variable")) {
              lexico.after(0,1);              
           if(lexico.type1(1).equals("Fin")||lexico.type1(1).equals("Coma")){    
               lexico.next();
               asigt("Frambuesa");
               constd();
           }else{              
              lexico.next();
              constDeclaration(); 
           }           
          }else{
          ErrorMessage.print("Id expected");
          }      
       while (lexico.type(1).equals("Coma")) {
         lexico.after(1,1);          
          if(lexico.type1(1).equals("Variable")) {
              lexico.after(0,1);              
           if(lexico.type1(1).equals("Fin")||lexico.type1(1).equals("Coma")){    
               lexico.next();
               asigt("Frambuesa");
               constd();
           }else{              
              lexico.next();
              constDeclaration(); 
           }           
          }else{
          ErrorMessage.print("Id expected");
          }   
       }
      if (lexico.type(1).equals("Fin")) 
            lexico.next();
      else 
        ErrorMessage . print ( ", OR ; EXPECTED");
    }
    if (lexico.type(0).equals("Toronja")) {          
          lexico.after(1,1);          
          if(lexico.type1(1).equals("Variable")) {
              lexico.after(0,1);              
           if(lexico.type1(1).equals("Fin")||lexico.type1(1).equals("Coma")){    
               lexico.next();
               asigt("Toronja");
               constd();
           }else{              
              lexico.next();
              dobleDeclaration(); 
           }           
          }else{
          ErrorMessage.print("Id expected");
          }      
       while (lexico.type(1).equals("Coma")) {
         lexico.after(1,1);          
          if(lexico.type1(1).equals("Variable")) {
              lexico.after(0,1);              
           if(lexico.type1(1).equals("Fin")||lexico.type1(1).equals("Coma")){    
               lexico.next();
               asigt("Toronja");
               constd();
           }else{              
              lexico.next();
              dobleDeclaration(); 
           }           
          }else{
          ErrorMessage.print("Id expected");
          }   
       }
      if (lexico.type(1).equals("Fin")) 
            lexico.next();
      else 
        ErrorMessage . print ( ", OR & EXPECTED");
    }      if (lexico.type(0).equals("Datil")) {          
          lexico.after(1,1);          
          if(lexico.type1(1).equals("Variable")) {
              lexico.after(0,1);              
           if(lexico.type1(1).equals("Fin")||lexico.type1(1).equals("Coma")){    
               lexico.next();
               asigt("Datil");
               constd();
           }else{              
              lexico.next();
              stringDeclaration(); 
           }           
          }else{
          ErrorMessage.print("Id expected");
          }      
       while (lexico.type(1).equals("Coma")) {
         lexico.after(1,1);          
          if(lexico.type1(1).equals("Variable")) {
              lexico.after(0,1);              
           if(lexico.type1(1).equals("Fin")||lexico.type1(1).equals("Coma")){    
               lexico.next();
               asigt("Datil");
               constd();
           }else{              
              lexico.next();
              stringDeclaration();  
           }           
          }else{
          ErrorMessage.print("Id expected");
          }   
       }
      if (lexico.type(1).equals("Fin")) 
            lexico.next();
      else 
        ErrorMessage . print ( ", OR & EXPECTED");
    }if (lexico.type(0).equals("Zarzamora")) {          
          lexico.after(1,1);          
          if(lexico.type1(1).equals("Variable")) {
              lexico.after(0,1);              
           if(lexico.type1(1).equals("Fin")||lexico.type1(1).equals("Coma")){    
               lexico.next();
               asigt("Zarzamora");
               constd();
           }else{              
              lexico.next();
              bolDeclaration(); 
           }           
          }else{
          ErrorMessage.print("Id expected");
          }      
       while (lexico.type(1).equals("Coma")) {
         lexico.after(1,1);          
          if(lexico.type1(1).equals("Variable")) {
              lexico.after(0,1);              
           if(lexico.type1(1).equals("Fin")||lexico.type1(1).equals("Coma")){    
               lexico.next();
               asigt("Zarzamora");
               constd();
           }else{              
              lexico.next();
              bolDeclaration();  
           }           
          }else{
          ErrorMessage.print("Id expected");
          }   
       }
      if (lexico.type(1).equals("Fin")) 
            lexico.next();
      else 
        ErrorMessage . print ( ", OR & EXPECTED");
    }   
  }

  } 
  private void condicion(){
     if(lexico.type(0).equals("Tamarindo")){
         lexico.next();
            if(lexico.type(1).equals("AGato")){
                lexico.next();
                condition();
               if(lexico.type(1).equals("CGato")){
                  lexico.next();
                     if(lexico.type(1).equals("AAdmiracion")){
                        lexico.next();                                   
                        cuerpo();
                        if(lexico.type(1).equals("CAdmiracion")){
                          lexico.next();
                         }else{
                         ErrorMessage.print("Expecting ! ");
                        }
                     }else{
                     ErrorMessage.print("Expecting ¡ ");   
                    }
                }else{
                  ErrorMessage.print("Expecting -#");  
                }
            }else{
               ErrorMessage.print("Expecting #-");  
            } 
     } 
  }
  private void condition(){
      if(lexico.type(1).equals("Variable")||lexico.type(1).equals("Digito R")||lexico.type(1).equals("Digito E")){
                    checar();
                   lexico.next();
                   if(lexico.type(1).equals("Mayor")||lexico.type(1).equals("Menor")||lexico.type(1).equals("Menor igual")||lexico.type(1).equals("Dif")||lexico.type(1).equals("Mayor igual")||lexico.type(1).equals("Igual")){
                       lexico.next();
                       if(lexico.type(1).equals("Variable")||lexico.type(1).equals("Digito R")||lexico.type(1).equals("Digito E")){
                           checar();
                           lexico.next();
                       }else{
                           ErrorMessage.print("Expecting Id or Digit");
                       }
                   }else{
                      ErrorMessage.print("Expecting Conditions");  
                   }
                }else{
                    ErrorMessage.print("Expecting Id or Digit"); 
                }
  }
  private void condielse(){      
 if(lexico.type(0).equals("Uva")){
         lexico.next();
            if(lexico.type(1).equals("AGato")){
                lexico.next();
                condition();
               if(lexico.type(1).equals("CGato")){
                  lexico.next();
                     if(lexico.type(1).equals("AAdmiracion")){
                        lexico.next();                                   
                        cuerpo();
                        if(lexico.type(1).equals("CAdmiracion")){
                          lexico.next();
                          if(lexico.type(0).equals("Melon")){
                              lexico.next();
                              if(lexico.type(1).equals("AAdmiracion")){
                                  lexico.next();
                                  cuerpo();
                                  if(lexico.type(1).equals("CAdmiracion")){
                                      lexico.next();
                                  }else{
                                      ErrorMessage.print("Expecting ! ");
                                  }
                              }else{
                                  ErrorMessage.print("Expecting ¡ ");  
                              }
                          }
                         }else{
                         ErrorMessage.print("Expecting ! ");
                        }
                     }else{
                     ErrorMessage.print("Expecting ¡ ");   
                    }
                }else{
                  ErrorMessage.print("Expecting -#");  
                }
            }else{
               ErrorMessage.print("Expecting #-");  
            } 
     }
  }
  private void condfor(){
      if(lexico.type(0).equals("Naranja")){
          lexico.next();
          if(lexico.type(1).equals("AGato")){
              lexico.next();
              constDeclaration();
              if(lexico.type(1).equals("Coma")){
                  lexico.next();
                  condition();
                  if(lexico.type(1).equals("Coma")){
                      lexico.next();
                      if(lexico.type(1).equals("Plus 1")||lexico.type(1).equals("Sub 1")){
                          lexico.next();
                          if(lexico.type(1).equals("CGato")){
                              lexico.next();
                            if(lexico.type(1).equals("AAdmiracion")){
                                lexico.next();                                   
                                cuerpo();
                                 if(lexico.type(1).equals("CAdmiracion")){
                                    lexico.next();
                                  }else{
                                    ErrorMessage.print("Expecting ! ");
                                    }   
                             }else{
                                ErrorMessage.print("Expecting ¡ ");   
                              }                              
                          }else{
                             ErrorMessage.print("Expected -#");  
                          }
                      }else{
                         ErrorMessage.print("Expected +1 or -1");  
                      }
                  }else{
                     ErrorMessage.print("Expected ,");  
                  }
              }else{
                 ErrorMessage.print("Expected ,"); 
              }
          }else{
              ErrorMessage.print("Expected #-");
          }
      }
  }
  private void cuerpo(){
      if(lexico.type(0).equals("Uva")||lexico.type(0).equals("Tamarindo")||lexico.type(0).equals("Naranja")||lexico.type(1).equals("Variable")){
         if( lexico.type(0).equals("Uva")){             
             condielse();
             cuerpo();
         }if(lexico.type(0).equals("Tamarindo")){
             condicion();
             cuerpo();
         }if(lexico.type(0).equals("Naranja")){
             condfor();
             cuerpo();
         }if(lexico.type(1).equals("Variable")){
             tabla.exis(lexico.type(0));
             asig(lexico.type(0));
             lexico.next();
             if(lexico.type(1).equals("Asig")){
                 lexico.next();
                 idstart();
                 is();
                 if(lexico.type(1).equals("Fin")){
                     postfix(infix);
                     tabla.val(variable,resultado());
                     clear();
                     lexico.next();
                 }else{
                     ErrorMessage.print("Expecting &");
                 }
             }else{
                 ErrorMessage.print("Expecting  = ");
             }
             cuerpo();
         }         
      }      
  }
  private void inicio(){
      if(lexico.type(0).equals("Guayaba")||lexico.type(0).equals("Higo")||lexico.type(0).equals("Granada")){
          lexico.next();
          if(lexico.type(0).equals("Fresa")||lexico.type(0).equals("Ciruela")){
              if(lexico.type(0).equals("Fresa")){
                 lexico.next();
                 if(lexico.type(0).equals("Ciruela")){
                     lexico.next();
                     if(lexico.type(1).equals("Variable")){
                         tabla.var(lexico.type(0),"Class","No valor");
                         lexico.next();
                         if(lexico.type(1).equals("AAdmiracion")){
                             lexico.next();                             
                         }else{
                           ErrorMessage.print("Especting ¡");  
                         }                         
                     }else{
                       ErrorMessage.print("Expecting Id");  
                     }
                 }else{
                    ErrorMessage.print("Expecting Ciruela");  
                 }
              }else{
                  lexico.next();
                   if(lexico.type(1).equals("Variable")){
                         lexico.next();
                         if(lexico.type(1).equals("AAdmiracion")){
                             lexico.next();                             
                         }else{
                           ErrorMessage.print("Expecting ¡");  
                         }                         
                     }else{
                       ErrorMessage.print("Expecting Id");                   
                      }
              }
        }else{
            ErrorMessage.print("Expecting Fresa o Ciruela");  
          }
  }else{
          ErrorMessage.print("Error de iniciar programa");
      }
  }  
  private void start(){
   inicio();
   declaracioni();      
   cuerpo();      
   end();      
  }
  private void end(){
      if(lexico.type(1).equals("CAdmiracion")){
          lexico.next();
          if(finish()){              
          }else{
             ErrorMessage.print("More nodos"); 
          }
      }else{
          ErrorMessage.print("Expecting ! to finish");
      }
  }
  private void idstart(){
      if(lexico.type(1).equals("Fin")){
          ErrorMessage.print("Expecting Ecuation");
      }if(lexico.type(0).equals("Manzana")||lexico.type(0).equals("Durazno")||lexico.type(1).equals("Cade")){
          tabla.zarza(variable,lexico.type(0));
          tabla.cade(variable,lexico.type(1),lexico.type(0));
             lexico.next();
       }if(lexico.type(1).equals("Digito R")||lexico.type(1).equals("Digito E")||lexico.type(1).equals("Variable")){              
              e();
       }      
  }
  private void e(){
      t();
      while (lexico.type(1).equals("Add")||lexico.type(1).equals("Sub")) {
      addlex(lexico.type(0));
      lexico.next();
      t(); 
    }
  }
  private void t(){
      f();
      while (lexico.type(1).equals("Div")||lexico.type(1).equals("Mul")) {         
      multi();
      addlex(lexico.type(0));
      lexico.next();
      t(); 
    }
      
  }
  private void f(){
    switch (lexico.type(1)) {
        case "Digito R":
            real();
            addlex(lexico.type(0));
            lexico.next();
            break;
        case "Digito E":
            addlex(lexico.type(0));
            lexico.next();
            break;
        case "Variable":
            id(lexico.type(0));
            obtenertipo();
            addlex(tabla.getvalor(lexico.type(0)));
            lexico.next();
            break;
        case "AGato":
            addlex("(");
            lexico.next();
            e();
            if(lexico.type(1).equals("CGato")){
                addlex(")");
                lexico.next();
            }else{
                ErrorMessage.print ("Expecting -#");
            } break;
        default:
            ErrorMessage.print ("UNRECOGNIZABLE SYMBOL");
            break;
    }
  }
  private void checar(){
      if(lexico.type(1).equals("Variable")){
          tabla.check(lexico.type(0));
          tabla.getvalor(lexico.type(0));
      }
  }
  private void multi(){
      if(lexico.type(1).equals("Div")){
          real();
      }
  }
  private String saberti(){
      if(saber==0){
          return "Frambuesa";
      }else{
          return "Toronja";
      }
  }
  private void obtenertipo(){
      checar();
      if(tabla.gettipo(id).equals("Toronja")){
          real();
      }
  }      
  private void igual(){
      if(tabla.gettipo(variable).equals("Frambuesa")){
          if(saberti().equals("Toronja")){
              ErrorMessage.print("Type invalid");
          }
      }if(tabla.gettipo(variable).equals("Toronja")){
          if(saberti().equals("Toronja")||saberti().equals("Frambuesa")){              
          }
      }
  }
  private void is(){
      igual();
      resetsaber();
  }
  private void addlex(String add){
      infix=infix+add;
  }
  private void clear(){
      infix="";
  }
  private void postfix(String parseMe){
      parseMe=infix;
      asPostfix =  rp.infixToPostfix(parseMe);
      String asPostfix_str = asPostfix.toString().replaceAll(",", " " ) ;
      asPostfix_str = asPostfix_str.substring(1, asPostfix_str.length()-1 ) ;
      rp.parseRPN( asPostfix_str ) ;
      inpos(parseMe,asPostfix_str );      
  }
  private void inpos(String infix, String postfix){
      cadena=cadena +"Infix :"+ infix+"      Postfix : "+postfix+"\n";
  }
  private String resultado(){
      String res=""+rp.getResult();
      return res ;
  }
  public String notacion(){
      return cadena;
  }
  
}
  
  
  

