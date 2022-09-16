package kg.megacom.finaltask.dao;

import kg.megacom.finaltask.enums.UserStatus;
import kg.megacom.finaltask.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    ArrayList<User> findAllByUserStatus(UserStatus status);


}
