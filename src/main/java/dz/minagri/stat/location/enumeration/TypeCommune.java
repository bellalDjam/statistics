package dz.minagri.stat.location.enumeration;

public enum TypeCommune {
    COMMUNAL("Comm"), DAIRA("daira"), WILAYA("Wilaya"),SUBDIV("Subdiv");

    private final String name;

    private TypeCommune(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
