import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pet extends Animal {
    private List<String> commands;

    public Pet(String name, LocalDate birthdate, String breed) {
        super(name, birthdate, breed);
        this.commands = new ArrayList<>();
    }

    public List<String> getCommands() {
        return commands;
    }

    public void setCommands(List<String> commands) {
        this.commands = commands;
    }

    public void addCommand(String command) {
        this.commands.add(command);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + getName() + '\'' +
                ", birthdate=" + getBirthdate() + '\'' +
                ", breed='" + getBreed() + '\'' +
                ", commands=" + commands +
                '}';
    }
}