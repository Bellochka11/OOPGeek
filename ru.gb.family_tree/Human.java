import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human> {
    private long id;
    private String name;
    private Gender gender;
    private int age;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deatDate, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deatDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate, null, mother, father);
    }
    public boolean addChild(Human child){
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }
    public Human getMother(){
        return mother;
    }
    public Human getFather(){
        return father;
    }
    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }
    public int getAge(){
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        }
        else{
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deadDate){
        Period diff = Period.between(birthDate, deadDate);
        return diff.getYears();
    }

    public String getName() {
        return name;
    }

public long getId(){
    return id;
}
public void setId(long id){
    this.id = id;
}
public LocalDate getBirthDate(){
    return birthDate;
}
public LocalDate getDeathDate(){
    return deathDate;
}
public List<Human> getChildren(){
    return children;
}
   public void setBirthDate(LocalDate birthDate){
    this.birthDate = birthDate;
   }
   public void setDeathDate(LocalDate deatDate){
    this.deathDate = deatDate;
   }
   public Gender getGender(){
    return gender;
   }

    

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(gender);
        sb.append(", возраст: ");
        sb.append(age);
        sb.append(" ,");
        sb.append(getMotherInfo());
        sb.append(" ,");
        sb.append(getFatherInfo());
        sb.append(" ,");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = "Мать: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        }
        else{
            res += "Неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "Отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        }
        else{
            res += "Неизвестен";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(",");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("Отсутствуют");
        }
        return res.toString();
    }
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
    

    
