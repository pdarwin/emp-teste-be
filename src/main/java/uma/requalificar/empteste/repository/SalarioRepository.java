package uma.requalificar.empteste.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.empteste.model.Salario;

@Repository
public interface SalarioRepository extends CrudRepository <Salario, Long>
{

}
