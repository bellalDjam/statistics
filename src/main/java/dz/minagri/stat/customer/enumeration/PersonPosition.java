package dz.minagri.stat.customer.enumeration;

public enum PersonPosition {
    CEO,
    Manager,
    Vendeur,
    Autre;

    public static PersonPosition fromAddressType(String add) {
        if (add == null) {
            return null;
        }
        return valueOf(add);
    }
}
