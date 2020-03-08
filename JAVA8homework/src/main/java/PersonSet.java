import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonSet {
  private List<MasterNumber> masterNumbers;

  private List<Address> addresses;

  private List<Telephone> telephones;

  private List<Email> emails;

  public PersonSet(List<MasterNumber> masterNumbers,
                   List<Telephone> telephones,
                   List<Address> addresses,
                   List<Email> emails) {
    this.masterNumbers = masterNumbers;
    this.addresses = addresses;
    this.telephones = telephones;
    this.emails = emails;
  }

  public Stream<Person> groupToPeople() {
    // TODO: group the data to Stream<Person>
    // Can use Collectors.groupingBy method
    // Can add helper method

    /* Not Using The GroupingBy Method */
    return masterNumbers.stream().map(item -> {
      String number = item.getNumber();
      List<Telephone> telephone = telephones.stream().filter(element -> element.getMasterNumber().equals(number)).collect(Collectors.toList());
      List<Address> addressList = addresses.stream().filter(element -> element.getMasterNumber().equals(number)).collect(Collectors.toList());
      Address address = (addressList.size() == 0 ? null : addressList.get(0));
      List<Email> email = emails.stream().filter(element -> element.getMasterNumber().equals(number)).collect(Collectors.toList());
      return new Person(number, telephone, address, email);
    });

    /* Using The GroupingBy Method */
//    Map<String, List<Telephone>> telephone = telephones.stream().collect(Collectors.groupingBy(Telephone::getMasterNumber));
//    Map<String, List<Address>> address = addresses.stream().collect(Collectors.groupingBy(Address::getMasterNumber));
//    Map<String, List<Email>> email = emails.stream().collect(Collectors.groupingBy(Email::getMasterNumber));
//    return masterNumbers.stream().map(item -> {
//            String number = item.getNumber();
//            return new Person(number,
//                    Optional.ofNullable(telephone.get(number)).orElse(new ArrayList<>()),
//                    (address.get(number) == null) ? null : address.get(number).get(0),
//                    Optional.ofNullable(email.get(number)).orElse(new ArrayList<>()));
//    });
  }

  public List<Address> getAddresses() {
    return addresses;
  }

  public List<Telephone> getTelephones() {
    return telephones;
  }

  public List<Email> getEmails() {
    return emails;
  }

  public void setMasterNumbers(List<MasterNumber> masterNumbers) {
    this.masterNumbers = masterNumbers;
  }

  public void setAddresses(List<Address> addresses) {
    this.addresses = addresses;
  }

  public void setEmails(List<Email> emails) {
    this.emails = emails;
  }

  public void setTelephones(List<Telephone> telephones) {
    this.telephones = telephones;
  }
}
