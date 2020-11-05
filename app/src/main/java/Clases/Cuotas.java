package Clases;

public class Cuotas {

    private String Cuota_Hipotecario;
    private String Cuota_Automotriz;

    public Cuotas()
    {
        Cuota_Hipotecario = "12";
        Cuota_Automotriz = "8";

    }

    public String getCuota_Hipotecario()
    {
        return Cuota_Hipotecario;
    }

    public String getCuota_Automotriz()
    {
        return Cuota_Automotriz;
    }
}
