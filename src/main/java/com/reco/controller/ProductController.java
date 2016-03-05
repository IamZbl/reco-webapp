package com.reco.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.reco.appmodel.ProductAppObject;
import com.reco.apputility.AppObjectConverter;
import com.reco.common.ServiceLookup;
import com.reco.exception.BusinessException;
import com.reco.model.Product;
import com.reco.model.ProductAttribute;
import com.reco.service.IProduct;
import com.reco.utils.ApplicationConstatnts;
import com.reco.utils.ProductComparator;

@Controller
public class ProductController {

	@RequestMapping(value = ApplicationConstatnts.PRODUCT, method = RequestMethod.GET)
	public ModelAndView listProducts() {
		try {
			IProduct productService = (IProduct) ServiceLookup
					.getService("productService");

			List<Product> productList = productService.fetchAllProducts();
			System.out.println("Size:" + productList.size());
			List<ProductAppObject> productAppObjectList = new ArrayList<ProductAppObject>();
			if (productList != null) {

				for (Product tempProduct : productList) {
					ProductAppObject recoProductAppObject = AppObjectConverter
							.createProductAppObject(tempProduct);
					productAppObjectList.add(recoProductAppObject);
				}
			}
			return new ModelAndView(ApplicationConstatnts.PRODUCT_LISTING, "productAppObjects",
					productAppObjectList);
		} catch (BusinessException e) {

			return new ModelAndView("error", "command", e.getMessage());
		}
	}

	@RequestMapping(value = ApplicationConstatnts.NEW_PRODUCT, method = RequestMethod.GET)
	public ModelAndView newProduct() {

		return new ModelAndView("product", "command", new ProductAppObject());
	}

	@RequestMapping(value = ApplicationConstatnts.ADD_PRODUCT, method = RequestMethod.POST)
	public String addProduct(@ModelAttribute ProductAppObject productAppModel,
			ModelMap model) {
		System.out.println("addProduct started");
		
			IProduct productService = (IProduct) ServiceLookup
					.getService("productService");
			boolean isUpdate = false;
			Product product = null;
			if (productAppModel.getProductCode() != null) {

				System.out.println("<--- product code --->"
						+ productAppModel.getProductCode());
				try {
					product = productService.findByProductCode(productAppModel
							.getProductCode());
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (product != null) {
				System.out.println("<--- update --->");
				isUpdate = true;
			
			} else {
				product = new Product();
			}
			product = AppObjectConverter
					.createProduct(product, productAppModel);
			Set<ProductAttribute> productAttributes = AppObjectConverter
					.createProductAttribute(productAppModel);
			product.setProductAttributes(productAttributes);
			if (!isUpdate) {
				try {
					productService.save(product);
				} catch (BusinessException e) {
					
					e.printStackTrace();
				}
			} else {
				System.out.println("<--- started --->");
				try {
					productService.update(product);
				} catch (BusinessException e) {
					e.printStackTrace();
				}
			}

			ProductAppObject productAppObject = AppObjectConverter
					.createProductAppObject(product);
			model.addAttribute("productAppObject", productAppObject);
			// model.addAttribute("manual", product.getProductAttributes().);

			System.out.println("Done");
			return ApplicationConstatnts.PRODUCT_INFORMATION;
		
	}

	@RequestMapping(value = ApplicationConstatnts.FIND_PRODUCT, method = RequestMethod.GET)
	public ModelAndView findProduct(
			@RequestParam(value = "query") String query, ModelMap model) {
		System.out.println("findProduct started");
		try {
			IProduct productService = (IProduct) ServiceLookup
					.getService("productService");
			Product product = productService.findByProductCode(query);
			ProductAppObject productAppObject = AppObjectConverter
					.createProductAppObject(product);

			return new ModelAndView("productEdit", "command", productAppObject);
		} catch (BusinessException e) {
			model.addAttribute("error", e.getMessage());
			return new ModelAndView(ApplicationConstatnts.PRODUCT_EDIT, "command", e.getMessage());
		}

	}

	@RequestMapping(value = ApplicationConstatnts.FIND_RECO_PRODUCTS, method = RequestMethod.GET)
	public String findProductWithRecommendation(
			@RequestParam(value = "query") String query, ModelMap model) {
		System.out.println("findProductWithRecommendation started");
		try {
			IProduct productService = (IProduct) ServiceLookup
					.getService("productService");
			Product product = productService.findByProductCode(query);
			ProductAppObject productAppObject = AppObjectConverter
					.createProductAppObject(product);
			List<Product> recoProductList = productService
					.findByProductRecommendation(product.getMilage(),
							product.getYear(), product.getCategory(),
							product.getEngine());
			List<ProductAppObject> recoProductAppObjectList = new ArrayList<ProductAppObject>();
			if (recoProductList != null) {
				recoProductList.remove(product);
				for (Product tempProduct : recoProductList) {
					ProductAppObject recoProductAppObject = AppObjectConverter
							.createProductAppObject(tempProduct);
					recoProductAppObjectList.add(recoProductAppObject);
				}
			}
			ProductComparator productComparator = new ProductComparator();
			Collections.sort(recoProductAppObjectList, productComparator);
			model.addAttribute("productAppObject", productAppObject);
			model.addAttribute("recommendedProductAppObjects",
					recoProductAppObjectList);
			// model.addAttribute("manual", product.getProductAttributes().);

			System.out.println("findProductWithRecommendation Done");
			return ApplicationConstatnts.PRODUCT_RESULT;
		} catch (BusinessException e) {
			model.addAttribute("error", e.getMessage());
			return "error";
		}
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("error", e.getMessage());
		mav.setViewName("error");
		return mav;
	}

}
