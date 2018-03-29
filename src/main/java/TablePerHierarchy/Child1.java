package TablePerHierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "gender",column = @Column(name ="sex" ))
@Entity
@DiscriminatorValue("child_1")
public class Child1 extends Parent {

    private String Addr;



}
