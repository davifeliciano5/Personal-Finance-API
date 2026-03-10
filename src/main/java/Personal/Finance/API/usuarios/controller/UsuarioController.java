package Personal.Finance.API.usuarios.controller;


import Personal.Finance.API.usuarios.entity.Usuarios;
import Personal.Finance.API.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/listar")
    public ResponseEntity listarTodosOsDados(@AuthenticationPrincipal Usuarios usuarioLogado){
        if(usuarioLogado.getId_usuario() == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(usuarioService.listarTodosOsDados(usuarioLogado.getId_usuario()));
    }
}
