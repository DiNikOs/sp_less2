package ru.geekbrains.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geekbrains.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select new User(u.id, u.name, u.description) from User u")
    List<User> findAllWithoutProductsUsers();

    @Query("select distinct u " +
            "from User u " +
            "left join fetch u.products p " +
            "where u.id = :id")
    Optional<User> findByIdWithProductsUsers(@Param("id") Long id);
}
