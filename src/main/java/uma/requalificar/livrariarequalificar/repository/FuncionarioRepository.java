package uma.requalificar.livrariarequalificar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.livrariarequalificar.model.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository <Funcionario, Long>
{

}
