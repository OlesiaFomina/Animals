import java.time.LocalDate;

public class PackAnimal extends Animal {
    private double loadCapacity;

    public PackAnimal(String name, LocalDate birthdate, String breed, double loadCapacity) {
        super(name, birthdate, breed);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "PackAnimal{" +
                "name='" + getName() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", loadCapacity=" + loadCapacity +
                '}';
    }
}
