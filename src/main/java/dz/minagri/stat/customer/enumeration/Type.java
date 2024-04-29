
package dz.minagri.stat.customer.enumeration;

public enum Type {
    Particuliere,
    Professional;

    public static Type from(String stat) {
        if(stat == null) {
            return null;
        }
        return valueOf(stat);
    }
}
