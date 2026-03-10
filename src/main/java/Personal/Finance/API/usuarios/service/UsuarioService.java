package Personal.Finance.API.usuarios.service;


import Personal.Finance.API.usuarios.entity.Usuarios;
import Personal.Finance.API.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService  {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuarios listarTodosOsDados(Long id){
           Optional<Usuarios> user = usuarioRepository.findById(id);
            Usuarios usuario = user.get();
            return usuario;
    }

}
