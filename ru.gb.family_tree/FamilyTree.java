import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Irerable<E>{
    private long countPeople;
    private List<E> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }
    public FamilyTree(List<E> humanList){
        this.humanList = humanList;
    }
    public boolean add(E human){
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humanId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
            return false; 
    }
    private void addToParents(E human){
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }
    private void addToChildren(E human){
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }
    public List<E> getSiblings(int id){
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<E> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }
    public List<E> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }
    // private boolean checkId(long id){
    //     return id < humanId && id >= 0;
    // }
    public E getById(long id){
        for (Human human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }
    @Override
    public String toString(){
        return getInfo();
    }
    
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве: ");
        sb.append(humanList.size());
        sb.append(" объектов: \n ");
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public Iterator<E> iterator(){
        return new HumanInerator(humanList);
    }
    public void sortByName(){
        humanList.sort(new HumanComporatorByName());
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComporatorByBirthDate);
    }
}
