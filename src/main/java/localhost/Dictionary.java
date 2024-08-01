package localhost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dictionary {
    private final static List<String> dict = new ArrayList<>(Arrays.asList("Абстракция",
            "Акварель",
            "Архитектура",
            "Библиотека",
            "Биология",
            "География",
            "Дирижёр",
            "Журналист",
            "Иллюстрация",
            "Информация",
            "Композиция",
            "Конструкция",
            "Лаборатория",
            "Литература",
            "Медицина",
            "Персонал",
            "Репетиция",
            "Симметрия",
            "Технология",
            "Фотография"));

    public static String getNoun() {
        Random rnd = new Random();
        int rndIndex = rnd.nextInt(dict.size());
        return dict.get(rndIndex);
    }

}
