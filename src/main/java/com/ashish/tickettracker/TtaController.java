package com.ashish.tickettracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TtaController {

    @Autowired
    private TtaService ttaService;

    public TtaController(TtaService ttaService){
        super();
        this.ttaService=ttaService;
    }

    @GetMapping("/tickettrackerapplication")
    public String listticket(Model model) {
        model.addAttribute("tickets", ttaService.getALLTicket());
        return "tickets";
    }

    @GetMapping("/tickettrackerapplication/new")
    public String createstudentForm(Model model) {
        TtaEntity ticket = new TtaEntity();
        model.addAttribute("ticket", ticket);
        return "create_ticket";
    }

    @PostMapping("/tickettrackerapplication")
    public String saveticket(@ModelAttribute("ticket") TtaEntity ticket) {
        ttaService.saveticket(ticket);
        return "redirect:/tickettrackerapplication";
    }

    @GetMapping("/tickettrackerapplication/edit/{id}")
    public String editTicketForm(@PathVariable Long id, Model model) {
        model.addAttribute("ticket", ttaService.getTicketById(id));
        return "edit_ticket";
    }

    @PostMapping("/tickettrackerapplication/{id}")
    public String updateTicket(@PathVariable Long id, @ModelAttribute("ticket") TtaEntity ticket, Model model) {
        TtaEntity existingTicket = ttaService.getTicketById(id);
        existingTicket.setId(id);
        existingTicket.setTicketTitle(ticket.getTicketTitle());
        existingTicket.setTicketCreatedDate(ticket.getTicketCreatedDate());
        existingTicket.setTicketShortDescription(ticket.getTicketShortDescription());

        ttaService.updateTicket(existingTicket);
        return "redirect:/tickettrackerapplication";
    }

    @GetMapping("/tickettrackerapplication/{id}")
    public String deleteTicket(@PathVariable Long id) {

        ttaService.deleteTicketById(id);
        return "redirect:/tickettrackerapplication";
    }

}
