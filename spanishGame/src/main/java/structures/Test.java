/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;

import com.opencsv.CSVReader;
import java.io.FileReader;

/**
 *
 * @author meesdef
 */
public class Test 
{
    private final String path = "/Users/meesdef/Documents/spanishGame/src/main/java/structures/verb_database.csv";
    
    public Test() 
    {
        
    }
    public String testVerbs() 
    {
        String str = "";
        try 
        { 
            // Create an object of filereader 
            // class with CSV file as a parameter. 
            var filereader = new FileReader(path); 

            // create csvReader object passing 
            // file reader as a parameter 
            CSVReader csvReader = new CSVReader(filereader); 
            String[] nextRecord; 

            // we are going to read data line by line 
            while ((nextRecord = csvReader.readNext()) != null) 
            { 
                for (String cell : nextRecord) 
                { 
                    str = str+ cell + "\t"; 
                } 
                str += "\n";
            } 
        } 
        catch (Exception e) 
        { 
            e.printStackTrace(); 
        } 
        return str;
    }
}
