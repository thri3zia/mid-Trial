/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package musiclife;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Student.Admin
 */
public class MusicLife {


    private static char[] Menu;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList <Classification> musicList = new ArrayList();
        int choice = 0;    
        String genre,artist,name;
        Date release = null;

        
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

       
        do{
            System.out.println("\n===================================================================");
            System.out.println("Choose from below:");
            System.out.print("1. Add");
            System.out.print("\n2. Remove");
            System.out.print("\n3. Display");
            System.out.print("\n4. Exit");

            System.out.print("\nSelected option: ");
            choice = input.next().charAt(0);
            
           switch (choice) {
                 
                case '1':
                    System.out.println("\n***** You are now going to ADD the details about Music *****");
                    System.out.print("Name of the Song : ");
                    name = input.next();
                    System.out.print("Name of the Singer : ");
                    artist = input.next();
                    System.out.print("Genre of Music: ");
                    genre = input.next();
                   System.out.print("Date Song Released (dd/mm/yyyy): ");
                   String strDate = input.next();

                   try{
                       release = simpleDateFormat.parse(strDate);
                   }catch(Exception e){
                       System.out.println("\nWrong input for Date. Follow the format for DATE INPUT. Try Again. \n");
                       input.nextLine();
                       break;
                   }

                    Classification mus = new Classification(genre,artist,name,release);
                    musicList.add(mus);
                    System.out.println("\nFavorite Music Added to the List Successfully!");
       
                    break;


                case '2':
                    System.out.println("\n***** You are now going to REMOVE a NUMBER *****");
                    Classification musDel = null;
                    System.out.print("\nInput the name of song to remove: ");
                    name = input.next();
                    int i;
                    for (i=0; i < musicList.size(); i++){
                        name = musicList.get(i).getName();
                        if(name.equalsIgnoreCase(name)){
                            musicList.remove(i);
                            System.out.println("Song Deleted Successfully!");
                            break;
                        }
                    }
                         if(i != musicList.size()){
                            System.out.println("Song Name Not FOund.");
                        }  
                    
                    

                    break;


                case '3':
                    System.out.println("Total Number of Fave Songs : " + musicList.size());
                    System.out.print("\n********************************************************************\n");                  
                    if(musicList.isEmpty()){
                        System.out.println("There is no Fave Songs to Display.");
                    }else{
                        System.out.print("\tName \t\t Artist Name \t\t Genre \t\t Date Released\n");
                        for (i = 0; i < musicList.size(); i++){
                        mus = musicList.get(i);
                        musiclife.Date date = mus.getRelease();
                        strDate = simpleDateFormat.format(date);
                        System.out.println("\t" + mus.getName() + "\t\t" + mus.getArtist() + "\t\t" + mus.getGenre() + strDate);
                    }
                    
                    }
                    break;
                case '4':
                    musicList.clear();
                    System.exit(0);
                    System.out.print("\n====================================================================\n"); 
                    System.out.println("\n******* THANK YOU FOR USING THIS SIMPLE PROGRAM. ADIOS! *******");  
                    System.out.print("\n====================================================================\n\n"); 
                    break;
                
                default:
                    System.out.println("\nJust Pick fron the options given above. Please try Again. ");
                    break;
            } 
        }while (choice != '4');

    }

   
    
    
}
