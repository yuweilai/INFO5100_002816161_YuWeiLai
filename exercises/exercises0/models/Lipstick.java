package exercises.exercises0.models;

public class Lipstick extends MakeupProduct {
    public String finish;
    
    public Lipstick(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType, String finish) {
        super(name, brand, shade, price, crueltyFree, waterproof, skinType);
        this.finish = finish;
    }
    
    public void apply() {
        System.out.println("Applying " + shade + " " + finish + " lipstick on lips.");
    }

    public void smudge() {
        System.out.println("Smudging " + shade + " " + finish + " lipstick for a blended look.");
    }
    
    public void peck() {
        System.out.println("Pecking " + shade + " " + finish + " lipstick on tissue to prevent transmission.");
    }
}