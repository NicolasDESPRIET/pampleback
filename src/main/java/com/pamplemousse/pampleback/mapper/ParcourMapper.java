package com.pamplemousse.pampleback.mapper;

import com.pamplemousse.pampleback.dto.ParcourFromClientDto;
import com.pamplemousse.pampleback.model.Parcour;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ParcourMapper {
    Parcour parcourFromClientDtoToParcour(ParcourFromClientDto parcourFromClientDto);

    void updateParcourFromDto(ParcourFromClientDto dto, @MappingTarget Parcour entity);
}
