import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human liza = new Human("Лиза", Gender.Female, 19, LocalDate.of(2004, 8, 11), null, null, null);

        Human lena = new Human("Лена", Gender.Female, 50, LocalDate.of(1970, 8, 19), null, null, null);

        Human george = new Human("Георгий", Gender.Male, 27, LocalDate.of(1997, 6, 5), null, null, null);

        Human gyram = new Human("Гурам", Gender.Male, 80, LocalDate.of(1960, 3, 20), null, null, null);

        System.out.println(liza);
        liza.setParents(lena, gyram);
        george.setParents(lena, gyram);
        System.out.print("Отец: " + liza.getFather().getName());
        System.out.println(", Мать: " + george.getMother().getName());
        System.out.println(george);
        System.out.print("Отец: " + liza.getFather().getName());
        System.out.println(", Мать: " + george.getMother().getName());

        gyram.addChildren(liza);
        gyram.addChildren(george);
        lena.addChildren(liza);
        lena.addChildren(george);
        System.out.println(lena);
        System.out.print("Дети: ");
        List<Human> children = gyram.getChildren();
        for (int i = 0; i < children.size(); i++) {
            System.out.print(children.get(i).getName());
            if (i < children.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" ");
        System.out.println(gyram);
        System.out.print("Дети: ");
        List<Human> childrens = gyram.getChildren();
        for (int i = 0; i < childrens.size(); i++) {
            System.out.print(childrens.get(i).getName());
            if (i < childrens.size() - 1) {
                System.out.print(", ");
            }
        }

    }

}
