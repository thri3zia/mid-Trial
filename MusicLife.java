/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package musiclife;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.*;


public class MusicLife {


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList <Classification> musicList = new ArrayList();
        char choice;   
        String genre,artist,name,fave,identify;
 
        do{
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            System.out.println("  @@                  Choose from below:                       @@ ");
            System.out.print("    @@                      A. Add                               @@ ");
            System.out.print("\n  @@                      B. Remove");
            System.out.print("\n  @@                      C. Display");
            System.out.print("\n  @@                      X. Exit");
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");

            System.out.print("\nSelected option: ");
            choice = input.next().charAt(0);
            
           switch (choice) {
                 
                case 'A':
                    System.out.println("\n***** You are now going to ADD the details about Music *****");
                    System.out.print("Your own identification name for the song : ");
                    identify = input.next();
                    Pattern p = Pattern.compile("[^A-Za-z]");
                    Matcher m = p.matcher(identify);
                    if(m.find()){
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        System.out.println("     Your identifier contains Special Characters. PLease input again.");
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        break;
                    }
                    // ==============================================================================

                    System.out.print("Name of the Song : ");
                    name = input.next();
                    
                    // ==============================================================================

                    System.out.print("Name of the Singer : ");
                    artist = input.next();
                    p = Pattern.compile("[^A-Za-z0-9 ]");
                    m = p.matcher(name);
                    if(m.find()){
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        System.out.println("    The entered name contains Special Characters. PLease input again.");
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        break;
                    }

                    // ==============================================================================

                    System.out.print("Is this one of your favorites? y/n : ");
                    fave = input.next();
                    try {
                        if (!fave.equalsIgnoreCase("yes") && !fave.equalsIgnoreCase("no")) {
                            // input.close();
                            throw new javaException("Please input only YES or NO. TRY AGAIN.");
                        }   
                    } catch (javaException e) {
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        System.out.println(e.getMessage());
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        input.nextLine();
                        break;
                    }

                    // ==============================================================================

                    System.out.print("Genre of Music: ");
                    genre = input.next();

                    try {
                        if (!Character.isUpperCase(genre.charAt(0))) {
                            throw new javaException("First Letter should be / would only be in Uppercase. TRY AGAIN.");
                        }
                    } catch (javaException e) {
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        System.out.println(e.getMessage());
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        input.nextLine();
                        break;
                    }

                    // ==============================================================================

                    Classification mus = new Classification(genre,artist,name,fave,identify);
                    musicList.add(mus);
                    System.out.println("\n#########################################################\n");
                    System.out.println("\n           Song Added to the List Successfully!\n");
                    System.out.println("\n#########################################################\n");

                    break;
//  *********************************************************************************************************************************************
                case 'B':
                    System.out.println("\n***** You are now going to REMOVE a NUMBER *****");
                    System.out.print("\nInput the name of song to remove: ");
                    identify = input.next();
                    int i;
               
                    try {
                        for (i=0; i < musicList.size(); i++){
                            identify = musicList.get(i).getIdentify();
                            if(identify.equalsIgnoreCase(identify)){
                                musicList.remove(i);
                                throw new javaException("YEY! SONG DELETED SUCCESSFULLY!");
                                
                            }
                        }
                    } catch (javaException e) {
                        System.out.println("\n#########################################################\n");
                        System.out.println(e.getMessage());
                        System.out.println("\n#########################################################\n");
                        input.nextLine();
                        break;
                    }

                    try {
                        if(i != musicList.size()){
                                throw new javaException("OH! SONG NOT FOUND. ADD SOME."); 
                        }
                    } catch (javaException e) {
                        System.out.println("\n#########################################################\n");
                        System.out.println(e.getMessage());
                        System.out.println("\n#########################################################\n");
                        input.nextLine();
                        break;
                    }
                    
//  *********************************************************************************************************************************************

                case 'C':
                    System.out.println("\n#########################################################\n");
                    System.out.println("       Total Number of Inputted Songs : " + musicList.size());
                    System.out.println("\n#########################################################\n");                 
                    if(musicList.isEmpty()){
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        System.out.println("              THERE ARE NO SONGS TO DISPLAY");
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                    }else{
                        System.out.print("\tIDENTIFIER \t=========== SONG NAME \t===========\t ARTIST NAME \t===========\t GENRE \t===========\t FAVE OR NOT\n");

                        for (i = 0; i < musicList.size(); i++) {
                        mus = musicList.get(i);
                        System.out.println("\t"+mus.getIdentify() + "\t\t\t" + mus.getName() + "\t\t\t" + mus.getArtist() + "\t\t\t" + mus.getGenre() + "\t\t\t" + mus.getFave());
                    }
                    }
                    break;

//  *********************************************************************************************************************************************
                case 'X':
                    musicList.clear();
                    System.out.print("\n=====================================================================\n"); 
                    System.out.println("\n******* THANK YOU FOR USING THIS SIMPLE APPLICATION. ADIOS! *******");  
                    System.out.print("\n=====================================================================\n\n"); 
                    break;
                
                default:
                    System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                    System.out.println("\n    JUST PICK FROM THE GIVEN OPTIONS ABOVE. PLEASE TRY AGAIN. ");
                    System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                    break;
            } 
        }while (choice != 'X');

    }

   
    
    
}
