package klio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chezz on 2/18/2016.
 */
public class Scene extends AdventureGameObject {

    private boolean locked;

    private String name;
    private String description;
    private Map<String, Exit> exitMap;
    private List<Item> itemList;
    private Map<String, Action> verbMap;
    private List<AdventureGameObject> gameObjectList;

    public Scene(int id, String varId, boolean isLocked) {
        super(id, varId);
        locked = isLocked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addExit(String direction, Exit exit) {
        if(exitMap == null) {
            exitMap = new HashMap<>();
        }

        exitMap.put(direction, exit);
    }

    public void addItem(Item item) {
        if(itemList == null) {
            itemList = new ArrayList<>();
        }

        itemList.add(item);
    }

    // TODO: etc...

}
