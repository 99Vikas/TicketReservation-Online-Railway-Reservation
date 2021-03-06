package com.railway.ticketReservation.service;

import com.railway.ticketReservation.model.Ticket;
import com.railway.ticketReservation.repository.TicketsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketsService {

    @Autowired
    private TicketsRepo ticketsRepo;

    public Ticket createTicket(Ticket ticket){
       return ticketsRepo.save(ticket);
    }

    public Optional<Ticket> updateTicket(String ticketId, Ticket ticket){
        Optional<Ticket> ticketData = ticketsRepo.findByTicketId(ticketId);
        if(ticketData.isPresent()){
            return Optional.of(ticketsRepo.save(ticket));
        }
        return Optional.empty();
    }

    public Optional<Ticket> deleteTicket(String ticketId){
        ticketsRepo.deleteByTicketId(ticketId);
        return Optional.empty();
    }

    public Optional<Ticket> getTicketByTicketId(String ticketId){
        Optional<Ticket> ticketData = ticketsRepo.findByTicketId(ticketId);
        return ticketData;
    }

    public Optional<Ticket> getTicketByPNR(String PNR){
        return  ticketsRepo.getTicketByPNR(PNR);
    }

    public Ticket updateTicketByPNR(String PNR, Ticket ticket){
        Optional<Ticket> ticketData = ticketsRepo.findTicketByPNR(PNR);
        if(ticketData.isPresent()){
            ticketsRepo.save(ticket);
        }
        return ticket;
    }

    public List<Ticket> getTicketsByTripScheduleId(String tripSchedule){
        return ticketsRepo.findTicketByTripScheduleId(tripSchedule);
    }

    public List<Ticket> getAll() {
        return ticketsRepo.findAll();
    }
}
