
package dz.minagri.stat.customer.enumeration;

public enum Status {
    ACTIVE,
    INACTIVE;

    public static Status from(String stat) {
        if(stat == null) {
            return null;
        }
        return valueOf(stat);
    }
}
