package com.waitakaLibrary.LibraryWaitaka.Entities;

import com.mongodb.client.model.IndexModel;
import com.mongodb.internal.connection.IndexMap;
import com.mongodb.internal.operation.CreateIndexesOperation;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Document
public class Estudante extends Usuario{



    @Id
    private String id;

    private Profile profile = Profile.ESTUDANTE;

    @Indexed(unique = true)
    @NotNull(message = "Email não pode ser vazio")
    private String email;

    //Construtor com parâmetros
    @PersistenceConstructor
    public Estudante(
            String nome,
            String email,
            String telefone,
            Integer matricula,
            String CEP) {
        super(nome,   telefone,matricula,CEP);
        this.email = email;


    }



}
