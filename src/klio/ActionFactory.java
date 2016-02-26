package klio;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chezz on 2/19/2016.
 */
public class ActionFactory {

    public static ActionFactory instance = new ActionFactory();
    private static boolean initialized = false;

    private Map<String, Action> actionMap;

    private ActionFactory() {

    }

    public static boolean isInitialized() {
        return initialized;
    }

    public Action getAction(String action) {
        return actionMap.get(action);
    }

    public void initialize() {

        if (actionMap == null) {

            actionMap = new HashMap<>();

            actionMap.put("describe", new Action() {
                @Override
                public void execute(AdventureGameObject o) {
                    System.out.println(o.toString());
                }
            });

            actionMap.put("relocate", new Action() {
                @Override
                public void execute(AdventureGameObject o) {
                    if (o instanceof Scene) {
                        PlayerCharacter.instance.setCurrentScene((Scene) o);
                    } else {
                        System.out.println("Cannot relocate to " + o.toString());
                    }
                }
            });

            actionMap.put("endGame", new Action() {
                @Override
                public void execute(AdventureGameObject o) {
                    KlioApp.gameState = KlioApp.GAME_STATE_CLOSING;
                }
            });

            initialized = true;

        }
    }

}
