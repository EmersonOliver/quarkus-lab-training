package com.stefanini.lab.entity;

import java.io.Serializable;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class ClienteEntity extends PanacheEntityBase implements Serializable {

    @Id
    @Column(name = "uuid_client")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuidClient;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "doc_client")
    private String docClient;

    public UUID getUuidClient() {
        return uuidClient;
    }

    public void setUuidClient(UUID uuidClient) {
        this.uuidClient = uuidClient;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDocClient() {
        return docClient;
    }

    public void setDocClient(String docClient) {
        this.docClient = docClient;
    }

}
