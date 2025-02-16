import java.time.LocalDate;

public class Horse extends PackAnimal {
    public Horse(String name, LocalDate birthdate, String breed, double loadCapacity) {
        super(name, birthdate, breed, loadCapacity);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + getName() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", loadCapacity=" + getLoadCapacity() +
                '}';
    }
}