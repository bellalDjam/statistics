
package dz.minagri.stat.customer.enumeration;

public enum Salutation {
    Miss,
    Mr,
    Mirs;

    public static Salutation from(String stat) {
        if(stat == null) {
            return null;
        }
        return valueOf(stat);
    }
}
