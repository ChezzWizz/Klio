package klio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chezz on 2/18/2016.
 */
public class Item extends AdventureGameObject {

    private boolean inventory;

    private String name;
    private String description;
    private Map<String, Action> verbMap;
    private List<AdventureGameObject> gameObjectList;

    public Item(int id, String varId, boolean isInventoryItem) {
        super(id, varId);
        inventory = isInventoryItem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addVerb(String verb, Action action) {
        if(verbMap == null) {
            verbMap = new HashMap<>();
        }

        verbMap.put(verb, action);
    }

    public void addGameObject(AdventureGameObject object) {
        if(gameObjectList == null) {
            gameObjectList = new ArrayList<>();
        }

        gameObjectList.add(object);
    }

}
