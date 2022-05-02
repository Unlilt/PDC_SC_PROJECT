/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
/**
* @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class Room {
    //Also how far in the story the player is
    private int roomNo;
    //Also includes any story progression
    private String desc;
    
    public Room(int roomNumber, String roomDesc){
        setRoomNo(roomNumber);
        setDesc(roomDesc);
    }

    public int getRoomNo() {
        return this.roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
  
}
