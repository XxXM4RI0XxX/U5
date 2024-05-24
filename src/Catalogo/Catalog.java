package Catalogo;

import Catalogo.CustomExceptions.NegativeInputDetected;
import Catalogo.CustomExceptions.ProductNotFound;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Catalog {

    protected static ArrayList<Product> products = new ArrayList<>();

    public static Product findById(int id) throws ProductNotFound {
        try{
            return products.get(id-1);
        }catch (IndexOutOfBoundsException | InputMismatchException e){
            if(id>=0)
            throw new ProductNotFound(">>>ID "+id+" no encontrado");
            else throw new NegativeInputDetected();
        }
    }

    public static Product findByName(String name) throws ProductNotFound {

        Product findProduct=null;

        for (Product product : products){
            if(product.getName().equals(name))
                findProduct=product;
        }

        if(findProduct!=null)
            return findProduct;
        else throw new ProductNotFound(">>>Nombre "+name+" no encontrado");
    }

    public static Product[] searchByDescription(String description) throws ProductNotFound {

        int pNumber=0;

        for(Product product : products){
            if(product.getDescription().contains(description))
                pNumber++;
        }

        Product[] descProducts = new Product[pNumber];
        int i=0;
        for(Product product : products){

            if(product.getDescription().contains(description)) {
                descProducts[i] = product;
                i++;
            }
        }

        if(descProducts.length==0)
            throw new ProductNotFound(">>> Descripción "+description+" no encontrada");
        else return descProducts;
    }

    public static void showAllProducts(){
        for(Product product: products){
            product.printProduct();
        }
    }

    public static void addProduct(Product product){
        products.add(product);
    }
    
    public static void removeProduct(int id) throws ProductNotFound {
        try {
            Product product = products.get(id);
            products.remove(product);
        }catch (IndexOutOfBoundsException | InputMismatchException _){
            if(id>=0)
            throw new ProductNotFound(">>> ID +"+id+" no encontrado");
            else throw new NegativeInputDetected();
        }
    }

    //GETTER

    public static int getProductsSize() {
        return products.size();
    }
}
