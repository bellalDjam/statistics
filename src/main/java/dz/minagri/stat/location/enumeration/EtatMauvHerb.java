package dz.minagri.stat.location.enumeration;

public enum EtatMauvHerb {
    BAD("Bad"), MIDDEL("Middel"), GOOD("good");

    private final String name;

    private EtatMauvHerb(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
