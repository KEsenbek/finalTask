package kg.megacom.finaltask.mappers;

import kg.megacom.finaltask.models.dto.UserDto;
import kg.megacom.finaltask.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseCrud<User, UserDto> {

UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


}
