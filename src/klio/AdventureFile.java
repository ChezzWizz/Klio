package klio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Chezz on 2/18/2016.
 */
public class AdventureFile {

    private InputStream fileIn;
    private Scene entryPoint;

    public AdventureFile(String adventureFileName) throws FileNotFoundException {
        fileIn = new FileInputStream(new File(adventureFileName));
    }

    public Scene getEntryPoint() {
        return entryPoint;
    }

}
