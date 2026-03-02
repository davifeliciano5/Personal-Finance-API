package Personal.Finance.API.transacao;


import Personal.Finance.API.categoria.Categoria;
import Personal.Finance.API.usuarios.Usuarios;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_transacao;

    private String descricao;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoTransacao tipo;

    private Date data;


    @ManyToOne
    @JoinColumn
    private Categoria categoria;

    @ManyToOne
    @JoinColumn
    private Usuarios usuario;


}
