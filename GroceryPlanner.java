/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocery.planner;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Tebancro
 */
public class GroceryPlanner {
    private ArrayList<Item> items;
    public static final int WINDOW_SIZE = 800;
    private static final String TEST_FOLDER_PREFIX = "Items";
    private static final String SOUTH_CONGRESS = "C:\\Users\\Tebancro\\Documents\\Grocery Planner\\items.txt";
    /**
     * @param args the command line arguments
     */
    public static void modifyItems(String filepath, String oldString, String newString){
        File fileToBeModified = new File(filepath);
        String content ="";
        try{
        Scanner scnr = new Scanner(fileToBeModified);
        while (scnr.hasNextLine()){
            String line = scnr.nextLine().replace(oldString, newString);
            content = content + line + "\n";
        }
        FileWriter writer = new FileWriter(SOUTH_CONGRESS);
        writer.write(content);
        writer.close();
        }catch(IOException ex){
        Logger.getLogger(GroceryPlanner.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Can not open the file!");  
        ex.printStackTrace();
        }
        
    }
    public static void readItems(String filepath, ArrayList<Item> items){
        File filename = new File(filepath);
        try {
            FileInputStream fis = new FileInputStream(filepath);
            Scanner s = new Scanner(fis);
            String itemType = "";
            int itemIsle = 0;
            String specialLocation = "";
            while (s.hasNext()){
                itemType = s.next();
                if(!s.hasNextInt()){
                    if (s.hasNext("Checkstands") || s.hasNext("Beer&Wine") || s.hasNext("HydrationCenter")){
                        specialLocation = s.next();
                        itemIsle = 0;
                    }
                    else{
                        itemType += " " + s.next();
                    }
                    if (s.hasNextInt()){
                        itemIsle = s.nextInt();
                        specialLocation = null;
                    }
                    else if (s.hasNext("Checkstands") || s.hasNext("Beer&Wine") || s.hasNext("HydrationCenter")){
                        specialLocation = s.next();
                        itemIsle = 0;
                    }
                }
                else {
                    itemIsle = s.nextInt();
                    specialLocation = null;
                }
                Item item = new Item(itemType, itemIsle, specialLocation);
                System.out.println(item);
                items.add(item);
            }
        }catch(IOException ex){
        Logger.getLogger(GroceryPlanner.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("Can not open the file!");
    }
}
    public static void main(String[] args) {
        ArrayList items = new ArrayList(); 
        modifyItems(SOUTH_CONGRESS, ".", "");
        modifyItems(SOUTH_CONGRESS, "Beer & Wine", "Beer&Wine");
        modifyItems(SOUTH_CONGRESS, "Hydration Center", "HydrationCenter");
        readItems(SOUTH_CONGRESS, items);
    }
    
}
