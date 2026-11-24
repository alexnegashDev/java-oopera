import java.util.ArrayList;

public class Theatre {

    /*
        Осталось совсем немного — собрать всё вместе и позволить нашему театру начать работу.
        Для этого создайте класс Theatre с методом main.

        Внутри метода main вам нужно выполнить следующие действия:
        Создать трёх актеров и двух режиссёров.
        Также создайте одного автора музыки и одного хореографа
        Создать три спектакля: обычный, оперный и балет
        Распределить актёров по спектаклям. Используйте для этого метод добавления нового актёра в спектакль.
        Один актёр может участвовать в нескольких спектаклях.
        Для каждого спектакля выведите на экран список актёров.
        Замените актёра в одном из спектаклей на актёра из другого спектакля и ещё раз выведите для него список актёров.
        Попробуйте заменить в другом спектакле несуществующего актёра
        Для оперного и балетного спектакля выведите на экран текст либретто.
        На этом всё! Теперь зрители могут спокойно наслаждаться представлениями — за кулисами театра всё разложено по полочкам.
    */

    public static void main(String[] args) {
        System.out.println("Поехали!");

        // Создать трёх актеров и двух режиссёров.
        // Для актёра добавим поля имя (name), фамилия (surname), пол (gender) и рост (height)
        Actor actor_1 = new Actor("Артём", "Волков", Gender.MALE, 188);
        Actor actor_2 = new Actor("София", "Морозова", Gender.FEMALE, 172);
        Actor actor_3 = new Actor("Кирилл", "Нестеров", Gender.MALE, 191);

        Director director_1 = new Director("Александр", "Громов", Gender.MALE, 27);
        Director director_2 = new Director("Елена", "Воронцова", Gender.FEMALE, 19);

        // Также создайте одного автора музыки и одного хореографа
        Person musicAuthor = new Person("Дмитрий", "Орлов", Gender.MALE);
        Person choreographer = new Person("Марина", "Соколова", Gender.FEMALE);

        // Либретто
        String librettoTextForOpera = "Это текст либретто для оперы.";
        String librettoTextForBallet = "Это текст либретто для балета.";

        // Размер хора
        int choirSize = 10;

        // Создать три спектакля: обычный, оперный и балет
        Show show = new Show("Вишнёвый сад", 150, director_1, new ArrayList<>());
        Opera opera = new Opera("Травиата", 160, director_1, new ArrayList<>(), musicAuthor, librettoTextForOpera, choirSize);
        Ballet ballet = new Ballet("Лебединое озеро", 155, director_2, new ArrayList<>(), musicAuthor, librettoTextForBallet, choreographer);

        // Распределить актёров по спектаклям. Используйте для этого метод добавления нового актёра в спектакль.
        // Один актёр может участвовать в нескольких спектаклях.
        show.addNewActor(actor_1);
        show.addNewActor(actor_2);
        opera.addNewActor(actor_3);
        ballet.addNewActor(actor_1);

        // Для каждого спектакля выведите на экран список актёров.
        show.printListOfActors();
        opera.printListOfActors();
        ballet.printListOfActors();

        // Замените актёра в одном из спектаклей на актёра из другого спектакля и ещё раз выведите для него список актёров.
        ballet.replaceActor(actor_2, actor_1.getPersonSurname());
        ballet.printListOfActors();

        // Попробуйте заменить в другом спектакле несуществующего актёра.
        opera.replaceActor(actor_1, actor_2.getPersonSurname()); // Выдаст сообщение: "Такого актера нет в спектакле"

        // Для оперного и балетного спектакля выведите на экран текст либретто.
        opera.printLibrettoText();
        ballet.printLibrettoText();

        // На этом всё! Теперь зрители могут спокойно наслаждаться представлениями — за кулисами театра всё разложено по полочкам.
    }


}
