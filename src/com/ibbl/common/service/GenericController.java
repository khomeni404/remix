package com.ibbl.common.service;

import com.ibbl.incident.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Khomeni
 * Created on : 17-May-17 at 12:54 AM
 */

@Component
public class GenericController {

    @Autowired
    public CommonService commonService;

    @Autowired
    public IncidentService incidentService;

    public static void addError(Object modelAttribute, BindingResult binding, RedirectAttributes redirectAttributes) {
        String modelClassName = modelAttribute.getClass().getSimpleName();
        redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult." + modelClassName, binding);
        redirectAttributes.addFlashAttribute(modelClassName, modelAttribute);
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
