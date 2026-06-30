package com.gabriel.van.service;

import com.gabriel.van.repository.MotoristaRespository;
import org.springframework.beans.factory.annotation.Autowired;

public class MotoristaService {

    private final MotoristaRespository respository;

    public MotoristaService (MotoristaRespository respository){
        this.respository = respository;
    }

}
