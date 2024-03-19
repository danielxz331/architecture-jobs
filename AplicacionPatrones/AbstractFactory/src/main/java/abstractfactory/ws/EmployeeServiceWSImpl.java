/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractfactory.ws;

import abstractfactory.service.IEmployeeService;

/**
 *
 * @author daniel
 */
public class EmployeeServiceWSImpl implements IEmployeeService{

    private static final String[] EMPLOYEES = new String[]{"Maria", "Rebeca", "Liliana"};
    
    @Override
    public String[] getEmployee() {
        System.out.println("WebServices");
        return EMPLOYEES;
    }
    
}
