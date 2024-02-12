package exercises.exercises0.models;

public class Highlighter extends MakeupProduct {
    public String undertone;
    public String glowType;
    public int shimmerLevel;

    public Highlighter(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType, String undertone, String glowType, int shimmerLevel) {
        super(name, brand, shade, price, crueltyFree, waterproof, skinType);
        this.undertone = undertone;
        this.glowType = glowType;
        this.shimmerLevel = shimmerLevel;
        System.out.println(name + " Highlighter created.");
    }

    public void addGlow() {
        System.out.println("Adding glow with " + undertone + " Highlighter.");
    }

    public void setUndertone(String undertone) {
        this.undertone = undertone;
        System.out.println("Setting undertone for " + undertone + " Highlighter to " + undertone + ".");
    }

    public void adjustShimmerLevel(int level) {
        this.shimmerLevel = level;
        System.out.println("Adjusting shimmer level of " + undertone + " Highlighter to " + level + ".");
    }
}