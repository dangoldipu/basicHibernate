package AttributeOverride;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @AttributeOverrides({
            @AttributeOverride(name = "country",column = @Column(name = "home_country")),
            @AttributeOverride(name = "city",column = @Column(name = "home_city"))
    })
    private Address homeAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "country",column = @Column(name = "work_country")),
            @AttributeOverride(name = "city",column = @Column(name = "work_city"))
    })
    private Address workAddress;
}
