package Personal.Finance.API.categoria;


import Personal.Finance.API.usuarios.entity.Usuarios;
import jakarta.persistence.*;

@Entity
@Table
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria;

    private String nome;

    @ManyToOne
    @JoinColumn
    private Usuarios categoria_usuario;


}
