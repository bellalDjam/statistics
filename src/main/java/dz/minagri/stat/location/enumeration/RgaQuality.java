package dz.minagri.stat.location.enumeration;

public enum RgaQuality {
    AGENT_CV("Agent_cv"), AGENT_SUBDIV("Agent_subdiv"), ADMIN("Admin"), AGENT_MINIST("Agent_minit"), SUPERVISOR("Supervisor"), CONTROLLER("Controller");

    private final String name;

    private RgaQuality(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
