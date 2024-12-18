package dz.minagri.stat.customer.enumeration;

public enum RoleType {
    AUTRES("Autres"),
    FELLAH_EXPLOITANT("Fellah_Exploitant"),
    USEROLE_TYPE("UserRole_Type"),
    CREATOR("Creator"),
    EDITOR("Editor"),
    INTERNE("Interne"),
    AGENT_CV("Agent_CV"),
    AGENT_SUBDEV("Agent_SubDiv"),
    AGENT_DSA("Agent_Dsa"),
    ADMIN("Admin"),
    SUPERVISOR("Supervisor"),
    AGENT_MINIST("Agent_Minist"),
    EXTERNE("Externe");
    private final String name;

    // private enum constructor
    private RoleType(String s) {
        this.name = s;
    }

    public String getRole() {
        return name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}