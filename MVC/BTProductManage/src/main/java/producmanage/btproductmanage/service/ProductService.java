package producmanage.btproductmanage.service;

import producmanage.btproductmanage.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private static List<Product> productList = new ArrayList<>();

    static {
//        productList = new ArrayList<>();
        productList.add ( new Product (1234567891, "I VENTAGLI MIDI SHIRT DRESS", 4, 77840000) );
        productList.add ( new Product (1234567891, "BAROCCO SILK MIDI SHIRT DRESS", 2, 94520000) );
        productList.add ( new Product (1234567891, "I VENTAGLI LA GRECA SHIRT DRESS", 1, 98000000) );
        productList.add ( new Product (1234567891, "I VENTAGLI MINI DRESS", 5, 57340000) );
        productList.add ( new Product (1234567891, "MEDUSA WOOL BLEND MINI DRESS", 3, 53870000) );
        productList.add ( new Product (1234567891, "MEDUSA MINI DRESS", 2, 57340000) );
    }
    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public void addProduct(Product newProduct) {
        productList.add ( newProduct );
    }

    @Override
    public Product findProductById(long id) {
        for (Product product : productList) {
            if ( product.getId () == id ) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void editProduct(long id, Product afterProduct) {
        Product product = findProductById ( id );
        product.setName ( afterProduct.getName () );
        product.setPrice ( afterProduct.getPrice () );
        product.setQuantity ( afterProduct.getQuantity () );
    }

    @Override
    public void removeProduct(long id) {
        Product product = findProductById ( id );
        productList.remove ( product );
    }
}
