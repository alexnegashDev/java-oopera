import java.util.ArrayList;
import java.util.Objects;

public class Actor extends Person {
    private Gender gender;
    private int height;

    /*
        Для актёра добавим поля имя (name), фамилия (surname), пол (gender) и рост (height)
    */
    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname);
        this.gender = gender;
        this.height = height;
    }

    /*
        Добавить нового актера в спектакль. Метод должен добавлять актёра в список listOfActors.
        Чтобы сравнивать актёров между собой, вам понадобится реализовать в классе актёра метод equals.
        Не забудьте, что при реализации метода equals обязательно также реализовать и hashCode
    */
    public void addNewActor(Show show) {
        /*
            При добавлении актёра должна быть проверка, нет ли уже такого актёра среди добавленных.
            Если есть, должно выводиться предупреждающее сообщение, и актёр не должен добавляться.
            Актёры считаются одинаковыми, если у них совпадают имя, фамилия и рост.
        */
        boolean isThisANewActor = true;
        for (Actor actor : show.listOfActors) {
            if (!this.equals(actor)) {
                System.out.println("Актера невозможно добавить, т.к. этот актер уже учавствует в спектакле.");
                isThisANewActor = false;
                break;
            }
        }

        if (isThisANewActor) { show.listOfActors.add(this); }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;
        Actor actor = (Actor) obj;

        // Вместо @Override hashCode

        // Актёры считаются одинаковыми, если у них совпадают имя, фамилия и рост.
        return Objects.hash(this.name, this.surname, this.height) == Objects.hash(actor.name, actor.surname, actor.height);
    }

    /*
        Заменить одного актёра в спектакле на другого. Здесь могут быть разные варианты реализации.
        Можно найти актёра для замены, удалить его из списка с помощью метода remove класса ArrayList, а затем добавить нового в конец списка.
        А можно сразу обновить актёра на том же месте, используя метод set

        Заменить одного актёра в спектакле на другого (на вход подаётся объект нового актёра и фамилия того, которого он заменяет).
        Если актёр с такой фамилией отсутствует, должно выводиться предупреждающее сообщение.
        Порядок актёров в списке значения не имеет.
    */
    public void replaceActor(ArrayList<Actor> listOfActors, String surnameOfActorToReplace) {
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            if (actor.surname.equals(surnameOfActorToReplace)) {
                // Заменяем сразу
                listOfActors.set(i, this);
                return;
            }
        }

        System.out.println("Такого актера нет в спектакле");
    }

    public String getActorData() {
        /*
            Для каждого актёра при этом должны выводиться имя и фамилия, а также в скобках его рост.
        */
        return name + " " + surname + " (" + height + ")\n";
    }
}
