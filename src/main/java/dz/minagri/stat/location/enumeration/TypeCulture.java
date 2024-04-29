package dz.minagri.stat.location.enumeration;

public enum TypeCulture {

    SUMMERTYPE_CULTURE("SummerType_Culture"),
    WINTERTYPE_CULTURE("WinterType_culture"),
    DRIED_VIGITABLR("Dried_Vegetables"),
    FOURAGE("Fourage"),
    INDUSTRIAL_CULTURE("Industrial_culture"),
    OTHERS("Others");

    private final String name;

    private TypeCulture(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
