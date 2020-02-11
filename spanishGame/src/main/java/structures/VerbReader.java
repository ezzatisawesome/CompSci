/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structures;
import com.opencsv.CSVReader;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author meesdef
 */
public class VerbReader 
{
    private final String file = "/Users/meesdef/Documents/spanishGame/src/main/java/structures/verb_database.csv";
    private CSVReader reader;
    
    private int definition = 1;
    
    private int s1 = 7;
    private int s2 = 8;
    private int s3 = 9;
    private int p1 = 10;
    private int p2 = 11;
    private int p3 = 12;
    
    private int gerund = 13;
    private int past_participle = 14;
    
    private int[] tenses;

    
    
    public VerbReader()
    {
        this.tenses = new int[]{definition, s1, s2, s3, p1, p2, p3, gerund, past_participle};
        
        try
        {
            reader = new CSVReader(new FileReader(file));
        }
        catch (FileNotFoundException e)
        {
            final JPanel panel = new JPanel();
            JOptionPane.showMessageDialog(panel, "Could not open file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public String nextLine()
    {
        String[] next = reader.readNext();
        return next[1];
    }
    
    public String nextWordWithConj()
    {
        
        String[] next = reader.readNext();
        return next[randomizer()];
    }
    
    public int randomizer() 
    {
        Random n = new Random();
        int r = n.nextInt(tenses.length);
        return tenses[r];
    }
}
