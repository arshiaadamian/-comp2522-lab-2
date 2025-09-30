import ca.bcit.comp2522.fantasy.*;

public class CreatureTest
{
    public static void main (final String[] args)
    {
        Date dragonDateOfBirth = new Date(2003, 12, 6);
        Date elfDateOfBirth = new Date(1995, 2, 19);
        Date orcDateOfBirth = new Date(2006, 8, 25);

        Creature dragon = new Dragon("Arshia", dragonDateOfBirth, 300, 80);
        Creature elf = new Elf("Elfinho",  elfDateOfBirth, 150, 50);
        Creature orc = new Orc("TheYoungOrc",  orcDateOfBirth, 200, 30);

        // Print details
        dragon.getDetails();
        elf.getDetails();
        orc.getDetails();

        // Identify exact class at runtime
        System.out.println("\nRuntime class checks:");
        System.out.println("dragon is a " + dragon.getClass().getSimpleName());
        System.out.println("elf is a " + elf.getClass().getSimpleName());
        System.out.println("orc is a " + orc.getClass().getSimpleName());

        // Make them fight with exception handling
        System.out.println("\n--- Fights Begin ---");

        try {
            if (dragon instanceof Dragon) {
                System.out.println("[Turn 1] "
                        + dragon.getClass().getSimpleName()
                        + " breathes fire at "
                        + orc.getClass().getSimpleName() + "...");
                ((Dragon) dragon).breatheFire(orc);
                System.out.println("    ➜ Fire attack resolved. Orc status:");
                orc.getDetails(); // optional, remove if you don't want status prints
            }
        } catch (Exception e) {
            System.out.println("Dragon attack failed: " + e.getMessage());
        }

        try {
            if (elf instanceof Elf) {
                System.out.println("[Turn 2] "
                        + elf.getClass().getSimpleName()
                        + " casts a spell at "
                        + dragon.getClass().getSimpleName() + "...");
                ((Elf) elf).castSpell(dragon);
                System.out.println("    ➜ Spell resolved. Dragon status:");
                dragon.getDetails(); // optional
            }
        } catch (Exception e) {
            System.out.println("Elf spell failed: " + e.getMessage());
        }

        try {
            if (orc instanceof Orc) {
                System.out.println("[Turn 3] "
                        + orc.getClass().getSimpleName()
                        + " goes berserk!...");
                ((Orc) orc).berserk();
                System.out.println("    ➜ Berserk resolved. Orc status:");
                orc.getDetails(); // optional
            }
        } catch (Exception e) {
            System.out.println("Orc berserk failed: " + e.getMessage());
        }

        System.out.println("--- Fights End ---");


    }
}
