package Assignment4;

public final class IntegrityStatement {
    public static String signature() {
        String names = "Daniel Ayzenshteyn and Ron Shefland"; // <- Fill in your names here!
        if (names.length() == 0) {
            throw new UnsupportedOperationException("You should sign here");
        }
        return names;
    }
}
