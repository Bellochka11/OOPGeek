import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    Gender gender;
    LocalDate birthDate;
    Human mother, father;
    List<Human> children;

    @Override
    public String toString() {
        
        return "gender: " + gender + ", birthDate:" + birthDate;
    }
    }


