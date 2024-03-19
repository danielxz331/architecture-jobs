/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractfactory.impl;

import java.util.Properties;
import abstractfactory.util.PropertiesUtil;

/**
 *
 * @author daniel
 */
public class ServiceStackAbstractFactory {

  public ServiceStackAbstractFactory() {}

     public static IServiceStackAbstractFactory createServiceFactory() {
       Properties props = PropertiesUtil.loadProperty(
           "MetaInf/AbstractFactoryConfiguration.properties");
       String factoryClass = props.getProperty("serviceProductImplClass");
       System.out.println(factoryClass);
       try {
            return (IServiceStackAbstractFactory)
                Class.forName(factoryClass).newInstance();
       } catch (Exception e) {
          e.printStackTrace();
       return null;
       }
    }
 }
