package com.pamplemousse.pampleback.service.impl;

import java.util.List;
import java.util.Optional;

import com.pamplemousse.pampleback.dto.TypeDto;
import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.exception.server.NotFoundException;
import com.pamplemousse.pampleback.mapper.TypeMapper;
import com.pamplemousse.pampleback.model.Type;
import com.pamplemousse.pampleback.repository.TypeRepository;
import com.pamplemousse.pampleback.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;

    private TypeMapper typeMapper;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository, TypeMapper typeMapper) {
        this.typeRepository = typeRepository;
        this.typeMapper = typeMapper;
    }

    /**
     * Logger Instance if need
     * 
     * import org.apache.logging.log4j.LogManager; import
     * org.apache.logging.log4j.Logger;
     * 
     * private static Logger log = LogManager.getLogger(Object.class);
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TypeDto> getAllTypes() {
        List<Type> list = typeRepository.findAll();
        return typeMapper.listTypeToListTypeDto(list);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDto getTypeByid(Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.TYPE_NOT_FOUND_IN_DB));
        return typeMapper.typeToTypeDto(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDto getTypeByName(String name) {
        Type type = typeRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.TYPE_NOT_FOUND_IN_DB));
        return typeMapper.typeToTypeDto(type);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDto addType(TypeDto typeDto) {
        if (!typeRepository.findByName(typeDto.getName()).isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.TYPE_NAME_ALREADY_USED_IN_DB);
        }

        Type typeCreated = typeRepository.save(typeMapper.typeDtoToType(typeDto));
        return typeMapper.typeToTypeDto(typeCreated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeDto updateType(TypeDto typeDto) {
        Optional<Type> typeName = typeRepository.findByName(typeDto.getName());
        if (!typeName.isEmpty() && typeDto.getId() != typeName.get().getId()) {
            throw new BadRequestException(ExceptionMessageConstants.TYPE_NAME_ALREADY_USED_IN_DB);
        }
        Type typeUpdated = typeRepository.save(typeMapper.typeDtoToType(typeDto));
        return typeMapper.typeToTypeDto(typeUpdated);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteType(Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.TYPE_NOT_FOUND_IN_DB));
        typeRepository.delete(type);
    }

}
