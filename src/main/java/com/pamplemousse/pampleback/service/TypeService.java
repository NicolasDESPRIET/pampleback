package com.pamplemousse.pampleback.service;

import java.util.List;

import com.pamplemousse.pampleback.model.Type;

public interface TypeService {
     /**
      * get all Types in the db.
      * @return List<Type>.
      */
     List<Type> getAllTypes();

     /**
      * get one Type by his id.
      * @param id the id researched.
      * @return the researched Type.
      * @throws NotFoundException.
      */
     Type getTypeByid(Long id);

     /**
      * get the first Type by his name.
      * @param name the name researched.
      * @return the researched Type.
      * @throws NotFoundException.
      */
     Type getTypeByName(String name);

     /**
      * add an Type to the db.
      * @param type the nex Type.
      * @return the Type added.
      * @throws BadRequestException.
      */
     Type createType(Type type);

     /**
      * update an Type with new value.
      * @param type the update data for Type.
      * @param id   the id of type to update.
      * @return the updated Type.
      * @throws BadRequestException.
      * @throws NotFoundException.
      */
     Type updateType(Type type, Long id);

     /**
      * delete the Type by his id.
      * @param id the id of the Type.
      * @throws NotFoundException.s
      */
     void deleteType(Long id);
}
