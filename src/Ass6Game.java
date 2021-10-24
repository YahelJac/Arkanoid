//208384420

import java.util.ArrayList;
import java.util.List;

/**
 * this class runs the game.
 * it calls the game class to initialize and run the game
 */
public class Ass6Game {
    /**
     * this function run the game.
     *
     * @param args which level to run in which order
     */
    public static void main(String[] args) {
        List<LevelInformation> levelInformationList = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("1")) {
                levelInformationList.add(new DirectHit());
            }
            if (args[i].equals("2")) {
                levelInformationList.add(new WideEasy());
            }
            if (args[i].equals("3")) {
                levelInformationList.add(new KingKong());
            }
            if (args[i].equals("4")) {
                levelInformationList.add(new Rainbow());
            }

        }  if (levelInformationList.size() == 0) {

            levelInformationList.add(new DirectHit());
            levelInformationList.add(new WideEasy());
            levelInformationList.add(new KingKong());
            levelInformationList.add(new Rainbow());
        }
        GameFlow gameFlow = new GameFlow();
        gameFlow.runLevels(levelInformationList);

    }


}
