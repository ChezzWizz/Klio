package klio;

public class Klio {

    public static void main(String[] args) {

        int errCode = Application.getInstance().Run();

        switch (errCode) {
        case 0:
        default: // No errors. Clean exit.
        }
    }

}
