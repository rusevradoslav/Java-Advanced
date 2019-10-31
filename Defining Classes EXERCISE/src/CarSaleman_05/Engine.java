package CarSaleman_05;

public class Engine {
    private String modelEngine;
    private int power;
    private String displacement;
    private String eficiency;


    public Engine(String modelEngine, int power) {
        this.modelEngine = modelEngine;
        this.power = power;
        this.displacement = "n/a";
        this.eficiency = "n/a";
    }

    public String getModelEngine() {
        return modelEngine;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public void setEficiency(String eficiency) {
        this.eficiency = eficiency;
    }

    public void setModelEngine(String modelEngine) {
        this.modelEngine = modelEngine;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public String getEficiency() {
        return eficiency;
    }
}
