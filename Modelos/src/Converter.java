import com.google.gson.annotations.SerializedName;

public class Converter {
    @SerializedName("conversion_rate") double conversionRate;



    public String toString(){
        return "Cotação = " + conversionRate;

    }
}
