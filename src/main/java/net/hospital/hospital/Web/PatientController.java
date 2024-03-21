package net.hospital.hospital.Web;
import net.hospital.hospital.entities.Patient;
import net.hospital.hospital.repositories.PatientRepository;
import net.hospital.hospital.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller // return data : HTML, JSON, XML,
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private IHospitalService iHospitalService;
    private  PatientRestController restController;

    @GetMapping("/index")
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
    @GetMapping("/Updatepatient")
    @ResponseBody
    public String  UpdatePatient (@RequestParam String nom, @RequestParam String tel){
        iHospitalService.updateTelPatient(nom, tel);
        return "redirect:/index";
    }
 @GetMapping("/DeletePatient")
    @ResponseBody
    public String  DeletePatient(@RequestParam String nom){

       iHospitalService.deletePatient(nom);

        return "redirect:/index";

    }



}
