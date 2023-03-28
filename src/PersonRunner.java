import java.text.ParseException;

public class PersonRunner {
  public static void main(String[] args) {
    try {
      Person person1 = new Person("Andrey", "10.10.1980");
      Person person2 = new Person("Victor", "20.10.1990");
      System.out.println(person1);
      System.out.println(person2);
      System.out.println(person1.compareTo(person2));
    } catch (ParseException e) {
      System.out.println("Incorrect data format" + e.getMessage());
    }
  }
}
