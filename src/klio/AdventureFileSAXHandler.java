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

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chezz on 1/4/2016.
 */
public class AdventureFileSAXHandler extends DefaultHandler {

    private Map<Integer, Scene> _sceneMap;

    private Object _obj = null;

    private boolean _inSceneNode = false;

    private boolean _inTextNode = false;
    private boolean _inCommandsNode = false;
    private boolean _inNpcsNode = false;
    private boolean _inItemsNode = false;

    public AdventureFileSAXHandler(Map<Integer, Scene> sceneMap) {
        _sceneMap = sceneMap;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
        throws SAXException {

        if (qName.equalsIgnoreCase("scene")) {
            _inSceneNode = true;
            int sceneId = Integer.parseInt(attributes.getValue("id"));
            boolean isTopLevel = Boolean.parseBoolean(attributes.getValue("top_level"));
            _obj = new Scene(sceneId, isTopLevel);
        }

        if (qName.equalsIgnoreCase("text")) {
            _inTextNode = true;
        }

        if (qName.equalsIgnoreCase("commands")) {
            _inCommandsNode = true;
        }

        if (qName.equalsIgnoreCase("npcs")) {
            _inNpcsNode = true;
        }

        if (qName.equalsIgnoreCase("items")) {
            _inItemsNode = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("scene")) {
            _inSceneNode = false;

            if (_obj instanceof Scene) {
                _sceneMap.put(((Scene)_obj).getId(), (Scene)_obj);
            }
        }

        if (qName.equalsIgnoreCase("text")) {
            _inTextNode = false;
        }

        if (qName.equalsIgnoreCase("commands")) {
            _inCommandsNode = false;
        }

        if (qName.equalsIgnoreCase("npcs")) {
            _inNpcsNode = false;
        }

        if (qName.equalsIgnoreCase("items")) {
            _inItemsNode = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (_inSceneNode && _inTextNode && _obj instanceof Scene) {
            ((Scene)_obj).setText(new String(ch, start, length));
        }

        if (_inCommandsNode || _inNpcsNode || _inItemsNode) {
            Map<String, String> map = parseMap(new String(ch, start, length));

            if (_inSceneNode && _obj instanceof Scene) {
                if (_inCommandsNode) {
                    ((Scene) _obj).setCommandMap(map);
                }

                if (_inNpcsNode) {
                    ((Scene) _obj).setNpcMap(map);
                }

                if (_inItemsNode) {
                    ((Scene) _obj).setItemMap(map);
                }
            }
        }
    }

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
