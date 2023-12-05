public class HumanComporatorByBirthDate implements Comporator<Human>{
    @Override
    public int compare(Human o1, Human o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
