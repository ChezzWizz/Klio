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

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the Simple Api for XML handler for Klio adventure files. This class reads each xml node
 * that contains scene, npc, or item data and loads it into the map that is provided when the
 * SAXHandler is created.
 *
 * Created by Chezz on 1/4/2016.
 */
public class AdventureFileSAXHandler extends DefaultHandler {

    private Map<Integer, Scene> _sceneMap;
    private Map<Integer, Npc> _npcMap;
    private Map<Integer, Item> _itemMap;

    private Object _obj = null;

    private boolean _inSceneNode = false;
    private boolean _inNpcNode = false;
    private boolean _inItemNode = false;

    private boolean _inTextNode = false;
    private boolean _inCommandsNode = false;
    private boolean _inNpcRefsNode = false;
    private boolean _inItemRefsNode = false;

    private boolean _inAttributesNode = false;
    private boolean _inAttributeSubNode = false;

    private String _currentAttributeNode = null;

    /**
     * Constructs the handler object with the maps to fill with data from the xml.
     * @param sceneMap The scene map to populate.
     * @param npcMap The npc map to populate.
     */
    public AdventureFileSAXHandler(Map<Integer, Scene> sceneMap, Map<Integer, Npc> npcMap,
    		Map<Integer, Item> itemMap) {
        _sceneMap = sceneMap;
        _npcMap = npcMap;
        _itemMap = itemMap;
    }

    /**
     * Sets the current state to indicate what node we are in and if we are in an attribute node, we
     * then set the name of the attribute node that we are currently in. This method also
     * instantiates a new object of the type we need to populate the map associated with the current
     * node we are in.
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {

        if (qName.equalsIgnoreCase("scene")) {
            _inSceneNode = true;
            int sceneId = Integer.parseInt(attributes.getValue("id"));
            boolean isTopLevel = Boolean.parseBoolean(attributes.getValue("top_level"));
            _obj = new Scene(sceneId, isTopLevel);
        }

        if (qName.equalsIgnoreCase("npc")) {
            _inNpcNode = true;
            int npcId = Integer.parseInt(attributes.getValue("id"));
            _obj = new Npc(npcId);
        }
        
        if (qName.equalsIgnoreCase("item")) {
        	_inItemNode = true;
        	int itemId = Integer.parseInt(attributes.getValue("id"));
        	_obj = new Item(itemId);
        }

        if (qName.equalsIgnoreCase("text")) {
            _inTextNode = true;
        }

        if (qName.equalsIgnoreCase("commands")) {
            _inCommandsNode = true;
        }

        if (qName.equalsIgnoreCase("npc_refs")) {
            _inNpcRefsNode = true;
        }

        if (qName.equalsIgnoreCase("item_refs")) {
            _inItemRefsNode = true;
        }

        if (_inAttributesNode) {
            _inAttributeSubNode = true;
            _currentAttributeNode = qName;
        } else if (qName.equalsIgnoreCase("attributes")) {
            _inAttributesNode = true;
        }

    }

    /**
     * Sets the current state to indicate which nodes we are no longer in and populates the scene
     * with the object that should now be full of the data from the corresponding node.
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("scene")) {
            _inSceneNode = false;

            if (_obj instanceof Scene) {
                _sceneMap.put(((Scene)_obj).getId(), (Scene)_obj);
            }
        }

        if (qName.equalsIgnoreCase("npc")) {
            _inNpcNode = false;

            if (_obj instanceof Npc) {
                _npcMap.put(((Npc)_obj).getId(), (Npc)_obj);
            }
        }
        
        if (qName.equalsIgnoreCase("item")) {
        	_inItemNode = false;
        	
        	if (_obj instanceof Item) {
        		_itemMap.put(((Item)_obj).getId(), (Item)_obj);
        	}
        }

        if (qName.equalsIgnoreCase("text")) {
            _inTextNode = false;
        }

        if (qName.equalsIgnoreCase("commands")) {
            _inCommandsNode = false;
        }

        if (qName.equalsIgnoreCase("npc_refs")) {
            _inNpcRefsNode = false;
        }

        if (qName.equalsIgnoreCase("item_refs")) {
            _inItemRefsNode = false;
        }

        if (_inAttributeSubNode) {
            _inAttributeSubNode = false;
            _currentAttributeNode = null;
        }

        if (qName.equalsIgnoreCase("attributes")) {
            _inAttributesNode = false;
        }
    }

    /**
     * Get the character data and convert it according to the rules for whatever node we are in.
     * @param ch The array of character data up to the cursor position in the document
     * @param start The starting index for the character data contained within the current node.
     * @param length The length of the character data in the current node.
     * @throws SAXException
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (_inSceneNode && _inTextNode && _obj instanceof Scene) {
            ((Scene)_obj).setText(new String(ch, start, length));
        }

        if (_inNpcNode && _inTextNode && _obj instanceof Npc) {
            ((Npc)_obj).setText(new String(ch, start, length));
        }

        if (_inCommandsNode || _inNpcRefsNode || _inItemRefsNode) {
            Map<String, String> map = parseMap(new String(ch, start, length));

            if (_inSceneNode && _obj instanceof Scene) {
                if (_inCommandsNode) {
                    ((Scene) _obj).setCommandMap(map);
                }

                if (_inNpcRefsNode) {
                    ((Scene) _obj).setNpcMap(map);
                }

                if (_inItemRefsNode) {
                    ((Scene) _obj).setItemMap(map);
                }
            }
        }

        if (_inAttributeSubNode) {
        	String val = new String(ch, start, length);
        	
            if (_inNpcNode && _obj instanceof Npc) {
                ((Npc)_obj).setAttribute(_currentAttributeNode, Integer.parseInt(val));
            }
            
            if (_inItemNode && _obj instanceof Item) {
            	((Item)_obj).setAttribute(_currentAttributeNode, Integer.parseInt(val));
            }
        }
    }

    /**
     * A simple utility method to parse JSON formatted data. Currently only accepts somply formated
     * data in the form of { String : Value }
     * @param jsonStyleString The string containing the JSON formatted data.
     * @return returns a map of the values as a set of strings.
     */
    private Map<String, String> parseMap(String jsonStyleString) {
        if (jsonStyleString.indexOf('{') < 0 || jsonStyleString.indexOf('}') < 0 ||
                jsonStyleString.indexOf('{') > 0 || jsonStyleString.indexOf('}') <
                (jsonStyleString.length() - 1)) {
            return null;
        }

        Map<String, String> valueMap = new HashMap<>();
        String valueStr = jsonStyleString.substring(1, jsonStyleString.length() - 2);

        for (String s : valueStr.split(",")) {
            String[] kvStr = s.trim().split(":");
            valueMap.put(trimChar('"', kvStr[0]), trimChar('"', kvStr[1]));
        }

        return valueMap;
    }

    /**
     * This is a utility method for trimming the specified character from the beginning and end of a
     * string.
     * @param c The character to trim off.
     * @param s The string to trim the character from
     * @return The new trimmed string.
     */
    private String trimChar(char c, String s) {
        if (!(s.equals("\"\"") || s.equals("\"") || s.equals(""))) {
            int start = s.indexOf(c);
            if (start > -1) {
                int end = s.lastIndexOf(c);
                if (end > -1) {
                    return s.substring(start + 1, end);
                }
            }
        }
        return s;
    }
}
