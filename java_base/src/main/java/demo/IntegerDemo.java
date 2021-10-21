package main.java.demo;

/**
 * @author ：lichuankang
 * @date ：2021/10/19 17:44
 * @description ：测试 Integer Demo
 */
public class IntegerDemo {
    public static void main(String[] args) {
        /**
         * == 地址比较
         * equal() 一般是值比较
         * Integer 会在第一次使用的时候缓存一批数据，缓存的数据范围是 [-128, 127]
         * i1,b1 值相同，地址相同；
         * i11,b11 值相同，地址不同；
         * i111,b111 值相同，地址相同；
         * i1111,b1111 值相同，地址不同；
         */

        /**
         *
         *
         *
         *      * Cache to support the object identity semantics of autoboxing for values between
         *      * -128 and 127 (inclusive) as required by JLS.
         *      *
         *      * The cache is initialized on first usage.  The size of the cache
         *      * may be controlled by the {@code -XX:AutoBoxCacheMax=<size>} option.
         *      * During VM initialization, java.lang.Integer.IntegerCache.high property
         *      * may be set and saved in the private system properties in the
         *      * sun.misc.VM class.
         *
         * private static class IntegerCache {
         *         static final int low = -128;
         *         static final int high;
         *         static final Integer cache[];
         *
         *         static {
         *             // high value may be configured by property
         *             int h = 127;
         *             String integerCacheHighPropValue =
         *                 sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
         *             if (integerCacheHighPropValue != null) {
         *                 try {
         *                     int i = parseInt(integerCacheHighPropValue);
         *                     i = Math.max(i, 127);
         *                     // Maximum array size is Integer.MAX_VALUE
         *                     h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
         *                 } catch( NumberFormatException nfe) {
         *                     // If the property cannot be parsed into an int, ignore it.
         *                 }
         *             }
         *             high = h;
         *
         *             cache = new Integer[(high - low) + 1];
         *             int j = low;
         *             for(int k = 0; k < cache.length; k++)
         *                 cache[k] = new Integer(j++);
         *
         *             // range [-128, 127] must be interned (JLS7 5.1.7)
         *             assert IntegerCache.high >= 127;
         *         }
         *
         *         private IntegerCache() {}
         *     }
         */

        /**
         *
         *
         *      * Returns an {@code Integer} instance representing the specified
         *      * {@code int} value.  If a new {@code Integer} instance is not
         *      * required, this method should generally be used in preference to
         *      * the constructor {@link #Integer(int)}, as this method is likely
         *      * to yield significantly better space and time performance by
         *      * caching frequently requested values.
         *      *
         *      * This method will always cache values in the range -128 to 127,
         *      * inclusive, and may cache other values outside of this range.
         *      *
         *
         *
         *   public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         */

        Integer i1 = 12;
        Integer b1 = 12;
        System.out.println("i1 == b1             is " + (i1 == b1));
        System.out.println("i1.equals(b1)        is " + i1.equals(b1));

        Integer i11 = 212;
        Integer b11 = 212;
        System.out.println("************************************");
        System.out.println("i11 == b11           is " + (i11 == b11));
        System.out.println("i11.equals(b11)      is " + i11.equals(b11));


        Integer i111 = new Integer(12);
        Integer b111 = new Integer(12);
        System.out.println("************************************");
        System.out.println("i111 == b111         is " + (i111 == b111));
        System.out.println("i111.equals(b111)    is " + i111.equals(b111));


        Integer i1111 = new Integer(212);
        Integer b1111 = new Integer(212);
        System.out.println("************************************");
        System.out.println("i1111 == b1111       is " + (i1111 == b1111));
        System.out.println("i1111.equals(b1111)  is " + i1111.equals(b1111));

    }


}
