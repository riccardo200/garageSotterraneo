package newpackageAutonoleggio;


public class Automobile {
    
    private String targa;
    private int viaggi;
    private Parcheggio locazione;
    
    public Automobile(String unaTarga, int unViaggio, Parcheggio unParc){
        
        this.targa = unaTarga;
        this.viaggi = unViaggio;
        this.locazione = unParc;
    }
    
    public Automobile(String unaTarga){
        
        this.targa = unaTarga;
    }
    
    public void setTarga(String unaTarga){
        
        this.targa = unaTarga;
    }
    
    public String getTarga(){
        
        return this.targa;
    }
    
    public void setViaggi(int unViaggio){
        
        this.viaggi = unViaggio; 
    }
    
    public int getViaggi(){
        
        return this.viaggi; 
    }
    
    public void setParcheggio(Parcheggio nuovo){
        
        locazione = nuovo;
        viaggi ++;   
    }
    
    public Parcheggio getLocazione(){
        
        return this.locazione;
    }   
}
