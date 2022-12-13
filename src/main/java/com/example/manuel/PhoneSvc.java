package com.example.manuel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PhoneSvc {
    public List<Contatti> getAll() {
        List<Contatti> result = new ArrayList<>();

        result.add(new Contatti( "Alexander", "Hunold", "8_997.85"));

        return result;
    }
    public void add(Contatti contatti){
    	
    }
}
