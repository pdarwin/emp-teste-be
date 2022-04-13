package uma.requalificar.empteste.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.empteste.model.Empresa;

@Repository
public interface EmpresaRepository extends CrudRepository <Empresa, Long>
{

	List<Empresa> findByNome(String nome);
}
