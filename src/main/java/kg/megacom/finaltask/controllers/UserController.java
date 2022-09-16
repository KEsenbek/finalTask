package kg.megacom.finaltask.controllers;

import kg.megacom.finaltask.enums.UserStatus;
import kg.megacom.finaltask.models.dto.UserDto;
import kg.megacom.finaltask.models.entity.User;
import kg.megacom.finaltask.models.responses.ChangeStatusResponse;
import kg.megacom.finaltask.models.responses.CheckStatusResponse;
import kg.megacom.finaltask.services.StatusUserService;
import kg.megacom.finaltask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.GeneratedValue;
import java.util.Date;

@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StatusUserService statusUserService;

    @PostMapping("/add")
    private User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/add/file")
    //Добавление нового пользователя.
    //Ответ сервера - уникальный ID нового пользователя.
    private Long addImageToUser(@RequestParam Long userId, @RequestPart MultipartFile file) {
        User user = userService.getById(userId);
        userService.addUser(user, file);
        return user.getId();
    }

    @GetMapping("/getById")
    //Передаем на сервер уникальный ID пользователя.
    //Ответ сервера - персональные данные пользователя
    private User getByID(@RequestParam Long userId) {
        return userService.getById(userId);
    }

    @PutMapping("/updateStatus")
    //Передаем на сервер уникальный ID пользователя и новый статус (Online, Offline)
    //Ответ сервера - уникальный ID пользователя, новый и предыдущий статус.
    private ChangeStatusResponse changeStatus(@RequestParam Long userId,
                                              @RequestParam(defaultValue = "ONLINE") UserStatus status) {
        if (status.equals("ONLINE")) {
            status = UserStatus.valueOf("ONLINE");
        } if(status.equals("OFFLINE")) {
            status = UserStatus.valueOf("OFFLINE");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return userService.changeUserStatus(userId, status);
    }

    @GetMapping("/getServerStatistics")
    //Передаем параметры на сервер: 1. статус клиентов (Online, Offline
    //или отсутствует), 2. уникальный ID (timestamp) запроса (может отсутствовать)
    // Ответ сервера - список пользователей со статусами и URI картинки,
    //а также уникальный ID (timestamp) запроса.
    private CheckStatusResponse getServerStatistics(@RequestParam(required = false, defaultValue = "ONLINE") UserStatus userStatus,
                                                    @RequestParam(required = false) Long timestamp) {

        if (userStatus.equals("ONLINE")) {
            userStatus = UserStatus.valueOf("ONLINE");
        } if (userStatus.equals("OFFLINE")){
            userStatus = UserStatus.valueOf("OFFLINE");
        }
        return statusUserService.getStatuses(userStatus, timestamp);
    }
}
