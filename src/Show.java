import java.util.ArrayList;

public class Show {
    /*
        У спектакля нас будут интересовать такие признаки, как название (title), длительность в минутах (duration),
        режиссёр (director) и список актёров (listOfActors)
    */
    public String title;
    public int duration;
    public Director director;
    public ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director, ArrayList<Actor> listOfActors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = listOfActors;
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
