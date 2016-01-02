package klio;

import java.util.Map;

/**
 * This is the class that holds all the data related to a scene object. A scene has text that can be
 * printed to some output stream and may contain NPCs or items that the character can interact with.
 *
 * Created by Chezz on 1/1/2016.
 */
public class Scene {
    private int _id;
    private String _text;
    private Map<String, Npc> _npcMap;
    private Map<String, Item> _itemMap;

    public Scene(int id, String text, Npc[] npcs, Item[] items) {

    }
}
