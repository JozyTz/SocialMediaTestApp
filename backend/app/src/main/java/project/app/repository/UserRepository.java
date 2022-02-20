package project.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findById(int id);
    void deleteById(int id);


}
