package klio;

public class Klio {

    public static void main(String[] args) {

        int errCode = Application.getInstance().Run();

        switch (errCode) {
        case -1: 
            System.err.println("Error on exit. Main loop terminated abnormally.");
            break;
        case 0:
        default: // Any one who pulls now, after editing this line, will have to resolve a conflict.
        }
    }

}
