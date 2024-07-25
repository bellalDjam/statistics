package dz.minagri.stat.production.enumeration;

public enum Status {
    SPRL,
    ASBL,
    SN,
    RESEARCH_CENTER,
    SARL;

    public static Status from(String stat) {
        if (stat == null) {
            return null;
        }
        return valueOf(stat);
    }
}
