package com.ashish.tickettracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.TtaEntitySorter;

import java.util.List; 

@Service
public class TtaService {
    @Autowired
    private TtaRespository ttarespository;
    
    public TtaService(TtaRespository ttarespository) {
        super();
        this.ttarespository = ttarespository;
    }
    public List<TtaEntity> getALLTicketSortedByStatus() {
        List<TtaEntity> tickets = ttarespository.findAll();
        return TtaEntitySorter.sortEntitiesByStatus(tickets);
    }
    
    public TtaEntity saveticket(TtaEntity ticket){
        return ttarespository.save(ticket);
    }

    public TtaEntity getTicketById(Long id){
        return ttarespository.findById(id).get();
    }

    public TtaEntity updateTicket(TtaEntity ticket){
        return ttarespository.save(ticket);
    }

    public void deleteTicketById(Long id){
        ttarespository.deleteById(id);
    }
}
