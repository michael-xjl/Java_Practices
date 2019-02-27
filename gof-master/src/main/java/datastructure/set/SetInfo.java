package datastructure.set;

/**
 *
 * HashSet implemented by HashMap, Set Value will be the key of Map, the value of each entry is fixed as a Object 'PRESENT'
 *     private transient HashMap<E,Object> map;
 *
 *     // Dummy value to associate with an Object in the backing Map
 *     private static final Object PRESENT = new Object();
 *
 *
    HashSet vs LinkHashSet

    LinkedHashSet extends HashSet

 |HashSet  | LinkedHashSet
 backby| HashMap|LinkedHashMap

 * <p>A linked hash set has two parameters that affect its performance:
 * <i>initial capacity</i> and <i>load factor</i>.  They are defined precisely
 * as for <tt>HashSet</tt>.  Note, however, that the penalty for choosing an
 * excessively high value for initial capacity is less severe for this class
 * than for <tt>HashSet</tt>, as iteration times for this class are unaffected
 * by capacity.
 *
 *
 *
 * @author Michael Liu
 */
public class SetInfo
{
}
