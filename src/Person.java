public class Person {
    /*
        Когда вы создавали классы, вы могли заметить, что часть полей у актёра и режиссёра дублируются — это имя, фамилия и пол.
        Всё потому, что и актёры, и режиссёры являются людьми, а эти признаки характерны для всех людей.
        То есть, в терминах ООП, существует базовый класс Person («Человек») с двумя наследниками — актёр и режиссёр.
        Давайте отразим это в структуре классов. Добавьте класс Person и перенесите поля, которые относятся к любому человеку, в этот класс.
    */

    private String name;
    private String surname;
    private Gender gender;

    public Person(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    // Геттеры
    public String getPersonName() {
        return name;
    }

    public String getPersonSurname() {
        return surname;
    }

    public Gender getPersonGender() {
        return gender;
    }

    // Сеттеры
    public void setPersonGender(Gender gender) {
        this.gender = gender;
    }
}
