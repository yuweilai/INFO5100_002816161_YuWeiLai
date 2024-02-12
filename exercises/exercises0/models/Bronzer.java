package exercises.exercises0.models;

public class Bronzer extends MakeupProduct {
    public String undertone;
    public String finish;
    public double sunProtectionFactor;

    public Bronzer(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType, String undertone, String finish, double sunProtectionFactor) {
        super(name, brand, shade, price, crueltyFree, waterproof, skinType);
        this.undertone = undertone;
        this.finish = finish;
        this.sunProtectionFactor = sunProtectionFactor;
        System.out.println(name + " Bronzer created.");
    }

    public void addWarmth() {
        System.out.println("Adding warmth with " + undertone + " Bronzer.");
    }

    public void setFinish(String finish) {
        this.finish = finish;
        System.out.println("Setting finish for " + undertone + " Bronzer to " + finish + ".");
    }

    public void setSunProtectionFactor(double spf) {
        this.sunProtectionFactor = spf;
        System.out.println("Setting SPF for " + undertone + " Bronzer to " + spf + ".");
    }
}
