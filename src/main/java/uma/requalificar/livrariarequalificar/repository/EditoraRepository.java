package uma.requalificar.livrariarequalificar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.livrariarequalificar.model.Editora;

@Repository
public interface EditoraRepository extends CrudRepository<Editora, Long>
{

}
