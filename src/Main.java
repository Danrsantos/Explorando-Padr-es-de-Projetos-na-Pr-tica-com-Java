import com.Strategy.*;
import com.facade.Facade;
import com.gof.SingletonEager;
import com.gof.SingletonLazy;
import com.gof.SingletonLazyHolder;

public class Main {
    public static void main(String[] args) {

        //Lazy
        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstance();
        System.out.println(lazy);

        //Eager
        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);

        //Lazy Holder
        SingletonLazyHolder holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);
        holder = SingletonLazyHolder.getInstancia();
        System.out.println(holder);

        System.out.println("");

        //Strategy
        Comportamento normal = new ComportamentoNormal();
        Comportamento defensivo = new ComportamentoDefensivo();
        Comportamento ofensivo = new ComportamentoOfensivo();

        Robo robo = new Robo();
        robo.setStrategy(normal);
        robo.mover();
        robo.mover();

        robo.setStrategy(defensivo);
        robo.mover();
        robo.mover();
        robo.mover();

        robo.setStrategy(ofensivo);
        robo.mover();
        robo.mover();
        robo.mover();
        robo.mover();

        System.out.println("");

        //Facade

        Facade facade = new Facade();
        facade.migrarCliente("Danilo","07803-180");



    }
}