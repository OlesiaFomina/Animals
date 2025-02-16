import java.util.ArrayList;
import java.util.List;

public class Registry {
    private List<Animal> animals;

    public Registry() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void showCommands(Animal animal) {
        if (animal instanceof Pet) {
            Pet pet = (Pet) animal;
            System.out.println("Команды, которые знает " + pet.getName() + ": " + pet.getCommands());
        } else {
            System.out.println(animal.getName() + " не является домашним животным и не знает команд.");
        }
    }

    public void teachCommand(Animal animal, String command) {
        if (animal instanceof Pet) {
            Pet pet = (Pet) animal;
            pet.addCommand(command);
            System.out.println(pet.getName() + " научился новой команде: " + command);
        } else {
            System.out.println(animal.getName() + " не является домашним животным и его нельзя обучить командам.");
        }
    }
}