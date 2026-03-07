package Personal.Finance.API.teste;


import Personal.Finance.API.usuarios.entity.Usuarios;
import Personal.Finance.API.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TesteService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuarios> buscaEmail(Long id){
       return usuarioRepository.findById(id);
    }
}
