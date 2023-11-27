import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }
    private boolean add(Human human){
        if (!humanList.contains(human)) {
            humanList.add(human);
            return true;
        }
        else{
            return false;
        }
    }
    
}
