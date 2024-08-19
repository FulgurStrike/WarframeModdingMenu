package fulgurstrike.warframemoddingproject.warframe;

import java.util.ArrayList;

public class WarframeList {
    private ArrayList<Warframe> warframes;

    public WarframeList() {
        warframes = new ArrayList<>();
    }

    public void addWarframe(Warframe warframe) {
        warframes.add(warframe);
    }

    public ArrayList<Warframe> getWarframes() {
        return warframes;
    }

    public void deleteWarframe(Warframe warframe) {
        warframes.remove(warframe);
    }
}
