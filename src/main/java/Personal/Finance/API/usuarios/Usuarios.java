package Personal.Finance.API.usuarios;

import Personal.Finance.API.categoria.Categoria;
import Personal.Finance.API.transacao.Transacao;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nome;

    private String email;

    private String password;


    @OneToMany(mappedBy = "categoria_usuario")
    private List<Categoria> categoria;

    @OneToMany(mappedBy = "usuario")
    private List<Transacao> transacao;

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
