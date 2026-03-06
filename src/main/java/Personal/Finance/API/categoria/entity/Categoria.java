package Personal.Finance.API.categoria.entity;


import Personal.Finance.API.usuarios.entity.Usuarios;
import jakarta.persistence.*;

@Entity
@Table
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuarios getCategoria_usuario() {
        return categoria_usuario;
    }

    public void setCategoria_usuario(Usuarios categoria_usuario) {
        this.categoria_usuario = categoria_usuario;
    }

    private String nome;

    @ManyToOne
    @JoinColumn
    private Usuarios categoria_usuario;


}
