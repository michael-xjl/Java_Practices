package misc;

/**
 *
 *  Hashtable vs HashMap vs Synchnized HashMap vs ConcurrentHashMap
 *
| *                           | HashMap | SynchronizedHashMap | Hashtable | ConcurrentHashMap |  |
| *  synchronized             | N       | Y                   | Y         | Y                 |  |
| synchronize Level           |         | block/object        | method    | segment           |  |
| synchronized on count/get   |         | Y                   | Y         | N                 |  |
| allow null(key/val)         | N       | N                   | Y         | N                 |  |
| iterate ConcurrentException | Y       | Y                   | Y         | N                 |  |
| keep insertion order        | N       | Y                   | N         | N                 |  |

 *
 *
 *
 * – ConcurrentHashMap is similar to Hashtable, but performs better in a multi-threaded environment as it does not block itself to be access by a single thread
 *
 * – It does not allow duplicate keys.
 *
 * – It does not allow null to be used as a key or value.
 *
 * – Iterators of ConcurrentHashMap don’t throw a ConcurrentModificationException, so we don’t need to lock the collection while iterating it.
 *
 * @author Michael Liu
 */
public class Maps
{
}
