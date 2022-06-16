package com.example.appfilm.interfaces;

import com.example.appfilm.model.PreTicket;
import com.example.appfilm.model.Ticket;

import java.util.List;

public interface TicketInterface {
    void myToast(String message);
    void onCallBack(List<Ticket> tickets);
    void onPreCallBack(PreTicket preTicket);

}
