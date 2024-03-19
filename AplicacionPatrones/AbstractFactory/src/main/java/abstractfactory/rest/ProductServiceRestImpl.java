/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractfactory.rest;

import abstractfactory.service.IProductsService;

/**
 *
 * @author daniel
 */
public class ProductServiceRestImpl implements IProductsService {
    private static final String[] PRODUCTS = new String[]{"Teclado","Mouse", "Monitor"};

    @Override
    public String[] getProducts() {
        System.out.println("RestFul");
        return PRODUCTS; 
    }
    
}
