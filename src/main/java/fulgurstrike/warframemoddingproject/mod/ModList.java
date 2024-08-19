package fulgurstrike.warframemoddingproject.mod;

import java.util.ArrayList;

public class ModList {

    private ArrayList<Mod> mods;

    public ModList() {
        this.mods = new ArrayList<>();
    }

    public ArrayList<Mod> getMods() {
        return mods;
    }

    public void addMod(Mod mod) {
        mods.add(mod);
    }

    public void removeMod(Mod mod) {
        mods.remove(mod);
    }
}
