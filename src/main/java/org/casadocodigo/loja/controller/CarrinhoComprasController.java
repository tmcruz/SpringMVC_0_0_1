package org.casadocodigo.loja.controller;

import org.casadocodigo.loja.dao.ProdutoDAO;
import org.casadocodigo.loja.models.CarrinhoCompras;
import org.casadocodigo.loja.models.CarrinhoItem;
import org.casadocodigo.loja.models.Produto;
import org.casadocodigo.loja.models.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/carrinho")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

	@Autowired
	private ProdutoDAO dao;
	
	@Autowired
    private CarrinhoCompras carrinho;
	
	@RequestMapping("/add")
	public ModelAndView add(Integer produtoId, TipoPreco tipo){
	    ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
	    CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
	    carrinho.add(carrinhoItem);
	    return modelAndView;
	}
	
	public CarrinhoItem criaItem(Integer id, TipoPreco tipo){
		
		Produto produto = dao.find(id);
		
		return new CarrinhoItem(tipo, produto);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView itens(){
	    return new ModelAndView("/carrinho/itens");
	}

	@RequestMapping("/remover")
	public ModelAndView remover(Integer produtoId, TipoPreco tipoPreco){
	    carrinho.remover(produtoId, tipoPreco);
	    return new ModelAndView("redirect:/carrinho");
	}

	
}
