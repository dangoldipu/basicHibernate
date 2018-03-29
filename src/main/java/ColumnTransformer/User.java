package ColumnTransformer;

import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ColumnTransformer(
//            read = "heightInInches / 2", // convert db values to object value
//            write = "? * 2" // convert object value to db value
//    )
//    private Long heightInInches;

    private Set<String> address = new HashSet<>();
}

