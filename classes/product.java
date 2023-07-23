package classes;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class product{
    int id;
    int price;
    String name;
    int quantity;
    Date mfgdate;
    public void add(String n, int q, int i,int p){
        mfgdate = new Date();
        name = n;
        quantity = q;
        id = i;
        price=p;
        try (FileWriter writer = new FileWriter("data.csv", true);) {
            String str = name + "," + Integer.toString(quantity) + ","+Integer.toString(id)+ "," +price+","+ mfgdate.toString()  
                     + "\n";
            writer.append(str);
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void search(String name) throws Exception{
        FileReader fr= new FileReader("data.csv");
        BufferedReader bfr = new BufferedReader(fr);
        String line;
        int flag=0;
        System.out.println(name);
        while((line = bfr.readLine()) != null) {
            String[] b = line.split(",");
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
    public void delete(String name,int q) throws Exception{
        
        FileReader fr= new FileReader("data.csv");
        BufferedReader bfr = new BufferedReader(fr);
        String line;
        System.out.println(name);
        int flag=0;
        ArrayList<String> arr = new ArrayList<>();
        while((line = bfr.readLine()) != null) {
            String[] b = line.split(",");
            if(b[0].equals(name)){
                flag=1;
                Integer quantity= Integer.parseInt(b[1])-q;
                if(quantity<0){
                    System.out.println("NO Product available");
                    return;
                }
                arr.add(b[0]+","+quantity.toString()+","+b[2]+","+b[3]+","+b[4]+"\n");
            }
            else{
                arr.add(b[0]+","+b[1]+","+b[2]+","+b[3]+","+b[4]+"\n");
            }
        } 
        if(flag==1){
            try (FileWriter writer = new FileWriter("data.csv")) {
                for(String i: arr){
                    writer.write(i);
                }
                System.out.println(" deleted record successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Product not found");
        }
        
    }
    public void update(String name) throws Exception{
        Scanner sc = new Scanner(System.in);
        FileReader fr= new FileReader("data.csv");
        BufferedReader bfr = new BufferedReader(fr);
        String line;
        // Runtime.getRuntime().exec("cls");
        int flag=0;
        ArrayList<String> arr = new ArrayList<>();
        while((line = bfr.readLine()) != null) {
            String[] b = line.split(",");
            if(b[0].equals(name)){
                flag=1;
                System.out.println("Enter Details to Update :: ");
                System.out.print("Enter Product Name :: ");
                String name1=sc.next();
                System.out.print("Enter Product Quantity :: ");
                Integer q=sc.nextInt();
                System.out.print("Enter Product id :: ");
                Integer id=sc.nextInt();
                System.out.print("Enter Product Price :: ");
                Integer p=sc.nextInt();
                System.out.print("Enter date year month date:: ");
                Date date = new Date(sc.nextInt(),sc.nextInt(),sc.nextInt());  
                // System.out.println(formatter.format(date));  
                if(quantity<0){
                    System.out.println("quantity must greater than zero");
                    return;
                }
                arr.add(name1+","+q+","+id+","+p+","+date+"\n");
            }
            else{
                arr.add(b[0]+","+b[1]+","+b[2]+","+b[3]+","+b[4]+"\n");
            }
        } 
        if(flag==1){
            try (FileWriter writer = new FileWriter("data.csv")) {
                for(String i: arr){
                    writer.write(i);
                }
                System.out.println(" updated record successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Product not found");
        }
        
    }
    public void show() throws Exception {
    FileReader fr= new FileReader("data.csv");
        BufferedReader bfr = new BufferedReader(fr);
        String line;
        // Runtime.getRuntime().exec("cls");
        int no=1;
        ArrayList<String> arr = new ArrayList<>();
        while((line = bfr.readLine()) != null) {
            String[] b = line.split(",");
            System.out.println("::  Product "+no+" Details  :: ");
            System.out.println("Name :: "+b[0]+" Quantity :: "+b[1]+" Id :: "+b[2]+" Price :: "+b[3]+" Date :: "+b[4]);
            no++;
        }    
    }   
}