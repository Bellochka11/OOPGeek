import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // FamilyTree tree = load();
        FamilyTree tree = createTestTree();
        System.out.println(tree);
        // save(tree);

        // Загрузка дерева из файла
        FamilyTree loadedTree = load();
        System.out.println(loadedTree);
    }

    private static FamilyTree load() {
        String filePath = "tree.ser";
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read(filePath);
    }

    private static void save(FamilyTree tree) {
        String filePath = "tree.ser";
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    static FamilyTree createTestTree() {
        FamilyTree tree = new FamilyTree();

        Human gyram = new Human("Гурам", Gender.Male, LocalDate.of(1960, 3, 20));
        Human lena = new Human("Лена", Gender.Female, LocalDate.of(1970, 8, 19));
        Human george = new Human("Георгий", Gender.Male, LocalDate.of(1997, 6, 5), lena, gyram);
        Human liza = new Human("Лиза", Gender.Female, LocalDate.of(2004, 8, 11), lena, gyram);

        tree.add(liza);
        tree.add(lena);
        tree.add(george);
        tree.add(gyram);

        return tree;
    }
}