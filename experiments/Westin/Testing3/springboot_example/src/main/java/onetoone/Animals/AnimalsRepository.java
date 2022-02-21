package onetoone.Animals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import onetoone.Animals.Animals;

public interface AnimalsRepository extends JpaRepository<Animals, Long> {
    Animals findById(int id);

    @Transactional
    void deleteById(int id);
}
