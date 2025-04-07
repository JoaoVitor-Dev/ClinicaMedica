package com.ifto.mapeamento.controller;

import com.ifto.mapeamento.model.repository.AgendaRepository;
import com.ifto.mapeamento.model.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("agenda")
public class AgendaController {

    @Autowired
    AgendaRepository repository;

    @GetMapping("/form")
    public ModelAndView formAgenda(ModelMap model){
        return new ModelAndView("agenda/form", model);
    }

}
