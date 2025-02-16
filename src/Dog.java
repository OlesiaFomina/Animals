import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String name, LocalDate birthdate, String breed) {
        super(name, birthdate, breed);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + getName() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", commands=" + getCommands() +
                '}';
    }
}