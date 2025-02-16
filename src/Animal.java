import java.time.LocalDate;

public class Animal {
    private String name;
    private LocalDate birthdate;
    private String breed;

    public Animal(String name, LocalDate birthdate, String breed) {
        this.name = name;
        this.birthdate = birthdate;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", birthdate=" + birthdate +
                ", breed='" + breed + '\'' +
                '}';
    }
}