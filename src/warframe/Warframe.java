package warframe;

import exceptions.RankOutOfBoundsException;
import exceptions.TooManyModsException;
import mod.*;

import java.util.ArrayList;

public class Warframe {


    private final int BASE_ARMOUR, BASE_HEALTH, BASE_SHIELDS, BASE_SPEED;
    private final int BASE_ENERGY = 100;
    private final int BASE_STRENGTH = 100;
    private final int BASE_DURATION = 100;
    private final int BASE_RANGE = 100;
    private final int BASE_EFFICIENCY = 100;

    private final String name;
    private int health, shields, energy, armour, abilityStrength, abilityDuration, abilityRange, abilityEfficiency, sprintSpeed;
    private final int maxEnergy;
    private int modCapacity = 0;
    private int level = 0;
    private ArrayList<Mod> mods = new ArrayList<Mod>();

    public Warframe(String name,
                    int baseHealth,
                    int baseSheilds,
                    int baseArmour,
                    int sprintSpeed,
                    int maxEnergy) {

        this.name = name;

        this.BASE_HEALTH = baseHealth;
        this.BASE_SHIELDS = baseSheilds;
        this.BASE_ARMOUR = baseArmour;

        this.health = BASE_HEALTH;
        this.shields = BASE_SHIELDS;
        this.armour = BASE_ARMOUR;
        this.energy = BASE_ENERGY;

        this.maxEnergy = maxEnergy;
        this.sprintSpeed = sprintSpeed;
        this.BASE_SPEED = sprintSpeed;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return health;
    }

    public int getShields() {
        return shields;
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

    public void setMod(Mod mod) throws TooManyModsException {
        if(this.getMods().size() < 8) {
            this.mods.add(mod);
        }else {
            throw new TooManyModsException();
        }

    }

    public void setLevel(int level) {
        this.level += level;
        this.modCapacity += level;
    }

    public void applyModEffects() {
        this.health = this.BASE_HEALTH;
        this.shields = this.BASE_SHIELDS;
        this.abilityStrength = this.BASE_STRENGTH;
        this.abilityDuration = this.BASE_DURATION;
        this.abilityRange = this.BASE_RANGE;
        this.abilityEfficiency = this.BASE_EFFICIENCY;
        this.sprintSpeed = this.BASE_SPEED;
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
                    this.shields = (int) Math.round(this.shields * mod.getEffectOnStats()[i]);
                    break;
                case ARMOUR:
                    this.armour = (int) Math.round(this.armour * mod.getEffectOnStats()[i]);
                case SPRINT_SPEED:
                    this.sprintSpeed = (int) Math.round(this.sprintSpeed * mod.getEffectOnStats()[i]);
                    break;
                case ENERGY:
                    this.energy = (int) Math.round(this.maxEnergy * mod.getEffectOnStats()[i]);

            }
        }
    }

    public String toString() {
        return this.getName() + "\n"
                + "Health :" + this.getHealth() + "\n"
                + "Shields :" + this.getShields() + "\n"
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

        try {
            Volt.setMod(intensify);
        }catch (TooManyModsException e) {
            e.printStackTrace();
        }

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
