package Criteria;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    int id;

    String name;
    String address;
    int marks;
    int standard;

}
