public class FamilyTreeModel {
    private FamilyTree<Human> familyTree;

    public FamilyTreeModel() {
        familyTree = new FamilyTree<>();
    }

    public boolean addHuman(Human human) {
        return familyTree.add(human);
    }

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    
}

