package com.pamplemousse.pampleback.mapper;

import java.util.Collection;
import java.util.List;

import com.pamplemousse.pampleback.dto.TypeDto;
import com.pamplemousse.pampleback.model.Type;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    TypeDto typeToTypeDto(Type entity);

    Type typeDtoToType(TypeDto dto);

    List<Type> listTypeDtoToListType(List<TypeDto> list);

    List<TypeDto> listTypeToListTypeDto(List<Type> list);

    Collection<Type> collectionTypeDtoToCollectionType(Collection<TypeDto> list);

    Collection<TypeDto> collectionTypeToCollectionTypeDto(Collection<Type> list);

}
