package cat.itacademy.s04.t02.n01.fruit_Api.repository;

import cat.itacademy.s04.t02.n01.fruit_Api.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository <Fruit, Long> {
    boolean existsByName(String name);
}
