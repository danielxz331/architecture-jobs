/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package abstractfactory.impl;

import abstractfactory.service.IEmployeeService;
import abstractfactory.service.IProductsService;

/**
 *
 * @author daniel
 */
public interface IServiceStackAbstractFactory {
    public IEmployeeService getEmployeeService();
    public IProductsService getProductsService(); 
}
