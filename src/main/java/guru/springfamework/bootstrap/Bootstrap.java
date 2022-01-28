package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;
    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadVendors() {
        Vendor vendor1 = new Vendor();
        vendor1.setName("Big Fruits LLC");

        Vendor vendor2 = new Vendor();
        vendor2.setName("No Nuts Limited");

        Vendor vendor3 = new Vendor();
        vendor3.setName("Veggies Are Bad Corp");

        Vendor vendor4 = new Vendor();
        vendor4.setName("U Want Some? LLC");

        vendorRepository.save(vendor1);
        vendorRepository.save(vendor2);
        vendorRepository.save(vendor3);
        vendorRepository.save(vendor4);

        System.out.println("Vendors Loaded: " + vendorRepository.count());
    }

    private void loadCategories() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Categories Loaded: " + categoryRepository.count());
    }

    private void loadCustomers(){
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setFirstName("Ihav");
        customer1.setLastName("Kanser");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setFirstName("Hanna");
        customer2.setLastName("Derps");

        Customer customer3 = new Customer();
        customer3.setId(3L);
        customer3.setFirstName("Illi");
        customer3.setLastName("McVert");

        Customer customer4 = new Customer();
        customer4.setId(4L);
        customer4.setFirstName("Trilda");
        customer4.setLastName("Hunder");

        Customer customer5 = new Customer();
        customer5.setId(4L);
        customer5.setFirstName("Limp");
        customer5.setLastName("Noleg");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);

        System.out.println("Customers Loaded: " + customerRepository.count());
    }
}
