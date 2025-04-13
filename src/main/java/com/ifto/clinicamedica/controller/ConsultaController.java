package com.ifto.clinicamedica.controller;
import com.ifto.clinicamedica.model.entity.Consulta;
import com.ifto.clinicamedica.model.entity.Medico;
import com.ifto.clinicamedica.model.entity.Paciente;
import com.ifto.clinicamedica.model.entity.Usuario;
import com.ifto.clinicamedica.model.repository.ConsultaRepository;
import com.ifto.clinicamedica.model.repository.MedicoRepository;
import com.ifto.clinicamedica.model.repository.PacienteRepository;
import com.ifto.clinicamedica.model.repository.UsuarioRepository;
import com.ifto.clinicamedica.model.validation.groups.Insert;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import org.springframework.security.core.Authentication;

@Transactional
@Controller

@RequestMapping("consulta")
public class ConsultaController {
    @Autowired
    ConsultaRepository repository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @ResponseBody
    @GetMapping("/list")
    public ModelAndView listarConsultas(ModelMap model, Authentication authentication) {

        String nomeUsuarioLogado = authentication.getName();

        Usuario usuario = usuarioRepository.usuario(nomeUsuarioLogado);

        Long idPessoa = usuario.getId();

        Medico medico = medicoRepository.medico(idPessoa);

        boolean isMedico = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_MEDICO"));

        if(isMedico){
            List<Consulta> consultasDoMedico = repository.consultasDoMedico(medico);
            model.addAttribute("consulta", consultasDoMedico);
            model.addAttribute("vTotal", repository.valorTotalMedico(medico));
        }else {
            model.addAttribute("consulta", repository.consultas());
            model.addAttribute("vTotal", repository.vTotal());
        }

        return new ModelAndView("consulta/list", model);
    }

    @GetMapping("/form")
    public ModelAndView formConsulta(ModelMap model){
        model.addAttribute("paciente",pacienteRepository.pacientes());
        model.addAttribute("medico", medicoRepository.medicos());
        model.addAttribute("consulta", new Consulta());
        return new ModelAndView("consulta/form", model);
    }

    @GetMapping("/{id}")
    public ModelAndView listarConsulta(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("consulta", repository.consulta(id));
        return new ModelAndView("consulta/detalhe", model);
    }

    @PostMapping("/save")
    public ModelAndView saveConsulta(@Validated(Insert.class)Consulta consulta, BindingResult result, ModelMap model){

        if (result.hasErrors()) {
            model.addAttribute("paciente", pacienteRepository.pacientes());
            model.addAttribute("medico", medicoRepository.medicos());
            return new ModelAndView("/consulta/form", model);

        }
        repository.save(consulta);
        return new ModelAndView("redirect:/consulta/list");
    }

    @GetMapping("/editConsulta/{id}")
    public ModelAndView editMedico(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("consulta", repository.consulta(id));
        List<Medico> medicos = medicoRepository.medicos();
        List<Paciente> pacientes = pacienteRepository.pacientes();
        model.addAttribute("medico", medicos);
        model.addAttribute("paciente", pacientes);
        return new ModelAndView("/consulta/form", model);
    }

    @GetMapping("/removeConsulta/{id}")
    public ModelAndView remove(@PathVariable("id") Long id){
        repository.remove(id);
        return new ModelAndView("redirect:/consulta/list");
    }

    @PostMapping("/update")
    public ModelAndView updateConsulta(Consulta consulta) {
        repository.update(consulta);
        return new ModelAndView("redirect:/consulta/list");
    }

    @ResponseBody
    @RequestMapping("pesquisapordata")
    public ModelAndView pesquisaPorData(ModelMap model, @RequestParam String data){
        model.addAttribute("consulta", repository.pesquisaPorData(data));
        return new ModelAndView("consulta/list", model);
    }
}
