package exercises.exercises0.models;

public class Eyeliner extends MakeupProduct {
    public String type;
    
    public Eyeliner(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType, String type) {
        super(name, brand, shade, price, crueltyFree, waterproof, skinType);
        this.type = type;
    }
    
    public void apply() {
        System.out.println("Applying " + shade + " " + type + " eyeliner on eyes.");
    }

    public void smudge() {
        System.out.println("Smudging " + shade + " " + type + " eyeliner on outer corners of eyes.");
    }

    public void addDetails() {
        System.out.println("Adding " + shade + " " + type + " eyeliner on inner corners of eyes and other detailed spots.");
    }
}
