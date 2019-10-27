package ru.geekbrains.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
