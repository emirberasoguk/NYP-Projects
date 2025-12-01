public class Car extends Vehicle {
    private int passengerCapacity;

    public Car(String model, String serialNumber, int passengerCapacity) {
        super(model, serialNumber);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + ", Passengers: " + passengerCapacity;
    }
}
