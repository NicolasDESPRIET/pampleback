package com.pamplemousse.pampleback.mapper;

import java.util.List;

import com.pamplemousse.pampleback.dto.ParcoursFromClientDto;
import com.pamplemousse.pampleback.dto.ParcoursToClientDto;
import com.pamplemousse.pampleback.model.Parcours;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {QcmMapper.class, QuestionMapper.class})
public interface ParcoursMapper {
    @Mapping(target = "qcm", ignore = true)
    @Mapping(target = "stagiaire", ignore = true)
    @Mapping(target = "nbBlank", ignore = true)
    Parcours parcourFromClientDtoToParcour(ParcoursFromClientDto parcourFromClientDto);

    List<Parcours> ListParcoursFromClientDtoToListParcours(List<ParcoursFromClientDto> parcourFromClientDtoList);

    @Mapping(target = "qcm", ignore = true)
    @Mapping(target = "stagiaire", ignore = true)
    @Mapping(target = "nbBlank", ignore = true)
    void updateParcoursFromDto(ParcoursFromClientDto dto, @MappingTarget Parcours entity);

    ParcoursToClientDto parcoursToParcoursToClientDto(Parcours parcour);

    List<ParcoursToClientDto> listParcoursToListParcoursToClientDto(List<Parcours> parcours);
}
