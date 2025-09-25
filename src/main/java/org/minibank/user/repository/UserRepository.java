package org.minibank.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.minibank.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
