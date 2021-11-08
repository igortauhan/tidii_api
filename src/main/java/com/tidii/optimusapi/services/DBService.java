package com.tidii.optimusapi.services;

import com.tidii.optimusapi.entities.District;
import com.tidii.optimusapi.entities.Street;
import com.tidii.optimusapi.repositories.DistrictRepository;
import com.tidii.optimusapi.repositories.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private StreetRepository streetRepository;

    public void instantiateDatabase() throws ParseException {
        District district1 = new District(null, "Centro", "Atividade normal", false);
        District district2 = new District(null, "Outro lado", "Atividade normal", false);
        District district3 = new District(null, "Bairro de cima", "Vazamento detectado", true);
        District district4 = new District(null, "Bairro de baixo", "Atividade normal", false);
        District district5 = new District(null, "Urbis", "Atividade normal", false);
        District district6 = new District(null, "Bairro Leste", "Vazamento detectado", true);

        // 1
        Street street1 = new Street(null, "Rua 1", "Atividade normal", false, district1);
        Street street2 = new Street(null, "Rua 2", "Atividade normal", false, district1);
        // 2
        Street street3 = new Street(null, "Rua Principal", "Atividade normal", false, district2);
        Street street4 = new Street(null, "Rua Secundaria", "Atividade normal", false, district2);
        // 3
        Street street5 = new Street(null, "Avenida Brasil", "Atividade normal", false, district3);
        Street street6 = new Street(null, "Avenida Dois", "Vazamento detectado", true, district3);
        // 4
        Street street7 = new Street(null, "Avenida de Cima", "Atividade normal", false, district4);
        Street street8 = new Street(null, "Rua D Pedro", "Atividade normal", false, district4);
        // 5
        Street street9 = new Street(null, "Rua D Pedro II", "Atividade normal", false, district5);
        Street street10 = new Street(null, "Avenida Oliveira", "Atividade normal", false, district5);
        // 6
        Street street11 = new Street(null, "Avenida Simples", "Vazamento detectado", true, district6);
        Street street12 = new Street(null, "Rua Campos", "Atividade normal", false, district6);

        district1.setStreets(Arrays.asList(street1, street2));
        district2.setStreets(Arrays.asList(street3, street4));
        district3.setStreets(Arrays.asList(street5, street6));
        district4.setStreets(Arrays.asList(street7, street8));
        district5.setStreets(Arrays.asList(street9, street10));
        district6.setStreets(Arrays.asList(street11, street12));

        districtRepository.saveAll(Arrays.asList(district1, district2, district3, district4, district5, district6));
        streetRepository.saveAll(Arrays.asList(street1, street2, street3, street4, street5, street6, street7, street8, street9, street10, street11, street12));
    }
}
