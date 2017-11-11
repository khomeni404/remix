package com.ibbl.admin;

import com.ibbl.admin.model.Supplier;
import com.ibbl.common.service.GenericController;
import com.ibbl.util.ActionUtil;
import com.ibbl.util.Constants;
import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

/**
 * Copyright &copy; 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Khomeni
 * Date: 23/08/2017 3:15 PM
 * Last modification by: Khomeni: Khomeni
 * Last modification on 23/08/2017: 23/08/2017 3:15 PM
 * Current revision: 1.0.0: 1.1 $
 * <p>
 * Revision History:
 * ------------------
 */
@Controller
@RequestMapping("/admin/")
public class AdminController extends GenericController {

    @RequestMapping(value = "/addSupplier.ibbl")
    public ModelAndView addSupplier(@RequestParam(required = false) String message,Model model) {
        model.addAllAttributes(ActionUtil.getModelMap("Supplier Add"));
        if (!model.containsAttribute(Constants.SUPPLIER)) {
            Supplier supplier = new Supplier();
            supplier.setName("Ordex Fashion Ltd.");
            model.addAttribute(Constants.SUPPLIER, supplier);
        }
        model.addAttribute("message", message);
        model.addAttribute("supplierList", commonService.findAll(Supplier.class));
        return new ModelAndView("/admin/add_supplier");
    }

    @RequestMapping(value = "/saveSupplier.ibbl", method = RequestMethod.POST)
    public ModelAndView saveSupplier(@ModelAttribute("Supplier") @Valid Supplier supplier,
                                   BindingResult result, RedirectAttributes attributes) throws IOException {
        Supplier duplicateSupplier = commonService.get(Supplier.class, "name", supplier.getName());
        if (duplicateSupplier != null) {
            result.rejectValue("name", "", "This name already Exists.");
        }
        // supplier.validate(result);
        if (result.hasErrors()) {
            addError(supplier, result, attributes);
            return new ModelAndView("redirect:/admin/addSupplier.ibbl");
        }
        commonService.save(supplier);

        Map<String, Object> modelMap = ActionUtil.getModelMap("Supplier List");
        modelMap.put("message", "Successfully Saved");
        modelMap.put("list", commonService.findAll(Supplier.class));
        return new ModelAndView("/admin/list_of_supplier", modelMap);
        //return new ModelAndView("redirect:/admin/addSupplier.ibbl?message=Successfully Saved");
    }

    @RequestMapping(value = "/supplierList.ibbl")
    public ModelAndView supplierList(@RequestParam(required = false) String message) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("Supplier List");
        modelMap.put("message", message);
        modelMap.put("list", commonService.findAll(Supplier.class));
        return new ModelAndView("/admin/list_of_supplier", modelMap);
    }


    @RequestMapping(value = "/viewSupplier.ibbl")
    public ModelAndView viewSupplier(@RequestParam Long id,
                                   @RequestParam(required = false) String message) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("View Supplier");
        if (!GenericValidator.isBlankOrNull(message))
            modelMap.put("message", message);
        Supplier supplier = commonService.get(Supplier.class, id);
        modelMap.put("supplier", supplier);
        //modelMap.put("orderList", commonService.findAll(POrder.class, "supplier", supplier));

        return new ModelAndView("/admin/view_supplier_master", modelMap);
    }


    @RequestMapping(value = "/editSupplier.ibbl")
    public ModelAndView editSupplier(@RequestParam Long id, Model model) {
        model.addAllAttributes(ActionUtil.getModelMap("Edit Supplier Review List"));
        if (!model.containsAttribute(Constants.INCIDENT)) {
            Supplier supplier = commonService.get(Supplier.class, id);
            model.addAttribute(Constants.INCIDENT, supplier);
        }

        return new ModelAndView("supplier/supplier_edit");
    }


    @RequestMapping(value = "/updateSupplier.ibbl", method = RequestMethod.POST)
    public ModelAndView updateSupplier(@ModelAttribute("supplier") @Valid Supplier supplier,
                                     BindingResult result, RedirectAttributes attributes) throws IOException {

        //supplier.setOperator(SessionUtil.getSessionUser());
        supplier.validate(result);
        if (result.hasErrors()) {
            addError(supplier, result, attributes);
            return new ModelAndView("redirect:/supplier/editSupplier.ibbl?id=" + supplier.getId());
        }
        commonService.update(supplier);

        return new ModelAndView("redirect:/supplier/viewSupplier.ibbl?message=Successfully Updated&id=" + supplier.getId());
    }
}
