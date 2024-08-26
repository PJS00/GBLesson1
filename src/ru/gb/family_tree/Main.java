/**
 * Реализовать, с учетом ооп подхода, приложение.
 * Для проведения исследований с генеалогическим древом.
 * Идея: описать некоторое количество компонент, например:
 * модель человека и дерева
 * Под “проведением исследования” можно понимать например получение всех детей выбранного человека.
 * Более детальное описание проекта и как его реализовать обсуждали в конце семинара
 * Сделать PR к проекту: https://github.com/Liberate520/homeWork
 * В качестве ответа указать ссылку на PR
 * Ссылка на то как сделать пулреквест смотри в материалах к уроку
 * Если PR все таки не дается, то можно и ссылкой на гит репозиторий
 * Дополнить проект методами записи в файл и чтения из файла.
 * Для этого создать отдельный класс и реализовать в нем нужные методы.
 * Для данного класса сделайте интерфейс, который и используйте в своей программе.
 * Пример работы с интерфейсом Serialazable можно найти в материалах к уроку.
 * Изменить древо, сделать класс параметизированным,
 * чтобы условно дерево можно было использовать не только
 * для людей, но и сделать родословную для собак (класс собак
 * создавать не надо или создать, но за пределами пакета проекта).
 * Продумать (только подумать, но можно и попробовать реализовать)
 * класс общения с пользователем, набор команд, для операций над деревом
 */

package ru.gb.family_tree;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.writer.FileHandler;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/ru/gb/family_tree/writer/tree.txt";
    public static void main(String[] args) {

//        FamilyTree tree = load();
        FamilyTree tree = testTree();
        save(tree);

        System.out.println(tree);
    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        return (FamilyTree) fileHandler.read();
    }

    public static void save(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }

    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human sveta = new Human("Светлана", Gender.Female, LocalDate.of(1956, 2, 12), LocalDate.of(2023, 1, 14));
        Human vova1 = new Human("Владимир", Gender.Male, LocalDate.of(1954, 10, 23));

        tree.add(sveta);
        tree.add(vova1);
//        tree.setWeddings(sveta, vova1);

        Human stepan = new Human("Степан", Gender.Male, LocalDate.of(1991, 12, 1), vova1, sveta);
        Human polina = new Human("Полина", Gender.Female, LocalDate.of(1983, 9, 28), vova1, sveta);
        Human vova2 = new Human("Владимир", Gender.Male, LocalDate.of(1996, 3, 1), vova1, sveta);

        tree.add(stepan);
        tree.add(polina);
        tree.add(vova2);

        return tree;
    }
}
