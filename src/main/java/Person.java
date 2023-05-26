import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private int age;
    private String cityOfLiving;
    private boolean hasAddress = false;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasAddress() {
        return hasAddress;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (!hasAge()) return OptionalInt.empty();
        else return OptionalInt.of(age);
    }

    public void setAddress(String address) {
        this.cityOfLiving = address;
        hasAddress = true;
    }

    public void happyBirthday() {
        this.age++;
    }

    public String getCityOfLiving() {
        if (hasAddress()) {
            return cityOfLiving;
        } else {
            return "Город жительства не указан!";
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(getSurname()).setAddress(getCityOfLiving());
    }


    @Override
    public String toString() {
        return "Name: " + getName() + "\nSurname: " + getSurname() + "\nAge: " + getAge().orElse(0) + "\nCity of living: " + getCityOfLiving();
    }
}
