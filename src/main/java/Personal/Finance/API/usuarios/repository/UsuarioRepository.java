package Personal.Finance.API.usuarios.repository;

import Personal.Finance.API.usuarios.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    UserDetails findByEmail(String email);
    Usuarios findByNome(String email);
   Optional<Usuarios> findById(Long id);
}
