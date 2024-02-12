package exercises.exercises0;

import exercises.exercises0.models.Blush;
import exercises.exercises0.models.Bronzer;
import exercises.exercises0.models.BrowMakeup;
import exercises.exercises0.models.Eyeliner;
import exercises.exercises0.models.Foundation;
import exercises.exercises0.models.Lipstick;
import exercises.exercises0.models.MakeupProduct;
import exercises.exercises0.models.Sponge;
import exercises.exercises0.models.Highlighter;
import exercises.exercises0.models.LashMakeup;

public class Main {
    public static void main(String[] args) {
        MakeupProduct mascara = new MakeupProduct("Mascara", "Maybelline", "Black", 9.99, true, true, "All");
        MakeupProduct falsies = new MakeupProduct("Falsies", "NARS", "Orgasm", 30.00, true, false, "All");
        MakeupProduct concealer = new MakeupProduct("Concealer", "Tarte", "Light Beige", 27.00, true, false, "Combination");
        
        Lipstick ultraMatteLipstick = new Lipstick("Ultra Matte Lipstick", "MAC", "Ruby Woo", 20.00, true, false, "All", "Matte");
        Lipstick glossLipstick = new Lipstick("Gloss Lipstick", "Fenty Beauty", "Fenty Glow", 19.00, true, true, "All", "Gloss");
        Lipstick MatteLipstick = new Lipstick("Matte Lipstick", "MAC", "Chili", 20.00, true, false, "All", "Matte");
        
        Foundation liquidFoundation = new Foundation("Liquid Foundation", "Estee Lauder", "Double Wear", 42.00, true, false, "Oily", "Full");
        Foundation powderFoundation = new Foundation("Powder Foundation", "bareMinerals", "Original", 31.00, true, true, "Dry", "Medium");
        Foundation creamFoundation = new Foundation("Cream Foundation", "RMS", "The Cream", 42.00, true, false, "Oily", "Full");

        Eyeliner liquidEyeliner = new Eyeliner("Liquid Eyeliner", "L'Oreal", "Black", 8.99, true, true, "All", "Liquid");
        Eyeliner pencilEyeliner = new Eyeliner("Pencil Eyeliner", "Urban Decay", "Zero", 22.00, true, false, "All", "Pencil");
        Eyeliner gelEyeliner = new Eyeliner("Gel Eyeliner", "Sephora Collection", "Zero", 22.00, true, false, "All", "Pencil");

        Highlighter goldHighlighter = new Highlighter("Gold Highlighter", "Becca", "Champagne Pop", 38.00, true, false, "All", "Warm", "Metallic", 8);
        Highlighter pinkHighlighter = new Highlighter("Pink Highlighter", "NARS", "Orgasm", 30.00, true, false, "All", "Cool", "Luminous", 6);
        Highlighter pearlHighlighter = new Highlighter("Pearl Highlighter", "Anastasia Beverly Hills", "Snowflake", 25.00, true, false, "All", "Neutral", "Metallic", 10);

        Bronzer matteBronzer = new Bronzer("Matte Bronzer", "Benefit", "Hoola", 30.00, true, false, "All", "Warm", "Matte", 8);
        Bronzer shimmerBronzer = new Bronzer("Shimmer Bronzer", "NARS", "Laguna", 38.00, true, false, "All", "Neutral", "Shimmer", 6);
        Bronzer satinBronzer = new Bronzer("Satin Bronzer", "Too Faced", "Sun Bunny", 30.00, true, false, "All", "Cool", "Satin", 10);
    
        BrowMakeup browPencil = new BrowMakeup("Brow Pencil", "Benefit", "Hoola", 30.00, true, true, "dry", "pencil", "pencil", true);
        BrowMakeup browGel = new BrowMakeup("Brow Gel", "Benefit", "Hoola", 30.00, true, true, "dry", "gel", "pencil", true);
        BrowMakeup browPowder = new BrowMakeup("Brow Powder", "Benefit", "Hoola", 30.00, true, true, "dry", "powder", "pencil", true);

        LashMakeup niceMascara = new LashMakeup("Nice Mascara", "Two Faced", "Super Black", 30.0, true, true, "dry", "matte", "valumous", 0.2);
        LashMakeup lashPrimer = new LashMakeup("Lash Primer", "Lamcome", "Super Black", 30.0, true, true, "dry", "matte", "valumous", 0.2);
        LashMakeup lashSerum = new LashMakeup("Lash Serum", "Grande Cosmetics", "Super Black", 30.0, true, true, "dry", "matte", "valumous", 0.2);
    
        Sponge beautyBlender = new Sponge("Beauty Blender Sponge", "beauty blender", "Precision Makeup", 20.0, "pink", "oily", 2, true, "sponge", false);
        Sponge realTechniquesSponge = new Sponge("Real Techniques Sponge", "Real Techniques", "Precision Makeup", 20.0, "pink", "oily", 2, true, "sponge", false);
        Sponge fentyBeautySponge = new Sponge("Fenty Beauty Sponge", "Fenty Beauty", "Precision Makeup", 20.0, "pink", "oily", 2, true, "sponge", false);

        Blush matteBlush = new Blush("Matte Blush", "NARS", "Orgasm", 30.00, true, false, "All", "Matte", "Daytime", 8);
        Blush shimmerBlush = new Blush("Shimmer Blush", "Benefit", "Dandelion", 29.00, true, false, "All", "Shimmer", "Evening", 6);
        Blush creamBlush = new Blush("Cream Blush", "Fenty Beauty", "Petal Poppin", 20.00, true, false, "All", "Cream", "Anytime", 10);
    }
}