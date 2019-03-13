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

|        | HashSet | LinkedHashSet |  |
| backby | HashMap | LinkedHashMap |  |

 * <p>A linked hash set has two parameters that affect its performance:
 * <i>initial capacity</i> and <i>load factor</i>.  They are defined precisely
 * as for <tt>HashSet</tt>.  Note, however, that the penalty for choosing an
 * excessively high value for initial capacity is less severe for this class
 * than for <tt>HashSet</tt>, as iteration times for this class are unaffected
 * by capacity.
 *
 *
 * ╔═══════════════════╦══════════════════════╦═════════════════════════════╗
 * ║                   ║         List         ║            Set              ║
 * ╠═══════════════════╬══════════════════════╬═════════════════════════════╣
 * ║     Duplicates    ║          YES         ║            NO               ║
 * ╠═══════════════════╬══════════════════════╬═════════════════════════════╣
 * ║       Order       ║       ORDERED        ║  DEPENDS ON IMPLEMENTATION
 * ║                                              LinkedHashSet has the insertion order
 * ╠═══════════════════╬══════════════════════╬═════════════════════════════╣
 * ║ Positional Access ║         YES          ║            NO               ║
 * ╚═══════════════════╩══════════════════════╩═════════════════════════════╝
 *
 *
 *  List:
 *  Can be accessed by index
 *  Have insertion order, or can control order by index
   * implemetented using
   *
   * LinkedList (also implement deque)
   * ArrayList
 *
 * Lists of unique elements:
 * Conform to Java's interface named Set
 * Can not be accessed by index
 *
 * implemetented using
 *
 * HashSet (unordered, implemented by HashMap)
 * LinkedHashSet (insertion ordered, extend HashSet, with such constructor : super(16, .75f, true), third parameter is dummy, all the constuctors in H
 * HashSet with dummy parameters will instant internal variable Map with LinkedHashMap , otherwise with HashMap)
 * TreeSet (sorted by natural order or by provided comparator, implement by TreeMap)
 *
 * @author Michael Liu
 */
public class SetInfo
{
}
