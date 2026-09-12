package com.desafiopanvel.questao_1.services;

import com.desafiopanvel.questao_1.entities.Produto;
import com.desafiopanvel.questao_1.exceptions.ProdutoNaoEncontradoException;
import com.desafiopanvel.questao_1.repository.ListaComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaComprasService {

    @Autowired
    private ListaComprasRepository listaComprasRepository;

    public List<Produto> getProdutos(){
        return this.listaComprasRepository.findAll();
    }

    public Produto getProdutoPorNome(String nome){
        Optional<Produto> produto = this.listaComprasRepository.findByNomeIgnoreCase(nome);

        if(produto.isEmpty())
            throw new ProdutoNaoEncontradoException("Produto " + nome + " não encontrado");

        return produto.get();
    }

    public Integer getContagemProdutos(){
        return this.listaComprasRepository.getContagemProdutos();
    }

    public Produto adicionarProduto(Produto produto){
        produto.setComprado(false);
        return this.listaComprasRepository.save(produto);
    }

    public Produto editarEstadoProduto(String nome){
        Produto produto = this.getProdutoPorNome(nome);

        produto.setComprado(true);

        return this.listaComprasRepository.save(produto);
    }

    public String removerProduto(String nome){
        Produto produtoEncontrado = this.getProdutoPorNome(nome);

        this.listaComprasRepository.deleteById(produtoEncontrado.getId());

        return "Produto " + nome + " deletado com sucesso!";
    }

}
