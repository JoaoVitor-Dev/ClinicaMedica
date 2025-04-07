package com.ifto.mapeamento.controller;
import com.ifto.mapeamento.model.entity.Paciente;
import com.ifto.mapeamento.model.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Transactional
@Controller
@RequestMapping("paciente")
public class PacienteController {
    @Autowired
    PacienteRepository repository;

    @GetMapping("/form")
    public String form(Paciente paciente){
        return "/paciente/form";
    }

    @GetMapping("/list")
    public ModelAndView listarPaciente(ModelMap model) {
        model.addAttribute("paciente", repository.pacientes());
        return new ModelAndView("paciente/list", model);
    }

    @GetMapping("/{id}")
    public ModelAndView listarPaciente(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("paciente", repository.paciente(id));
        return new ModelAndView("paciente/consulta", model);
    }

    @PostMapping("/save")
    public ModelAndView salvarPaciente(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes){

        if(result.hasErrors())
            return new ModelAndView("paciente/form");

        repository.save(paciente);
        attributes.addFlashAttribute("mensagemsucesso", "Paciente cadastrado com sucesso!");
        return new ModelAndView("redirect:/paciente/list");
    }

    @GetMapping("/removePaciente/{id}")
    public ModelAndView remove(@PathVariable("id") Long id, RedirectAttributes attributes, ModelMap model){

        if(!repository.paciente(id).getConsultas().isEmpty()){
            attributes.addFlashAttribute("mensagemerro", "Não é possível deletar paciente com consultas!");
            return new ModelAndView("redirect:/paciente/list");
        }

        repository.remove(id);
        return new ModelAndView("redirect:/paciente/list");
    }

    @GetMapping("/editPaciente/{id}")
    public ModelAndView editPaciente(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("paciente", repository.paciente(id));
        return new ModelAndView("/paciente/form", model);
    }

    @PostMapping("/update")
    public ModelAndView updatePaciente(@Valid Paciente paciente, BindingResult result) {

        if(result.hasErrors())
            return new ModelAndView("paciente/form");

        repository.update(paciente);
        return new ModelAndView("redirect:/paciente/list");
    }

    @ResponseBody
    @RequestMapping("pesquisapornome")
    public ModelAndView pesquisaporNome(ModelMap model, @RequestParam String nome){
        model.addAttribute("paciente", repository.pesquisaPorNome(nome));
        return new ModelAndView("paciente/list", model);
    }
}
