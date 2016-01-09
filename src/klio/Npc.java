/***************************************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c)2015 Project klio.Klio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 **************************************************************************************************/


package klio;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains the representation of a single NPC and the actions that can be performed on
 * that npc. The Npc object will also contain a collection of items and a description of the NPC.
 * Each NPC has a set of actions that can be used on them and will run a corresponding method or
 * return some corresponding Scene that describes the effect of the action taken against the NPC.
 *
 * Created by Chezz on 1/1/2016.
 */
public class Npc {
    private Map <String, Integer> _attributeMap;
    private String _text;
    private Map<String, String> _itemMap;
    private Map<String, String> _commandMap;
    private int _id;

    public Npc(int id) {
        _id = id;
        _text = null;
        _itemMap = new HashMap<>();
        _commandMap = new HashMap<>();
        _attributeMap = new HashMap<>(9);

        _attributeMap.put("str", null);
        _attributeMap.put("agl", null);
        _attributeMap.put("dex", null);
        _attributeMap.put("int", null);
        _attributeMap.put("wis", null);
        _attributeMap.put("cha", null);
        _attributeMap.put("min_damage", null);
        _attributeMap.put("max_damage", null);
        _attributeMap.put("armor_bonus", null);
    }

    public int getId() {
        return _id;
    }

    public void setText(String text) {
        _text = text;
    }

    public String getText() {
        return _text;
    }

    public void setAttribute(String attrName, int attrValue) {
        _attributeMap.replace(attrName, attrValue);
    }

    public int getAttribute(String attrName) {
        return _attributeMap.get(attrName);
    }

    public Map<String, Integer> getAttributeMap() {
        return Collections.unmodifiableMap(_attributeMap);
    }

    public void setCommandMap(Map<String, String> map) {
        _commandMap = map;
    }

    public void addCommand(String command, String target) {
        _commandMap.put(command, target);
    }

    public void setItemMap(Map<String, String> map) {
        _itemMap = map;
    }

    public void addItem(String textDescriptor, String itemId) {
        _itemMap.put(textDescriptor, itemId);
    }
}
