package pro.sky.skyprodb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int city_id;
        @Column
        String city_name;

        @OneToMany(mappedBy = "city_id", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Employee> employees;

        public City(String city_name) {
                this.city_name = city_name;
        }

        public City() {
        }

        public int getCity_id() {
                return city_id;
        }

        public void setCity_id(int city_id) {
                this.city_id = city_id;
        }

        public String getCity_name() {
                return city_name;
        }

        public void setCity_name(String city_name) {
                this.city_name = city_name;
        }
}
