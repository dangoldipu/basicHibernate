package BuilderPattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complex {
    @Id
    private int id;

    private String name;

    private String address;

    public static ComplexBuilder builder() {
        return new ComplexBuilder();
    }

    public static class ComplexBuilder {
        private int id;
        private String name;
        private String address;

        ComplexBuilder() {
        }

        public ComplexBuilder id(int id) {
            this.id = id;
            return this;
        }

        public ComplexBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ComplexBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Complex build() {
            return new Complex(id, name, address);
        }

        public String toString() {
            return "Complex.ComplexBuilder(id=" + this.id + ", name=" + this.name + ", address=" + this.address + ")";
        }
    }
}
