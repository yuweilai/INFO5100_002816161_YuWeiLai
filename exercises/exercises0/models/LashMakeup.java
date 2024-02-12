package exercises.exercises0.models;

public class LashMakeup extends MakeupProduct {
    public String volume;
    public double length;
    
    public LashMakeup(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType, String finish, String volume, double length) {
        super(name, brand, shade, price, crueltyFree, waterproof, skinType);
        this.volume = volume;
        this.length = length;
    }

    public void applyMascara() {
        System.out.println("Applying " + volume + " volume " + length + " length " + " mascara on eyes.");
    }

    public void applyFalseLashes() {
        System.out.println("Applying " + volume + " volume " + length + " length " + " falsies on eyes.");
    }

    public void curlLashes() {
        System.out.println("Curling lashes before applying " + volume + " volume " + length + " length " + " mascara or falsies.");
    }
}