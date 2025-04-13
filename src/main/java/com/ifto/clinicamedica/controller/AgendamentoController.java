package com.ifto.clinicamedica.controller;


import com.ifto.clinicamedica.model.entity.Agenda;
import com.ifto.clinicamedica.model.entity.Agendamento;
import com.ifto.clinicamedica.model.entity.Medico;
import com.ifto.clinicamedica.model.repository.AgendaRepository;
import com.ifto.clinicamedica.model.repository.AgendamentoRepository;
import com.ifto.clinicamedica.model.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
@RequestMapping("agendamento")
public class AgendamentoController {
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private AgendaRepository agendaRepository;
    @Autowired
    private MedicoRepository medicoRepository;

    @GetMapping("/{idMedico}")
    public String formAgendamento(@PathVariable(value = "idMedico", required = false) Long idMedico, ModelMap model, Medico medico, Agendamento agendamento){
        medico = medicoRepository.medico(idMedico);
        var agenda = agendaRepository.agendasPorMedico(idMedico);
        model.addAttribute("agenda", agenda);
        model.addAttribute("medico", medico);

        return "agendamento/form";
    }

    @GetMapping("/list")
    public ModelAndView listar(ModelMap model) {
        model.addAttribute("agendamento", agendamentoRepository.agendamentos());
        return new ModelAndView("agendamento/list", model);
    }

    @GetMapping("/medicos")
    public ModelAndView medicos(ModelMap model) {
        model.addAttribute("medico", medicoRepository.medicos());
        return new ModelAndView("agendamento/medicos", model);
    }

    @ResponseBody
    @RequestMapping("pesquisapornome")
    public ModelAndView pesquisaporNome(ModelMap model, @RequestParam String nome){
        model.addAttribute("medico", medicoRepository.pesquisaPorNome(nome));
        return new ModelAndView("agendamento/medicos", model);
    }

    @PostMapping("/save")
    public ModelAndView save(Agendamento agendamento, BindingResult result, ModelMap map){

        Agenda agenda = agendaRepository.agenda(agendamento.getAgenda().getId());
        agenda.setDisponivel(false);
        agendamentoRepository.save(agendamento);
        agendaRepository.update(agenda);
        return new ModelAndView("redirect:/agendamento/list");
    }

    @GetMapping("/detalhe/{id}")
    public ModelAndView detalhes(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("agendamento", agendamentoRepository.agendamento(id));
        return new ModelAndView("agendamento/detalhe", model);
    }

}
