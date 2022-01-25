package com.pamplemousse.pampleback.mapper;

import java.util.List;

import com.pamplemousse.pampleback.dto.ParcourFromClientDto;
import com.pamplemousse.pampleback.dto.ParcourToClientDto;
import com.pamplemousse.pampleback.model.Parcour;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {QcmMapper.class, QuestionMapper.class})
public interface ParcourMapper {
    @Mapping(target = "qcm", ignore = true)
    @Mapping(target = "stagiaire", ignore = true)
    @Mapping(target = "nbBlank", ignore = true)
    Parcour parcourFromClientDtoToParcour(ParcourFromClientDto parcourFromClientDto);

    List<Parcour> ListParcourFromClientDtoToListParcours(List<ParcourFromClientDto> parcourFromClientDtoList);

    @Mapping(target = "qcm", ignore = true)
    @Mapping(target = "stagiaire", ignore = true)
    @Mapping(target = "nbBlank", ignore = true)
    void updateParcourFromDto(ParcourFromClientDto dto, @MappingTarget Parcour entity);

    ParcourToClientDto parcourToParcourToClientDto(Parcour parcour);

    List<ParcourToClientDto> listParcourToListParcourToClientDto(List<Parcour> parcour);
}
