package com.example.dns.Controllers;

import com.example.dns.Models.*;
import javax.validation.Valid;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
@RequestMapping("/Moderator")
@Controller
public class ModeratorController {

    public String baseUrl = "http://localhost:8080/";

    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/Index")
    public String Index(Model model) {
        return "/Moderator/Index";
    }

    //ManufacturerProduct

    @GetMapping("/ManufacturerProduct/Index")
    public String ManufacturerProductIndex(Model model) {
        ManufacturerProduct[] requestGet = getRestTemplate().getForObject(baseUrl+"manufacturerProduct", ManufacturerProduct[].class);
        model.addAttribute("objects",requestGet);
        return "/Moderator/ManufacturerProduct/Index";
    }


    @GetMapping("/ManufacturerProduct/Add")
    public String ManufacturerProductAdd(@ModelAttribute("manufacturerProduct") ManufacturerProduct manufacturerProduct, Model model) {
        return "/Moderator/ManufacturerProduct/Add";
    }


    @PostMapping("/ManufacturerProduct/Add")
    public String ManufacturerProductPost(@Valid @ModelAttribute("manufacturerProduct") ManufacturerProduct manufacturerProduct, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "/Moderator/ManufacturerProduct/Add";
        }
        ManufacturerProduct requestPost = getRestTemplate().postForObject(baseUrl+"manufacturerProduct",manufacturerProduct, ManufacturerProduct.class);
        return "redirect:/Moderator/ManufacturerProduct/Index";
    }

    @GetMapping("/ManufacturerProduct/Index/{id}")
    public String ManufacturerDelete(@PathVariable(value = "id") Long id, Model model) {
        getRestTemplate().delete(baseUrl+"manufacturerProduct/"+id);
        return "redirect:/Moderator/ManufacturerProduct/Index";
    }

    @GetMapping("/ManufacturerProduct/Update/{id}")
    public String ManufacturerUpdate(@PathVariable Long id, Model model) {
        ManufacturerProduct requestGet = getRestTemplate().getForObject(baseUrl+"manufacturerProduct/"+id, ManufacturerProduct.class);
        model.addAttribute("object",requestGet);
        return "/Moderator/ManufacturerProduct/Update";
    }

    @PostMapping("/ManufacturerProduct/Update/{id}")
    public String ManufacturerUpdate(@PathVariable Long id, @Valid ManufacturerProduct manufacturerProduct, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "redirect:/Moderator/ManufacturerProduct/Update/"+id;
        }
        manufacturerProduct.setIdManufacturerProduct(id);
        getRestTemplate().put(baseUrl+"manufacturerProduct/"+id, manufacturerProduct, Void.class);
        return "redirect:/Moderator/ManufacturerProduct/Index";
    }

    //Product
    @GetMapping("/Product/Index")
    public String ProductIndex(Model model) {
        Product[] requestGet = getRestTemplate().getForObject(baseUrl+"product", Product[].class);
        model.addAttribute("objects",requestGet);
        return "/Moderator/Product/Index";
    }


    @GetMapping("/Product/Add")
    public String ProductAdd(@ModelAttribute("product") Product product, Model model) {
        ProductCategory[] requestGetCategory = getRestTemplate().getForObject(baseUrl+"productCategory", ProductCategory[].class);
        ManufacturerProduct[] requestGetManufacturer = getRestTemplate().getForObject(baseUrl+"manufacturerProduct", ManufacturerProduct[].class);
        model.addAttribute("objectsCategory",requestGetCategory);
        model.addAttribute("objectsManufacturer",requestGetManufacturer);
        return "/Moderator/Product/Add";
    }


    @PostMapping("/Product/Add")
    public String ProductPost(@Valid @ModelAttribute("product") Product product,
                              BindingResult bindingResult,
                              @RequestParam(name="idManufacturerProduct") Long idManufacturerProduct,
                              @RequestParam(name="idProductCategory") Long idProductCategory,
                              Model model) {
        if (bindingResult.hasErrors())
        {
            ProductCategory[] requestGetCategory = getRestTemplate().getForObject(baseUrl+"productCategory", ProductCategory[].class);
            ManufacturerProduct[] requestGetManufacturer = getRestTemplate().getForObject(baseUrl+"manufacturerProduct", ManufacturerProduct[].class);
            model.addAttribute("objectsCategory",requestGetCategory);
            model.addAttribute("objectsManufacturer",requestGetManufacturer);
            return "/Moderator/Product/Add";
        }
        ProductCategory requestGetProductCategoryId = getRestTemplate().getForObject(baseUrl+"productCategory/"+idProductCategory, ProductCategory.class);
        ManufacturerProduct requestGetManufacturerProductId = getRestTemplate().getForObject(baseUrl+"manufacturerProduct/"+idManufacturerProduct, ManufacturerProduct.class);
        product.setProductCategory(requestGetProductCategoryId);
        product.setManufacturerProduct(requestGetManufacturerProductId);
        Product requestPost = getRestTemplate().postForObject(baseUrl+"product",product, Product.class);
        return "redirect:/Moderator/Product/Index";
    }

    @GetMapping("/Product/Index/{id}")
    public String ProductDelete(@PathVariable(value = "id") Long id, Model model) {
        getRestTemplate().delete(baseUrl+"product/"+id);
        return "redirect:/Moderator/Product/Index";
    }

    @GetMapping("/Product/Update/{id}")
    public String ProductUpdate(@PathVariable Long id, Model model) {
        Product requestGet = getRestTemplate().getForObject(baseUrl+"product/"+id, Product.class);
        model.addAttribute("object",requestGet);
        ProductCategory[] requestGetCategory = getRestTemplate().getForObject(baseUrl+"productCategory", ProductCategory[].class);
        ManufacturerProduct[] requestGetManufacturer = getRestTemplate().getForObject(baseUrl+"manufacturerProduct", ManufacturerProduct[].class);
        model.addAttribute("objectsCategory",requestGetCategory);
        model.addAttribute("objectsManufacturer",requestGetManufacturer);
        return "/Moderator/Product/Update";
    }

    @PostMapping("/Product/Update/{id}")
    public String ProductUpdate(@PathVariable Long id,
                                @RequestParam(name="idManufacturerProduct") Long idManufacturerProduct,
                                @RequestParam(name="idProductCategory") Long idProductCategory,
                                @Valid Product product, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            ProductCategory[] requestGetCategory = getRestTemplate().getForObject(baseUrl+"productCategory", ProductCategory[].class);
            ManufacturerProduct[] requestGetManufacturer = getRestTemplate().getForObject(baseUrl+"manufacturerProduct", ManufacturerProduct[].class);
            model.addAttribute("objectsCategory",requestGetCategory);
            model.addAttribute("objectsManufacturer",requestGetManufacturer);
            return "redirect:/Moderator/Product/Update/"+id;
        }
        product.setIdProduct(id);
        ProductCategory requestGetProductCategoryId = getRestTemplate().getForObject(baseUrl+"productCategory/"+idProductCategory, ProductCategory.class);
        ManufacturerProduct requestGetManufacturerProductId = getRestTemplate().getForObject(baseUrl+"manufacturerProduct/"+idManufacturerProduct, ManufacturerProduct.class);
        product.setProductCategory(requestGetProductCategoryId);
        product.setManufacturerProduct(requestGetManufacturerProductId);
        getRestTemplate().put(baseUrl+"product/"+id, product, Void.class);
        return "redirect:/Moderator/Product/Index";
    }

    //ProductCategory
    @GetMapping("/ProductCategory/Index")
    public String ProductCategoryIndex(Model model) {
        ProductCategory[] requestGet = getRestTemplate().getForObject(baseUrl+"productCategory", ProductCategory[].class);
        model.addAttribute("objects",requestGet);
        return "/Moderator/ProductCategory/Index";
    }

    @GetMapping("/ProductCategory/Add")
    public String ProductCategoryAdd(@ModelAttribute("productCategory") ProductCategory productCategory, Model model) {
        return "/Moderator/ProductCategory/Add";
    }


    @PostMapping("/ProductCategory/Add")
    public String ProductCategoryPost(@Valid @ModelAttribute("productCategory") ProductCategory productCategory, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "/Moderator/ProductCategory/Add";
        }
        ProductCategory requestPost = getRestTemplate().postForObject(baseUrl+"productCategory",productCategory, ProductCategory.class);
        return "redirect:/Moderator/ProductCategory/Index";
    }

    @GetMapping("/ProductCategory/Index/{id}")
    public String ProductCategoryDelete(@PathVariable(value = "id") Long id, Model model) {
        getRestTemplate().delete(baseUrl+"productCategory/"+id);
        return "redirect:/Moderator/ProductCategory/Index";
    }

    @GetMapping("/ProductCategory/Update/{id}")
    public String ProductCategoryUpdate(@PathVariable Long id, Model model) {
        ProductCategory requestGet = getRestTemplate().getForObject(baseUrl+"productCategory/"+id, ProductCategory.class);
        model.addAttribute("object",requestGet);
        return "/Moderator/ProductCategory/Update";
    }

    @PostMapping("/ProductCategory/Update/{id}")
    public String ProductCategoryUpdate(@PathVariable Long id, @Valid ProductCategory productCategory,BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "redirect:/Moderator/ProductCategory/Update/"+id;
        }
        productCategory.setIdProductCategory(id);
        getRestTemplate().put(baseUrl+"productCategory/"+id, productCategory, Void.class);
        return "redirect:/Moderator/ProductCategory/Index";
    }
    //Shop
    @GetMapping("/Shop/Index")
    public String ShopIndex(Model model) {
        Shop[] requestGet = getRestTemplate().getForObject(baseUrl+"shop", Shop[].class);
        model.addAttribute("objects",requestGet);
        return "/Moderator/Shop/Index";
    }

    @GetMapping("/Shop/Add")
    public String ShopAdd(@ModelAttribute("shop") Shop shop, Model model) {
        Product[] requestGetProduct = getRestTemplate().getForObject(baseUrl+"product", Product[].class);
        Schedule[] requestGetSchedule = getRestTemplate().getForObject(baseUrl+"schedule", Schedule[].class);
        model.addAttribute("objectsProduct",requestGetProduct);
        model.addAttribute("objectsSchedule",requestGetSchedule);
        return "/Moderator/Shop/Add";
    }


    @PostMapping("/Shop/Add")
    public String ShopPost(@Valid @ModelAttribute("shop") Shop shop,
                           BindingResult bindingResult,
                           @RequestParam(name="idProduct") Long idProduct,
                           @RequestParam(name="idSchedule") Long idSchedule,
                           Model model) {
        if (bindingResult.hasErrors())
        {
            Product[] requestGetProduct = getRestTemplate().getForObject(baseUrl+"product", Product[].class);
            Schedule[] requestGetSchedule = getRestTemplate().getForObject(baseUrl+"schedule", Schedule[].class);
            model.addAttribute("objectsProduct",requestGetProduct);
            model.addAttribute("objectsSchedule",requestGetSchedule);
            return "/Moderator/Shop/Add";
        }
        Product requestGetProductId = getRestTemplate().getForObject(baseUrl+"product/"+idProduct, Product.class);
        Schedule requestGetScheduleId = getRestTemplate().getForObject(baseUrl+"schedule/"+idSchedule, Schedule.class);
        shop.setProduct(requestGetProductId);
        shop.setSchedule(requestGetScheduleId);
        Shop requestPost = getRestTemplate().postForObject(baseUrl+"shop",shop, Shop.class);
        return "redirect:/Moderator/Shop/Index";
    }

    @GetMapping("/Shop/Index/{id}")
    public String ShopDelete(@PathVariable(value = "id") Long id, Model model) {
        getRestTemplate().delete(baseUrl+"shop/"+id);
        return "redirect:/Moderator/Shop/Index";
    }

    @GetMapping("/Shop/Update/{id}")
    public String ShopUpdate(@PathVariable Long id, Model model) {
        Shop requestGet = getRestTemplate().getForObject(baseUrl+"shop/"+id, Shop.class);
        model.addAttribute("object",requestGet);
        Product[] requestGetProduct = getRestTemplate().getForObject(baseUrl+"product", Product[].class);
        Schedule[] requestGetSchedule = getRestTemplate().getForObject(baseUrl+"schedule", Schedule[].class);
        model.addAttribute("objectsProduct",requestGetProduct);
        model.addAttribute("objectsSchedule",requestGetSchedule);
        return "/Moderator/Shop/Update";
    }

    @PostMapping("/Shop/Update/{id}")
    public String ShopUpdate(@Valid Shop shop,
                             BindingResult bindingResult,
                             @PathVariable Long id,
                             @RequestParam(name="idProduct") Long idProduct,
                             @RequestParam(name="idSchedule") Long idSchedule,
                             Model model) {
        if (bindingResult.hasErrors())
        {
            Product[] requestGetProduct = getRestTemplate().getForObject(baseUrl+"product", Product[].class);
            Schedule[] requestGetSchedule = getRestTemplate().getForObject(baseUrl+"schedule", Schedule[].class);
            model.addAttribute("objectsProduct",requestGetProduct);
            model.addAttribute("objectsSchedule",requestGetSchedule);
            return "redirect:/Moderator/Shop/Update/"+id;
        }
        shop.setIdShop(id);
        Product requestGetProductId = getRestTemplate().getForObject(baseUrl+"product/"+idProduct, Product.class);
        Schedule requestGetScheduleId = getRestTemplate().getForObject(baseUrl+"schedule/"+idSchedule, Schedule.class);
        shop.setProduct(requestGetProductId);
        shop.setSchedule(requestGetScheduleId);
        getRestTemplate().put(baseUrl+"shop/"+id, shop, Void.class);
        return "redirect:/Moderator/Shop/Index";
    }
    //Schedule
    @GetMapping("/Schedule/Index")
    public String TimetableIndex(Model model) {
        Schedule[] requestGet = getRestTemplate().getForObject(baseUrl+"schedule", Schedule[].class);
        model.addAttribute("objects",requestGet);
        return "/Moderator/Schedule/Index";
    }


    @GetMapping("/Schedule/Add")
    public String TimetableAdd(@ModelAttribute("schedule") Schedule schedule, Model model) {
        return "/Moderator/Schedule/Add";
    }


    @PostMapping("/Schedule/Add")
    public String TimetablePost(@Valid @ModelAttribute("schedule") Schedule schedule, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "/Moderator/Schedule/Add";
        }
        Schedule requestPost = getRestTemplate().postForObject(baseUrl+"schedule",schedule, Schedule.class);
        return "redirect:/Moderator/Schedule/Index";
    }

    @GetMapping("/Schedule/Index/{id}")
    public String TimetableDelete(@PathVariable(value = "id") Long id, Model model) {
        getRestTemplate().delete(baseUrl+"schedule/"+id);
        return "redirect:/Moderator/Schedule/Index";
    }

    @GetMapping("/Schedule/Update/{id}")
    public String TimetableUpdate(@PathVariable Long id, Model model) {
        Schedule requestGet = getRestTemplate().getForObject(baseUrl+"schedule/"+id, Schedule.class);
        model.addAttribute("object",requestGet);
        return "/Moderator/Schedule/Update";
    }

    @PostMapping("/Schedule/Update/{id}")
    public String TimetableUpdate(@PathVariable Long id, @Valid Schedule schedule, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
        {
            return "redirect:/Moderator/Schedule/Update/"+id;
        }
        schedule.setIdTimetable(id);
        getRestTemplate().put(baseUrl+"schedule/"+id, schedule, Void.class);
        return "redirect:/Moderator/Schedule/Index";
    }
}
