package org.example.services;

import org.example.officeEntity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> veiwAll(){
        return products;
    }

    public List<Product> SearchByPlace(String place){
        List<Product> productPlace = new ArrayList<>();
        for(Product p : products){
        Product tempP = new Product(p.getProductName(), p.getType(), p.getPlace(), p.getWarranty());
            if(tempP.getPlace().toLowerCase().equals(place.toLowerCase())){
                productPlace.add(tempP);
            }
        }
        return productPlace;
    }

    public List<Product> searchProductOutOfWarranty(int year){
        List<Product> productWarranty = new ArrayList<>();
        for(Product w : products){
            Product tempw = new Product(w.getProductName(), w.getType(), w.getPlace(), w.getWarranty());
            if(tempw.getWarranty()<= year){
                productWarranty.add(tempw);
            }
        }
        return productWarranty;
    }

    public List<Product> searchByName(String name){
        List<Product> searchName = new ArrayList<>();
        for(Product N : products) {
            if(N.getProductName().toLowerCase().contains(name.toLowerCase()) || N.getType().toLowerCase().contains(name.toLowerCase()) || N.getPlace().toLowerCase().contains(name.toLowerCase())){
                searchName.add(N);
            }
        }
        return searchName;
    }
}
