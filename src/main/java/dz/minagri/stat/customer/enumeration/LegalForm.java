package dz.minagri.stat.customer.enumeration;

public enum LegalForm {
    SPRL,
    ASBL,
    SN,
    RESEARCH_CENTER,
    SARL;

    public static LegalForm from(String stat) {
        if (stat == null) {
            return null;
        }
        return valueOf(stat);
    }
}
