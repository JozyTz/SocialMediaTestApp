package project.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.app.model.User;

/**
 * Repo of users
 * 
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * finds a user using their ID
	 * @param id
	 * @return
	 */
	User findById(long id);
	
	
	/**
	 * finds a user using their username
	 * @param username
	 * @return
	 */
	User findByUsernameAndPassword(String username, String password);
	
	/**
	 * deletes a user by their ID
	 * @param id
	 */
    void deleteById(int id);


    
}
