package com.example.appfilm.presenter;

import com.example.appfilm.interfaces.ApiServer;
import com.example.appfilm.interfaces.TicketInterface;
import com.example.appfilm.model.PreTicket;
import com.example.appfilm.model.Ticket;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeatPresenter {

    List<Ticket> tickets = new ArrayList<>();
    PreTicket preTicket=new PreTicket();
    TicketInterface ticketInterface;

    public SeatPresenter(TicketInterface ticketInterface) {
        this.ticketInterface = ticketInterface;
    }


    public void readListTicket(final TicketInterface ticketInterface,int idPhim,int idRap,int idKhunggio){
        ApiServer.API_SERVER.callTicket(idPhim,idRap,idKhunggio).enqueue(new Callback<List<Ticket>>() {

            @Override
            public void onResponse(Call<List<Ticket>> call, Response<List<Ticket>> response) {
                tickets = response.body();
                for(Ticket t: tickets){
                    if(t.getLoaiGhe().equalsIgnoreCase("VIP")){
                        t.setGiaMacDinh(t.getGiaMacDinh()+20000);
                    }
                }
                ticketInterface.onCallBack(tickets);

            }

            @Override
            public void onFailure(Call<List<Ticket>> call, Throwable t) {
                ticketInterface.myToast(t.toString());
            }
        }
        );


    }
    public void readInfTicket(final TicketInterface ticketInterface,int idPhim,int idRap,int idKhunggio){
        ApiServer.API_SERVER.callPreTicket(idPhim,idRap,idKhunggio).enqueue(new Callback<PreTicket>() {
            @Override
            public void onResponse(Call<PreTicket> call, Response<PreTicket> response) {
                preTicket=response.body();
                ticketInterface.onPreCallBack(preTicket);
            }

            @Override
            public void onFailure(Call<PreTicket> call, Throwable t) {
                ticketInterface.myToast(t.toString());
            }
        });
    }


}
