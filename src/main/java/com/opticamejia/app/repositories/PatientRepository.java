// el servicio usa el repositorio para hacer las conexiones con la DB utilizando el modelo para saber que datos debe traer

package com.opticamejia.app.repositories;

import com.opticamejia.app.models.PatientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository // notación repository para indicar que va a ser de este tipo
public interface PatientRepository extends CrudRepository<PatientModel, Integer> { // interface que hereda de Crudrepository; indicando el tipo de dato "PatientModel" y el tipo de id que tiene, entero "integer"
    // buscar los usuarios que coincida con la cc o id_card
    public abstract ArrayList<PatientModel> findByCc(Integer cc);
}
