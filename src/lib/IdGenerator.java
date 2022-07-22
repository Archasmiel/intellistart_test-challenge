package lib;

import java.util.ArrayList;
import java.util.List;

/**
 *   Class, which generates unique ID and saves to system.
 *   • ID consists of 10 characters (lowercase latin characters and 0-9 numbers).
 *   • If generated ID already in system, recursively generates new.
 *   • Remove method if id currently not used.
 *   • Check method for ID existence in generator.
 */
public class IdGenerator {

    private static final List<String> generatedIDs = new ArrayList<>();
    private static final String usingChars = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int idLength = 10;




    /**
     * Method for unique ID generating
     * @return generated ID
     */
    public static String genID() {
        StringBuilder id = new StringBuilder();

        for (int i = 0 ; i < idLength ; i++){
            id.append(usingChars.charAt((int) (Math.random() * usingChars.length())));
        }

        String res = hasID(id.toString()) ? genID() : id.toString();
        generatedIDs.add(res);
        return res;
    }

    /**
     * Method for ID existence check generator
     * @param id id to check in system
     * @return boolean variable, representing if current id already exists
     */
    public static boolean hasID(String id) {
        for (String i: generatedIDs)
            if (id.equals(i))
                return true;
        return false;
    }

    /**
     * Method for ID remove from generator
     * @param id id to remove from generator list
     * Throws exception if id not found.
     */
    public static void removeID(String id) {
        for (int i = 0 ; i < generatedIDs.size() ; i++) {
            if (id.equals(generatedIDs.get(i))){
                generatedIDs.remove(i);
            }
        }

        throw new ArrayStoreException("Array has no ID: " + id);
    }

}
