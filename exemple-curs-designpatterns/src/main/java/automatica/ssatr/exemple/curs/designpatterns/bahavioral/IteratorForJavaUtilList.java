/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatica.ssatr.exemple.curs.designpatterns.bahavioral;

import java.util.Arrays;
import java.util.List;

/**
 * @author Radu Miron
 */
public class IteratorForJavaUtilList {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Marry", "Egbert");
        java.util.Iterator<String> it = names.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
