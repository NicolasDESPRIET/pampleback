package com.pamplemousse.pampleback.service.impl;

import java.util.List;
import java.util.Optional;

import com.pamplemousse.pampleback.exception.ExceptionMessageConstants;
import com.pamplemousse.pampleback.exception.server.BadRequestException;
import com.pamplemousse.pampleback.exception.server.NotFoundException;
import com.pamplemousse.pampleback.model.Type;
import com.pamplemousse.pampleback.repository.TypeRepository;
import com.pamplemousse.pampleback.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    /**
     * TypeRepository.
     */
    private TypeRepository typeRepository;

    /**
     * constructor of the service.
     * @param typeRepository
     */
    @Autowired
    public TypeServiceImpl(final TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Type> getAllTypes() {
        List<Type> list = typeRepository.findAll();
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getTypeByid(final Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.TYPE_NOT_FOUND_IN_DB));
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getTypeByName(final String name) {
        Type type = typeRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.TYPE_NOT_FOUND_IN_DB));
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type createType(final Type type) {
        if (!typeRepository.findByName(type.getName()).isEmpty()) {
            throw new BadRequestException(ExceptionMessageConstants.TYPE_NAME_ALREADY_USED_IN_DB);
        }

        Type typeCreated = typeRepository.save(type);
        return typeCreated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type updateType(final Type type, final Long id) {
        Optional<Type> typeName = typeRepository.findByName(type.getName());
        if (!typeName.isEmpty() && type.getId() != typeName.get().getId()) {
            throw new BadRequestException(ExceptionMessageConstants.TYPE_NAME_ALREADY_USED_IN_DB);
        }
        type.setId(id);
        Type typeUpdated = typeRepository.save(type);
        return typeUpdated;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteType(final Long id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ExceptionMessageConstants.TYPE_NOT_FOUND_IN_DB));
        typeRepository.delete(type);
    }

}
