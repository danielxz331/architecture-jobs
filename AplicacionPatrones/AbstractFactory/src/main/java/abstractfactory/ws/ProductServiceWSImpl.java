/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractfactory.ws;

import abstractfactory.service.IProductsService;

/**
 *
 * @author daniel
 */
public class ProductServiceWSImpl implements IProductsService{

    private static final String[] PRODUCTS = new String[]{"Refresco", "Jugo", "Fruta"}; 
    
    @Override
    public String[] getProducts() {
        System.out.println("WebServices");
        return PRODUCTS; 
    }
    
}
