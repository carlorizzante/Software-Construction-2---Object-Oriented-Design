import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        HashMap<GuideLeader, ArrayList<GirlGuide>> troops = new HashMap<>();

        // Guiders
        GuideLeader vanessa = new GuideLeader("Vanessa");
        GuideLeader trixie = new GuideLeader("Trixie");
        GirlGuide chloe = new GirlGuide("Chloe");
        GirlGuide kira = new GirlGuide("Kira");

        // Troops
        troops.put(vanessa, new ArrayList<GirlGuide>());
        troops.put(trixie, new ArrayList<GirlGuide>());

        // GirlGuides into troops
        ArrayList<GirlGuide> fortyNinthGuides = troops.get(trixie);

        fortyNinthGuides.add(chloe);

        troops.put(vanessa, fortyNinthGuides);

        fortyNinthGuides.add(kira);

        troops.get(trixie).remove(chloe);

        ArrayList<GirlGuide> eighteenthGuides = troops.get(new GuideLeader("Trixie"));


    }
}
