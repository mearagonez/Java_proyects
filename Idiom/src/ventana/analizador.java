package ventana;

/**
 *
 * @author drm_6
 */
import java.util.regex.*;

public class analizador {
    private String patron="("+get_Espanol()+")|("+get_Ingles()+")|("+get_Frances()+")";
    private ListaDoble ld;
    private StringBuilder texto;
    
    public analizador(StringBuilder Text) {
        ld=new ListaDoble();
        this.texto=Text;
        
    }


    /**
    * Devuelve las palabras mas usuales 
    * en el idioma español
    * @return
    */
    public String get_Espanol(){
       String spanish="";
       spanish="^el$|^la$|^de$|^que$|^y{1}$|^a{1}$|^en$|^un$|^ser$|haber|^por$|^con$|^para$|^como$|estar|tener|todo|pero|más|hacer|^o{1}$|poder|"
               + "decir|este|^ir$|otro|esté|^ir$|otro|ese|^la$|^si$|^ya$|^ver$|porque|^dar$|cuando|él|^muy$|^sin$|^vez$|mucho|saber|qué|^sobre$|"
               + "^mi$|alguno|mismo|^yo$|también|hasta|año|^dos$|querer|así|primero|desde|grande|^eso$|^ni$|^nos$|llegar|pasar|tiempo|"
               + "ella|^sí$|^día$|^uno$|bien|poco|deber|entonces|poner|cosa|tanto|hombre|parecer|nuestro|^tan$|donde|ahora|parte|"
               + "después|vida|quedar|siempre|creer|hablar|llevar|dejar|nada|cada|seguir|menos|nuevo|encontrar|momento|"
               + "forma|casa|mundo|mujer|hombre|caso|país|lugar|persona|hora|trabajo|punto|mano|manera|^fin$|tipo|gente|hola|"
               + "adios|comida|dormir|baño|recamara|casa|silla|mesa|zapatos|tenis|pantalon|camisa|playera|mediante|quién|"
               + "nosotros|^ello$|^cierto$|^aquel$|ñ|á|é|í|ó|ú";
       return spanish;
    }
    
    /**
     * Devuelve las palabras mas usuales 
     * en el idioma ingles
     * @return
     */
    public String get_Ingles(){
        String ingles="";
        ingles="^the$|^of$|^to$|^and$|^in$|^is$|^it$|"+in("you")+"|"+in("that")+"|"+in("he")+"|"+in("was")+"|"+in("for")+"|"+in("on")+"|"
                +in("are")+"|"+in("with")+"|"+in("as")+"|"+in("i")+"|"+in("his")+"|"+in("they")+"|"+in("be")+"|"+in("at")+"|"+in("one")+"|"
                +in("one")+"|"+in("have")+"|"+in("this")+"|"+in("from")+"|"+in("or")+"|"+in("had")+"|"+in("by")+"|"+in("hot")+"|"+in("name")+"|"
                +in("very")+"|through|"+in("just")+"|"+in("form")+"|"+in("much")+"|great|think|say|help|low|line|before|turn|cause|same|mean|differ|move|"
                + "right|boy|old|too|does|tell|sentence|set|three|want|air|open|seem|together|next|white|children|begin|got|walk|example|ease|paper|often|"
                + "always|music|those|both|mark|book|letter|until|mile|river|car|feet|care|second|group|carry|took|"+in("ten")+"|simple|several|vowel|toward|"
                + "war|lay|against|pattern|slow|center|love|"+in("person")+"|money|serve|appear|road|"+in("map")+"|science|rule|govern|pull|cold|notice|voice|"
                + "fall|power|town|fine|certain|but|word|some|what|there|"+in("we")+"|"+in("can")+"|"+in("out")+"|other|were|"+in("all")+"|your|when|"+in("up")+"|"
                + "use|how|said|"+in("an")+"|each|"+in("she")+"|wich|"+in("do")+"|their|time|"+in("if")+"|"+in("will")+"|"+in("way")+"|about|many|then|them|well|also|"
                + "play|small|end|put|home|read|hand|port|large|spell|add|even|land|here|must|big|high|such|follow|act|why|ask|men|change|went|light|kind|off|need|rain|"
                + "eat|room|friend|began|idea|fish|mountain|north|once|base|hear|horse|cut|sure|watch|color|face|wood|main|enough|plain|girl|usual|young|ready|above|ever|"
                + "red|list|though|fly|unit|lead|cry|dark|machine|note|wait|plan|figure|star|box|noun|field|rest|correct|able|pound|done|beauty|drive|stood|contain|front|"
                + "teach|week|final|gave|green|"+in("oh")+"|quick|them|would|write|like|"+in("so")+"|these|"+in("her")+"|long|make|thing|see|"+in("him")+"|two|has|look|more|"
                + "day|could|"+in("go")+"|come|did|"+in("my")+"|sound|most|number|who|over|know|water|"+in("than")+"|house|picture|animal|mother|world|build|earth|father|head|stand|"
                + "country|found|answer|school|study|learn|plant|cover|food|body|dog|family|direct|leave|song|measure|state|product|black|short|numeral|class|question|complete|area|"
                + "rock|south|problem|develop|quick|sleep|warm|free|minute|strong|special|mind|behind|clear|tail|produce|fact|street|nothing|wheel|force|object|decide|island|new|people|"
                + "between|city|while|night|real|life|farm|knew|hour|hundred|remember|interest|listen|busy|common|possible|thousand|ago|check|game|shape|brought|heat|perhaps|weight|length|"
                + "morning|afternoon|among";
        return ingles;
    }
    
        /**
     * Devuelve las palabras mas usuales 
     * en el idioma frances
     * @return
     */
    public String get_Frances(){
        String frances="";
        frances="à|être|^et$|avoir|pour|dans|^ce$|^il$|^qui$|^ne$|pouvoir|^je$|avec|tout|faire|mettre|autre|mais|nous|comme|^ou$|leur|elle|"
                + "devoir|avant|deux|même|pendre|aussi|celui|donner|^où$|fois|vous|nouveau|aller|cela|premier|vouloir|déjà|^grand$|^mon$|"
                + "moins|aucun|^lui$|temps|très|savoir|falloir|voir|quelque|sans|raison|^notre$|^an$|monde|jour|monsieur|^demander$|alors|"
                + "après|trouver|personne|rendre|dernier|pendant|passer|^peu$|lequel|suite|^bon$|comprendre|depuis|point|ainsi|heure|rester|"
                + "pourquoi|soit|cependant|puisque|toutefois|combien|néanmoins|aucun|^dix$|à|è|ù|â|ê|î|ô|û|ç|ë|ï|ÿ|ö|heure|année|toujours|"
                + "parler|seul|lie|partie|quand|contre|sous|suivre|seulement|"+in("moi")+"|politique|jusque|croire|homme|connaître|commencer|"
                + "compter|fait|donc|beaucoup|soit|rien|appeler|affaire|revenir|problème|peut-être|pourquoi|meileur|répondre|recevoir|rappeler|"
                + "accepter|agir|présenter|votre|reconnaître|aujourd'hui|également|français|économique|plutôt|société|difficile";
        return frances;
    }
    
    
    /**
    * Analiza el patron que le dimos
    * y agregas las palabras reconocidas a una lista
    * @return
    */
    public void analize(){
     Pattern pa =Pattern.compile(getPatron());
     Matcher matcher= pa.matcher(getTexto());
     
      while(matcher.find()){ 
         String a = matcher.group(1);
         if(a!=null){         
          ld.agregarNodo("Español", a);
         }
         String b = matcher.group(2);
         if(b!=null){         
          ld.agregarNodo("Ingles", b);
         }
         String c = matcher.group(3);
         if(c!=null){         
          ld.agregarNodo("Frances", c);
         }
      }
      
    }
    
   public String in(String item){
       return "^"+item+"$";
   }
    private StringBuilder getTexto() {
        return texto;
    }
    
    private String imprimircadena(){
         return ld.getelementos();
    }
     
    public void eliminar(){    
         ld.setInicio();
    }

    private String getPatron() {
        return patron;
    }
    
    public String init(){
        analize();
        return check();
    }
    
    
    /**
    * En los nodos que se encuentran
    * revisa que los nodos sean iguales 
    * @return
    */
    public String check(){
        int total=ld.contarNodos(),error=0;
        String ante="",actual="",idioma="";
        if(total>0){
        for (int i = 0; i < total; i++) {
            if(i==0&&(total-1==0)){
                ante=ld.tipo();
                idioma=ante;
            }else if(total-1==i&&i!=0){
                actual=ld.tipo();
                if(ante.equals(actual)){
                    ante=actual;
                    if(error==0){
                        idioma=actual;
                    }else{
                        idioma="mixto";
                    }             
                }else{
                    idioma="mixto";
                }
            }else{
                actual=ld.tipo();
                if(ante.equals(actual)){
                    ante=actual;
                }else{
                    error++;
                }
                ld.next();
            }            
        }
        }else{
            idioma="Escriba algo :|";
        }
        return "Posiblemente el idioma que esta escrito es: "+idioma;
    }
     
     
}
