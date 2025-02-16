import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Registry registry = new Registry();
        Scanner scanner = new Scanner(System.in);

        try (Counter counter = new Counter()) {
            while (true) {
                System.out.println("\nМеню:");
                System.out.println("1. Завести новое животное");
                System.out.println("2. Посмотреть список животных");
                System.out.println("3. Посмотреть список команд животного");
                System.out.println("4. Обучить животное новой команде");
                System.out.println("5. Выход");

                System.out.print("Выберите пункт меню: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        try {
                            System.out.print("Введите имя животного: ");
                            String name = scanner.nextLine();
                            System.out.print("Введите дату рождения животного (YYYY-MM-DD): ");
                            LocalDate birthdate = LocalDate.parse(scanner.nextLine());
                            System.out.print("Введите породу животного: ");
                            String breed = scanner.nextLine();
                            System.out.println("Выберите тип животного: 1 - Собака, 2 - Кошка, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осел");
                            String type = scanner.nextLine();
                            Animal animal = null;

                            switch (type) {
                                case "1":
                                    animal = new Dog(name, birthdate, breed);
                                    break;
                                case "2":
                                    animal = new Cat(name, birthdate, breed);
                                    break;
                                case "3":
                                    animal = new Hamster(name, birthdate, breed);
                                    break;
                                case "4":
                                    System.out.print("Введите сколько животное может поднять: ");
                                    double loadCapacity = Double.parseDouble(scanner.nextLine());
                                    animal = new Horse(name, birthdate, breed, loadCapacity);
                                    break;
                                case "5":
                                    System.out.print("Введите сколько животное может поднять: ");
                                    loadCapacity = Double.parseDouble(scanner.nextLine());
                                    animal = new Camel(name, birthdate, breed, loadCapacity);
                                    break;
                                case "6":
                                    System.out.print("Введите сколько животное может поднять: ");
                                    loadCapacity = Double.parseDouble(scanner.nextLine());
                                    animal = new Donkey(name, birthdate, breed, loadCapacity);
                                    break;
                                default:
                                    System.out.println("Неверный тип животного.");
                                    break;
                            }

                            if (animal != null) {
                                registry.addAnimal(animal);
                                counter.add();
                                System.out.println("Животное успешно добавлено.");
                            }
                        } catch (Exception e) {
                            System.out.println("Ошибка при добавлении животного: " + e.getMessage());
                        }
                        break;
                    case "2":
                        System.out.println("\nСписок животных:");
                        for (Animal animal : registry.getAnimals()) {
                            System.out.println(animal);
                        }
                        break;
                    case "3":
                        System.out.print("Введите имя животного, чтобы посмотреть его команды: ");
                        String animalName = scanner.nextLine();
                        Animal foundAnimal = null;
                        for (Animal animal : registry.getAnimals()) {
                            if (animal.getName().equals(animalName)) {
                                foundAnimal = animal;
                                break;
                            }
                        }
                        if (foundAnimal != null) {
                            registry.showCommands(foundAnimal);
                        } else {
                            System.out.println("Животное с таким именем не найдено.");
                        }
                        break;
                    case "4":
                        System.out.print("Введите имя животного, чтобы обучить его новой команде: ");
                        animalName = scanner.nextLine();
                        foundAnimal = null;
                        for (Animal animal : registry.getAnimals()) {
                            if (animal.getName().equals(animalName)) {
                                foundAnimal = animal;
                                break;
                            }
                        }
                        if (foundAnimal != null) {
                            System.out.print("Введите название новой команды: ");
                            String command = scanner.nextLine();
                            registry.teachCommand(foundAnimal, command);
                        } else {
                            System.out.println("Животное с таким именем не найдено.");
                        }
                        break;
                    case "5":
                        System.out.println("Выход из программы.");
                        return;
                    default:
                        System.out.println("Неверный пункт меню.");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе со счетчиком: " + e.getMessage());
        }
    }
}