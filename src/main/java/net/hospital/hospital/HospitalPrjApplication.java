package net.hospital.hospital;

import net.hospital.hospital.entities.Consultation;
import net.hospital.hospital.entities.Medecin;
import net.hospital.hospital.entities.Patient;
import net.hospital.hospital.entities.RendezVous;
import net.hospital.hospital.repositories.MdecinRepository;
import net.hospital.hospital.repositories.PatientRepository;
import net.hospital.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class HospitalPrjApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalPrjApplication.class, args);
    }


    /**
    @Bean
    CommandLineRunner start(IHospitalService hospitalService ,
                            PatientRepository patientRepository,
                            MdecinRepository mdecinRepository){
        return args -> {
            hospitalService.savePatient(new Patient("Tazi Salma3",new Date("12/02/1979"),false,"0647560853"));
            hospitalService.savePatient(new Patient("Salwa tijanie3",new Date("03/31/2003"),true,"0545694587"));
            hospitalService.savePatient(new Patient("iderisse mehdi3",new Date("11/02/1998"),false ,null));
            hospitalService.savePatient(new Patient("aicha dersii 3",new Date("11/20/1997"),true, "0623147625"));//-----------------------------------------------------------------------------------------------------------
            //-----------------------------------------------------------------------------------------------------------


            hospitalService.saveMedecin(new Medecin("Yaakoubi Ahmed",Math.random()>0.5?"Cardio":"Dentiste"));
            hospitalService.saveMedecin(new Medecin("Jiale Samira",Math.random()>0.5?"Cardio":"Dentiste"));

            //-----------------------------------------------------------------------------------------------------------
            Patient p1 = patientRepository.findById(2L).orElse(null);
            Patient p2 =patientRepository.findById(1L).orElse(null);

            Medecin m1= mdecinRepository.findById(1L).orElse(null);
            Medecin m2 =mdecinRepository.findById(1L).orElse(null);

            hospitalService.saveRendezVous(new RendezVous(new Date("25/02/2024"), StatusRDV.DONE,p2,m2));

            RendezVous r = new RendezVous(new Date("12/03/2024"), StatusRDV.PENDIG,p1,m1);
            hospitalService.saveRendezVous(r);

            //-----------------------------------------------------------------------------------------------------------
            hospitalService.saveConsultation(new Consultation(new Date(),"Rap01..............",r));

        };

    }**/

}
