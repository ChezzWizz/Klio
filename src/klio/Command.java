package klio;

/**
 * Created by Chezz on 2/18/2016.
 */
public class Command {

    private String modVerb;
    private String verb;
    private String noun;

    public Command(String modifierVerb, String verb, String noun) {
        this.modVerb = modifierVerb;
        this.verb = verb;
        this.noun = noun;
    }

    public Command(String verb, String noun) {
        this(null, verb, noun);
    }
}
