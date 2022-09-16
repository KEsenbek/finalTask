package kg.megacom.finaltask.services.impl;

import kg.megacom.finaltask.dao.UserRepo;
import kg.megacom.finaltask.enums.UserStatus;
import kg.megacom.finaltask.mappers.UserMapper;
import kg.megacom.finaltask.microservices.FileServiceFeign;
import kg.megacom.finaltask.microservices.json.Response;
import kg.megacom.finaltask.models.entity.User;
import kg.megacom.finaltask.models.responses.ChangeStatusResponse;
import kg.megacom.finaltask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private FileServiceFeign fileServiceFeign;

    private final UserMapper userMapper;

    public UserServiceImpl() {
        this.userMapper = UserMapper.INSTANCE;
    }


    @Override
    public User save(User user) {
        return userRepo.save(user);
    }

    @Override
    public User update(User user) {
        if (userRepo.existsById(user.getId())){
            return userRepo.save(user);
        }

        return null;
    }

    @Override
    public User getById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Указанный пользователь не найден"));
    }


    @Override
    public Long addUser(User user, MultipartFile file) {
        Response response = fileServiceFeign.upload(file);
        user.setImageUri(response.getDownloadUri());
        save(user);
        return user.getId();
    }

    @Override
    public ChangeStatusResponse changeUserStatus(Long userId, UserStatus currentStatus) {

        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("Пользователь не найден!"));
        ChangeStatusResponse change = new ChangeStatusResponse();
        Date date = new Date();
        change.setUserId(user.getId());
        change.setOldStatus(user.getUserStatus());
        change.setNewStatus(UserStatus.valueOf(currentStatus.toString()));
        user.setUserStatus(UserStatus.valueOf(currentStatus.toString()));
        user.setChangeDate(date.getTime());
        userRepo.save(user);
        return change;
    }


}
