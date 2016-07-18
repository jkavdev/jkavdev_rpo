package br.com.jkavdev.springmvc.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jkavdev.springmvc.daos.ProductDAO;
import br.com.jkavdev.springmvc.model.Product;

@Controller
@Transactional
public class ProductsController {

	private static final Logger logger = Logger.getLogger(ProductsController.class);

	@Autowired
	private ProductDAO productDao;

	@RequestMapping("/produtos")
	public String save(Product product) {

		logger.info("Cadastrando produto" + product);

		productDao.save(product);

		return "products/ok";
	}

	@RequestMapping("/produtos/form")
	public String form() {

		return "products/form";
	}

}
