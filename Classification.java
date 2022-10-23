
package musiclife;


public class Classification{ 
    private String genre;
    private String name;
    private String artist;
    private String fave;
    private String identify;


    public Classification(){

    }

    public Classification(String genre, String artist, String name, String fave, String identify ) {
        this.name = name;
        this.genre = genre;
        this. artist = artist;
        this.fave = fave;
        this.identify = identify;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }
    public String getGenre(){
        return genre;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    
    public void setArtist(String artist){
        this.artist = artist;

    }
    public String getArtist(){
        return artist;
    }

    public void setFave(String fave){
        this.fave = fave;
    }
     public String getFave(){
        return fave;
     }
     public void setIdentify(String identify){
        this.identify = identify;
    }
     public String getIdentify(){
        return identify;
     }

    
}
