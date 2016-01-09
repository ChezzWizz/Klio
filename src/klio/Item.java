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
import java.util.Map;

/**
 * This class is for objects that can be interacted with within the text adventure.
 *
 * Created by Chezz on 1/1/2016.
 */
public class Item {
	private String _text;
    private int _id;
    private Map<String, String> _commandMap;
    private Map<String, Integer> _attributeMap;
    
    public Item(int id) {
		_id = id;
    	_text = null;
    	_commandMap = new HashMap<>();
    	_attributeMap = new HashMap<>(3);
    	_attributeMap.put("min_damage", null);
    	_attributeMap.put("max_damage", null);
    	_attributeMap.put("armor_bonus", null);
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
    
    public void setAttribute(String attribute, int value) {
    	_attributeMap.replace(attribute, value);
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
}
