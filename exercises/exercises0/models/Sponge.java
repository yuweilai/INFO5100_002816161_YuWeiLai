package exercises.exercises0.models;

public class Sponge {

    public String material;
    public boolean reusable;
    public String name;
    public String brand;
    public String category;
    public double price;
    public String shade;
    public String skinType;
    public int quantity;

    public Sponge(String name, String brand, String category, double price, String shade, String skinType, int quantity, boolean crueltyFree, String material, boolean reusable) {
        
        this.material = material;
        this.reusable = reusable;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.shade = shade;
        this.skinType = skinType;
        this.quantity = quantity;

        System.out.println("Sponge " + name + " created.");
    }

    public void clean() {
        System.out.println("Cleaning " + name + " sponge...");
    }

    public void applyFoundation() {
        System.out.println("Applying foundation with " + name + " sponge...");
    }

    public void applySunscreen() {
        System.out.println("Applying sunscreen with " + name + " sponge...");
    }

    public boolean isReusable() {
        return reusable;
    }
}
