package com.devsu.bank.converters;

import com.devsu.bank.generated.api.models.Client;
import com.devsu.bank.model.enums.State;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class ClientConverter {

    // Define a custom date format
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    public static Client convertToExpose(com.devsu.bank.model.Client person) {
        Client client = new Client();
        client.setId(person.getId().intValue());
        client.setName(person.getName());
        client.setPhone(person.getPhone());
        client.setGender(person.getGender());
        client.setAddress(person.getAddress());
        client.setPassword(person.getPassword());
        client.setState(person.getState());
        client.setDateOfBirth(person.getDateOfBirth().toString());
        client.setAge(calculateAge(person.getDateOfBirth()));

        return client;
    }

    public static com.devsu.bank.model.Client convertToEntity(Client client) {

        com.devsu.bank.model.Client clientEntity = new com.devsu.bank.model.Client();
        clientEntity.setName(client.getName());
        clientEntity.setAddress(client.getAddress());
        clientEntity.setPassword(client.getPassword());
        clientEntity.setState(State.ACTIVE.name());

        LocalDate localDate = LocalDate.parse(client.getDateOfBirth(), formatter);

        clientEntity.setDateOfBirth(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        clientEntity.setPhone(client.getPhone());
        clientEntity.setGender(client.getGender());

        return clientEntity;
    }

    public static String calculateAge(Date dateOfBirth) {
        // Convert java.util.Date to LocalDate
        LocalDate birthDate = dateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate currentDate = LocalDate.now();
        return String.valueOf(Period.between(birthDate, currentDate).getYears());
    }
}
