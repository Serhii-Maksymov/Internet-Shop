package mate.academy.internetshop;

import java.math.BigDecimal;
import mate.academy.internetshop.lib.Injector;
import mate.academy.internetshop.model.Product;
import mate.academy.internetshop.service.ProductService;

public class ShopApp {
    private static Injector injector = Injector.getInstance("mate.academy.internetshop");

    public static void main(String[] args) {
        ProductService productService = (ProductService) injector.getInstance(ProductService.class);

        Product product1 = new Product("Potatoes", new BigDecimal(12));
        Product product2 = new Product("Cabbage", new BigDecimal(8));
        Product product3 = new Product("Chocolate", new BigDecimal(25));
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);

        System.out.println(productService.get(1L));
        System.out.println(productService.getAll());

        productService.delete(3L);
        System.out.println(productService.getAll());
        productService.update(productService.get(2L));
        Product productCar = new Product("Carrot", new BigDecimal(5));
        productService.create(productCar);
        System.out.println(productService.getAll());
        productCar.setPrice(new BigDecimal(7));
        productCar.setName("Fresh_Carrot");
        System.out.println(productService.getAll());
    }
}
