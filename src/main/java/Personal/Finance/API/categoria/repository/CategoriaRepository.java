package Personal.Finance.API.categoria.repository;

import Personal.Finance.API.categoria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

//    List<Categoria> findByCategoria_usuario(Long idUsuario);

}
