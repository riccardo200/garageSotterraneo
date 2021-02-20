package newpackageAutonoleggio;

import java.util.ArrayList;
import static jdk.nashorn.tools.ShellFunctions.input;

public class GarageImpl {
    
    private final ArrayList<Parcheggio> parcheggi;
    private final ArrayList<Automobile> automobile;
    
    public GarageImpl(){             //costruttore
        
       parcheggi = new ArrayList<>();
       automobile = new ArrayList<>();
    }
        
/*    public void aggiungi(String unaTarga){            //aggiunge un automobile
        
        automobile.add(new Automobile(unaTarga));
    }*/
    
    public void mostraA(){        //mostra le auto disponibbili nell array
    
        automobile.forEach(auto1 -> {
            
            System.out.println("Automobili: " + auto1.getTarga());     
        });
    }
    
    public void mostraP(){
        
        parcheggi.forEach(parche1 ->{
            
            System.out.println("Nome Parcheggio: " + parche1.getNome());    
        });
    }
    
    public int cercaAuto(String unaTarga){      
        
        int result = -1;
        
        for(int i = 0; i<automobile.size();i++){
            
            if(automobile.get(i).getTarga().equals(unaTarga)){
                
                System.out.println("Auto trovata: \n" + automobile.get(i).getTarga());
                
                result = 1;   
            }
        }
        
        return result;
    }
    
    public int cercaParc(String unNome){  
        
        int result = -1;
        
        for(int i = 0; i<parcheggi.size();i++){
            
            if(parcheggi.get(i).getNome().equals(unNome)){
                
                System.out.println("Parcheggio trovato: \n" + parcheggi.get(i).getNome());
                
                result = 1;
            }
                
        }
         
        return result;    
    }
   
    public void aggiungiParcheggio(String unNome){   //aggiunge un nuovo parcheggio
        
        if(cercaParc(unNome) != -1)
            
            return;
        
        parcheggi.add(new Parcheggio(unNome));
    }
    
    public void aggiungiAutomobile(String unaTarga, String unNomeParcheggio){   //aggiunge un auto ad un parcheggio
                                                                               //senza creare duplicati
        if(cercaAuto(unaTarga) != -1)
            
            return;
        
        if(cercaAuto(unNomeParcheggio) != -1)
            
            automobile.add(new Automobile(unaTarga,0,parcheggi.get(cercaParc(unNomeParcheggio))));
        
        else{
            
            Parcheggio p = new Parcheggio(unNomeParcheggio);
            
            automobile.add(new Automobile(unaTarga,0,p));
        }
        
    }
    
    public void movimenti(String unaTarga, String parcheggioArrivo){    //sposta un auto da un parcheggio ad un altro
        
        if(cercaAuto(unaTarga) == -1 || cercaParc(parcheggioArrivo) == -1)
            
            return;
        
        automobile.get(cercaAuto(unaTarga)).setParcheggio(parcheggi.get(cercaParc(parcheggioArrivo)));
    }
    
    public int contaAutomobili(String unNomeParcheggio){      //conta le automobili all interno di un parcheggio
        
        if(cercaParc(unNomeParcheggio)== -1)
            
            return -1;
        
          int totale = 0;
        
        for (Automobile automobile1 : automobile) {
            
            if(automobile1.getLocazione().getNome().equals(unNomeParcheggio)){
                
                totale ++;
                
           // System.out.println("Le auto presenti in questo parcheggio: \n" + automobile.get(totale).getLocazione());
            }
        }
        
        System.out.println("Auto presenti in questo garage: " + totale);
        
        return totale;
    }

    public void rimuoviAutomobili(int unNumeroViaggi){   //rimuove un auto che abbia compiuto un tot di viaggi
        
        for(int i = automobile.size()-1;i>=0;i--){
            
            if(automobile.get(i).getViaggi()>= unNumeroViaggi){
                
                automobile.remove(i);
            }
        }
    }
    
    public String statistica(){       //restituisce il nome del parcheggio con più auto
        
        int max = 0;
        int indice = -1;
        
        for(int i = 0;i< parcheggi.size();i++){
            
            int cont = 0;
            
            for(int j = 0; j< automobile.size();i++){
                
                if(automobile.get(j).getLocazione().getNome().equals(parcheggi.get(i).getNome()))
                    
                    cont ++;
                
                if(cont>max){
                    
                    max = cont;
                    indice = i;
                }
            }
        }
        
      //  System.out.println(parcheggi.get(indice).getNome());

        return parcheggi.get(indice).getNome();
 }
    
    public Automobile rimuovi(String unaTarga){
      
        for(int i = 0; i<automobile.size();i++){
   
           if (automobile.get(i).getTarga().equals(unaTarga)){
   
        return automobile.remove(i);
 }
   
   }
        return null;
    }
                                              
}
