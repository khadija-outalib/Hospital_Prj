package net.hospital.hospital.Web;

import net.hospital.hospital.entities.Patient;
import net.hospital.hospital.repositories.PatientRepository;
import net.hospital.hospital.service.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //return data :JSON ,XLM
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private IHospitalService  iHospitalService;


    @GetMapping("/patients")
    public List<Patient> PatientList() {
       return patientRepository.findAll();
    }
    @GetMapping("/Updatepatient")
    @ResponseBody
    public List<Patient> UpdatePatient (@RequestParam String nom,@RequestParam String tel){
      iHospitalService.updateTelPatient(nom, tel);
       return patientRepository.findAll();
    }
    @GetMapping("/DeletePatient")
    @ResponseBody
    public List<Patient>  DeletePatient(@RequestParam String nom){
         iHospitalService.deletePatient(nom);
        return patientRepository.findAll();

    }


}
