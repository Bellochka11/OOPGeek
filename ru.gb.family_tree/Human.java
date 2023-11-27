import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private int age;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, int age, LocalDate birthDate, LocalDate deatDate, Human mother, Human father){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
        this.deathDate = deatDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }
    
        public void setMother(Human mother){
            this.mother = mother;
        }
        public void setFather(Human father){
            this.father = father;
        }
        public void setGender(Gender gender){
            this.gender = gender;
        }
        
        

    public boolean addChildren(Human child){
        if (!children.contains(child)) { //если нету 
            children.add(child);
            return true;
        }
        return false;
    }
    public List<Human>  getChildren(){
        return children;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(gender);
        sb.append(", возраст: ");
        sb.append(age);
        return sb.toString();
    }

    public void setParents(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
    }
    public Human getMother(){
        return mother;
    }
    
    
    public Human getFather(){
        return father;
    }
    
    
    

    public String getName() {
        return name;
    }
}



