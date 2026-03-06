package Personal.Finance.API.transacao.service;

import Personal.Finance.API.transacao.Transacao;
import Personal.Finance.API.transacao.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public List<Transacao> listarTodas() {
        return repository.findAll();
    }

    public Transacao salvar(Transacao transacao) {
        return repository.save(transacao);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
