package Personal.Finance.API.usuarios.repository;

import Personal.Finance.API.usuarios.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    UserDetails findByLogin(String login);
}
