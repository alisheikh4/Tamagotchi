// Ali Sheikh ID : 260864038
import java.util.ArrayList;
import java.util.Random;

public class Toy {
  private static String[] names = {"Bob", "Penny", "Fisher", "Snoopy", "Garfield", "Mary", "Chuchu", "Trooper", "Lovebug", "Bella"};
  private static String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
  private static String[] types = {"car", "doll", "stuffed cat", "train", "ball", "kite", "teddy bear", "trike"};
  private static Random r = new Random();
  private String name;
  private String color;
  private String type;
  private int xp;
  public static void main (String [] args) {
   
  }
  
  public Toy (String name,String color,String type,int xp) {
    this.name=name;
    this.color=color;
    this.type=type;
    this.xp=xp;
    
    
  }
  
  public Toy () {
    this.name= getRandomName();
    this.color=getRandomColor();
    this.type=getRandomType();
    this.xp=(int)(Math.random()*25);
    while (this.xp<10) {
      this.xp=(int)(Math.random()*25);
    }
    
  }
  
  public String getName () {
    return this.name;
  }
  public String getColor() {
    return this.color;
  }
  public String getType() {
    return this.type;
  }
  public int getXp() {
    return this.xp;
  }
  
  public String toString(){
    
    String aToy = (this.name+" the "+this.color+" "+this.type);
    
    return aToy;
  }
  
  public static Toy createToy(String toyValues) {
    try {
      String [] b=toyValues.split("\t",4);
      String name = b[0];
      String color = b[1];
      String type = b[2];
      int xp = Integer.parseInt(b[3]);
      Toy a = new Toy(name,color,type,xp);
      return a;
    }
    catch (NumberFormatException e){
      throw new IllegalArgumentException("Invalid Input, you need 4 pieces of information!");
    }
  }
  
  public Toy findBestToy(ArrayList<Toy> toysList) {
    
    if (toysList.size()==0) {
      return null;
    }
    Toy highXp = toysList.get(0);
    for (int i =1; i<toysList.size();i++) {
      if (highXp.xp<toysList.get(i).xp) {
        highXp = toysList.get(i);
    }
    }
    
    return  highXp;
  }
  
  
  
  
  
  // private static methods provided
  private static String getRandomName() {
    int i = r.nextInt(names.length);
    return names[i];
  }
  
  private static String getRandomColor() {
    int i = r.nextInt(colors.length);
    return colors[i];
  }
  
  private static String getRandomType() {
    int i = r.nextInt(types.length);
    return types[i];
  }
  
  
}
