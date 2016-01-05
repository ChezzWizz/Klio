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
    public int strength;
    public int agility;
    public int dexterity;
    public int intelligence;
    public int wisdom;
    public int charisma;
    public int minDamage;
    public int maxDamage;
    public int armorClass;
    public String text;
    public List<Item> items;
    public Map<String, String> commands;

}
