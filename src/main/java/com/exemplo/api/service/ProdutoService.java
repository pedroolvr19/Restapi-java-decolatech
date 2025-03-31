package com.exemplo.api.service;

import com.exemplo.api.exception.ResourceNotFoundException;
import com.exemplo.api.model.Produto;
import com.exemplo.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }
    
    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com id: " + id));
    }
    
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }
    
    public Produto update(Long id, Produto produtoDetails) {
        Produto produto = findById(id);
        
        produto.setNome(produtoDetails.getNome());
        produto.setDescricao(produtoDetails.getDescricao());
        produto.setPreco(produtoDetails.getPreco());
        produto.setQuantidade(produtoDetails.getQuantidade());
        
        return produtoRepository.save(produto);
    }
    
    public void delete(Long id) {
        Produto produto = findById(id);
        produtoRepository.delete(produto);
    }
}