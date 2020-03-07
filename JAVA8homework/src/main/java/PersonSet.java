import entity.Address;
import entity.Email;
import entity.MasterNumber;
import entity.Person;
import entity.Telephone;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    return masterNumbers.stream().map(item -> {
      String number = item.getNumber();
      List<Telephone> telephone = telephones.stream().filter(element -> element.getMasterNumber().equals(number)).collect(Collectors.toList());
      List<Address> addressList = addresses.stream().filter(element -> element.getMasterNumber().equals(number)).collect(Collectors.toList());
      Address address = (addressList.size() == 0 ? null : addressList.get(0));
      List<Email> email = emails.stream().filter(element -> element.getMasterNumber().equals(number)).collect(Collectors.toList());
      return new Person(number, telephone, address, email);
    });
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
