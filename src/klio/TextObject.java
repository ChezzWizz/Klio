package klio;

/**
 * Created by Chezz on 2/19/2016.
 */
public class TextObject extends AdventureGameObject {

    private String text;

    public TextObject(String id, String text) {
        super(id);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}
