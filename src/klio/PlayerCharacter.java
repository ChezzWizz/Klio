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

/**
 * This class contains all the state information about the player. This class tracks the character's
 * current attributes, the current scene being applied, the current amount of life, any equipment
 * being carried, and any skills the character might have.
 *
 * Created by Chezz on 1/1/2016.
 */
public class PlayerCharacter {
    public int strength;
    public int agility;
    public int dexterity;
    public int intelligence;
    public int wisdom;
    public int charisma;
    public int minDamage;
    public int maxDamage;
    public int armorClass;

    PlayerCharacter(int str, int agl, int dex, int inl, int wis, int cha, int minDmg, int maxDmg) {
        strength = str;
        agility = agl;
        dexterity = dex;
        intelligence = inl;
        wisdom = wis;
        charisma = cha;
        minDamage = minDmg;
        maxDamage = maxDmg;
        armorClass = 10;
    }
}
