package com.pamplemousse.pampleback.mapper;

import com.pamplemousse.pampleback.dto.QuestionNoResponseDto;
import com.pamplemousse.pampleback.model.Question;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    /**
     * function to map a question into questionNoresponseDto.
     * @param entity
     * @return QuestionNoResponseDto
     */
    @Mapping(target = "responsesList", ignore = true)
    QuestionNoResponseDto questionToQuestionNoResponseDto(Question entity);
}
