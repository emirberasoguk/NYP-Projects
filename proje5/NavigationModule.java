public class NavigationModule extends Module {
    private String mapVersion;

    public NavigationModule(String name, String version, String mapVersion) {
        super(name, version);
        this.mapVersion = mapVersion;
    }

    public String getMapVersion() {
        return mapVersion;
    }

    public void setMapVersion(String mapVersion) {
        this.mapVersion = mapVersion;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Map: " + mapVersion;
    }
}
