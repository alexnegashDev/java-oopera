import java.util.ArrayList;
import java.util.Objects;

public class Show {
    /*
        У спектакля нас будут интересовать такие признаки, как название (title), длительность в минутах (duration),
        режиссёр (director) и список актёров (listOfActors)
    */
    private String title;
    private int duration;
    private Director director;
    private ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
    }

    /*
        Добавить нового актера в спектакль. Метод должен добавлять актёра в список listOfActors.
        Чтобы сравнивать актёров между собой, вам понадобится реализовать в классе актёра метод equals.
        Не забудьте, что при реализации метода equals обязательно также реализовать и hashCode
    */
    public void addNewActor(Actor newActor) {
//        /*
//            При добавлении актёра должна быть проверка, нет ли уже такого актёра среди добавленных.
//            Если есть, должно выводиться предупреждающее сообщение, и актёр не должен добавляться.
//            Актёры считаются одинаковыми, если у них совпадают имя, фамилия и рост.
//        */

        ArrayList<Actor> listOfActors = this.listOfActors;

        boolean isThisANewActor = true;
        for (Actor actor : listOfActors) {
            if (Objects.equals(actor, newActor)) {
                System.out.println("Актера невозможно добавить, т.к. этот актер уже учавствует в спектакле.");
                isThisANewActor = false;
                break;
            }
        }

        if (isThisANewActor) { listOfActors.add(newActor); }
    }

    /*
        Заменить одного актёра в спектакле на другого. Здесь могут быть разные варианты реализации.
        Можно найти актёра для замены, удалить его из списка с помощью метода remove класса ArrayList, а затем добавить нового в конец списка.
        А можно сразу обновить актёра на том же месте, используя метод set

        Заменить одного актёра в спектакле на другого (на вход подаётся объект нового актёра и фамилия того, которого он заменяет).
        Если актёр с такой фамилией отсутствует, должно выводиться предупреждающее сообщение.
        Порядок актёров в списке значения не имеет.
    */
    public void replaceActor(Actor actorToReplaceBy, String surnameOfActorToReplace) {
        /*
            В логике метода replaceActor нужно предусмотреть случай, когда в спектакле может участвовать несколько актеров-однофамильцев.
            В этом случае стоит вывести предупреждение и замену не осуществлять.
        */

        ArrayList<Actor> listOfActors = this.listOfActors;
        int indexOfActorToReplace = 0;

        // Считаем кол-во актеров-однофамильцев
        int numberOfActorsWithSimilarSurname = 0;
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            if (actor.getActorSurname().equals(surnameOfActorToReplace)) {
                numberOfActorsWithSimilarSurname++;
                indexOfActorToReplace = i;
            }
        }

        if (numberOfActorsWithSimilarSurname == 1) {
            System.out.println("Заменили актера с фамилией " + surnameOfActorToReplace + " на актера " + actorToReplaceBy.getActorName() + " " + actorToReplaceBy.getActorSurname());
            listOfActors.set(indexOfActorToReplace, actorToReplaceBy); // Замена
        }
        else if (numberOfActorsWithSimilarSurname == 0) {
            System.out.println("Актера с фамилией " + surnameOfActorToReplace + " нет в спектакле");
        }
        else if (numberOfActorsWithSimilarSurname > 1) {
            System.out.println("В спектакле несколько актеров-однофамильцев. Замена не выполнена");
        }
    }

    public void printListOfActors() {
        String str = "Список актеров учавствующих в спектакле '" + title + "':\n";
        for (int i = 0; i < listOfActors.size(); i++) {
            Actor actor = listOfActors.get(i);
            str += "  " + (i + 1) + ". " + actor.getActorData();
        }

        System.out.println(str);
    }
}
