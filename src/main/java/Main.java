import com.onlinestorewepr.service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        productService.getListProduct("1");
    }
}
