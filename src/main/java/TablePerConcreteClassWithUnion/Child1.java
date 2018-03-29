package TablePerConcreteClassWithUnion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "gender",column = @Column(name ="sex" ))
@Entity
public class Child1 extends Parent {

    private String Addr;



}
