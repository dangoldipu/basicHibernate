package formula;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long heightInInches;

    @Formula("heightininches * 2") // random conversion
    @Setter(AccessLevel.PRIVATE) // user cannot set height on centimeter
    private Long heightInCentimeter;
}

