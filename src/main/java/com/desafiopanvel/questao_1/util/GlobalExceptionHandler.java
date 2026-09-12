package com.desafiopanvel.questao_1.util;

import com.desafiopanvel.questao_1.entities.dto.ErroRespostaDto;
import com.desafiopanvel.questao_1.exceptions.ProdutoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ErroRespostaDto> handleProdutoNaoEncontradoException(ProdutoNaoEncontradoException e){
        ErroRespostaDto erroResposta = new ErroRespostaDto(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroResposta);
    }


}
