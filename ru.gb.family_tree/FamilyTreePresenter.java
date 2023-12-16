public class FamilyTreePresenter {
    private FamilyTreeModel model;
    private FamilyTreeView view;

    public FamilyTreePresenter() {
        model = new FamilyTreeModel();
        view = new FamilyTreeView();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        Human human = new Human(name, gender, birthDate);
        boolean success = model.addHuman(human);
        if (success) {
            view.showInfo("Человек успешно добавлен в семейное дерево.");
        } else {
            view.showInfo("Не удалось добавить человека в семейное дерево.");
        }
    }

    public void sortByBirthDate() {
        model.sortByBirthDate();
        view.showInfo("Дерево успешно отсортировано по дате рождения.");
    }

    
}
