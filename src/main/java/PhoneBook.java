import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            String name = s[0];
            String phoneNumber = s[1];
            HashSet<String> phoneNumbers = map.getOrDefault(name, new HashSet<>());
            phoneNumbers.add(phoneNumber);
            map.put(name, phoneNumbers);
        }
        List<Map.Entry<String, HashSet<String>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, HashSet<String>>>() {
            public int compare(Map.Entry<String, HashSet<String>> o1, Map.Entry<String, HashSet<String>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });
        for (Map.Entry<String, HashSet<String>> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue().size() + " " + entry.getValue());
        }
    }
}