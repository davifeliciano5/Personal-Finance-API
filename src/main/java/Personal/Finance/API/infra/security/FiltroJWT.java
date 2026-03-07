package Personal.Finance.API.infra.security;

import Personal.Finance.API.usuarios.entity.Usuarios;
import Personal.Finance.API.usuarios.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FiltroJWT extends OncePerRequestFilter {


    @Autowired
    TokenService tokenService;

    @Autowired
    UsuarioRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
        var token = this.recoverToken(request);
        if(token != null){
            var login = tokenService.validateToken(token);
            UserDetails user = userRepository.findByEmail(login);
            Usuarios testeUser = userRepository.findByNome(login);
            if(testeUser == null){
                System.out.printf("o teste está vazio");
            }
            System.out.printf(user.getUsername());
            System.out.printf(user.getPassword());
            System.out.printf(user.getAuthorities().toString());
            if (user == null) {
                System.out.println("USUÁRIO NÃO ENCONTRADO NO BANCO");
            } else {
                System.out.println("USER OK: " + user.getUsername());
            }
            var authentication = new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        System.out.println("Cheguei até aqui recover token");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ","");
    }
}
