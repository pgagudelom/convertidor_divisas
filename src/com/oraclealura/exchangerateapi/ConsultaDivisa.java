package com.oraclealura.exchangerateapi;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {

    /*
    * Metodo para consultar al API exchangenerate la divisa */
    public Divisa buscaDivisa(String divisaBase, String divisaObjetivo, String monto){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5a376f923fa926a6ccd8ab1b/pair/"+divisaBase+"/"+divisaObjetivo+"/"+monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = null;
        try{
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }


        return new Gson().fromJson(response.body(), Divisa.class);
    }
}
