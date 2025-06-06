package dz.minagri.stat.location.enumeration;

public enum EtatSanitaire {
    BAD("Bad"), MIDDEL("Middel"), GOOD("good");

    private final String name;

    private EtatSanitaire(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
