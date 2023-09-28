package com.victorvitorianowebiii.ProjetoFinal.repository;

import com.victorvitorianowebiii.ProjetoFinal.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author  Victor Vitoriano Woycickoski
 * @since 02/12/2021 17:32
 * @version 1.0
 * @category repository
 */

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
}
