package net.braniumacademy.ex674.comparator;

import net.braniumacademy.ex674.Smartphone;

import java.util.Comparator;

// sắp xếp theo tên hãng a-z
public class SortByBrandASC implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getBrand().compareTo(o2.getBrand());
    }
}
