package kg.megacom.finaltask.models.entity;

import kg.megacom.finaltask.enums.UserStatus;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data

@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "users")
public class User {

    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String imageUri;
    String phoneNum;
    String email;
    Long changeDate;

    @Enumerated(value = EnumType.STRING)
            @Column(nullable = false)
    UserStatus userStatus;
}
