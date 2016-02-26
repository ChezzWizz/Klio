package klio;

/**
 * Created by Chezz on 2/18/2016.
 */
public class PlayerCharacter {

    private String name;
    private Scene currentScene;

    public static PlayerCharacter instance = new PlayerCharacter();
    private static boolean initialized = false;

    private PlayerCharacter() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentScene(Scene s) {
        currentScene = s;
    }

    public String getName() {
        return name;
    }

    public Scene getCurrentScene() {
        return currentScene;
    }

    public static boolean isInitialized() {
        return initialized;
    }

    public void initialize(Scene entryPoint) {
        currentScene = entryPoint;
        initialized = true;
    }

}
