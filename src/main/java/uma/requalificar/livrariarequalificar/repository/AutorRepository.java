package uma.requalificar.livrariarequalificar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.livrariarequalificar.model.Autor;

@Repository
public interface AutorRepository extends CrudRepository <Autor, Long>
{

}
