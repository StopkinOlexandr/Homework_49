import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

// Задача 1.
// Создайте класс Person, которому при создании передавайте имя и дату рождения в виде строки
// в формате "ДД.ММ.ГГГГ".
//
// Реализуйте в классе интерфейс Comparable<Person>, в котором "меньше" будет значить "младше".
//
// Подсказка: не обязательно вычислять возраст, этому мы так и не научились.
// Но можно сравнивать даты рождения!
//
// Альтернативная подсказка: если очень хочется вычислять возраст,
// то можно это делать в миллисекундах с использованием getTime()!
public class Person implements Comparable<Person> {
  private final String name;
  private final Date born;

  public String getName() {
    return this.name;
  }

  public Date getBorn() {
    return this.born;
  }

  public Person(String name, String birthday) throws ParseException {
    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    if (name == null) {
      throw new IllegalArgumentException("Name can't be null");
    }
    if (birthday == null) {
      throw new IllegalArgumentException("birthday can't be null");
    }
    this.name = name;
    this.born = formatter.parse(birthday);
  }

  @Override
  public String toString() {
    DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
    return "Person{" +
        "name='" + name + '\'' +
        ", born=" + formatter.format(born) +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return name.equals(person.name) && born.equals(person.born);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, born);
  }

  @Override
  public int compareTo(Person o) {
    if (born.before(o.born)) {
      return 1;
    } else if (o.born.before(born)) {
      return -1;
    } else {
      return 0;
    }
  }
}
