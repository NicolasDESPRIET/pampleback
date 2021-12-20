package com.pamplemousse.pampleback.service;

import java.util.List;

import com.pamplemousse.pampleback.dto.TypeDto;

public interface TypeService {
     /**
     * get all Types in the db.
     * @return List<Type>.
     */
    List<TypeDto> getAllTypes();
	
    /**
     * get one Type by his id.
     * @param id the id researched.
     * @return the researched Type.
     * @throws NotFoundException.
     */
    TypeDto getTypeByid(Long id);

    /**
     * get the first Type by his name.
     * @param name the name researched.
     * @return the researched Type.
     * @throws NotFoundException.
     */
    TypeDto getTypeByName(String name);
	
    /**
     * add an Type to the db.
     * @param typeDto the nex Type.
     * @return the Type added.
     * @throws BadRequestException.
     */
    TypeDto addType(TypeDto typeDto);
	
    /**
     * update an Type with new value.
     * @param typeDto the update data for Type.
     * @return the updated Type.
     * @throws BadRequestException.
     * @throws NotFoundException.
     */
    TypeDto updateType(TypeDto typeDto);
	
    /**
     * delete the Type by his id.
     * @param id the id of the Type.
     * @throws NotFoundException.s
     */
	void deleteType(Long id);
}
