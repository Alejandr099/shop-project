package wszib.project.shop;

import wszib.project.shop.domain.Category;
import wszib.project.shop.domain.Product;
import wszib.project.shop.repository.CategoryRepository;
import wszib.project.shop.service.ProductService;
import wszib.project.shop.domain.User;
import wszib.project.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class StartupData implements CommandLineRunner {
    private final UserService userService;
    private final ProductService productService;
    private final CategoryRepository categoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(StartupData.class);

    @Autowired
    public StartupData(UserService userService, ProductService productService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        adminAccount();
        userAccount();
        category();
        exampleProducts();
    }

    private void userAccount(){
        User user = new User();

        user.setUsername("user");
        user.setPassword("user");
        user.setPasswordConfirm("user");
        user.setGender("Male");
        user.setEmail("user@example.com");

        userService.save(user);
    }

    private void adminAccount(){
        User admin = new User();

        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setPasswordConfirm("admin");
        admin.setGender("Male");
        admin.setEmail("admin@example.com");

        userService.save(admin);
    }

    private void category(){
        Category category1 = new Category();
        Category category2 = new Category();
        category1.setId(1);
        category1.setCategoryName("Phone");
        category2.setId(2);
        category2.setCategoryName("PC");

        categoryRepository.save(category1);
        categoryRepository.save(category2);
    }

    private void exampleProducts(){
        final String NAME = "IPhone SE 1 gen.";
        final String IMAGE_URL = "https://image.ceneostatic.pl/data/products/43844116/i-apple-iphone-se-16gb-gwiezdna-szarosc.jpg";
        final String DESCRIPTION = "IPhone-a SE pierwszej generacji";
        final BigDecimal PRICE = BigDecimal.valueOf(339);

        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product1.setName(NAME);
        product1.setImageUrl(IMAGE_URL);
        product1.setDescription(DESCRIPTION);
        product1.setCategory(categoryRepository.findByCategoryName("Phone"));
        product1.setPrice(PRICE);

        product2.setName(NAME);
        product2.setImageUrl(IMAGE_URL);
        product2.setDescription(DESCRIPTION);
        product2.setCategory(categoryRepository.findByCategoryName("Phone"));
        product2.setPrice(PRICE);

        product3.setName(NAME);
        product3.setImageUrl(IMAGE_URL);
        product3.setDescription(DESCRIPTION);
        product3.setCategory(categoryRepository.findByCategoryName("PC"));
        product3.setPrice(PRICE);

        product4.setName(NAME);
        product4.setImageUrl(IMAGE_URL);
        product4.setDescription(DESCRIPTION);
        product4.setCategory(categoryRepository.findByCategoryName("PC"));
        product4.setPrice(PRICE);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);
    }
}
