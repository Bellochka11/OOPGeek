public class FamilyTreeView {
    private FamilyTreePresenter presenter;

    public FamilyTreeView() {
        presenter = new FamilyTreePresenter();
    }

    public void showInfo(String info) {
        System.out.println(info);
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        presenter.addHuman(name, gender, birthDate);
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

}
