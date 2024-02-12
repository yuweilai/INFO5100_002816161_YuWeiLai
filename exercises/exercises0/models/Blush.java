package exercises.exercises0.models;

public class Blush extends MakeupProduct {
    public String finish;
    public String occasion;
    public int pigmentation;

    public Blush(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType, String finish, String occasion, int pigmentation) {
        super(name, brand, shade, price, crueltyFree, waterproof, skinType);
        this.finish = finish;
        this.occasion = occasion;
        this.pigmentation = pigmentation;
        System.out.println(name + " Blush created.");
    }

    public void enhanceCheeks() {
        System.out.println("Enhancing cheeks with " + finish + " Blush.");
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
        System.out.println("Setting occasion for " + finish + " Blush to " + occasion + ".");
    }

    public void adjustPigmentation(int level) {
        this.pigmentation = level;
        System.out.println("Adjusting pigmentation level of " + finish + " Blush to " + level + ".");
    }
}