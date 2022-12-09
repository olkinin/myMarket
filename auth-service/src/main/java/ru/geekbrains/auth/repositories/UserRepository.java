package ru.geekbrains.auth.repositories;





import org.springframework.stereotype.Repository;
import ru.geekbrains.auth.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends org.springframework.data.jpa.repository.JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
