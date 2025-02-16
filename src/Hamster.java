import java.time.LocalDate;

public class Hamster extends Pet {
    public Hamster(String name, LocalDate birthdate, String breed) {
        super(name, birthdate, breed);
    }

    @Override
    public String toString() {
        return "Hamster{" +
                "name='" + getName() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", commands=" + getCommands() +
                '}';
    }
}