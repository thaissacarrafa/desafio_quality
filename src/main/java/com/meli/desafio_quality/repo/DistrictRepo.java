package com.meli.desafio_quality.repo;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.desafio_quality.model.District;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class DistrictRepo {

    private final String linkFile = "src/main/resources/districts.json";
    private final ObjectMapper mapper = new ObjectMapper();

    public List<District> getAll() {
        try {
            return Arrays.asList(
                mapper.readValue(new File(linkFile), District[].class)
            );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public boolean districtAlreadyExists(District district) {
        return getAll().contains(district);
    }

    public Optional<List<District>> saveDistrict(List<District> newDistricts) {
        List<District> districts = new ArrayList<>(getAll());
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

        for (District currentDistrict : newDistricts) {
            if (!districtAlreadyExists(currentDistrict)) districts.add(
                currentDistrict
            );
        }

        try {
            writer.writeValue(new File(linkFile), districts);
            return Optional.of(newDistricts);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return Optional.empty();
    }
}
