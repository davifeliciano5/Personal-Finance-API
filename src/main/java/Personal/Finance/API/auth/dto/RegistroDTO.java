package Personal.Finance.API.auth.dto;

import Personal.Finance.API.usuarios.entity.UsuarioRole;

public record RegistroDTO(String email, String password, UsuarioRole usuarioRole) {
}
