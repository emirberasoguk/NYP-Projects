public class AIControlModule extends Module {
    private String modelName;

    public AIControlModule(String name, String version, String modelName) {
        super(name, version);
        this.modelName = modelName;
    }

    public void updateModel(String newModel) {
        this.modelName = newModel;
    }

    public void updateModel(String newModel, boolean verbose) {
        this.modelName = newModel;
        if (verbose) {
            System.out.println("AI Model updated to: " + newModel);
        }
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", AI Model: " + modelName;
    }
}
