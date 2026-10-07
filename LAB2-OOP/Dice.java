import java.util.Random;

public class Dice {
    private int value;
    private Random random;

    public Dice() {
        this.value = 1;
        this.random = new Random();
    }

    public int roll() {
        this.value = random.nextInt(6) + 1;
        return this.value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Dice Class & Experimental Probability ---");

        Dice myDice = new Dice();
        int totalRolls = 10000;

        int[] frequencies = new int[7];

        for (int i = 0; i < totalRolls; i++) {
            int rolledValue = myDice.roll();
            frequencies[rolledValue]++;
        }

        System.out.println("Total Rolls: " + totalRolls);
        System.out.println("Face\tCount\tExperimental Probability");
        System.out.println("----------------------------------------");

        for (int face = 1; face <= 6; face++) {
            double probability = (double) frequencies[face] / totalRolls;
            System.out.printf("%d\t%d\t%.4f (%.2f%%)\n", 
                face, frequencies[face], probability, probability * 100);
        }
    }
}