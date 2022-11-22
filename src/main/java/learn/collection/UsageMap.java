package learn.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mail@mail.com", "Афанасий");
        map.put("mail23@mail.com", "Люся");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("Пользователь с почтой " + key + " имеет имя " + value);
        }
    }
}
