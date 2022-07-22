package lib;

import java.util.ArrayList;
import java.util.List;

public class IdGenerator {

    /**
     *   Class, which generates unique ID and saves to system.
     *   ID consists of 10 characters (lowercase latin characters and 0-9 numbers).
     *   If generated ID already in system, recursively generates new.
     */


    private static final List<String> generatedIDs = new ArrayList<>();
    private static final String usingChars = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int idLength = 10;





    public static String genID() {
        StringBuilder id = new StringBuilder();

        for (int i = 0 ; i < idLength ; i++){
            id.append(usingChars.charAt((int) (Math.random() * usingChars.length())));
        }

        String res = hasID(id.toString()) ? genID() : id.toString();
        generatedIDs.add(res);
        return res;
    }

    public static boolean hasID(String id) {
        for (String i: generatedIDs)
            if (id.equals(i))
                return true;
        return false;
    }

    public static String removeID(String id) {
        for (int i = 0 ; i < generatedIDs.size() ; i++) {
            if (id.equals(generatedIDs.get(i))){
                return generatedIDs.remove(i);
            }
        }

        throw new ArrayStoreException("Array has no ID: " + id);
    }

}
