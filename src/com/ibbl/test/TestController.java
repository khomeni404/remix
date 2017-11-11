package com.ibbl.test;

import com.ibbl.common.service.GenericController;
import com.ibbl.incident.model.Incident;
import com.ibbl.incident.service.IncidentService;
import com.ibbl.util.*;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright &copy; 2002-2003 Islami Bank Bangladesh Limited
 * <p>
 * Original author: Khomeni
 * Date: 13/08/2017 11:08 AM
 * Last modification by: Khomeni: Khomeni
 * Last modification on 13/08/2017: 13/08/2017 11:08 AM
 * Current revision: 1.0.1: 1.1 $
 * <p>
 * Revision History:
 * ------------------
 */

@Controller
@RequestMapping(name = "Test Controller", value = "/test/")
//@SessionAttributes({"exampleForm"})
public class TestController extends GenericController {
    @Autowired
    public IncidentService incidentService;

    @RequestMapping(value = "/catchForm.ibbl")
    public ModelAndView catchForm(@ModelAttribute("incident") Incident incident,
                                  BindingResult errors) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("View Incident");

        //incident.validate(binding);

        if (errors.hasErrors()) {
            return new ModelAndView("/test/form_bind", modelMap);
        }

        System.out.println(incident.getDetails());

        modelMap.put("incident", incident);
        return new ModelAndView("/test/form_bind", modelMap);
    }

    @RequestMapping(value = "/loadForm.ibbl", method = RequestMethod.GET)
    public ModelAndView loadForm(@ModelAttribute Incident incident,
                                 BindingResult errors, RedirectAttributes attr, HttpSession session) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("View Incident");
        incident.setRefNo(incidentService.maxRefNo() + 1);
        incident.setDetails("This is a test details.");
        Object sessIncident = session.getAttribute("incident");
        modelMap.put("incident", sessIncident != null ? (Incident) sessIncident : incident);
        errors = (BindingResult) session.getAttribute("binding");

//        modelMap.put("incident", session.getAttribute("incident"));
        //modelMap.put("org.springframework.validation.BindingResult.incident", session.getAttribute("binding"));

        modelMap.put("typeMap", Constants.INCIDENT_TYPE_MAP);
        return new ModelAndView("/test/form_bind_3", modelMap);
    }


    @RequestMapping(value = "/beanValidation.ibbl")
    public ModelAndView beanValidation(@ModelAttribute @Valid Incident incident,
                                       BindingResult binding, RedirectAttributes attr, HttpSession session) {

//        if (!binding.hasErrors())
        incident.validate(binding);


        if (binding.hasErrors()) {
            //return super.processFormSubmission(request, reponse, encounter, binding);
            //return new ModelAndView("/test/form_bind", modelMap);

//            attr.addFlashAttribute("org.springframework.validation.BindingResult.incident", binding);
//            attr.addFlashAttribute("incident", incident);
            session.setAttribute("incident", incident);
            session.setAttribute("binding", binding);
            return new ModelAndView("redirect:/test/loadForm.ibbl");
        }

        Map<String, Object> modelMap = ActionUtil.getModelMap("View Incident");
        System.out.println(incident.getDetails());

        modelMap.put("incident", incident);
        return new ModelAndView("/test/form_bind", modelMap);
    }

    @RequestMapping(value = "/processMyForm", method = RequestMethod.POST)
    public ModelAndView processMyForm(
            @Valid @ModelAttribute("incident") final Incident incident,
            final BindingResult bindingResult,
            final RedirectAttributes redirectAttributes, HttpSession session) {

        if (bindingResult.hasErrors()) {
            session.setAttribute("incident", incident);
            session.setAttribute("binding", bindingResult);
            // redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.incident", bindingResult);
            // redirectAttributes.addAttribute("incident", incident);
            return new ModelAndView("redirect:/test/loadForm.ibbl");
        } else {
            // Success
            return new ModelAndView("/test/form_bind_3");
        }
    }

   /* public ModelAndView createMav(BindingResult result) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName(getPrimaryControllerView());
        mav.addAllObjects(result.getmModel());
        return mav;
    }*/

    @RequestMapping(value = "/createIncident.ibbl")
    public ModelAndView createIncident(@RequestParam(required = false) String message) {
        Map<String, Object> modelMap = ActionUtil.getModelMap("Incident Create");
        if (!GenericValidator.isBlankOrNull(message))
            modelMap.put("message", message);
        Incident incident = new Incident();
        incident.setRefNo(incidentService.maxRefNo() + 1);
        modelMap.put("reportingDate", new Date());
        modelMap.put("incident", incident);
        return new ModelAndView("/test/form_bind_incident", modelMap);
    }

    @RequestMapping(value = "/saveIncident.ibbl", method = RequestMethod.POST)
    public ModelAndView saveIncident(@RequestParam(required = false) String message,
                                     @DateTimeFormat(pattern = "dd/MM/yyyy")
                                     @ModelAttribute("reportingDate") Date reportingDate,
                                     @ModelAttribute("incident") Incident incident

                                     /*@DateTimeFormat(pattern = "dd/MM/yyyy")
                                     @RequestParam(required = false) Date incidentDate*/) throws IOException {
        Map<String, Object> modelMap = new HashMap<>();

        //incident.setIncidentDate(incidentDate);
        incident.setReportingDate(new Date());

        //commonService.save(incident);

        modelMap.put("PageTitle", "Incident Create");
        modelMap.put("TU", new Utility());
        modelMap.put("message", message);
        modelMap.put("incident", incident);
        return new ModelAndView("redirect:/incident/incidentList.ibbl", modelMap);
    }


    /*@ModelAttribute("exampleForm")
    public Incident getExampleForm() {
        return new Incident();
    }*/

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("exampleForm")
                              final Incident form, final BindingResult result,
                              final SessionStatus sessionStatus) {
        if (result.hasErrors()) {
            return "redirect:/test/myform";
        }
        sessionStatus.setComplete();
        return "redirect:/complete";
    }

    @RequestMapping(value = "/myform", method = RequestMethod.GET)
    public ModelAndView showForm(@ModelAttribute("exampleForm")
                                 final Incident model) {
        return new ModelAndView("/test/form_bind_3", "mm", model);
    }

    @RequestMapping(value = "/complete", method = RequestMethod.GET)
    public String showSomething(final Model model) {
        return "complete";
    }

    @RequestMapping(value = "/homeLoad", method = RequestMethod.GET)
    public ModelAndView homeLoad(Model model) {
        model.addAllAttributes(ActionUtil.getModelMap("View Incident"));
        if (!model.containsAttribute(Constants.INCIDENT_REVIEW)) {
            Incident incident = new Incident();
            incident.setRefNo(incidentService.maxRefNo() + 1);
            incident.setDetails("This is a test details.");
            model.addAttribute(Constants.INCIDENT_REVIEW, incident);
        }
        return new ModelAndView("/test/form_bind_3");
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ModelAndView send(@Valid @ModelAttribute Incident incident,
            BindingResult binding, RedirectAttributes redirectAttributes) {

        incident.validate(binding);

        if (binding.hasErrors()) {
            addError(incident, binding, redirectAttributes);
            return new ModelAndView("redirect:/test/homeLoad");
        }

        return new ModelAndView("/test/success");
    }


}
