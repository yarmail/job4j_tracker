package learn.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {

    public static Map<String, Student> convert(List<Student> list) {
        return list.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        student -> student,
                        (name1, name2) -> name1
                ));
    }
}
