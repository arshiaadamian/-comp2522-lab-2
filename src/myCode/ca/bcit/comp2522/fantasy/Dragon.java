package ca.bcit.comp2522.fantasy;

public class Dragon extends Creature {
    private int firePower; // 0 - 100

    public Dragon(String name, Date dateOfBirth, int health, int firePower) {
        super(name, dateOfBirth, health);
        if (firePower < 0 || firePower > 100) {
            throw new IllegalArgumentException("firePower must be between 0 and 100");
        }
        this.firePower = firePower;
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Fire Power: " + firePower);
    }

    public void breatheFire(Creature target) throws LowFirePowerException {
        if (firePower < 10) {
            throw new LowFirePowerException("Not enough fire power to breathe fire (need >= 10).");
        }
        firePower -= 10;
        target.takeDamage(20);
    }

    public void restoreFirePower(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        firePower = Math.min(100, firePower + amount);
    }

    public int getFirePower() {
        return firePower;
    }
}
