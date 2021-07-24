import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneContacts phoneContacts = new PhoneContacts();
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                Программа справочник
                Введите название группы контактов:
                """);

        while (true) {
            String groupName = scanner.nextLine();
            if (groupName.equalsIgnoreCase("нет")) {
                break;
            }
            phoneContacts.addGroup(groupName);
            System.out.println("Создать еще одну группу (введите название или \"нет\")");
        }

        while (true) {
            System.out.println("Создать контакт (введите имя и номер контакта или введите \"нет\")");
            String contactName = scanner.next();
            String contactNumber = scanner.nextLine();

            if (contactName.equalsIgnoreCase("нет")) {
                break;
            }
            Contact contact = new Contact(contactName, contactNumber);

            System.out.println("Укажите группы контактов через пробел");
            String[] groups = scanner.nextLine().split(" ");
            phoneContacts.addContactToGroup(groups, contact);
        }

        phoneContacts.printContacts();
        phoneContacts.printSortedContacts();
    }
}