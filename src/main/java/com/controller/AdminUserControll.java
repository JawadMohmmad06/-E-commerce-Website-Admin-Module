package com.controller;

import com.domain.*;
import com.exception.BadRequestAlertException;
import com.exception.NotFoundAlertException;
import com.service.*;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/admin/user/")
public class AdminUserControll {
    private static final Logger logger = Logger.getLogger(AdminUserControll.class);
    private UserService userService;
    private VarifyService varifyService;
    private BussGrowthService bussGrowthService;
    private CustomerRegService customerRegService;
    private ProductService productService;
    private TracOrderService tracOrderService;
    public AdminUserControll(UserService userService,VarifyService varifyService,BussGrowthService bussGrowthService, CustomerRegService customerRegService,ProductService productService,TracOrderService tracOrderService) {

        this.userService=userService;
        this.varifyService=varifyService;
        this.bussGrowthService=bussGrowthService;
        this.customerRegService=customerRegService;
        this.productService=productService;
        this.tracOrderService=tracOrderService;

    }
    @RequestMapping("/admins")
    public ResponseEntity<List<Adminuser>> admins() {
        logger.info("Getting All Admins info");

        List<Adminuser> adminusers = userService.getAll();
        return ResponseEntity.ok().body(adminusers);
    }
    @CrossOrigin
    @RequestMapping("/regis")
    public ResponseEntity<Adminuser> create(@Valid @RequestBody Adminuser adminUser) throws Exception {
        if (adminUser.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot have an id value");
        }
        logger.info("Registaring info");

        userService.insert(adminUser);
        return ResponseEntity.created(new URI("/admins/"))
                .body(adminUser);
    }
    @RequestMapping("/update")
    public ResponseEntity<Adminuser> update(@Valid @RequestBody Adminuser adminuser) throws Exception {
        if (adminuser.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        logger.info("updaing admin");
        userService.update(adminuser);
        return ResponseEntity.created(new URI("/admins/"))
                .body(adminuser);
    }
    @CrossOrigin
    @RequestMapping("/admin/{id}")
    public ResponseEntity<Adminuser> getbyid(@PathVariable Long id) {
        Optional<Adminuser> adminuser = Optional.ofNullable(userService.get(id));
        if (adminuser.isPresent()) {
            logger.info("getting admin by id");
            return ResponseEntity.ok().body(adminuser.get());


        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }
    @RequestMapping("/updatepassword")
    public ResponseEntity<Adminuser> updatepassword(@Valid @RequestBody Adminuser adminuser) throws Exception {
        if (adminuser.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }
        logger.info("updating password");
        userService.updatepassword(adminuser);
        return ResponseEntity.created(new URI("/admins/"))
                .body(adminuser);
    }
    @RequestMapping("/seller/varify")
    public ResponseEntity<List<Registration>> users() {
        List<Registration> registrations = varifyService.getAll();

        logger.info("getting seller infos");
        return ResponseEntity.ok().body(registrations);
    }

    @RequestMapping("/seller/varify/update")
    public ResponseEntity<Registration> updatevarify(@Valid @RequestBody Registration registrations) throws Exception {
        if (registrations.getId() == null) {
            throw new BadRequestAlertException("Invalid id");
        }

        varifyService.update(registrations);
        return ResponseEntity.created(new URI("/seller/varify/"))
                .body(registrations);
    }
    @RequestMapping("/seller/varify/{id}")
    public ResponseEntity<Registration> getbyidvarify(@PathVariable Long id) {
        Optional<Registration> registration = Optional.ofNullable(varifyService.get(id));
        if (registration.isPresent()) {
            logger.info("verifying seller");
            return ResponseEntity.ok().body(registration.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }


    @RequestMapping("/admin/forgot/{email}")
    public ResponseEntity<Adminuser> getbyidvarify(@PathVariable String email) {
        Optional<Adminuser> adminuser = Optional.ofNullable(userService.getbyemail(email));
        if (adminuser.isPresent()) {
            logger.info("getting admin by email");
            return ResponseEntity.ok().body(adminuser.get());
        }
        throw new NotFoundAlertException("Record not found [" + email + "]");
    }
    @RequestMapping("/bus/growth")
    public ResponseEntity<List<Busgrowth>> busgr() {
        List<Busgrowth> busgrowths = bussGrowthService.getAll();
        logger.info("getting business growth");

        return ResponseEntity.ok().body(busgrowths);
    }
    @RequestMapping("/bus/growth/create")
    public ResponseEntity<Busgrowth> createbuss(@Valid @RequestBody Busgrowth busgrowth) throws Exception {
        if (busgrowth.getId() != null) {
            throw new BadRequestAlertException("A new authority cannot have an id value");
        }
        logger.info("inserting business info");
        bussGrowthService.insert(busgrowth);
        return ResponseEntity.created(new URI("/bus/growth"))
                .body(busgrowth);
    }
    @RequestMapping("/bus/growth/delate/{year}")
    public ResponseEntity<Busgrowth> delete(@PathVariable String year) {
        bussGrowthService.delete(year);
        logger.info("dealing business info");
        return ResponseEntity.noContent().build();
    }
    @RequestMapping("/get/customer")
    public ResponseEntity<List<Customerreg>> customers() {
        List<Customerreg> customerregs = customerRegService.getAll();
        logger.info("Getting customer info");
        return ResponseEntity.ok().body(customerregs);
    }
    @RequestMapping("/delete/customer/{id}")
    public ResponseEntity<Customerreg> deletecustomer(@PathVariable Long id) {
        customerRegService.delete(id);
        logger.info("deleting customer");
        return ResponseEntity.noContent().build();
    }
    @RequestMapping("/get/product")
    public ResponseEntity<List<Product>> product() {
        List<Product> products = productService.getAll();
        logger.info("Getting product info");
        return ResponseEntity.ok().body(products);
    }
    @RequestMapping("/delete/product/{id}")
    public ResponseEntity<Customerreg> deleteproduct(@PathVariable Long id) {
        productService.delete(id);
        logger.info("dealing product info");
        return ResponseEntity.noContent().build();
    }
    @RequestMapping("/get/trackorder")
    public ResponseEntity<List<Trackorder>> orders() {
        List<Trackorder> trackorders = tracOrderService.getAll();
        logger.info("tracking order");
        return ResponseEntity.ok().body(trackorders);
    }
    @RequestMapping("/delete/order/{id}")
    public ResponseEntity<Trackorder> deleteorder(@PathVariable Long id) {
        tracOrderService.delete(id);
        logger.info("Deleting order");
        return ResponseEntity.noContent().build();
    }
}
