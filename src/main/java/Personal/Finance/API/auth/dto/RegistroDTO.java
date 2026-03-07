package Personal.Finance.API.auth.dto;

import Personal.Finance.API.usuarios.entity.UsuarioRole;

public record RegistroDTO(String email, String nome,String password, UsuarioRole usuarioRole) {
}
