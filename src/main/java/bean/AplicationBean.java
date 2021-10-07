import javax.faces.bean.*;
import java.util.ArrayList;
import java.lang.Math;
import java.lang.*;
import java.util.Arrays;

@ApplicationScoped
@ManagedBean(name = "calculadoraBean")
public class AplicationBean {

    protected ArrayList<Double> datos = new ArrayList<>();
    protected String entrada;
    protected double promediofinal = 0;
    protected double varianza = 0;
    protected double desvestandatarfinal = 0;
    protected double moda = 0;
    protected int cantidadnum = 0;
    protected double total = 0;

    public double calculateMean(ArrayList<Double> promedio){
        cantidadnum = promedio.size();
        for(int i = 0 ; i<promedio.size(); i++){
            total += promedio.get(i);
        }
        promediofinal = total/promedio.size();
        return promediofinal;
    }

    public double calculateVariance(ArrayList<Double> lisvarianza){
        cantidadnum = lisvarianza.size();
        double media = 0;
        double varia = 0;

        for(int i = 0 ; i<lisvarianza.size(); i++){
            for(int j = 0 ; j<lisvarianza.size(); j++){
                total += lisvarianza.get(j);
            }
            media = total/cantidadnum;

            double rango;
            rango = Math.pow((lisvarianza.get(i)).doubleValue() - media,2f);
            varia = varia + (double)rango;
        }
        varianza = varia / lisvarianza.size();
        return varianza;
    }

    public double calculateStandardDeviation(ArrayList<Double> desvestandar){
        cantidadnum = desvestandar.size();
        double varianza = calculateVariance(desvestandar);
        desvestandatarfinal = (double)Math.sqrt(varianza);
        return desvestandatarfinal;
    }



    public double calculateMode(ArrayList<Double> lismoda){
        cantidadnum = lismoda.size();
        double maxValue = 0;
        double maxCount = 0;

        for (int i = 0; i < lismoda.size(); ++i) {
            int count = 0;
            for (int j = 0; j < lismoda.size(); ++j) {
                if (lismoda.get(j) == lismoda.get(i)) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = lismoda.get(i);
            }
        }
        moda = maxValue;
        return moda;
    }

    public void restart(){
        promediofinal = 0;
        varianza = 0;
        desvestandatarfinal = 0;
        moda = 0;
        cantidadnum = 0;
        total = 0;
    }

    public void calbean(){
        datos = new ArrayList<>();
        String espacios = entrada.replace(" ","");
        String[] y = espacios.split(";");
        for (String t : y) {
            datos.add(Double.parseDouble(t));
        }
        calculateMean(datos);
        calculateVariance(datos);
        calculateStandardDeviation(datos);
        calculateMode(datos);
    }

    public ArrayList<Double> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Double> datos) {
        this.datos = datos;
    }

    public double getPromediofinal() {
        return promediofinal;
    }

    public void setPromediofinal(double promediofinal) {
        this.promediofinal = promediofinal;
    }

    public double getVarianza() {
        return varianza;
    }

    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }

    public double getDesvestandatarfinal() {
        return desvestandatarfinal;
    }

    public void setDesvestandatarfinal(double desvestandatarfinal) {
        this.desvestandatarfinal = desvestandatarfinal;
    }

    public double getModa() {
        return moda;
    }

    public void setModa(double moda) {
        this.moda = moda;
    }

    public int getCantidadnum() {
        return cantidadnum;
    }

    public void setCantidadnum(int cantidadnum) {
        this.cantidadnum = cantidadnum;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
}
