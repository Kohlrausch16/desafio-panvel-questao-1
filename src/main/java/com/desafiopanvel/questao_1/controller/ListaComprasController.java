package com.desafiopanvel.questao_1.controller;

import com.desafiopanvel.questao_1.entities.Produto;
import com.desafiopanvel.questao_1.entities.dto.ContagemProdutosDto;
import com.desafiopanvel.questao_1.services.ListaComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListaComprasController {

    @Autowired
    private ListaComprasService listaComprasService;

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> getProdutos(){
        return ResponseEntity.ok().body(this.listaComprasService.getProdutos());
    }

    @GetMapping("/produtos/total")
    public ResponseEntity<ContagemProdutosDto> getContagemProdutos(){
        return ResponseEntity.ok().body(new ContagemProdutosDto(this.listaComprasService.getContagemProdutos()));
    }

    @PostMapping("/produtos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto){
        return ResponseEntity.ok().body(this.listaComprasService.adicionarProduto(produto));
    }

    @PutMapping("/produtos/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Produto> editarEstadoProduto(@PathVariable String nome){
        return ResponseEntity.ok().body(this.listaComprasService.editarEstadoProduto(nome));
    }

    @DeleteMapping("/produtos/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> removerProduto(@PathVariable String nome){
        return ResponseEntity.ok().body(this.listaComprasService.removerProduto(nome));
    }

}