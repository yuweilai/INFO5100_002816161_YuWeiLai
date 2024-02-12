package exercises.exercises0.models;

public class MakeupProduct {
    String name;
    int id;
    String brand;
    String shade;
    double price;
    boolean crueltyFree;
    boolean waterproof;
    String skinType;

    private static int counter = 1;
    
    public MakeupProduct(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType) {
        this.name = name;
        this.brand = brand;
        this.shade = shade;
        this.price = price;
        this.crueltyFree = crueltyFree;
        this.waterproof = waterproof;
        this.skinType = skinType;
        System.out.println(name + " created.");
        this.id = counter++;
        System.out.println(name + " with ID: " + id + " created.");
    }
    
    public void apply() {
        System.out.println("Applying " + name + " on skin.");
    }
    
    public void remove() {
        System.out.println("Removing " + name + " from skin.");
    }
    
    public void checkCompatibility() {
        System.out.println("Checking compatibility of " + name + " with " + skinType + " skin.");
    }

    public class Brush {
        String type;
        String material;
        
        public Brush(String type, String material) {
            this.type = type;
            this.material = material;
            System.out.println("Brush created.");
        }
        
        public void apply() {
            System.out.println("Applying makeup with " + type + " brush.");
        }
        
        public void clean() {
            System.out.println("Cleaning " + type + " brush.");
        }
    }
    
    public class Palette {
        int numOfColors;
        
        public Palette(int numOfColors) {
            this.numOfColors = numOfColors;
            System.out.println("Palette created.");
        }
        
        public void mixColors() {
            System.out.println("Mixing colors in the palette.");
        }
        
        public void customize() {
            System.out.println("Customizing the palette.");
        }
    }
}