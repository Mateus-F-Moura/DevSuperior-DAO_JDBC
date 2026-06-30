package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void main() {

        try (Scanner sc = new Scanner(System.in)){
            SellerDao sellerDao = DaoFactory.createSellerDao();

            System.out.println("=== TEST 1: Seller findById ===");
            Seller seller = sellerDao.findById(3);
            System.out.println(seller);

            System.out.println();
            System.out.println("=== TEST 2: Seller findByDepartment ===");
            Department department = new Department(2, null);
            List<Seller> list = sellerDao.findByDepartment(department);
            list.forEach(System.out::println);

            System.out.println();
            System.out.println("=== TEST 3: Seller findAll ===");
            List<Seller> listAll = sellerDao.findAll();
            listAll.forEach(System.out::println);

            System.out.println();
            System.out.println("=== TEST 4: Seller insert ===");
            Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
            sellerDao.insert(newSeller);
            System.out.println("Inserted! New id = " + newSeller.getId());

            System.out.println();
            System.out.println("=== TEST 5: Seller update ===");
            seller = sellerDao.findById(1);
            seller.setName("Martha Wayne");
            sellerDao.update(seller);
            System.out.println("Update completed!");

            System.out.println();
            System.out.println("=== TEST 6: Seller delete ===");
            System.out.print("Enter id to delete: ");
            sellerDao.deleteById(sc.nextInt());
            System.out.println("Delete completed!");

            DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

            System.out.println();
            System.out.println("=== TEST 7: Department findById ===");
            Department dep = departmentDao.findById(1);
            System.out.println(dep);

            System.out.println();
            System.out.println("=== TEST 8: Department findAll ===");
            List<Department> depList = departmentDao.findAll();
            depList.forEach(System.out::println);

            System.out.println();
            System.out.println("=== TEST 9: Department insert ===");
            Department newDepartment = new Department(null, "Music");
            departmentDao.insert(newDepartment);
            System.out.println("Inserted! New id = " + newDepartment.getId());

            System.out.println();
            System.out.println("=== TEST 10: Department update ===");
            dep = departmentDao.findById(1);
            dep.setName("Food");
            departmentDao.update(dep);
            System.out.println("Update completed!");

            System.out.println();
            System.out.println("=== TEST 11: Department delete ===");
            System.out.print("Enter id to delete: ");
            departmentDao.deleteById(sc.nextInt());
            System.out.println("Delete completed!");
        }
    }
}
