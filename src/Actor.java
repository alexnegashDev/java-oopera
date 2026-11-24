import java.util.ArrayList;
import java.util.Objects;

public class Actor extends Person {
    private int height;

    /*
        Для актёра добавим поля имя (name), фамилия (surname), пол (gender) и рост (height)
    */
    public Actor(String name, String surname, Gender gender, int height) {
        super(name, surname, gender);
        this.height = height;
    }

    public String getActorData() {
        /*
            Для каждого актёра при этом должны выводиться имя и фамилия, а также в скобках его рост.
        */
        return getPersonName() + " " + getPersonSurname() + " (" + height + ")\n";
    }

    // Геттеры и Сеттеры
    public String getActorName() {
        return getPersonName();
    }

    public String getActorSurname() {
        return getPersonSurname();
    }


    // Переопределение методов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; // можно оформить и так
        Actor actor = (Actor) obj;

        // Сравнение хэшей
        return Objects.equals(getActorName(), actor.getActorName()) && Objects.equals(getPersonSurname(), actor.getPersonSurname()) &&
                Objects.equals(getPersonGender(), actor.getPersonGender()) && Objects.equals(height, actor.height);
    }

    @Override
    public int hashCode() {
        // Чтобы не дублировать код вывел однотипные действия в отдельный метод hashCodeHelper()

        int hash = 17;
        hash = hashCodeHelper(hash, getPersonName());
        hash = hash * 31; // умножаем промежуточный результат на простое число
        hash = hashCodeHelper(hash, getPersonSurname());
        hash = hashCodeHelper(hash, getPersonGender());
        hash = hashCodeHelper(hash, height);

        return hash; // возвращаем итоговый хеш
    }

    public int hashCodeHelper(int hash, Object obj) {
        if (obj != null) {
            // вычисляем хеш первого поля и добавляем к нему начальное значение
            hash = hash + obj.hashCode();
        }

        return hash;
    }
}
