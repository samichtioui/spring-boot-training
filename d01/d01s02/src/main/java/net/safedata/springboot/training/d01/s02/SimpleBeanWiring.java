package net.safedata.springboot.training.d01.s02;

import net.safedata.springboot.training.d01.s02.config.DomainConfig;
import net.safedata.springboot.training.d01.s02.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * A simple demo for the usage of a Spring {@link org.springframework.context.annotation.Bean} which has a wired
 * collaborator
 *
 * @author bogdan.solga
 */
public class SimpleBeanWiring {

    private static final boolean USE_ANNOTATIONS_CONFIG = true;

    public static void main(String[] args) {
        final ApplicationContext applicationContext = buildAppContext();

        // retrieving and using the ProductService; it will have the dependency wired (injected)
        final ProductService productService = applicationContext.getBean(ProductService.class);
        productService.displayProducts();
    }

    private static ApplicationContext buildAppContext() {
        return USE_ANNOTATIONS_CONFIG ? new AnnotationConfigApplicationContext(DomainConfig.class) :
                new ClassPathXmlApplicationContext("applicationContext.xml");
    }
}
