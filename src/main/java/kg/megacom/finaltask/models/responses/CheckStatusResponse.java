package kg.megacom.finaltask.models.responses;


import kg.megacom.finaltask.models.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CheckStatusResponse {

    Long timestamp;
    String imageUri;
    List<User> users;
}
