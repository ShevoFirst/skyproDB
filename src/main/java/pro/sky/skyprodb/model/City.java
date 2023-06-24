package pro.sky.skyprodb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "city_id",unique=true, nullable = false)
        private int cityId;
        @Column(name = "city_name")
        private String cityName;

        @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Employee> employees;

        public City(String city_name) {
                this.cityName = city_name;
        }

        public City() {
        }

        public int getCityId() {
                return cityId;
        }

        public void setCityId(int city_id) {
                this.cityId = city_id;
        }

        public String getCityName() {
                return cityName;
        }

        public void setCityName(String city_name) {
                this.cityName = city_name;
        }
}
