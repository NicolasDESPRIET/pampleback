package com.pamplemousse.pampleback.mapper;

import java.util.Collection;
import java.util.List;

import com.pamplemousse.pampleback.dto.UserFromClientDto;
import com.pamplemousse.pampleback.model.User;

import org.mapstruct.Mapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "type", ignore = true)
    User UserDtoToUser(UserFromClientDto dto);

    List<User> listUserDtoToListUser(List<UserFromClientDto> list);

    Collection<User> collectionUserDtoToCollectionUser(Collection<UserFromClientDto> list);

}
