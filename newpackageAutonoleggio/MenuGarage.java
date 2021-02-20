package newpackageAutonoleggio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class MenuGarage{
      
    public MenuGarage(){
    
    Parcheggio p = new Parcheggio("");
    Automobile a = new Automobile("",0,p);
    GarageImpl gI = new GarageImpl();
    
    Scanner input = new Scanner(System.in);
    String risp = "";
      
    LocalDateTime dataOra = LocalDateTime.now();          
    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM);
    
        System.out.println(dataOra.format(formatter) + "\n======================="
                + "\nParcheggio Sotterraneo\n=======================");
            
    do{
        
        try{
            
            System.out.println("Digita 1 x creare un parcheggio(consigliabile prima scelta)\n"
                    + "Digita 2 x cercare un auto\nDigita 3 x cercare un parcheggio"
                    + "\nDigita 4 x aggiungere un auto ad un parcheggio\nDigita 5 x spostare un auto da un parcheggio a un altro"
                    + "\nDigita 6 x sapere la capienza di un parcheggio\nDigita 7 x rimuovere un auto\n"
                    + "Digita 8 x sapere quale parcheggio ha più auto\nDigita 9 x visualizzare tutte le auto e parcheggi"
                    + "\nDigita 10 x eliminare un auto x numero di targa");
            
            if(risp.equalsIgnoreCase("s")||risp.equalsIgnoreCase("si")||risp.equalsIgnoreCase("y"));
            
          else if((risp.equalsIgnoreCase("n")|| risp.equalsIgnoreCase("no")|| risp.equalsIgnoreCase("fine")))break;
            
            int scelta = input.nextInt();
            risp = input.nextLine();
            
            switch(scelta){
                              
                case 1:
                    
                    System.out.println("Inserisci il nome di un parcheggio");
                    gI.aggiungiParcheggio(input.nextLine());
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
                    
                case 2:
                    
                    System.out.println("Inserisci una targa da cercare");
                    gI.cercaAuto(input.nextLine());
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
                    
                case 3:
                    
                    System.out.println("Inserisci il nome parcheggio da cercare");
                    gI.cercaParc(input.nextLine());
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
                    
                case 4:
                    
                    System.out.println("Digita la targa da aggiungere e il nome parcheggio x assegnare l'auto");
                    gI.aggiungiAutomobile(input.nextLine(),input.nextLine());
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
    
                case 5:
                    
                    System.out.println("inserisci targa e nome parcheggio x spostare la macchina");
                    gI.movimenti(input.nextLine(),input.nextLine());
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
                    
                case 6:
                    
                    System.out.println("Digita il nome di un parcheggio x sapere quante auto ci sono");
                    gI.contaAutomobili(input.nextLine());
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
                    
                case 7:
                    
                    System.out.println("L'auto verrà rimossa dopo 2 viaggi");
                    gI.rimuoviAutomobili(4);       //l'auto viene rimossa dopo essere stata mossa 4 volte
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
                    
                case 8:
                    
                    System.out.println("Quale parcheggio ha più auto ?");
                    gI.statistica();
                    //System.out.println("" + gI.statistica());
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
                    
                case 9:
                    
                    System.out.println("Le targhe: ");
                    gI.mostraA();
                    System.out.println("I parcheggi: ");
                    gI.mostraP();
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();

                    break;
                    
                case 10:
                    
                    System.out.println("Digita la targa dell'auto da eliminare");
                    gI.rimuovi(input.nextLine());
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();
                    
                    break;
    
                default:
                    
                    System.out.println("Devi inserire un numero da 1 a 11");
                    System.out.println("Vuoi continuare si/no?");
                    risp = input.nextLine();
            }
        
        }catch(Exception e){
            
            e.printStackTrace();
            System.out.println("Devi inserire un numero non una lettera");
            System.out.println("Vuoi continuare si/no?");
            input.nextLine();
            risp = input.nextLine();
        }
    
    }while((risp.equalsIgnoreCase("s")||risp.equalsIgnoreCase("si")||risp.equalsIgnoreCase("y")));

  }
  
}
