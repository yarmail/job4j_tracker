package learn.search;

import learn.search.Person;
import learn.search.PhoneDictionary;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        Assert.assertEquals(persons.get(0).getSurname(), "Arsentev");
    }

    @Test
    public void whenFindFalse() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Alex");
        Assert.assertEquals(persons.size(), 0);
    }

    @Test
    public void whenTwoPersonName() {
        var phones = new PhoneDictionary();
        phones.add(
                new Person("Alex", "Semenov", "534872", "New York")
        );
        phones.add(
                new Person("York", "Gryn", "0010100", "Altay")
        );
        ArrayList<Person> persons = phones.find("York");
        Assert.assertEquals(persons.get(1).getAddress(), "Altay");
    }

}
