package producmanage.btproductmanage.service;

import producmanage.btproductmanage.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();
    void addProduct(Product newProduct);
    Product findProductById(long id);
    void editProduct(long id, Product afterproduct);
    void removeProduct(long id);
}
