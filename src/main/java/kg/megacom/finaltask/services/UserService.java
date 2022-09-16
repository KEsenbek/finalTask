package kg.megacom.finaltask.services;

import kg.megacom.finaltask.enums.UserStatus;
import kg.megacom.finaltask.models.entity.User;
import kg.megacom.finaltask.models.responses.ChangeStatusResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User save(User user);

    User update (User user);

    User getById(Long id);

    Long addUser(User user, MultipartFile file);

    ChangeStatusResponse changeUserStatus(Long userId, UserStatus currentStatus);


}
