package pl.jatustygne.fragment;

/**
 * Created by kacper on 18.11.15.
 */
public class CoffeeTemperatureFragment extends TemperatureFragment{

    @Override
    protected String minValName() {
        return "minValCoffee";
    }

    @Override
    protected String maxValName() {
        return "maxValCoffee";
    }
}
