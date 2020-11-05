package Clases;

public class Creditos
{

private String Credito_Hipotecario;
private String Credito_Automotriz;

public Creditos()
{
    Credito_Hipotecario = "1000000";
    Credito_Automotriz = "500000";

}

public String getCredito_Hipotecario()
    {
       return Credito_Hipotecario;
    }

    public String getCredito_Automotriz()
    {
        return Credito_Automotriz;
    }

}
