package com.pamplemousse.pampleback.mapper;

import java.util.Collection;
import java.util.List;

import com.pamplemousse.pampleback.dto.UserFromClientDto;
import com.pamplemousse.pampleback.model.User;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * mapper to convert UserFromClientDto to User.
     * @param dto
     * @return User
     */
    @Mapping(target = "type", ignore = true)
    User userDtoToUser(UserFromClientDto dto);

    /**
     * mapper to convert List UserFromClientDto to List User.
     * @param list
     * @return List<User>
     */
    List<User> listUserDtoToListUser(List<UserFromClientDto> list);

    /**
     * mapper to convert Collection UserFromClientDto to Collection User.
     * @param list
     * @return Collection<UserFromClientDto>
     */
    Collection<User> collectionUserDtoToCollectionUser(Collection<UserFromClientDto> list);

}
