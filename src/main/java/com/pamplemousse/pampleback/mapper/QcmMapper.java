package com.pamplemousse.pampleback.mapper;

import java.util.List;

import com.pamplemousse.pampleback.dto.QcmFromClientDto;
import com.pamplemousse.pampleback.dto.QcmParcourDto;
import com.pamplemousse.pampleback.dto.QcmToClientNoRDto;
import com.pamplemousse.pampleback.model.Qcm;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = QuestionMapper.class)
public interface QcmMapper {
    /**
     * mapper QcmFromClientDto to Qcm
     * @param dto
     * @return Qcm
     */
    Qcm qcmFromClientDtoToQcm(QcmFromClientDto dto);

    /**
     * mapper List<QcmFromClientDto> to List<Qcm>
     * @param listdto
     * @return List<Qcm>
     */
    List<Qcm> qcmFromClientDtoListToQcmList(List<QcmFromClientDto> listdto);

    /**
     * mapper Qcm to QcmToClientNoRDto
     * @param entity
     * @return QcmToClientNoRDto
     */
    QcmToClientNoRDto qcmToQcmToClientNoRDto(Qcm entity);

    /**
     * mapper List<Qcm> to List<QcmToClientNoRDto>
     * @param entity
     * @return
     */
    List<QcmToClientNoRDto> qcmListToQcmToClientNoRDtoList(List<Qcm> entity);

    /**
     * mapper function to update qcm witout delete listQuestion
     * @param dto
     * @param entity
     */
    @Mapping(target = "qcmQuestion", ignore = true)
    void updateQcmFromDto(QcmFromClientDto dto, @MappingTarget Qcm entity);

    QcmParcourDto qcmToQcmParcourDto(Qcm entity);
}
