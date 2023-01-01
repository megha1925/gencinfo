package com.megha.gencinfo.service;

import com.megha.gencinfo.model.GencIntern;
import com.megha.gencinfo.model.GencInternDTO;

import java.util.List;

public interface GencInfoService  {
    public List<GencIntern> getAllInternsInfo();

    public String addGencInternsInfo(GencInternDTO gencIntern);

    public  String updateGencInfo(GencIntern gencIntern);

    public String deleteGencInfo(long id);
}
