/***************************************************************************************************
 * The MIT License (MIT)
 *
 * Copyright (c)2015 Project Klio
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

import java.util.HashMap;
import java.util.Map;

/**
 * This is the class that holds all the data related to a scene object. A scene has text that can be
 * printed to some output stream and may contain NPCs or items that the character can interact with.
 *
 * Created by Chezz on 1/1/2016.
 */
public class Scene {
    private int _id;
    private boolean _topLevel;
    private String _text;
    private Map<String, String> _npcMap;
    private Map<String, String> _itemMap;
    private Map<String, String> _commandMap;

    public Scene(int id, boolean topLevel) {
        _id = id;
        _topLevel = topLevel;
        _text = null;
        _npcMap = new HashMap<>();
        _itemMap = new HashMap<>();
        _commandMap = new HashMap<>();
    }

    public void addNpc(String textDescriptor, String npcId) {
        _npcMap.put(textDescriptor, npcId);
    }

    public void addItem(String textDescriptor, String itemId) {
        _itemMap.put(textDescriptor, itemId);
    }

    public void addCommand(String command, String target) {
        _commandMap.put(command, target);
    }

    public void setCommandMap(Map<String, String> map) {
        _commandMap = map;
    }

    public void setNpcMap(Map<String, String> map) {
        _npcMap = map;
    }

    public void setItemMap(Map<String, String> map) {
        _itemMap = map;
    }

    public void setText(String text) {
        _text = text;
    }

    public String getText() {
        return _text;
    }

    public int getId() {
        return _id;
    }

}
