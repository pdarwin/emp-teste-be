package uma.requalificar.empteste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.empteste.model.Pessoa;

@Repository
public interface PessoaRepository extends CrudRepository <Pessoa, Long>
{

}
