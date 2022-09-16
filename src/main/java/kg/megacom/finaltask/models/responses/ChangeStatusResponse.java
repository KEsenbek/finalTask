package kg.megacom.finaltask.models.responses;


import kg.megacom.finaltask.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChangeStatusResponse {

    Long userId;
    UserStatus oldStatus;
    UserStatus newStatus;
}
