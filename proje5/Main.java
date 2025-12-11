import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {

    Car car = new Car("SuperAraba", "ES001", 5);
    CargoBot cargo = new CargoBot("KargoBot", "KB001", 500.0);
    GroundDrone drone = new GroundDrone("Drone", "UV001", 8);

    NavigationModule nav1 = new NavigationModule("NavCore", "2.1", "HarikalarDiyarı 2024");
    SafetyModule safe1 = new SafetyModule("Koruma", "1.5", 3);
    AIControlModule ai1 = new AIControlModule("SuperZeka", "7.0", "EmirAI");

    car.addModule(nav1);
    car.addModule(safe1);
    car.addModule(ai1);

    ai1.updateModel("EmirAI-2");
    ai1.updateModel("EmirAI-3", true);

    cargo.load(300);
    cargo.load(250);
    cargo.unload();

    drone.scan();
    drone.scan("thermal");
    drone.scan("lidar");

    Engineer eng = new Engineer("Talha Gurler", "talha@sirket.com", "ENG001", "AI Systems");
    Technician tech = new Technician("Mehmet Gul", "mehmet@sirket.com", "TECH001", 99);
    Manager mgr = new Manager("Emir Bera Soguk", "emir@sirket.com", "MGR001");

    mgr.addTeamMember(eng);
    mgr.addTeamMember(tech);

    tech.maintenanceReport();
    tech.maintenanceReport(true);

    Mission mission1 = new Mission("M001", "Urban thermal scan mission with cargo delivery");
    mission1.assignVehicle(car);
    mission1.assignVehicle(cargo);
    mission1.assignVehicle(drone);
    mission1.assignEmployee(eng);
    mission1.assignEmployee(tech);
    mission1.assignEmployee(mgr);

    FleetControlCenter center = new FleetControlCenter();
    center.addVehicle(car);
    center.addVehicle(cargo);
    center.addVehicle(drone);
    center.addEmployee(eng);
    center.addEmployee(tech);
    center.addEmployee(mgr);
    center.addMission(mission1);

    System.out.println("\n=== MISSION SEARCH: 'thermal' ===");
    ArrayList<Mission> found = center.searchMission("thermal");
    for (Mission m : found) {
      System.out.println("Found: " + m.getMissionId() + " - " + m.getDescription());
    }

    System.out.println("\n=== ALL VEHICLE STATUS (POLYMORPHISM) ===");
    center.listVehiclesByStatus();

    System.out.println("\n=== EMPLOYEE DESCRIPTIONS (POLYMORPHISM) ===");
    System.out.println(eng.describe());
    System.out.println(tech.describe());
    System.out.println(mgr.describe());

    System.out.println("\n=== BATTERY CHARGE TEST ===");
    car.setBatteryLevel(50);
    System.out.println("Car battery before: " + car.getBatteryLevel() + "/%");
    car.charge(30);
    System.out.println("Car battery after charge(30): " + car.getBatteryLevel() + "/%");
    car.charge();
    System.out.println("Car battery after charge(): " + car.getBatteryLevel() + "/%");

    System.out.println("\n=== MODULE INFORMATION ===");
    for (Module m : car.getModules()) {
      System.out.println(m.getInfo());
    }
  }
}
