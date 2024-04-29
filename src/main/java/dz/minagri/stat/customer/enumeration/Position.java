
package dz.minagri.stat.customer.enumeration;

public enum Position {
    CEO,
    Manager,
    Vendeur,
    Autre;

    public static Position fromAddressType(String add) {
        if(add == null) {
            return null;
        }
        return valueOf(add);
    }
}
