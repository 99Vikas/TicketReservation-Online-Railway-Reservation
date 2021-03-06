package com.railway.ticketReservation.repository;

import com.railway.ticketReservation.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketsRepo extends MongoRepository<Ticket, String> {

    public Optional<Ticket> findByTicketId(String ticketId);

    public void deleteByTicketId(String ticketId);

    public Optional<Ticket> findTicketByPNR(String PNR);

    public Optional<Ticket> getTicketByPNR(String PNR);

    public List<Ticket> findTicketByTripScheduleId(String tripScheduleId);
}
