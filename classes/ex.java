import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ex {
    public static void main(String[] args)throws Exception {
    String  name ="laptop";//name to search         
    FileReader fr= new FileReader("data.csv");
    BufferedReader bfr = new BufferedReader(fr);
        String line;
        int flag=0;
        while((line = bfr.readLine()) != null) {
            String[] b = line.split(",");//first line into string 
            if(b[0].equals(name)){

                flag=1;
                
            }
        }
        if(flag==1){
            System.out.println("Found");
        }
        else{
            System.out.println("Not Found");

        }
    }    
}

