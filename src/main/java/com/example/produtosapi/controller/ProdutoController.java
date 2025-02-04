package com.example.produtosapi.controller;

import com.example.produtosapi.model.Produto;
import com.example.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/salvar")
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Salvando produto: " + produto);

        var id = UUID.randomUUID();
        produto.setId(id.toString());
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPoId(@PathVariable String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable String id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam(required = false) String nome) {
        return produtoRepository.findByNome(nome);
    }
}