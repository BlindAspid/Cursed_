public class Vector {

    private  byte[] repn;
    private final int length;

    private static final int BITS_PER_UNIT = 8;

    private static int subscript(int idx) {
        return idx / BITS_PER_UNIT;
    }

    private static int position(int idx) {
        return 1 << (BITS_PER_UNIT - 1 - (idx % BITS_PER_UNIT));
    }

//    public BitVector(int length) throws IllegalArgumentException {
//        if (length < 0) {`
//            throw new IllegalArgumentException("Negative length for BitArray");
//        }
//
//        this.length = length;
//
//        repn = new byte[(length + BITS_PER_UNIT - 1)/BITS_PER_UNIT];
//    }