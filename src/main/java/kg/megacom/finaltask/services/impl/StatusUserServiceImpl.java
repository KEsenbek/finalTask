package kg.megacom.finaltask.services.impl;

import kg.megacom.finaltask.dao.UserRepo;
import kg.megacom.finaltask.enums.UserStatus;
import kg.megacom.finaltask.models.entity.User;
import kg.megacom.finaltask.models.responses.CheckStatusResponse;
import kg.megacom.finaltask.services.StatusUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusUserServiceImpl implements StatusUserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public CheckStatusResponse getStatuses(UserStatus status, Long timestamp) {

        List<User> users = userRepo.findAllByUserStatus(UserStatus.valueOf(status.toString()));

        users.stream().filter(x -> x.getChangeDate() > timestamp).collect(Collectors.toList());
        CheckStatusResponse checkStatusResponse = new CheckStatusResponse();
        checkStatusResponse.setUsers(users);
        checkStatusResponse.setTimestamp(timestamp);
        checkStatusResponse.setImageUri(users.stream().map(x->x.getImageUri()).toString());
        return checkStatusResponse;
    }
}
