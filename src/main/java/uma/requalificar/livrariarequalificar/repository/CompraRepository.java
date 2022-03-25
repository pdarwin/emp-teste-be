package uma.requalificar.livrariarequalificar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import uma.requalificar.livrariarequalificar.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository <Compra, Long>
{

}
