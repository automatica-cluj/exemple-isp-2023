/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.exemple.curs.designpatterns.creational;

import java.lang.reflect.InvocationTargetException;

/**
 * @author radu.miron
 */
abstract class AbstractProduct {

    public void writeName(String name) {
        System.out.println("My name is " + name);
    }
}

class ProductA extends AbstractProduct {
}

class ProductB extends AbstractProduct {
    public void writeName(String name) {
        StringBuilder tempName = new StringBuilder().append(name);
        System.out.println("My reversed name is " + tempName.reverse());
    }
}

class ProductFactory {
    AbstractProduct createProduct(String type) {
        if (type.equals("B")) {
            return new ProductB();
        } else {
            return new ProductA();
        }
    }
}

abstract class Client {
    public void printProductDescr(String name) {
        new ProductFactory()
                .createProduct(this.getClass().getSimpleName().replace("Client", ""))
                .writeName(name);
    }

    public abstract void printType();
}

class ClientA extends Client {
    AbstractProduct prod;

    @Override
    public void printType() {
        System.out.println("type A");
    }
}

class ClientB extends Client {
    AbstractProduct prod;

    @Override
    public void printType() {
        System.out.println("type B");
    }
}


public class TestClientFactory {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String className = "automatica.ssatr.exemple.curs.designpatterns" + args[0].toUpperCase();

        Client c = (Client) Class.forName(className).getDeclaredConstructor().newInstance();
        c.printProductDescr("Product Name");
        c.printType();
    }
}
