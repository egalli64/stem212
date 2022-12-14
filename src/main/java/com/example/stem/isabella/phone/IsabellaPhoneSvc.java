package com.example.stem.isabella.phone;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class IsabellaPhoneSvc {
	public List<IsabellaContact> getAll() {
		List<IsabellaContact> result = new ArrayList<>();

		result.add(new IsabellaContact("Alexander", "Hunold", "3425465"));

		return result;
	}
	public void add(IsabellaContact contact){
		
	}
}
