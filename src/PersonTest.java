import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTest {
  @ParameterizedTest
  @CsvSource({
      "Andrey, 10.10.1980, 'Person{name=''Andrey'', born=10.10.1980}'",
      "Victor, 20.10.1990, 'Person{name=''Victor'', born=20.10.1990}'",
  })
  public void toString(String name, String birthday, String expected) throws ParseException {
    // arrange
    Person person1 = new Person(name, birthday);
    String actual = person1.toString();
    assertEquals(expected, actual);
  }

  @Test
  public void usualComparison() throws ParseException {

    Person person1 = new Person("Andrey", "10.10.1980");
    Person person2 = new Person("Victor", "20.10.1990");

    int res1 = person1.compareTo(person2);
    int res2 = person2.compareTo(person1);

    assertTrue(res1 > 0);
    assertTrue(res2 < 0);
  }

  @Test
  public void onEdgeComparison() throws ParseException {

    Person person1 = new Person("", "10.10.1980");
    Person person2 = new Person("", "11.10.1980");
    int res1 = person1.compareTo(person2);
    int res2 = person2.compareTo(person1);
    assertTrue(res1 > 0);
    assertTrue(res2 < 0);

    Person person3 = new Person("", "10.10.1980");
    Person person4 = new Person("", "10.11.1980");
    int res3 = person1.compareTo(person2);
    int res4 = person2.compareTo(person1);
    assertTrue(res3 > 0);
    assertTrue(res4 < 0);

    Person person5 = new Person("", "10.10.1980");
    Person person6 = new Person("", "10.10.1981");
    int res5 = person1.compareTo(person2);
    int res6 = person2.compareTo(person1);
    assertTrue(res5 > 0);
    assertTrue(res6 < 0);

    Person person7 = new Person("", "0.0.0");
    Person person8 = new Person("", "1.0.0");
    int res7 = person1.compareTo(person2);
    int res8 = person2.compareTo(person1);
    assertTrue(res7 > 0);
    assertTrue(res8 < 0);
  }

  @Test
  public void eqPersons() throws ParseException {
    Person person1 = new Person("A", "10.10.1980");
    Person person2 = new Person("A", "10.10.1980");
    int res1 = person1.compareTo(person2);
    int res2 = person2.compareTo(person1);
    assertTrue(res1 == 0);
    assertTrue(res2 == 0);
  }
}
