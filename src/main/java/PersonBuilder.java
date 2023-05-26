public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;
    private boolean hasAddress = false;
    private boolean hasAge = false;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age > 0 && age < 110) {
            this.age = age;
            hasAge = true;
            return this;
        } else {
            throw new IllegalArgumentException("Введен неправильный возраст!");
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        hasAddress = true;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не введены обязательные данные: Имя и Фамилия!");
        }
        if (hasAge && hasAddress) {
            Person resultPerson = new Person(this.name, this.surname, this.age);
            resultPerson.setAddress(this.address);
            return resultPerson;
        } else if (hasAge) {
            return new Person(this.name, this.surname, this.age);
        } else if (hasAddress) {
            Person resultPerson = new Person(this.name, this.surname);
            resultPerson.setAddress(this.address);
            return resultPerson;
        } else return new Person(this.name, this.surname);

    }
}
