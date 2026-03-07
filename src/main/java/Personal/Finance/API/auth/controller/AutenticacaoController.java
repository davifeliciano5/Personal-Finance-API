package Personal.Finance.API.auth.controller;


import Personal.Finance.API.auth.dto.AutenticacaoDTO;
import Personal.Finance.API.auth.dto.LoginResponse;
import Personal.Finance.API.auth.dto.RegistroDTO;
import Personal.Finance.API.infra.security.TokenService;
import Personal.Finance.API.usuarios.entity.Usuarios;
import Personal.Finance.API.usuarios.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticacaoDTO data){
        System.out.printf(data.email());
        System.out.printf(data.password());
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(),data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuarios) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegistroDTO data){
        if(this.userRepository.findByEmail(data.email())  != null) return ResponseEntity.badRequest().build();

        String encriptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuarios newUser = new Usuarios(data.email(), data.nome(), encriptedPassword,data.usuarioRole());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
