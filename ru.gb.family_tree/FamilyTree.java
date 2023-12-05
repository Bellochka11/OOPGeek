import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Irerable<Human>{
    private long humanId;
    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    public boolean add(Human human){
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
    private void addToParents(Human human){
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }
    private void addToChildren(Human human){
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }
    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }
    public List<Human> getByName(String name){
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
    public Human getById(long id){
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
    public Iterator<Human> iterator(){
        return new HumanInerator(humanList);
    }
    public void sortByName(){
        humanList.sort(new HumanComporatorByName());
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComporatorByBirthDate);
    }
}
