
package musiclife;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.*;


public class MusicLife {


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList <Classification> musicList = new ArrayList();
        char choice;   
        String genre,artist,name,fave,identify;

        System.out.println("  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("  @@       *******      YOUR OWN SONG LIST        *******      @@ ");
        System.out.println("  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
 
        do{
            System.out.println("\n");
            System.out.println("  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ ");
            System.out.println("  @@                  Choose from below:                       @@ ");
            System.out.println("  @@                     [A] Add Song                          @@ ");
            System.out.println("  @@                     [B] Remove Song                       @@ "); 
            System.out.println("  @@                     [C] Display List                      @@ ");
            System.out.println("  @@                     [X] Exit                              @@ ");
            System.out.println("  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            System.out.print("Selected option: ");
            choice = input.next().charAt(0);
            
            
           switch (choice) {
                 
                case 'A':
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println("@@          ***** ADD THE CORRESPONDING DETAILS *****        @@");
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    System.out.print("\n[1.] YOUR OWN IDENTIFIER FOR THE SONG : ");
                    identify = input.next();
                    Pattern p = Pattern.compile("[^A-Za-z]");
                    Matcher m = p.matcher(identify);
                    if(m.find()){
                        System.out.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("  XX   WARNING!!!                                                               XX ");
                        System.out.println("  XX         Your identifier contains Special Characters. PLease input again.   XX");
                        System.out.println("  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        break;
                    }
                    // ==============================================================================
                    System.out.print("[2.] NAME OF THE SONG: ");
                    name = input.next();
                    
                    // ==============================================================================
                    System.out.print("[3.] NAME OF THE ARTIST/SINGER: ");
                    artist = input.next();
                    p = Pattern.compile("[^A-Za-z0-9 ]");
                    m = p.matcher(name);
                    if(m.find()){
                        System.out.println("  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("  XX   WARNING!!!                                                                XX ");
                        System.out.println("  XX         The entered name contains Special Characters. PLease input again.   XX");
                        System.out.println("  XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        break;
                    }
                    try {
                        if (!Character.isUpperCase(artist.charAt(0))) {
                            throw new javaException("First letter should be in Uppercase. TRY AGAIN.");
                        }
                    } catch (javaException e) {
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("   WARNING!!!                                                     ");
                        System.out.println(e.getMessage());
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        input.nextLine();
                        break;
                    }


                    // ==============================================================================
                    System.out.print("[4.] GENRE OF THE SONG: ");
                    genre = input.next();

                    try {
                        if (!Character.isUpperCase(genre.charAt(0))) {
                            throw new javaException("First letter should be in uppercase. TRY AGAIN.");
                        }
                    } catch (javaException e) {
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("   WARNING!!!                                                     ");
                        System.out.println(e.getMessage());
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        input.nextLine();
                        break;
                    }

                    // ==============================================================================
                    System.out.print("[5.] IS THIS ONE OF YOUR FAVORITE? [YES/NO]: ");
                    fave = input.next();
                    try {
                        if (!fave.equalsIgnoreCase("yes") && !fave.equalsIgnoreCase("no")) {
                            // input.close();
                            throw new javaException("Please input only YES or NO. TRY AGAIN.");
                        }   
                    } catch (javaException e) {
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("   WARNING!!!                                                     ");
                        System.out.println(e.getMessage());
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        input.nextLine();
                        break;
                    }

                    // ==============================================================================

                    Classification mus = new Classification(genre,artist,name,fave,identify);
                    musicList.add(mus);
                    System.out.println("#########################################################");
                    System.out.println("##    CONFIRMED!!!                                     ##");
                    System.out.println("##           Song Added to the List Successfully!      ##");
                    System.out.println("#########################################################\n");

                    break;
//  *********************************************************************************************************************************************
                case 'B':
                    System.out.println("\n***** REMOVE YOUR SONG *****");
                    System.out.print("\nInput the Identifer of the song to remove: ");
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
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        System.out.println("   CONFIRMED!!!                                                     ");
                        System.out.println(e.getMessage());
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        input.nextLine();
                        break;
                    }

                    try {
                        if(i != musicList.size()){
                                throw new javaException("OH! SONG NOT FOUND. ADD SOME."); 
                        }
                    } catch (javaException e) {
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                        System.out.println("   WARNING!!!                                                     ");
                        System.out.println(e.getMessage());
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        input.nextLine();
                        break;
                    }
                    
//  *********************************************************************************************************************************************

                case 'C':
                    System.out.println("#########################################################");
                    System.out.println("       TOTAL NUMBER OF SONG LISTED :  " + musicList.size());
                    System.out.println("#########################################################\n");                 
                    if(musicList.isEmpty()){
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                        System.out.println("             THERE ARE NO SONGS TO DISPLAY \n");
                        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                    }else{
                        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                        System.out.println("::\tIDENTIFIER \t    SONG NAME \t\t   ARTIST NAME \t\t       GENRE \t\t    FAVE OR NOT            ::");
                        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");;
                        for (i = 0; i < musicList.size(); i++) {
                        mus = musicList.get(i);
                        System.out.println("::\t  "+mus.getIdentify() + "\t\t\t" + mus.getName() + "\t\t\t" + mus.getArtist() + "\t\t\t" + mus.getGenre() + "\t\t\t" + mus.getFave() + "\t           ::");
                        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
                    }
                    }
                    break;

//  *********************************************************************************************************************************************
                case 'X':
                    musicList.clear();
                    System.out.println("          ================                ================="); 
                    System.out.println("      =======================          ========================="); 
                    System.out.println(" ==============================     ==============================="); 
                    System.out.println(" =======                                                     ======"); 
                    System.out.println("  *****  THANK YOU FOR USING THIS SIMPLE APPLICATION. ADIOS!  *****"); 
                    System.out.println("  ======                                                     ====="); 
                    System.out.println("    ============================================================"); 
                    System.out.println("        ====================================================="); 
                    System.out.println("            =============================================n\n"); 
                    break;
//  *********************************************************************************************************************************************            
                default:
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    System.out.println("XX   WARNING!!!                                                          XX ");
                    System.out.println("XX          JUST PICK FROM THE GIVEN OPTIONS ABOVE. PLEASE TRY AGAIN.    XX");
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n");
                    break;
            } 
        }while (choice != 'X');

    }

   
    
    
}
