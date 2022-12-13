package com.example.stem.manuel.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ManuelPhoneSvc {
    public List<ManuelContatti> getAll() {
        List<ManuelContatti> result = new ArrayList<>();

        result.add(new ManuelContatti( "Alexander", "Hunold", "8_997.85"));

        return result;
    }
    public void add(ManuelContatti contatti){
    	
    }
}
