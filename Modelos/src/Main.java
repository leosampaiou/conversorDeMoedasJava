import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String endereco = "https://v6.exchangerate-api.com/v6/58da0acfc46bb71969ff1f87/pair/USD/BRL";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        Scanner leitura = new Scanner(System.in);
        String busca = "";
        System.out.println("++++++++++++++++++");
        System.out.println("Escolha Qual moeda Gostaria de converter?");
        System.out.println("""
                1 - Dolar;
                2 - Libra;
                3 - Euro;
                4 - Real;
                """);
        System.out.println("++++++++++++++++++");
        busca = leitura.nextLine();






    }

}