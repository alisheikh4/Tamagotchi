// Ali Sheikh ID : 260864038
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Tamagotchi {
  // static attributes
  private static final double MAX_ENERGY = 10;
  private static Random r = new Random();
  private String name;
  private int level;
  private double energy;
  private int experience;
  private int meals;
  private ArrayList <Toy> Toys;
  
  
  public static void main (String [] args) {
    
  }
  
  public Tamagotchi (String name, int level,double energy,int experience,int meals,ArrayList<Toy> Toys) {
    this.name = name;
    this.level = level;
    this.energy = energy;
    this.experience = experience;
    this.meals = meals;
    this.Toys = new ArrayList<Toy>();
    for (int i = 0; i<Toys.size();i++) {
      this.Toys.add(Toys.get(i));
    }
    
  }
  
  public Tamagotchi (String name) {
    this.name = name;
    this.level = 1;
    this.energy = MAX_ENERGY;
    this.experience = 0;
    this.meals = 0;
    this.Toys = new ArrayList<Toy>();
    Toy x = new Toy ();
    this.Toys.add(x);
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getLevel() {
    return this.level;
  }
  public double getEnergy() {
    return this.energy;
  }
  public int getXp() {
    return this.experience;
  }
  public int getNumOfMeals() {
    return this.meals;
  } 
  public ArrayList <Toy> getToys() {
    ArrayList<Toy> toysCopy = new ArrayList<Toy>();
    for (int i = 0; i<this.Toys.size();i++) {
      toysCopy.add(this.Toys.get(i));
    }
    return toysCopy;
  }
  
  private void levelUp() {
    if (this.experience>= 50*level*(level + 1)/2) {
      this.level = this.level +1;
      this.meals=0;
      Toy x = new Toy ();
      this.Toys.add(x);
      System.out.println("*** YAY, time to level up!! *** ");
      System.out.println(this.name+" is now level "+this.level);
      System.out.println("Your new toy is " + x);
    }
    
    
  }
  
  
  public void play(int mode) {
    if (this.energy < 2 || this.Toys==null) {
      throw new IllegalStateException("The Tamagotchi is unable to play!");
    }
    Toy play = new Toy();
    if (mode == 1) {
      play = new Toy().findBestToy(this.Toys);
      }
    if (mode ==2) {
      play = Toys.get((int)(Math.random()*Toys.size()));
    }
    int xp = play.getXp();
    this.experience = this.experience+xp;
    double energyUsed = Math.random()*(xp/20.0+0.5);
    while (energyUsed<xp/20.0) {
      energyUsed = Math.random()*(xp/20.0+0.5);
    }
    this.energy = this.energy - energyUsed;
    System.out.println(this.name+" played with "+ play + " and earned " + xp + " xp." );
    System.out.println(this.name+" now has "+this.experience+" xp, and " +this.energy+ " energy.");
    levelUp();
  }
  
  
  public void feed() {
    if (this.energy<1 || this.meals>= (this.level*2)) {
    throw new IllegalStateException("The Tamagotchi is unable to eat!");
  
  } else {
  double energyGained= (Math.random()*0.5);
  int experienceGained= (int)(Math.random()*4);
  this.energy=this.energy+energyGained;
  this.experience=this.experience+experienceGained;
  System.out.println("Nom nom nom");
  System.out.println(this.name+" now has "+this.experience+" xp, and "+ this.energy+" energy.");
  this.meals=this.meals+1;
  levelUp();
}
  }
  
  public void sleep () {
    this.energy = MAX_ENERGY;
    System.out.println(this.name+" is going to sleep to regain its energy!");
    
  }
  
  public String toString() {
    String card = ("Name: "+this.name +"\nLevel: "+this.level+"\nEnergy: "+this.energy+"\nXP: "+this.experience+"\nMeals: "+this.meals+"\nToys: "+this.Toys);
    return card;
  }
  
  
  
  
}