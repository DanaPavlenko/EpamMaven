package ua.epam.dana.viewAndController;

import ua.epam.dana.model.*;
import ua.epam.dana.model.metadata.TableMetaData;
import ua.epam.dana.persistant.ConnectionManager;
import ua.epam.dana.service.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class View {
    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private static Scanner input = new Scanner(System.in);

    public View() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();
        menu.put("A", "   A - Select all table");
        menu.put("B", "   B - Select structure of DB");

        menu.put("1", "   1 - Table: Dog");
        menu.put("11", "  11 - Create Dog");
        menu.put("12", "  12 - Update Dog");
        menu.put("13", "  13 - Delete Dog");
        menu.put("14", "  14 - Select Dog");
        menu.put("15", "  15 - Find Dog by id");
        menu.put("16", "  16 - Find Dog by name");
        menu.put("17", "  17 - Find Dog by age");

        menu.put("2", "   2 - Table: Breed");
        menu.put("21", "  21 - Create Breed");
        menu.put("22", "  22 - Update Breed");
        menu.put("23", "  23 - Delete Breed");
        menu.put("24", "  24 - Select Breed");
        menu.put("25", "  25 - Find Breed by id");

        menu.put("Q", "   Q - exit");

        methodsMenu.put("A", this::selectAllTable);
        methodsMenu.put("B", this::takeStructureOfDB);

        methodsMenu.put("11", this::createDog);
        methodsMenu.put("12", this::updateDog);
        methodsMenu.put("13", this::deleteDog);
        methodsMenu.put("14", this::selectDog);
        methodsMenu.put("15", this::findDogById);
        methodsMenu.put("16", this::findDogByName);
        methodsMenu.put("17", this::findDogByAge);

        methodsMenu.put("21", this::createBreed);
        methodsMenu.put("22", this::updateBreed);
        methodsMenu.put("23", this::deleteBreed);
        methodsMenu.put("24", this::selectBreed);
        methodsMenu.put("25", this::findBreedById);

    }

    private void selectAllTable() throws SQLException {
        selectDog();
        selectBreed();
    }

    private void takeStructureOfDB() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        MetaDataService metaDataService = new MetaDataService();
        List<TableMetaData> tables = metaDataService.getTablesStructure();
        System.out.println("TABLE OF DATABASE: "+connection.getCatalog());

        for (TableMetaData table: tables ) {
            System.out.println(table);
        }
    }


    private void deleteDog() throws SQLException {
        System.out.println("Input id of dog you would like to delete: ");
        Integer id = input.nextInt();
        DogService service = new DogService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createDog() throws SQLException {
        System.out.println("Input name of dog: ");
        String name = input.nextLine();
        System.out.println("Input age of dog: ");
        Integer age = input.nextInt();
        System.out.println("Input breed_id of dog");
        Integer id = input.nextInt();
        DogEntity entity = new DogEntity(name, age, id);

        DogService service = new DogService();
        int count = service.insert(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDog() throws SQLException {
        System.out.println("Input id of dog you would like to update: ");
        Integer id = input.nextInt();
        System.out.println("Input name: ");
        String name = input.next();
        System.out.println("Input age: ");
        Integer age = input.nextInt();
        System.out.println("Input breed_id: ");
        Integer breed_id = input.nextInt();
        DogEntity entity = new DogEntity(id, name, age, breed_id);

        DogService service = new DogService();
        int count = service.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectDog()throws SQLException {
        System.out.println("\nTable: dog");
        DogService service = new DogService();
        List<DogEntity> dogs = service.findAll();
        for (DogEntity entity : dogs) {
            System.out.println(entity);
        }
    }

    private void findDogById() throws SQLException {
        System.out.println("Input id of dog you would like to find: ");
        Integer id = input.nextInt();
        DogService service = new DogService();
        DogEntity entity = service.find(id);
        System.out.println(entity);
    }

    private void findDogByName() throws SQLException {
        System.out.println("Input name of dog you would like to find: ");
        String name = input.next();
        DogService service = new DogService();
        List<DogEntity> dogs = service.findByName(name);
        for (DogEntity entity : dogs){
        	System.out.println(entity);
        }
    }
    
    private void findDogByAge() throws SQLException {
        System.out.println("Input id of dog you would like to find: ");
        Integer age = input.nextInt();
        DogService service = new DogService();
        List<DogEntity> dogs = service.findByAge(age);
        for (DogEntity entity : dogs){
        	System.out.println(entity);
        }
    }
   

    //------------------------------------------------------------------------

    private void deleteBreed() throws SQLException {
        System.out.println("Input id of breed you would like to delete: ");
        Integer id = input.nextInt();
        input.nextLine();
        BreedService service = new BreedService();
        int count = service.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void createBreed() throws SQLException {
        System.out.println("Input breed: ");
        String breed = input.nextLine();
        BreedEntity entity = new BreedEntity(breed);
        BreedService service = new BreedService();
        int count = service.create(entity);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateBreed() throws SQLException {
        System.out.println("Input id of breed you would like to update: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println("Input new breed: ");
        String breed = input.nextLine();
        BreedEntity entity = new BreedEntity(id, breed);
        BreedService service = new BreedService();

        int count = service.update(entity);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void selectBreed() throws SQLException {
        System.out.println("\nTable: Kind");
        BreedService service = new BreedService();
        List<BreedEntity> breeds = service.findAll();
        for (BreedEntity entity : breeds) {
            System.out.println(entity);
        }
    }

    private void findBreedById() throws SQLException {
        System.out.println("Input id of breed you would like to find: ");
        Integer id = input.nextInt();
        input.nextLine();
        BreedService service = new BreedService();
        BreedEntity entity = service.find(id);
        System.out.println(entity);
    }


    //-------------------------------------------------------------------------

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
            }
        } while (!keyMenu.equals("Q"));
    }
}
