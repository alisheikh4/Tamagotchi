// Ali Sheikh ID : 260864038
import java.io.*;
import java.util.ArrayList;
public class FileIO {
  
  public static void main (String [] args) {
  
  }
  private static  ArrayList <Toy> loadToys (String fileName) throws IOException {
    ArrayList <Toy> a = new ArrayList <Toy>();
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    ArrayList<String> b = new ArrayList <String>();
    String currentLine =br.readLine();
    
    while(currentLine != null) {
      b.add(currentLine);
      
      currentLine = br.readLine();
      
    }
    
    
    
    try {
      for (int i = 0; i<b.size();i++) {
        
        a.add(Toy.createToy(b.get(i)));
      }
    }
    catch (Exception e) {
      System.out.println("The format of the file is incorrect");
      ArrayList<Toy> empty = new ArrayList<Toy>();
      br.close();
      fr.close();
      return empty;
      
    }
    
    br.close();
    fr.close();
    return a;
  }
  
  private static boolean saveToys (ArrayList<Toy> Toys,String fileName) {
    if (Toys.size()==0) {
      return false;
    }
    try {
      FileWriter fw = new FileWriter (fileName,true);
      BufferedWriter bw = new BufferedWriter(fw);
      for (int i =0; i<Toys.size();i++) {
        String name = Toys.get(i).getName();
        String color = Toys.get(i).getColor();
        String type = Toys.get(i).getType();
        int xp = Toys.get(i).getXp();
        bw.write(name+"\t"+color+"\t"+type+"\t"+xp);
        bw.newLine();
      }
      
      
      bw.close();
      fw.close();
    }
    
    catch(IOException e) {
      System.out.println("Something went wrong when trying to save! There seems to be an IOException.");
    }
    return true;
  }
  
  public static Tamagotchi loadTamagotchi(String fileName) throws IOException {
    
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    String name = br.readLine();
    int level = Integer.parseInt(br.readLine());
    double energy =Double.parseDouble(br.readLine());
    int experience = Integer.parseInt(br.readLine());
    int meals = Integer.parseInt(br.readLine());
    ArrayList<Toy> Toys = loadToys(br.readLine());
    
    Tamagotchi a = new Tamagotchi(name,level,energy,experience,meals,Toys);
    br.close();
    fr.close();
    return a;
    
    
    
    
  }
  
  public static boolean saveTamagotchi (Tamagotchi myTamagotchi ,String fileName,String toysFileName) {
    
    try {
      FileWriter fw = new FileWriter (fileName);
      BufferedWriter bw = new BufferedWriter(fw);
      String name = myTamagotchi.getName();
        String level = "" + myTamagotchi.getLevel();
        String energy = ""+myTamagotchi.getEnergy();
        String experience =""+myTamagotchi.getXp();
        String meals =""+myTamagotchi.getNumOfMeals();
        String Toys = toysFileName;
        saveToys(myTamagotchi.getToys(),toysFileName);
        
        bw.write(name);
        bw.newLine();
        bw.write(level);
        bw.newLine();
        bw.write(energy);
        bw.newLine();
        bw.write(experience);
        bw.newLine();
        bw.write(meals);
        bw.newLine();
        bw.write(Toys);
        bw.newLine();
    
    
    bw.close();
    fw.close();
    }
  
  catch(Exception e) {
    System.out.println("Something went wrong! The files were not saved. Please check the input provided for errors");
    return false;
  }
  return true;
}





  
  
  
  
  
  
  
}