package wszib.project.shop.service;

import wszib.project.shop.creator.ProductCreator;
import wszib.project.shop.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTests {

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Test
    public void checkIfShoppingCartServiceIsNotNull() {
        assertThat(shoppingCartService).isNotNull();
    }

    @Test
    public void addProductToCartTests(){
        Map<Product, Integer> cart = new LinkedHashMap<>();
        Product product = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        cart.put(product, 1);

        assertThat(shoppingCartService.productsInCart()).containsKey(product);
    }

    @Test
    public void addTwoTheSameProductsToCartTests(){
        Map<Product, Integer> cart = new LinkedHashMap<>();
        Product product = ProductCreator.createTestProduct();
        Product product2 = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        product.setName("Great Phone");
        product2.setName("Bad Phone");

        cart.put(product, 1);
        cart.put(product2, 1);

        assertThat(shoppingCartService.productsInCart()).containsKey(product);
        assertThat(shoppingCartService.productsInCart()).containsKey(product2);
    }

    @Test
    public void removeProductFromCartTests(){
        Map<Product, Integer> cart = new LinkedHashMap<>();
        Product product = ProductCreator.createTestProduct();

        when(shoppingCartService.productsInCart()).thenReturn(cart);

        cart.put(product, 1);
        assertThat(shoppingCartService.productsInCart()).containsKey(product);

        cart.remove(product);
        assertThat(shoppingCartService.productsInCart()).doesNotContainKey(product);
    }
}
