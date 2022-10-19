/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package musiclife;

/**
 *
 * @author Student.Admin
 */
public class Classification{ 
    private String genre;
    private String name;
    private String artist;
    private Date release;



    public Classification(String genre2, String artist2, String name2, java.util.Date release2) {
    }


    public void Classification( String genre, String artist,String name,Date release) throws javaException{ 

        this.genre = genre;
        this.artist = artist;
        this.name = name;
        this.release = release;
    }

    
    /*    Classification(String genre, String artist, String name, java.util.Date release) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
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

    public void setRelease(Date release){
        this.release = release;
    }
     public Date getRelease(){
        return release;
     }

    
}
