package org.example.services;

import ProductDatabase.ProductDB;
import org.example.officeEntity.Product;

//import java.util.ArrayList;
//import java.util.List;

public class ProductService {

//    List<Product> products = new ArrayList<>();

    ProductDB db = new ProductDB();

    public void addProduct(Product p){
//        products.add(p);
        db.addProduct(p);

    }

/*    public List<Product> veiwAll(){
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
    }*/

    public void veiwAll(){
        db.showProduct();
    }


    public void SearchByPlace(String place){
        db.SBP(place);
    }

    public void searchProductOutOfWarranty(int year) {
        db.SPOW(year);
    }

    public void searchByName(String text) {
        db.SBN(text);
    }
}
