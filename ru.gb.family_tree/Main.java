import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Human liza = new Human();
        liza.gender = Gender.Female;
        liza.birthDate = LocalDate.of(2004, 8, 11);

        Human lena = new Human();
        lena.gender = Gender.Female;
        lena.birthDate = LocalDate.of(1970, 8, 19);

        Human george = new Human();
        george.gender = Gender.Male;
        george.birthDate = LocalDate.of(1997, 3, 7);

        Human gyram = new Human();
        gyram.gender = Gender.Male;
        gyram.birthDate = LocalDate.of(1963, 5, 9);

        liza.mother = lena;
        liza.father = gyram;
        george.mother = lena;
        george.father = gyram;

        lena.children = Arrays.asList(liza);
        lena.children = Arrays.asList(george);
        gyram.children = Arrays.asList(liza);
        gyram.children = Arrays.asList(george);

        

        System.out.println(liza);
        System.out.println(lena);
        System.out.println(george);
        System.out.println(gyram);

    }

}
