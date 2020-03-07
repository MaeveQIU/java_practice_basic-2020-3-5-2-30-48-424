import entity.MasterNumber;
import entity.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

  public static void main(String[] args) {
    PersonService personService = new PersonService();
    //TODO: print Person data that masterNumber is 1 and 2
    // print Person data that masterNumber is 3
    Stream<Person> personOneAndTwo = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("1"), new MasterNumber("2")));
    printPerson(personOneAndTwo);

    Stream<Person> personThree = personService.getPersonByMasterNumbers(Arrays.asList(new MasterNumber("3")));
    printPerson(personThree);
  }

  public static void printPerson(Stream<Person> stream) {
    List<Person> person = stream.collect(Collectors.toList());
    System.out.println(person);
  }
}
