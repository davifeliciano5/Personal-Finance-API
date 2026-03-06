package Personal.Finance.API.transacao.repository;

import Personal.Finance.API.transacao.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

//    List<Transacao> findByUsuarioIdUsuario(Long idUsuario);

}