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
    private Map<String, Exit> exitMap;
    private List<Item> itemList;

    public Scene(String id, boolean isLocked) {
        super(id);
        locked = isLocked;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        addSubobject(new TextObject("description", description));
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
