import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(String name, LocalDate birthdate, String breed) {
        super(name, birthdate, breed);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + getName() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", commands=" + getCommands() +
                '}';
    }
}