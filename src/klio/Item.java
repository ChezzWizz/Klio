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
    private Map<String, Action> verbMap;

    public Item(String id, boolean isInventoryItem) {
        super(id);
        inventory = isInventoryItem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        addSubobject(new TextObject("description", description));
    }

    public void addVerb(String verb, Action action) {
        if(verbMap == null) {
            verbMap = new HashMap<>();
        }

        verbMap.put(verb, action);
    }

}
