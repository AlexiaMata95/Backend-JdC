package src.main.java.org.generation.joyaDelCaribe.repository;
import java.util.Optional;
import org.generation.ecommerce.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	Optional<Producto> finByDate(Date date);

}//interface ProductoRepository
