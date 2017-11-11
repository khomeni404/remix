package com.ibbl.house;

import com.ibbl.admin.model.Supplier;
import com.ibbl.common.service.GenericController;
import com.ibbl.house.model.*;
import com.ibbl.security.service.SessionUtil;
import com.ibbl.util.ActionUtil;
import com.ibbl.util.Constants;
import org.apache.commons.collections.CollectionUtils;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Copyright &copy; 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Khomeni
 * Date: 21/08/2017 10:47 AM
 * Last modification by: Khomeni: Khomeni
 * Last modification on 21/08/2017: 21/08/2017 10:47 AM
 * Current revision: 1.0.0: 1.1 $
 * <p>
 * Revision History:
 * ------------------
 */

@Controller
@RequestMapping("/house/")
public class OrderController extends GenericController {
    @RequestMapping(value = "/test.ibbl")
    public ModelAndView test(Model model) {
        model.addAllAttributes(ActionUtil.getModelMap("Sample Create"));
        MModel sampleMaster = new MModel();
        sampleMaster.setModelNo("");
        sampleMaster.setModelName("HDS-56-8");
        sampleMaster.setOperator(SessionUtil.getSessionUser());
        commonService.save(sampleMaster);


        SampleA first = new SampleA();
        first.setmModel(sampleMaster);
        commonService.save(first);

        SampleB b = new SampleB();
        b.setmModel(sampleMaster);
        commonService.save(b);

        SamplePP ss = new SamplePP();
        ss.setmModel(sampleMaster);
        commonService.save(ss);


        model.addAttribute("message", "Sample Saved Successfully");
        return new ModelAndView("/home/dashboard");
    }

    @RequestMapping(value = "/addModel.ibbl")
    public ModelAndView addModel(Model model) {
        model.addAllAttributes(ActionUtil.getModelMap("Model Add"));
        if (!model.containsAttribute(Constants.MASTER_MODEL)) {
            MModel sampleMaster = new MModel();
            sampleMaster.setStatus(1);
            sampleMaster.setModelName("HDS-56-8");
            sampleMaster.setOperator(SessionUtil.getSessionUser());
            model.addAttribute(Constants.MASTER_MODEL, sampleMaster);
        }
        Map<String, String> supplierMap = commonService.findAll(Supplier.class, Arrays.asList("id", "name")).stream().collect(
                Collectors.toMap(sm -> sm.getId().toString(), Supplier::info)
        );
        model.addAttribute("supplierMap", supplierMap);
        return new ModelAndView("house/add_master_model");
    }

    @RequestMapping(value = "/saveModel.ibbl", method = RequestMethod.POST)
    public ModelAndView saveModel(@ModelAttribute @Valid MModel MModel,
                                   BindingResult result, RedirectAttributes attributes) throws IOException {
        List<MModel> duplicateModels = commonService.findAll(MModel.class, "modelName", MModel.getModelName());
        if (!CollectionUtils.isEmpty(duplicateModels)) {
            result.rejectValue("modelName", "", "This name already Exists.");
        }
        MModel.validate(result);
        if (result.hasErrors()) {
            addError(MModel, result, attributes);
            return new ModelAndView("redirect:/house/addModel.ibbl");
        }
        commonService.save(MModel);

        return new ModelAndView("redirect:/house/viewModel.ibbl?message=Successfully Saved&id=" + MModel.getId());
    }

    @RequestMapping(value = "/modelList.ibbl")
    public ModelAndView modelList(@RequestParam(required = false) String message) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("Model List");
        modelMap.put("message", message);
        modelMap.put("list", commonService.findAll(MModel.class));
        return new ModelAndView("house/list_of_model", modelMap);
    }


    @RequestMapping(value = "/viewModel.ibbl")
    public ModelAndView viewModel(@RequestParam Long id,
                                   @RequestParam(required = false) String message) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("View Model");
        if (!GenericValidator.isBlankOrNull(message))
            modelMap.put("message", message);
        MModel mModel = commonService.get(MModel.class, id);
        modelMap.put("mModel", mModel);
        modelMap.put("orderList", commonService.findAll(POrder.class, "mModel", mModel));

        return new ModelAndView("house/view_master_model", modelMap);
    }


    @RequestMapping(value = "/editModel.ibbl")
    public ModelAndView editModel(@RequestParam Long id, Model model) {
        model.addAllAttributes(ActionUtil.getModelMap("Edit Model Master"));
        if (!model.containsAttribute(Constants.MASTER_MODEL)) {
            MModel sampleMaster = commonService.get(MModel.class, id);
            sampleMaster.setOperator(SessionUtil.getSessionUser());
            model.addAttribute(Constants.MASTER_MODEL, sampleMaster);
        }
        Map<String, String> supplierMap = commonService.findAll(Supplier.class, Arrays.asList("id", "name")).stream().collect(
                Collectors.toMap(sm -> sm.getId().toString(), Supplier::info)
        );
        model.addAttribute("supplierMap", supplierMap);
        return new ModelAndView("house/edit_master_model");
    }


    @RequestMapping(value = "/updateModel.ibbl", method = RequestMethod.POST)
    public ModelAndView updateModel(@ModelAttribute("sample") @Valid MModel MModel,
                                     BindingResult result, RedirectAttributes attributes) throws IOException {

        MModel.setOperator(SessionUtil.getSessionUser());
        MModel.validate(result);
        if (result.hasErrors()) {
            addError(MModel, result, attributes);
            return new ModelAndView("redirect:/sample/editModel.ibbl?id=" + MModel.getId());
        }
        commonService.update(MModel);

        return new ModelAndView("redirect:/sample/viewModel.ibbl?message=Successfully Updated&id=" + MModel.getId());
    }

    @RequestMapping(value = "/addOrder.ibbl")
    public ModelAndView addOrder(@RequestParam(required = false) Long modelId, Model model) {
        model.addAllAttributes(ActionUtil.getModelMap("Order Add"));
        if (!model.containsAttribute(Constants.P_ORDER)) {
            POrder po = new POrder();
            po.setRecordDate(new Date());
            po.setOperator(SessionUtil.getSessionUser());
            if (modelId != null) {
                MModel sm = commonService.get(MModel.class, modelId);
                po.setmModel(sm);
            }
            model.addAttribute(Constants.P_ORDER, po);
        }

        //if (modelId == null) {
            Map<String, String> modelMap = commonService.findAll(MModel.class, Arrays.asList("id", "modelNo", "modelName")).stream().collect(
                    Collectors.toMap(sm -> sm.getId().toString(), MModel::info)
            );
            model.addAttribute("modelMap", modelMap);
        //}

        return new ModelAndView("/house/add_purchase_order");
    }

    @RequestMapping(value = "/saveOrder.ibbl", method = RequestMethod.POST)
    public ModelAndView saveOrder(@ModelAttribute("POrder") @Valid POrder po,
                                  BindingResult result, RedirectAttributes attributes) throws IOException {
         po.validate(result);
        if (result.hasErrors()) {
            addError(po, result, attributes);
            return new ModelAndView("redirect:/house/addOrder.ibbl?modelId=" + (po.getmModel().getId() == null ? "" : po.getmModel().getId()));
        }
        commonService.save(po);

        return new ModelAndView("redirect:/house/viewModel.ibbl?message=PO Successfully Saved&id=" + po.getmModel().getId());
    }

    @RequestMapping(value = "/orderList.ibbl")
    public ModelAndView orderList(@RequestParam(required = false) String message) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("Order List");
        modelMap.put("message", message);
        modelMap.put("list", commonService.findAll(POrder.class));
        return new ModelAndView("/house/sample_list", modelMap);
    }

    @RequestMapping(value = "/viewPOrder.ibbl")
    public ModelAndView viewPOrder(@RequestParam Long id,
                                   @RequestParam(required = false) String message) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("View Model");
        if (!GenericValidator.isBlankOrNull(message))
            modelMap.put("message", message);
        POrder po = commonService.get(POrder.class, id);
        modelMap.put("sample", po);
        return new ModelAndView("/house/view_purchase_order", modelMap);
    }


    @RequestMapping(value = "/editPOrder.ibbl")
    public ModelAndView editPOrder(@RequestParam Long id, Model model) {
        model.addAllAttributes(ActionUtil.getModelMap("Edit Model Review List"));
        if (!model.containsAttribute(Constants.INCIDENT)) {
            POrder po = commonService.get(POrder.class, id);
            model.addAttribute(Constants.INCIDENT, po);
        }

        return new ModelAndView("sample/sample_edit");
    }


    @RequestMapping(value = "/updatePOrder.ibbl", method = RequestMethod.POST)
    public ModelAndView updatePOrder(@ModelAttribute("POrder") @Valid POrder po,
                                     BindingResult result, RedirectAttributes attributes) throws IOException {

        po.setOperator(SessionUtil.getSessionUser());
        po.validate(result);
        if (result.hasErrors()) {
            addError(po, result, attributes);
            return new ModelAndView("redirect:/sample/editModel.ibbl?id=" + po.getId());
        }
        commonService.update(po);

        return new ModelAndView("redirect:/sample/viewModel.ibbl?message=Successfully Updated&id=" + po.getId());
    }
}
