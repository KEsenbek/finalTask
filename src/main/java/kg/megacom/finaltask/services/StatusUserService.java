package kg.megacom.finaltask.services;

import kg.megacom.finaltask.enums.UserStatus;
import kg.megacom.finaltask.models.responses.CheckStatusResponse;

public interface StatusUserService {
    CheckStatusResponse getStatuses(UserStatus status, Long timestamp);
}
