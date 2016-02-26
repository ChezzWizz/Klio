package klio;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chezz on 2/18/2016.
 */
public abstract class AdventureGameObject {

    protected String id;
    protected Map<String, AdventureGameObject> subobjectMap;

    public AdventureGameObject(String id) {
        this.id = id;
    }

    public void addSubobject(AdventureGameObject ago) {
        if(subobjectMap == null) {
            subobjectMap = new HashMap<>();
        }

        subobjectMap.put(ago.getId(), ago);
    }

    public String getId() {
        return id;
    }

    public AdventureGameObject getSubobject(String id) {
        return subobjectMap.get(id);
    }

}
