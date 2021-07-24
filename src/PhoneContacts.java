import java.util.*;

public class PhoneContacts {
    private HashMap<String, List<Contact>> groups = new HashMap<>();

    public void addGroup(String groupName) {
        groups.put(groupName, new ArrayList<>());
    }

    public void addContactToGroup(String[] groups, Contact contact) {
        for (String group : groups) {
            if (this.groups.containsKey(group)) {
                this.groups.get(group).add(contact);
            }
        }
    }

    public void printContacts() {
        for (Map.Entry<String, List<Contact>> entry : groups.entrySet()) {
            System.out.println("- " + entry.getKey());
            for (Contact contact : entry.getValue()) {
                System.out.println(contact.toString());
            }
        }
    }

    public void printSortedContacts() {
        List<Contact> contacts = new ArrayList<>();
        for (Map.Entry<String, List<Contact>> entry : groups.entrySet()) {
            for (Contact contact : entry.getValue()) {
                if (!contacts.contains(contact)) {
                    contacts.add(contact);
                }
            }
        }
        contacts.sort(Comparator.naturalOrder());
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }
}