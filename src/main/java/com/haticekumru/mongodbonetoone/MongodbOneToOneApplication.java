package com.haticekumru.mongodbonetoone;

import com.haticekumru.mongodbonetoone.entity.Company;
import com.haticekumru.mongodbonetoone.entity.Contact;
import com.haticekumru.mongodbonetoone.entity.Product;
import com.haticekumru.mongodbonetoone.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MongodbOneToOneApplication implements CommandLineRunner {

    @Autowired
    CompanyRepository companyRepository;


    public void run(String... args)  {

        //clear repository
        System.out.println("==========Delete all company entities==========");
        companyRepository.deleteAll();


        companyRepository.saveAll(Arrays.asList(

                new Company(1, "Apple", Arrays.asList(new Product("A-123", "Iphone 7", "Price: 649.00 USD & FREE shipping"),
                        new Product("A-456", "IPadPro", "Price: 417.67 USD & FREE shipping")),

                        // contact
                        new Contact("Cupertino, CA 95014", "1-408-996-1010")),


                new Company(2, "Samsung",

                        // list of products
                        Arrays.asList(new Product("S-012", "GalaxyJ7", "Price: 219.00 USD & FREE shipping"),
                                new Product("S-456", "GalaxyTabA", "Price: 299.99 USD & FREE shipping")),

                        // contact
                        new Contact("Seocho District, Seoul, South Korea", "+82-2-2053-3000"))

        ));


        List<Company> companies = null;
        
        // fetch all documents
        System.out.println("==========Fetch aLL companies:==========");
        companies = companyRepository.findAll();
        companies.forEach(System.out::println);

        // find Company by name
        System.out.println("==========Find a company by name:==========");
        companies = companyRepository.findByName("Samsung");
        companies.forEach(System.out::println);

        // find Company by address
        System.out.println("==========Find a company by address:==========");
        companies = companyRepository.findByAddress("Cupertino, CA 95014");
        companies.forEach(System.out::println);

        companyRepository.delete(companies.get(0));
    }

    public static void main(String[] args) {
        SpringApplication.run(MongodbOneToOneApplication.class, args);
    }

}
