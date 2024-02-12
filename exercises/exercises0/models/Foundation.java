package exercises.exercises0.models;

public class Foundation extends MakeupProduct {
    public String coverage;
    
    public Foundation(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType, String coverage) {
        super(name, brand, shade, price, crueltyFree, waterproof, skinType);
        this.coverage = coverage;
    }
    
    public void apply() {
        System.out.println("Applying " + coverage + " coverage " + shade + " foundation on face.");
    }

    public void set() {
        System.out.println("Setting " + coverage + " coverage " + shade + " foundation on face.");
    }

    public void touchUp() {
        System.out.println("Touching up with " + coverage + " coverage " + shade + " foundation on face.");
    }
}