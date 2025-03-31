package com.exemplo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.api.model.Produto;
import com.exemplo.api.service.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        return ResponseEntity.ok(produtoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getProdutoById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(produtoService.findById(id));
    }
    
    @PostMapping
    public ResponseEntity<Produto> createProduto(@Valid @RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable("id") Long id, @Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.update(id, produto));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable("id") Long id) {
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}