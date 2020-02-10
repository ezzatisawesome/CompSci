/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 *
 * @author meesdef
 */
public class User {
    
    private ArrayList<String> userVerbList;
    private Scanner verbList;
    
    public User() {
        
        userVerbList = new ArrayList<>();
        
    }
    
    public boolean addFile(String verbDatabase) {
        try {
            verbList = new Scanner(new File(verbDatabase));
            verbList.useDelimiter(",");
            return true;
        } catch (FileNotFoundException e) {
            
        }
        return false;
    }
    
    public boolean addVerb(String verb) {
        String check = verbList.findInLine(verb);
        if(check.equals(verb)) {
            userVerbList.add(verb);
            return true;
        }
        return false;
    }
    
    public ArrayList<String> getVerbs() {
        return userVerbList;
    }
}
