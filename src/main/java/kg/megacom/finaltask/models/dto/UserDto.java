package kg.megacom.finaltask.models.dto;

import kg.megacom.finaltask.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data

@FieldDefaults(level = AccessLevel.PRIVATE)


public class UserDto {


    Long id;

    String name;
    String imageUri;
    String phoneNum;
    String email;

    UserStatus userStatus;

}
