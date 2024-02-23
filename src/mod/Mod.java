package mod;

import java.util.Arrays;

public class Mod {

    private final String name, rarity, polarity;
    private final int rank, initialDrain, drainIncreaseOnRankUp;

    private final String[] statsEffected;

    private final Double[] effectIncreaseOnRankUp, effectOnStats;

    public Mod(String name,
               String rarity,
               String polarity,
               int rank,
               int initalDrain,
               String[] statsEffected,
               Double[] effectOnStats,
               Double[] effectIncreaseOnRankUp,
               int drainIncreaseOnRankUp) {


        this.name = name;
        this.rarity = rarity;
        this.polarity = polarity;
        this.rank = rank;
        this.initialDrain = initalDrain;
        this.statsEffected = statsEffected;
        this.effectOnStats = effectOnStats;
        this.effectIncreaseOnRankUp = effectIncreaseOnRankUp;
        this.drainIncreaseOnRankUp = drainIncreaseOnRankUp;

    }

    public String getName() {
        return this.name;
    }

    public String getRarity() {
        return this.rarity;
    }

    public String getPolarity() {
        return this.polarity;
    }

    public int getRank() {
        return this.rank;
    }

    public int getInitialDrain() {
        return initialDrain;
    }

    public String[] getStatsEffected() {
        return this.statsEffected;
    }

    public Double[] getEffectIncreaseOnRankUp() {
        return this.effectIncreaseOnRankUp;
    }

    public int getDrainIncreaseOnRankUp() {
        return this.drainIncreaseOnRankUp;
    }

    public Double[] getEffectOnStats() {
        return this.effectOnStats;
    }

    public String toString() {
        return "Hello";
    }

    public static void main(String[] args) {
        Mod testMod = new Mod("Intensify", "Rare", "Madurai", 0, 6, new String[]{"Ability Strength"}, new Double[]{1.05}, new Double[]{0.05}, 1);

        System.out.println("Name: "+testMod.getName()
        +"\n"
        +"Rarity: "+testMod.getRarity()
        +"\n"
        +"Polarity: "+testMod.getPolarity()
        +"\n"
        +"Rank: "+testMod.getRank()
        +"\n"
        +"Initial Drain: "+testMod.getInitialDrain()
        +"\n"
        +"Stats effected: "+Arrays.toString(testMod.getStatsEffected())
        +"\n"
        +"Effect on stats: "+Arrays.toString(testMod.getEffectOnStats())
        +"\n"
        +"Stat increase on rank up: "+Arrays.toString(testMod.getEffectIncreaseOnRankUp())
        +"\n"
        +"Drain increase on rank up: "+testMod.getDrainIncreaseOnRankUp()
        );
    }


}
