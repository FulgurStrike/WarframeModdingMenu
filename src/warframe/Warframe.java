package warframe;

import RankOutOfBoundsException.RankOutOfBoundsException;
import mod.*;

import java.util.ArrayList;

public class Warframe {

    private String name;
    private int health;
    private int sheilds;
    private final int energy;
    private int armour;
    private final int BASE_ARMOUR;
    private int modCapacity;
    private int level;
    private ArrayList<Mod> mods = new ArrayList<Mod>();;
    private int abilityStrength, abilityDuration, abilityRange, abilityEfficiency, sprintSpeed;

    public Warframe(String name,
                    int health,
                    int sheilds,
                    int energy,
                    int baseArmour,
                    int sprintSpeed) {

        this.name = name;
        this.health = health;
        this.sheilds = sheilds;
        this.BASE_ARMOUR = baseArmour;
        this.armour = BASE_ARMOUR;
        this.energy = energy;
        this.modCapacity = 0;
        this.level = 0;
        this.abilityStrength = 100;
        this.abilityDuration = 100;
        this.abilityRange = 100;
        this.abilityEfficiency = 100;
        this.sprintSpeed = sprintSpeed;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return health;
    }

    public int getSheilds() {
        return sheilds;
    }

    public int getSprintSpeed()  {
        return this.sprintSpeed;
    }

    public int getEnergy() {
        return energy;
    }

    public int getArmor() {
        return armour;
    }

    public int getAbilityStrength() {
        return this.abilityStrength;
    }

    public int getAbilityDuration() {
        return this.abilityDuration;
    }

    public int getAbilityRange() {
        return this.abilityRange;
    }

    public int getAbilityEfficiency() {
        return this.abilityEfficiency;
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
        this.mods.add(mod);
    }

    public void setLevel(int level) {
        this.level += level;
        this.modCapacity += level;
    }

    public void applyModEffects() {
        this.health = 100;
        this.sheilds = 100;
        this.abilityStrength = 100;
        this.abilityDuration = 100;
        this.abilityRange = 100;
        this.abilityEfficiency = 100;
        this.sprintSpeed = 1;
        this.armour = this.BASE_ARMOUR;

        for (Mod mod : mods) {
            for(int i = 0; i<mod.getEffectOnStats().length; i++) {
                applyModEffect(mod);
            }
        }
    }

    private void applyModEffect(Mod mod) {
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
                case SPRINT_SPEED:
                    this.sprintSpeed = (int) Math.round(this.sprintSpeed * mod.getEffectOnStats()[i]);
            }
        }
    }

    public String toString() {
        return this.getName() + "\n"
                + "Health :" + this.getHealth() + "\n"
                + "Shields :" + this.getSheilds() + "\n"
                +"Health :" + this.getArmor() + "\n"
                +"Sprint Speed: " + this.getSprintSpeed()
                +"Ability Strength :" + this.getAbilityStrength() + "\n"
                +"Ability Duration :" + this.getAbilityDuration() + "\n"
                +"Ability Range :" + this.getAbilityRange() + "\n"
                +"Energy Efficiency :" + this.getAbilityEfficiency() + "\n";
    }

    public static void main(String[] args) {
        Mod intensify = new Mod("Intensify", "Rare", "Madurai", 0, 5, 6, new String[]{"Ability_Strength"}, new Double[]{1.05}, new Double[]{0.05}, 1);
        Warframe Volt = new Warframe("Volt", 100, 100, 100, 100, 1);

        Volt.setMod(intensify);
        System.out.println(Volt);
        Volt.applyModEffects();
        System.out.println(Volt.getAbilityStrength());

        try {
            intensify.changeRank(5);
        } catch (RankOutOfBoundsException e) {
            System.out.println("Rank exceeds max rank");
        }

        Volt.applyModEffects();

        System.out.println(Volt.getAbilityStrength() + " " + Volt.getAbilityDuration());

    }
}
