/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractfactory;

import java.util.Arrays;
import abstractfactory.impl.IServiceStackAbstractFactory;
import abstractfactory.impl.ServiceStackAbstractFactory;
import abstractfactory.service.IEmployeeService;
import abstractfactory.service.IProductsService;
/**
 *
 * @author daniel
 */
public class AbstractFactoryMain {
    public static void main(String[] args) {
    IServiceStackAbstractFactory factory =
    ServiceStackAbstractFactory.createServiceFactory();
    IEmployeeService employeeService = factory.getEmployeeService();
    IProductsService productService = factory.getProductsService();

    System.out.println("EmployeeService class > "
    + employeeService.getClass().getCanonicalName());
    System.out.println("ProductService class > "
    + productService.getClass().getCanonicalName());

    System.out.println("getEmployee > "
    + Arrays.toString(employeeService.getEmployee()));
    System.out.println("getProduct > "
    + Arrays.toString(productService.getProducts()));
    } 
}
