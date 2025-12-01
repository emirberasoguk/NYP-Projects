public class SafetyModule extends Module {
    private int riskLevel;

    public SafetyModule(String name, String version, int riskLevel) {
        super(name, version);
        this.riskLevel = riskLevel;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Risk Level: " + riskLevel;
    }
}
