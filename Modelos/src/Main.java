import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        String codigoUm = "";
        String codigoDois = "";


        Scanner leitura = new Scanner(System.in);
        codigoUm = "";
        codigoDois = "";

        while (!codigoUm.equals("sair")) {

            System.out.println("++++++++++++++++++");
            System.out.println("Escolha Qual moeda Gostaria de converter?");
            System.out.println("""
                    1 - Dolar;
                    2 - Libra;
                    3 - Euro;
                    4 - Real;
                    Ou digite "sair"
                    """);
            System.out.println("++++++++++++++++++");
            codigoUm = leitura.nextLine();
            Moedas primeiraMoeda = new Moedas(codigoUm);
            switch (codigoUm) {
                case "1":
                    codigoUm = "USD";
                    break;

                case "2":
                    codigoUm = "GBP";
                    break;

                case "3":
                    codigoUm = "EUR";
                    break;

                case "4":
                    codigoUm = "BRL";
                    break;


            }


            System.out.println("++++++++++++++++++");
            System.out.println("Para Qual moeda Gostaria de converter?");
            System.out.println("""
                    1 - Dolar;
                    2 - Libra;
                    3 - Euro;
                    4 - Real;
                    Ou digite "sair"
                    """);
            System.out.println("++++++++++++++++++");
            codigoDois = leitura.nextLine();
            Moedas segundaMoeda = new Moedas(codigoDois);
            switch (codigoDois) {
                case "1":
                    codigoDois = "USD";
                    break;

                case "2":
                    codigoDois = "GBP";
                    break;

                case "3":
                    codigoDois = "EUR";
                    break;

                case "4":
                    codigoDois = "BRL";
                    break;


            }


            String endereco = "https://v6.exchangerate-api.com/v6/58da0acfc46bb71969ff1f87/pair/" + codigoUm + "/" + codigoDois;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            Converter converter = gson.fromJson(response.body(), Converter.class);
            System.out.println(converter);

        }












    }

}