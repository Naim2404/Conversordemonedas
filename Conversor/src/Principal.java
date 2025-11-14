import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
       HerramientasConversion menu = new HerramientasConversion();
       Scanner lectura = new Scanner(System.in);
       String direccion = "https://v6.exchangerate-api.com/v6/key/latest/USD"; // Debes de colocar la key generada PROPIA;
       boolean validador = true;
       while (validador){
           menu.Menu();
           System.out.println("Indica la opción deseada");
           int opcion = lectura.nextInt();

           try {
               HttpClient cliente = HttpClient.newHttpClient();
               HttpRequest request = HttpRequest.newBuilder()
                       .uri(URI.create(direccion))
                       .build();
               HttpResponse<String> response = cliente
                       .send(request, HttpResponse.BodyHandlers.ofString());

               String json = response.body();
               JsonObject objetojson = JsonParser.parseString(json).getAsJsonObject();
               JsonObject rates = objetojson.getAsJsonObject("conversion_rates");
               switch (opcion){
                   case 1:
                       System.out.println("¿Cuantos dolares quieres convertir a pesos mexicanos?");
                       double cantidadATranformar1 = lectura.nextDouble();
                       double valorMXN1 = rates.get("MXN").getAsDouble();
                       double operacion1 = cantidadATranformar1 * valorMXN1;
                       System.out.println(STR."Los \{cantidadATranformar1} Dolares a Pesos Mexicanos son: \{operacion1} MXN");
                       break;
                   case 2:
                       System.out.println("¿Cuantos pesos mexicanos quieres convertir a dolares?");
                       double cantidadATranformar2 = lectura.nextDouble();
                       double valorMXN2 = rates.get("MXN").getAsDouble();
                       double operacion2 = cantidadATranformar2/ valorMXN2;
                       System.out.println(STR."Los \{cantidadATranformar2} Pesos Mexicanos a Dolares son: \{operacion2} USD");
                       break;
                   case 3:
                       System.out.println("¿Cuantos dolares quieres convertir a euros?");
                       double cantidadATranformar3 = lectura.nextDouble();
                       double valorEUR3 = rates.get("EUR").getAsDouble();
                       double operacion3 = cantidadATranformar3 * valorEUR3;
                       System.out.println(STR."Los \{cantidadATranformar3} Dolares a Euros son: \{operacion3} EUR");
                       break;
                   case 4:
                       System.out.println("¿Cuantos euros quieres convertir a dolares?");
                       double cantidadATranformar4 = lectura.nextDouble();
                       double valorEUR4 = rates.get("EUR").getAsDouble();
                       double operacion4 = cantidadATranformar4 / valorEUR4;
                       System.out.println(STR."Los \{cantidadATranformar4} Euros a Dolares son: \{operacion4} USD");
                       break;
                   case 5:
                       System.out.println("¿Cuantos dolares quieres convertir a pesos argentinos?");
                       double cantidadATranformar5 = lectura.nextDouble();
                       double valorARS5 = rates.get("ARS").getAsDouble();
                       double operacion5 = cantidadATranformar5 * valorARS5;
                       System.out.println(STR."Los \{cantidadATranformar5} Dolares a Pesos Argentinos son: \{operacion5} ARS");
                       break;
                   case 6:
                       System.out.println("¿Cuantos pesos argentinos quieres convertir a dolares?");
                       double cantidadATranformar6 = lectura.nextDouble();
                       double valorARS6 = rates.get("ARS").getAsDouble();
                       double operacion6 = cantidadATranformar6 / valorARS6;
                       System.out.println(STR."Los \{cantidadATranformar6} Pesos Argentinos a Dolares son: \{operacion6} USD");
                       break;
                   case 7:
                       validador = false;
                       break;
                   default:
                       System.out.println("Seleccione una opción valida");

               }

           }
           catch (NumberFormatException e) {
               System.out.println("Ocurrio un error");
               System.out.println(e.getMessage());
           }
       }


    }

}


