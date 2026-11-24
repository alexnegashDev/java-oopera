import java.util.ArrayList;

public class MusicalShow extends Show {

    private Person musicAuthor;
    private String librettoText;

    MusicalShow(String title, int duration, Director director, ArrayList<Actor> listOfActors, Person musicAuthor, String librettoText) {
        super(title, duration, director, listOfActors);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    /*
        Распечатать текст либретто. Так как либретто есть у любого музыкального спектакля, будет логично добавить этот метод в класс MusicalShow . Метод должен выводить на экран содержимое поля librettoText .
    */
    public void printLibrettoText() {
        System.out.println("Текст либретто:\n" + librettoText);
    }
}
