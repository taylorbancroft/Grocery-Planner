/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery.planner;

/**
 *
 * @author Tebancro
 */
public class Item {
    private String itemType;
    private int itemIsle;
    private String specialLocation;
    
    private Item(){
        itemType = "none";
        itemIsle = 0;
        specialLocation = "none";
    }
    
    public Item(String itemType, int itemIsle, String specialLocation){
        this.itemType = itemType;
        this.itemIsle = itemIsle;
        this.specialLocation = specialLocation;
    }

    public String getItemType() {
        return itemType;
    }

    public int getItemIsle() {
        return itemIsle;
    }

    public String getSpecialLocation() {
        return specialLocation;
    }
    
    

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemIsle(int itemIsle) {
        this.itemIsle = itemIsle;
    }

    public void setSpecialLocation(String specialLocation) {
        this.specialLocation = specialLocation;
    }

    @Override
    public String toString() {
        return "Item{" + "itemType=" + itemType + ", itemIsle=" + itemIsle + ", specialLocation=" + specialLocation + '}';
    }
       
}
