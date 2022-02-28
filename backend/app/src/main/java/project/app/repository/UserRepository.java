package project.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.app.model.User;

/**
 * Repo of users
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * finds a user using their ID
	 * @param id
	 * @return
	 */
	User findById(int id);
	
	/**
	 * deletes a user by their ID
	 * @param id
	 */
    void deleteById(int id);


}
