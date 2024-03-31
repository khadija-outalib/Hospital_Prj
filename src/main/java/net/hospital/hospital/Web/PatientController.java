package net.hospital.hospital.Web;

import jakarta.validation.Valid;
import net.hospital.hospital.entities.Patient;
import net.hospital.hospital.repositories.PatientRepository;
import net.hospital.hospital.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller // Returns data: HTML, JSON, XML
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private IHospitalService iHospitalService;
    @GetMapping("/user/index")
    public String index(Model model ,@RequestParam(name ="page",defaultValue ="0")int page ,
                        @RequestParam(name ="size",defaultValue ="4")int size,
                        @RequestParam(name = "keyword" ,defaultValue = "")String keyword
    )
    {

        Page<Patient> ListPatient =patientRepository.findByNomContainsIgnoreCase(keyword,PageRequest.of(page,size));
        model.addAttribute("ps",ListPatient.getContent());
        model.addAttribute("pages" ,new int [ListPatient.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }
    @GetMapping("/admin/DeletePatient")
    @ResponseBody
    public RedirectView deletePatient(@RequestParam Long id, String keyword, int page) {
        iHospitalService.deleteById(id);
        return new RedirectView("/user/index?page=" + page + "&keyword=" + keyword);
    }

    @GetMapping("/admin/FormPatient")
    public String formPatients(Model model) {
        model.addAttribute("patient", new Patient());
        return "formPatients";
    }

    @PostMapping("/admin/save")
    public RedirectView save(Model model, @Valid Patient patient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new RedirectView("/user/FormPatient");
        }
        patientRepository.save(patient);
        return new RedirectView("/user/index");
    }
    @GetMapping("/admin/UpdatePatient")
    public String UpdatePatient(Model model ,Long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        if(patient ==null)throw new RuntimeException("Patienr introvable");

        model.addAttribute("patient", patient);
        return "updatePatient";
    }

}
