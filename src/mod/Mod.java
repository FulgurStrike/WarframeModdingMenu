package mod;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import RankOutOfBoundsException.*;

public class Mod {

    private final String name, rarity, polarity;
    private int rank;
    private final int maxRank;
    private int drain;
    private final int drainIncreaseOnRankUp;
    private final ModEffects[] statsEffected;
    private final Double[] effectIncreaseOnRankUp;
    private final Double[]  effectOnStats;

    public enum ModEffects{
        SHIELD_CAPACITY,
        HEALTH,
        ARMOUR,
        ENERGY,
        ABILITY_STRENGTH,
        ABILITY_DURATION,
        ENERGY_EFFICIENCY,
        ABILITY_RANGE
    }

    public Mod(String name,
               String rarity,
               String polarity,
               int rank,
               int maxRank,
               int initalDrain,
               String[] statsEffected,
               Double[] effectOnStats,
               Double[] effectIncreaseOnRankUp,
               int drainIncreaseOnRankUp) {


        this.name = name;
        this.rarity = rarity;
        this.polarity = polarity;
        this.rank = rank;
        this.maxRank= maxRank;
        this.drain = initalDrain;

        this.statsEffected = generateModEffectsArray(statsEffected);

        this.effectOnStats = effectOnStats;
        this.effectIncreaseOnRankUp = effectIncreaseOnRankUp;
        this.drainIncreaseOnRankUp = drainIncreaseOnRankUp;

    }

    private static ModEffects[] generateModEffectsArray(String[] statEffects) {
        ModEffects[] effects = new ModEffects[statEffects.length];
        for (int i = 0; i < statEffects.length; i++) {
            effects[i] = ModEffects.valueOf(statEffects[i].toUpperCase());
        }
        return effects;
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

    public int getDrain() {
        return drain;
    }

    public ModEffects[] getStatsEffected() {
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


    public void changeRank(int newRank) throws RankOutOfBoundsException{
        ArrayList<Double> statIncreaseAfterRankUp = new ArrayList<>();
        DecimalFormat twoDecimalPlaces = new DecimalFormat("#.##");

        if(newRank > this.maxRank){
            throw new RankOutOfBoundsException();
        }

        for(int i = 0; i<effectIncreaseOnRankUp.length; i++) {
            statIncreaseAfterRankUp.add(effectIncreaseOnRankUp[i] * newRank);
        }

        for(int i = 0; i<effectOnStats.length; i++) {
            this.effectOnStats[i] = Double.valueOf(twoDecimalPlaces.format(this.effectOnStats[i] + statIncreaseAfterRankUp.get(i)));
        }

        this.drain = this.drain + newRank;
        this.rank = newRank;
    }

    public String toString() {
        return  "Name: "+this.getName()
                +"\n"
                +"Rarity: "+this.getRarity()
                +"\n"
                +"Polarity: "+this.getPolarity()
                +"\n"
                +"Rank: "+this.getRank()
                +"\n"
                +"Drain: "+this.getDrain()
                +"\n"
                +"Stats effected: "+Arrays.toString(this.getStatsEffected())
                +"\n"
                +"Effect on stats: "+Arrays.toString(this.getEffectOnStats())
                +"\n"
                +"Stat increase on rank up: "+Arrays.toString(this.getEffectIncreaseOnRankUp())
                +"\n"
                +"Drain increase on rank up: "+this.getDrainIncreaseOnRankUp();
    }

    public static void main(String[] args) {
        Mod testMod = new Mod("Blind Rage", "Rare", "Madurai", 0, 10, 6, new String[]{"Ability_Strength", "Energy_Efficiency"}, new Double[]{1.09, 0.95}, new Double[]{0.09, -0.05}, 1);
        Mod testMod2 = new Mod("Intensify", "Rare", "Madurai", 0, 5, 6, new String[]{"Ability_Strength"}, new Double[]{1.05}, new Double[]{0.05}, 1);

        try{
            testMod.changeRank(10);
            System.out.println(testMod);
        }catch (RankOutOfBoundsException e) {
            System.err.println("Rank exceeds max rank of mod");
        }
    }
}
