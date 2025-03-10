package sisal.it.copilot.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sisal.it.copilot.challenge.beans.request.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
}
