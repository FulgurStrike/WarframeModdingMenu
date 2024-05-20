package warframe;

import mod.*;

import java.util.ArrayList;

public class Warframe {

    private int health;
    private int sheilds;
    private final int energy;
    private int armour;
    private int modCapacity;
    private int level;
    private ArrayList<Mod> mods;
    private int abilityStrength, abilityDuration, abilityRange, abilityEfficiency;

    public Warframe(int health,
                    int sheilds,
                    int energy,
                    int armour) {

        this.health = health;
        this.sheilds = sheilds;
        this.armour = armour;
        this.energy = energy;
        this.modCapacity = 0;
        this.level = 0;
        ArrayList<Mod> mods = new ArrayList<Mod>();
    }

    public int getHealth() {
        return health;
    }

    public int getSheilds() {
        return sheilds;
    }

    public int getEnergy() {
        return energy;
    }

    public int getArmor() {
        return armour;
    }

    public int getModCapacity() {
        return modCapacity;
    }

    public int getLevel() {
        return level;
    }

    public ArrayList<Mod> getMods() {
        return mods;
    }

    public void setMod(Mod mod) {
        mods.add(mod);
    }

    public void setLevel(int level) {
        this.level += level;
        this.modCapacity += level;
    }

    public void applyModEffects() {
        for (Mod mod : mods) {
            for(int i = 0; i<mod.getEffectOnStats().length; i++) {

            }
        }
    }

    public void applyModEffect(Mod mod) {
        for(int i = 0; i<mod.getEffectOnStats().length; i++) {
            Mod.ModEffects effect = mod.getStatsEffected()[i];
            switch (effect) {
                case ABILITY_STRENGTH:
                    this.abilityStrength = (int) Math.round(this.abilityStrength * mod.getEffectOnStats()[i]);
                    break;
                case ABILITY_DURATION:
                    this.abilityDuration = (int) Math.round(this.abilityDuration * mod.getEffectOnStats()[i]);
                    break;
                case ENERGY_EFFICIENCY:
                    this.abilityEfficiency = (int) Math.round(this.abilityEfficiency * mod.getEffectOnStats()[i]);
                case ABILITY_RANGE:
                    this.abilityRange = (int) Math.round(this.abilityRange * mod.getEffectOnStats()[i]);
                    break;
                case HEALTH:
                    this.health = (int) Math.round(this.health * mod.getEffectOnStats()[i]);
                    break;
                case SHIELD_CAPACITY:
                    this.sheilds = (int) Math.round(this.sheilds * mod.getEffectOnStats()[i]);
                    break;
                case ARMOUR:
                    this.armour = (int) Math.round(this.armour * mod.getEffectOnStats()[i]);
            }
        }
    }
}
