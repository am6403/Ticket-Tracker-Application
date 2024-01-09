package com.ashish.tickettracker;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="ttas")
public class TtaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id",nullable = false)
    private Long id;

    @Column(name="ticket_title",nullable = false)
    private String ticketTitle;
    
    @Column(name = "ticket_created_date")
    private LocalDateTime ticketCreatedDate=LocalDateTime.now();

    @Column(name="ticket_short_description")
    private String ticketShortDescription;

    
    private String status="Created" ;
    
    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public TtaEntity(Long id, String ticketTitle, LocalDateTime ticketCreatedDate, String ticketShortDescription, String status) {
        this.id = id;
        this.ticketTitle = ticketTitle;
        this.ticketCreatedDate = ticketCreatedDate;
        this.ticketShortDescription = ticketShortDescription;
        this.status=status;
    }


    @PreUpdate
    public void preUpdate() {
        this.ticketCreatedDate = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public TtaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }


    public String getTicketShortDescription() {
        return ticketShortDescription;
    }

    public void setTicketShortDescription(String ticketShortDescription) {
        this.ticketShortDescription = ticketShortDescription;
    }

    public LocalDateTime getTicketCreatedDate() {
        return ticketCreatedDate;
    }

    public void setTicketCreatedDate(LocalDateTime ticketCreatedDate) {
        this.ticketCreatedDate = ticketCreatedDate;
    }

    
    
}
