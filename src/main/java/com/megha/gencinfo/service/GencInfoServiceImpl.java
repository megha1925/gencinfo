package com.megha.gencinfo.service;

import com.megha.gencinfo.exception.ResourceNotFoundException;
import com.megha.gencinfo.model.GencIntern;
import com.megha.gencinfo.model.GencInternDTO;
import com.megha.gencinfo.repository.GencInternRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GencInfoServiceImpl implements GencInfoService {

    @Autowired
    private GencInternRepository gencInternRepository;

    @Override
    public List<GencIntern> getAllInternsInfo() {
        //return gencInternRepository.findAll().stream().map(this::convertGencInternToDTO).collect(Collectors.toList());
        return gencInternRepository.findAll();
    }

    @Override
    public String addGencInternsInfo(GencInternDTO gencIntern) {
        GencIntern intern = new GencIntern(0,gencIntern.getFirstName(),gencIntern.getLastName(),gencIntern.getEmail());
        gencInternRepository.save(intern);
        return "Intern Added";
    }

    @Override
    public String updateGencInfo(GencIntern gencIntern) {
        GencIntern updatedIntern = gencInternRepository.findById(gencIntern.getId());
        if(updatedIntern != null)
        {
            updatedIntern.setFirstName(gencIntern.getFirstName());
            updatedIntern.setLastName(gencIntern.getLastName());
            updatedIntern.setEmail(gencIntern.getEmail());
            gencInternRepository.save(updatedIntern);
            return "Genc Intern Info Updated!";
        }
        else{
            throw new ResourceNotFoundException("Intern Not found");
        }
    }

    @Override
    public String deleteGencInfo(long id) {
        GencIntern currentIntern = gencInternRepository.findById(id);
        if(currentIntern != null)
        {
           gencInternRepository.delete(currentIntern);
           return "Intern Deleted Successfully";
        }
        else {
            throw new ResourceNotFoundException("Intern not found with id " + id);
        }
    }

    public GencInternDTO convertGencInternToDTO(GencIntern gencIntern){
        GencInternDTO gencInternDTO = new GencInternDTO();
        gencInternDTO.setFirstName(gencIntern.getFirstName());
        gencInternDTO.setLastName(gencIntern.getLastName());
        gencInternDTO.setEmail(gencIntern.getEmail());
        return gencInternDTO;
    }

}
