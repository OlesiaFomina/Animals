import java.time.LocalDate;

public class Donkey extends PackAnimal {
    public Donkey(String name, LocalDate birthdate, String breed, double loadCapacity) {
        super(name, birthdate, breed, loadCapacity);
    }

    @Override
    public String toString() {
        return "Donkey{" +
                "name='" + getName() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", loadCapacity=" + getLoadCapacity() +
                '}';
    }
}