package uma.requalificar.livrariarequalificar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.livrariarequalificar.model.Livro;

@Repository
public interface LivroRepository extends CrudRepository <Livro, Long>
{

}
