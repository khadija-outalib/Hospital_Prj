package net.hospital.hospital.Web;
import net.hospital.hospital.entities.Patient;
import net.hospital.hospital.repositories.PatientRepository;
import net.hospital.hospital.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller // return data : HTML, JSON, XML,
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private IHospitalService iHospitalService;
    private  PatientRestController restController;

    @GetMapping("/index")
    public String index(Model model){

        List<Patient> ListPatient =patientRepository.findAll();
        model.addAttribute("ps",ListPatient);
        return "patients";
    }
    @GetMapping("/Updatepatient")
    @ResponseBody
    public String  UpdatePatient (@RequestParam String nom, @RequestParam String tel){
        iHospitalService.updateTelPatient(nom, tel);
        return "redirect:/index";
    }
    @GetMapping("/DeletePatient")
    @ResponseBody
    public String  Delete(@RequestParam String nom){
        iHospitalService.deletePatient(nom);
        return "redirect:/index";

    }



}
