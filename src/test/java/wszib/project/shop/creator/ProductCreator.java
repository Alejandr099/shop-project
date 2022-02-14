package wszib.project.shop.creator;

import wszib.project.shop.domain.Product;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductCreator {
    public static final String NAME = "Testowy";
    public static final String DESCRIPTION = "Testowy";
    public static final BigDecimal PRICE = BigDecimal.valueOf(1000);
    public static final String IMAGE_URL = "https://www.orange.pl/medias/sys_master/root/images/h73/h2c/9094440550430/iphone-se-czarny-tyl.png";

    public static Product createTestProduct(){
        Product testProduct = new Product();

        testProduct.setName(NAME);
        testProduct.setDescription(DESCRIPTION);
        testProduct.setPrice(PRICE);
        testProduct.setImageUrl(IMAGE_URL);

        return testProduct;
    }

    public static Set<Product> createTestProducts(){
        Set<Product> testProducts = new HashSet<>();

        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());
        testProducts.add(createTestProduct());

        return testProducts;
    }
}
