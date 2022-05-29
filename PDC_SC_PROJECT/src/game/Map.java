/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
class Map {
   public static ArrayList<Room> map = new ArrayList<Room>();
     
        public static String getRoomDesc(int key) {
            Room room = map.get(key);
            String desc = room.getDesc();
                  return desc;
        }


    static void loadMap() {
        String desc = "";
//        map.add(new Room());
        try (BufferedReader inStream = new BufferedReader(new FileReader("resources/map.txt"))) {
                String line = null;
                while((line=inStream.readLine())!=null){
                    StringTokenizer st= new StringTokenizer(line, ":"); 

                    if(line.contains("Intro")){
                        desc = "";
                    line = inStream.readLine();
                       do{                    
                        desc += line + "\n";
                    line = inStream.readLine();
                    
                    } while(st.hasMoreTokens() && line.contains("end") == false);
                        map.add(new Room(0, desc));
                    }
                    if(line.contains("1")){
                        desc = "";
                    line = inStream.readLine();
                       do{                    
                        desc += line + "\n";
                    line = inStream.readLine();
                    
                    } while(st.hasMoreTokens() && line.contains("end") == false);
                        map.add(new Room(1, desc));
                    }
                    if(line.contains("2")){
                        desc = "";
                    line = inStream.readLine();
                       do{                    
                        desc += line + "\n";
                    line = inStream.readLine();
                    
                    } while(st.hasMoreTokens() && line.contains("end") == false);
                        map.add(new Room(2, desc));
                    }
                    if(line.contains("3")){
                        desc = "";
                    line = inStream.readLine();
                       do{                    
                        desc += line + "\n";
                    line = inStream.readLine();
                    
                    } while(st.hasMoreTokens() && line.contains("end") == false);
                        map.add(new Room(3, desc));
                    }
                     if(line.contains("4")){
                        desc = "";
                    line = inStream.readLine();
                       do{                    
                        desc += line + "\n";
                    line = inStream.readLine();
                    
                    } while(st.hasMoreTokens() && line.contains("end") == false);
                        map.add(new Room(4, desc));
                    }
                      if(line.contains("5")){
                        desc = "";
                    line = inStream.readLine();
                       do{                    
                        desc += line + "\n";
                    line = inStream.readLine();
                    
                    } while(st.hasMoreTokens() && line.contains("end") == false);
                        map.add(new Room(5, desc));
                    }
                       if(line.contains("6")){
                        desc = "";
                    line = inStream.readLine();
                       do{                    
                        desc += line + "\n";
                    line = inStream.readLine();
                    
                    } while(st.hasMoreTokens() && line.contains("end") == false);
                        map.add(new Room(6, desc));
                    }
                }  
                
}       catch (FileNotFoundException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}


