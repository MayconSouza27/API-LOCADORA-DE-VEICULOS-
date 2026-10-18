package org.example.service;

import org.example.locacao.model.LocacaoModel;
import org.example.locacao.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    public List<LocacaoModel> listarTodas() {
        return locacaoRepository.findAll();
    }

    public Optional<LocacaoModel> buscarPorId(Long id) {
        return locacaoRepository.findById(id);
    }

    public LocacaoModel salvar(LocacaoModel locacao) {
        return locacaoRepository.save(locacao);
    }

    public void deletar(Long id) {
        locacaoRepository.deleteById(id);
    }
}