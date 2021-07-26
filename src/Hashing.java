/**
 * Representation of hash
 *
 * @author Anna Savova
 */

public class Hashing {

    int key = 0;
    String value;
    int[] keys;
    String[] values;

    /**
     * Creates a new Hashing algorithm with the given properties.
     */
    public Hashing(String value){
        this.value = value;
        this.key = 0;
        keys[0] = key;
        values[0] = value;
    }

    /**
     * Helper function to check if element exists
     *
     * @param  k
     * @return validity
     */
    public boolean isValidKey(int k){
        return (k >= 0 && k < keys.length);
    }

    public int getSize(){
        return keys.length;
    }

    /**
     * Returns the element at a given position
     * @param  k             key of the element
     * @return value         value of the element
     * @throws Exception
     */
    public String get(int k) throws Exception {
        if (isValidKey(k)) {
            for(int i = 0; i < getSize(); i++){
                if (keys[i] == k){
                    return values[i];
                }
            }
        }
        return null;
    }

    public void add(String v){
        int index = getSize();
        values[index] = v;
        keys[index] = index;
    }

    /**
     * Hashing function
     * @param value         String that will be hashed
     */
    public void hash(String value){
        int hash = 0;
        for (int i = 0; i < value.length(); i++){
            hash = (31 * hash + value.charAt(i)) % getSize();
        }
    }
}
