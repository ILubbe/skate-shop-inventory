package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {
    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Start Sample Parts.

        if (partRepository.count() == 0) { // Only put in parts if partRepository is empty.

            // Start Sample Outsourced Parts.

            OutsourcedPart theOutPart;
            List<OutsourcedPart> outsourcedParts;

            OutsourcedPart outPart1 = new OutsourcedPart();
            outPart1.setId(101);
            outPart1.setCompanyName("Skate Supplies Unlimited");
            outPart1.setName("Classic Trucks (Pair)");
            outPart1.setPrice(25.00);
            outPart1.setInvMin(10);
            outPart1.setInvMax(500);
            outPart1.setInv(101);
            outsourcedPartRepository.save(outPart1);
            theOutPart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Classic Trucks (Pair)")) theOutPart = part;
            }

            OutsourcedPart outPart2 = new OutsourcedPart();
            outPart2.setId(102);
            outPart2.setCompanyName("Skate Supplies Unlimited");
            outPart2.setName("Classic Trucks Hardware Pack");
            outPart2.setPrice(15.00);
            outPart2.setInvMin(10);
            outPart2.setInvMax(500);
            outPart2.setInv(90);
            outsourcedPartRepository.save(outPart2);
            theOutPart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Classic Trucks Hardware Pack")) theOutPart = part;
            }

            OutsourcedPart outPart3 = new OutsourcedPart();
            outPart3.setId(103);
            outPart3.setCompanyName("Skate Supplies Unlimited");
            outPart3.setName("Deck Grip Tape (18\" x 36\")");
            outPart3.setPrice(10.00);
            outPart3.setInvMin(10);
            outPart3.setInvMax(500);
            outPart3.setInv(45);
            outsourcedPartRepository.save(outPart3);
            theOutPart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Deck Grip Tape (18\" x 36\")")) theOutPart = part;
            }

            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            // Start Sample InHouse Parts

            InhousePart theInPart;
            List<InhousePart> inhouseParts;

            InhousePart inPart1 = new InhousePart();
            inPart1.setId(201);
            inPart1.setName("Handmade Classic Deck");
            inPart1.setPrice(70.00);
            inPart1.setInvMin(10);
            inPart1.setInvMax(500);
            inPart1.setInv(105);
            inhousePartRepository.save(inPart1);
            theInPart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Handmade Classic Deck")) theInPart = part;
            }

            InhousePart inPart2 = new InhousePart();
            inPart2.setId(202);
            inPart2.setName("Handmade Longboard Deck");
            inPart2.setPrice(65.00);
            inPart2.setInvMin(10);
            inPart2.setInvMax(500);
            inPart2.setInv(44);
            inhousePartRepository.save(inPart2);
            theInPart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Handmade Longboard Deck")) theInPart = part;
            }

            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                System.out.println(part.getName() + " " + part.getId());
            }
        }

        // Start Sample Products.

        if (productRepository.count() == 0) { // only put in sample products in productRepository is empty.
            Product classic = new Product("Classic Skateboard", 125.00, 284);
            Product longboard = new Product("Longboard", 110.00, 212);
            Product cruiser = new Product("Cruiser", 100.00, 89);
            Product miniCruiser = new Product("Mini-Cruiser", 70.00, 77);
            Product oldSchool = new Product("Old-School", 90.00, 55);

            productRepository.save(classic);
            productRepository.save(longboard);
            productRepository.save(cruiser);
            productRepository.save(miniCruiser);
            productRepository.save(oldSchool);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());

    }
}