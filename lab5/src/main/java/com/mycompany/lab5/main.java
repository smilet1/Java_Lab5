/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5;

/**
 *
 * @author Максим Усков
 */

public class main {
    public static void main(String[] args) {
  
        SomeBean sb = Injector.inject(new SomeBean());
        sb.foo();
    }
}
