public class Director extends Person {

    /*
        Для для режиссёра добавим поля имя, фамилия, пол и количество поставленных спектаклей (numberOfShows)
    */
    Gender gender;
    int numberOfShows;

    public Director(String name, String surname, Gender gender, int numberOfShows) {
        super(name, surname);
        this.gender = gender;
        this.numberOfShows = numberOfShows;
    }

    /*
        Распечатать информацию о режиссёре спектакля.
        Нам нужно описание объекта класса в виде строки, поэтому есть смысл переопределить для этого метод toString
    */
    @Override
    public String toString() {
        // Распечатать информацию о режиссёре спектакля — должны выводиться его имя и фамилия.
        String str = "Режиссер спектакля:";
        str += name + " " + surname + "\n";
        // str += numberOfShows + "постановок\n";
        return str;
    }
}
