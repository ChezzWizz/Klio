package klio;

/**
 * Created by Chezz on 2/18/2016.
 */
public class Command {

    private String verb;
    private String object;

    public Command(String verb, String object) {
        this.verb = verb;
        this.object = object;
    }

    public String getVerb() {
        return verb;
    }

    public String getObject() {
        return object;
    }

}
