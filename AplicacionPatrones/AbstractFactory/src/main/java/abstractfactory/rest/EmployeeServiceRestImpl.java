/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractfactory.rest;

import abstractfactory.service.IEmployeeService;

/**
 *
 * @author daniel
 */
public class EmployeeServiceRestImpl implements IEmployeeService{
    private static final String[] EMPLOYEES = new String[]{"Juan","Pedro", "Manuel"}; 

    @Override
    public String[] getEmployee() {
         System.out.println("RestFul");
         return EMPLOYEES; 
    }
}
