import java.time.LocalDate;

public class Camel extends PackAnimal {
    public Camel(String name, LocalDate birthdate, String breed, double loadCapacity) {
        super(name, birthdate, breed, loadCapacity);
    }

    @Override
    public String toString() {
        return "Camel{" +
                "name='" + getName() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", loadCapacity=" + getLoadCapacity() +
                '}';
    }
}
