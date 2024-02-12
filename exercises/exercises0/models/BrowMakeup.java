package exercises.exercises0.models;

public class BrowMakeup extends MakeupProduct {
    public String formula;
    public String finish;
    public boolean longLasting;

    public BrowMakeup(String name, String brand, String shade, double price, boolean crueltyFree, boolean waterproof, String skinType, String formula, String finish, boolean longLasting) {
        super(name, brand, shade, price, crueltyFree, waterproof, skinType);
        this.formula = formula;
        this.finish = finish;
        this.longLasting = longLasting;
        System.out.println(name + " Brow Makeup created.");
    }

    public void fillIn() {
        System.out.println("Filling in brows with " + formula + " Brow Makeup.");
    }

    public void setFinish(String finish) {
        this.finish = finish;
        System.out.println("Setting finish for " + formula + " Brow Makeup to " + finish + ".");
    }

    public void setLongLasting(boolean longLasting) {
        this.longLasting = longLasting;
        System.out.println("Setting long-lasting property for " + formula + " Brow Makeup to " + longLasting + ".");
    }
}